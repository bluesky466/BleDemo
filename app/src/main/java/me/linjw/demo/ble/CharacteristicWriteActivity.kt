package me.linjw.demo.ble

import android.app.Activity
import android.bluetooth.BluetoothGattCharacteristic
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CharacteristicWriteActivity : Activity() {
    companion object {
        const val SERVICE = "service"
        const val CHARACTERISTIC = "characteristic"
    }

    private lateinit var characteristic: BluetoothGattCharacteristic

    private lateinit var dataEdit: EditText
    private lateinit var mtuEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characteristic_write)

        val serviceUuid = intent.getStringExtra(SERVICE)!!
        val characteristicUuid = intent.getStringExtra(CHARACTERISTIC)!!
        characteristic = BleHelper.getCharacteristic(serviceUuid, characteristicUuid)!!

        dataEdit = findViewById(R.id.data)
        mtuEdit = findViewById(R.id.mtu)

        findViewById<Button>(R.id.send_data).setOnClickListener {
            sendData(dataEdit.text.toString())
        }

        findViewById<Button>(R.id.send_mtu).setOnClickListener {
            sendMtu(mtuEdit.text.toString())
        }
    }

    private fun sendData(data: String) {
        val bytes = data.chunked(2)
            .map { it.toInt(16).toByte() }
            .toByteArray()
        BleHelper.writeCharacteristic(characteristic, bytes)
    }

    private fun sendMtu(mtu: String) {
        BleHelper.setMtu(mtu.toInt())
    }
}