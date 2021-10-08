package me.linjw.demo.ble

import android.app.Activity
import android.bluetooth.BluetoothGattCharacteristic
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CharacteristicNotifyActivity : Activity(), BleHelper.CharacteristicChangedCallback {
    companion object {
        const val SERVICE = "service"
        const val CHARACTERISTIC = "characteristic"
    }

    private lateinit var characteristic: BluetoothGattCharacteristic

    private lateinit var data: TextView
    private lateinit var uuid: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characteristic_notify)

        val serviceUuid = intent.getStringExtra(SERVICE)!!
        val characteristicUuid = intent.getStringExtra(CHARACTERISTIC)!!
        characteristic = BleHelper.getCharacteristic(serviceUuid, characteristicUuid)!!

        uuid = findViewById(R.id.uuid)
        uuid.text = characteristicUuid

        data = findViewById(R.id.data)
    }

    override fun onStart() {
        super.onStart()

        BleHelper.startCharacteristicChangeNotify(characteristic, this)
    }

    override fun onCharacteristicChanged(characteristic: BluetoothGattCharacteristic) {
        runOnUiThread {
            data.text = characteristic.value.map { String.format("0X%02X", it) }.toString()
        }
    }
}