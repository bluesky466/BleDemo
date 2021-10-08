package me.linjw.demo.ble

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattService
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ServiceListActivity : AppCompatActivity(), BleHelper.ConnectCallback,
    BleHelper.DiscoverServicesCallback {
    companion object {
        const val DEVICE = "device"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_list)

        findViewById<Button>(R.id.bond).setOnClickListener {
            val device = intent.getParcelableExtra<BluetoothDevice>(DEVICE)!!
            BleHelper.bond(device)
        }
    }

    override fun onStart() {
        super.onStart()

        val device = intent.getParcelableExtra<BluetoothDevice>(DEVICE)!!
        BleHelper.connectDevice(this, device, this)
    }

    class ServiceListAdapter(
        private val services: List<BluetoothGattService>
    ) :
        RecyclerView.Adapter<ServiceListAdapter.Holder>() {

        @RequiresApi(Build.VERSION_CODES.N)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_service, parent, false)
            val holder = Holder(view)
            holder.details.setOnClickListener {
                val service = it.getTag(R.id.services) as BluetoothGattService
                val intent = Intent(it.context, CharacteristicListActivity::class.java)
                //这里有坑,不能直接传service,要不然readCharacteristics会失败
                intent.putExtra(CharacteristicListActivity.SERVICE, service.uuid.toString())
                it.context.startActivity(intent)
            }
            return holder
        }


        override fun onBindViewHolder(holder: Holder, position: Int) {
            val service = services[position]
            holder.uuid.text = service.uuid.toString()
            holder.details.setTag(R.id.services, service)
        }

        override fun getItemCount(): Int {
            return services.size
        }

        class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val uuid: TextView = itemView.findViewById(R.id.uuid)
            val details: Button = itemView.findViewById(R.id.details)
        }

    }

    override fun onConnected(gatt: BluetoothGatt) {
        BleHelper.discoverServices(gatt, this)
    }

    override fun onServicesDiscovered(services: MutableList<BluetoothGattService>) {
        runOnUiThread {
            findViewById<RecyclerView>(R.id.services).let {
                it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                it.adapter = ServiceListAdapter(services)
            }
        }
    }
}