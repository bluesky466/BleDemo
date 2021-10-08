package me.linjw.demo.ble

import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharacteristicListActivity : AppCompatActivity(), BleHelper.ReadCharacteristicCallback {
    companion object {
        const val SERVICE = "service"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characteristic_list)

        val serviceUuid = intent.getStringExtra(SERVICE)!!
        val service = BleHelper.getService(serviceUuid)!!

        findViewById<RecyclerView>(R.id.characteristics).let {
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            it.adapter = CharacteristicListAdapter(this, serviceUuid, service.characteristics, this)
        }
    }

    override fun onCharacteristicRead(characteristic: BluetoothGattCharacteristic) {
        runOnUiThread {
            val data = characteristic.value?.map { String.format("0X%02X", it) }
            Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    class CharacteristicListAdapter(
        private val context: Context,
        private val serviceUuid: String,
        private val characteristics: List<BluetoothGattCharacteristic>,
        private val callback: BleHelper.ReadCharacteristicCallback,
    ) :
        RecyclerView.Adapter<CharacteristicListAdapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_characteristic, parent, false)

            val holder = Holder(view)
            holder.read.setOnClickListener {
                val characteristic = it.tag as BluetoothGattCharacteristic
                BleHelper.readCharacteristic(characteristic, callback)
            }

            holder.write.setOnClickListener {
                val characteristic = it.tag as BluetoothGattCharacteristic
                val intent = Intent(it.context, CharacteristicWriteActivity::class.java)
                intent.putExtra(CharacteristicWriteActivity.SERVICE, serviceUuid)
                intent.putExtra(
                    CharacteristicWriteActivity.CHARACTERISTIC,
                    characteristic.uuid.toString()
                )
                context.startActivity(intent)
            }

            holder.notify.setOnClickListener {
                val characteristic = it.tag as BluetoothGattCharacteristic

                val intent = Intent(it.context, CharacteristicNotifyActivity::class.java)
                intent.putExtra(CharacteristicNotifyActivity.SERVICE, serviceUuid)
                intent.putExtra(
                    CharacteristicNotifyActivity.CHARACTERISTIC,
                    characteristic.uuid.toString()
                )
                context.startActivity(intent)
            }
            return holder
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            val characteristic = characteristics[position]
            holder.uuid.text = characteristic.uuid.toString()
            val readable = BleHelper.isCharacteristicReadable(characteristic)
            val writeable = BleHelper.isCharacteristicWriteable(characteristic)
            val notify = BleHelper.isCharacteristicNotify(characteristic)
            holder.read.visibility = if (readable) View.VISIBLE else View.INVISIBLE
            holder.write.visibility = if (writeable) View.VISIBLE else View.INVISIBLE
            holder.notify.visibility = if (notify) View.VISIBLE else View.INVISIBLE
            holder.read.tag = characteristic
            holder.write.tag = characteristic
            holder.notify.tag = characteristic
        }

        override fun getItemCount(): Int {
            return characteristics.size
        }

        class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val uuid: TextView = itemView.findViewById(R.id.uuid)
            val read: Button = itemView.findViewById(R.id.read)
            val write: Button = itemView.findViewById(R.id.write)
            val notify: Button = itemView.findViewById(R.id.notify)
        }
    }
}