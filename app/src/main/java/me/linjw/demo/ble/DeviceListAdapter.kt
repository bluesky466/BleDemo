package me.linjw.demo.ble

import android.bluetooth.BluetoothDevice
import android.bluetooth.le.ScanResult
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DeviceListAdapter : RecyclerView.Adapter<DeviceListAdapter.Holder>() {
    private val devices = ArrayList<BluetoothDevice>()

    private val deviceInfo = HashMap<BluetoothDevice, DeviceInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_device, parent, false)

        return Holder(view).apply {
            connect.setOnClickListener { view ->
                connect(view.context, view.getTag(R.id.connect) as BluetoothDevice)
            }

            advertising.setOnClickListener { view ->
                showAdvertising(view.context, view.getTag(R.id.advertising) as ByteArray)
            }
        }
    }

    private fun showAdvertising(context: Context, advertising: ByteArray) {
        val intent = Intent(context, AdvertisingActivity::class.java)
        intent.putExtra(AdvertisingActivity.ADVERTISING, advertising)
        context.startActivity(intent)
    }

    private fun connect(context: Context, device: BluetoothDevice) {
        val intent = Intent(context, ServiceListActivity::class.java)
        intent.putExtra(ServiceListActivity.DEVICE, device)
        context.startActivity(intent)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val context = holder.itemView.context
        holder.name.text = devices[position].name ?: context.getText(R.string.unknown)
        holder.address.text = devices[position].address

        val info = deviceInfo[devices[position]]!!
        holder.rssi.text = info.rssi.toString()

        holder.connect.visibility = if (info.connectable) View.VISIBLE else View.INVISIBLE
        holder.connect.setTag(R.id.connect, devices[position])

        val advertising = info.advertising
        holder.advertising.visibility = if (advertising != null) View.VISIBLE else View.INVISIBLE
        holder.advertising.setTag(R.id.advertising, advertising)
    }

    override fun getItemCount(): Int {
        return devices.size
    }

    fun onDeviceFound(result: ScanResult) {
        val device = result.device ?: return
        val index = devices.indexOf(device)
        if (index == -1) {
            val info = DeviceInfo(result.rssi, isConnectable(result), result.scanRecord?.bytes)
            devices.add(device)
            deviceInfo[device] = info
            notifyItemInserted(devices.size - 1)
        } else {
            val info = deviceInfo[device]!!
            info.rssi = result.rssi
            info.connectable = isConnectable(result)
            info.advertising = result.scanRecord?.bytes
            notifyItemChanged(index)
        }
    }

    private fun isConnectable(result: ScanResult): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            result.isConnectable
        } else {
            false
        }
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val address: TextView = itemView.findViewById(R.id.address)
        val rssi: TextView = itemView.findViewById(R.id.rssi)
        val connect: Button = itemView.findViewById(R.id.connect)
        val advertising: Button = itemView.findViewById(R.id.advertising)
    }

    data class DeviceInfo(
        var rssi: Int,
        var connectable: Boolean,
        var advertising: ByteArray?
    )
}