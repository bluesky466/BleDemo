package me.linjw.demo.ble

import android.app.Application
import android.bluetooth.*
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import java.util.*

object BleHelper {
    private const val TAG = "BleHelper"
    private const val UUID_DESCRIPTOR_CLIENT_CHARACTERISTIC_CONFIGURATION =
        "00002902-0000-1000-8000-00805f9b34fb"
    private const val PACKAGE_BLUETOOTH = "com.android.bluetooth"
    private const val ACTION_BLUETOOTH = "android.bluetooth.IBluetoothHidHost"

    private lateinit var application: Application

    private lateinit var scanner: BluetoothLeScanner
    private var scanCallback: ScanCallback? = null
    private var hidHost: IBluetoothHidHost? = null

    private var connectCallback: ConnectCallback? = null
    private var gatt: BluetoothGatt? = null
    private val gattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
            super.onConnectionStateChange(gatt, status, newState)
            this@BleHelper.gatt = gatt ?: return

            if (newState == BluetoothProfile.STATE_CONNECTED) {
                connectCallback?.onConnected(gatt)
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
            super.onServicesDiscovered(gatt, status)
            val services = gatt?.services ?: return
            discoverServicesCallback?.onServicesDiscovered(services)
        }

        override fun onCharacteristicRead(
            gatt: BluetoothGatt?,
            characteristic: BluetoothGattCharacteristic?,
            status: Int
        ) {
            super.onCharacteristicRead(gatt, characteristic, status)
            if (characteristic == null) {
                return
            }
            readCharacteristicCallback?.onCharacteristicRead(characteristic)
        }

        override fun onCharacteristicWrite(
            gatt: BluetoothGatt?,
            characteristic: BluetoothGattCharacteristic?,
            status: Int
        ) {
            super.onCharacteristicWrite(gatt, characteristic, status)
            Log.d(TAG, "onCharacteristicWrite ${characteristic?.uuid} ${status}")
        }

        override fun onCharacteristicChanged(
            gatt: BluetoothGatt?,
            characteristic: BluetoothGattCharacteristic?
        ) {
            super.onCharacteristicChanged(gatt, characteristic)
            Log.d(TAG, "onCharacteristicChanged ${characteristic?.uuid}")
            if (characteristic != null) {
                characteristicChangedCallback?.onCharacteristicChanged(characteristic)
            }
        }

        override fun onMtuChanged(gatt: BluetoothGatt?, mtu: Int, status: Int) {
            super.onMtuChanged(gatt, mtu, status)
            Log.d(TAG, "onMtuChanged $mtu")
        }
    }

    private var discoverServicesCallback: DiscoverServicesCallback? = null

    private var readCharacteristicCallback: ReadCharacteristicCallback? = null

    private var characteristicChangedCallback: CharacteristicChangedCallback? = null

    fun init(application: Application) {
        this.application = application

        val intent = Intent(ACTION_BLUETOOTH)
        intent.setPackage(PACKAGE_BLUETOOTH)

        Log.d(TAG, "init")
        application.bindService(
            intent,
            object : ServiceConnection {
                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                    Log.d(TAG, "IBluetoothHidHost onServiceConnected")
                    hidHost = IBluetoothHidHost.Stub.asInterface(service)
                }

                override fun onServiceDisconnected(name: ComponentName?) {
                    Log.d(TAG, "IBluetoothHidHost onServiceDisconnected")
                }
            },
            Context.BIND_AUTO_CREATE
        )
    }

    /**
     * 第一步,开始扫描ble设备
     */
    fun startScan(context: Context, callback: ScanCallback): Boolean {
        val manager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val adapter = manager.adapter
        scanner = adapter?.bluetoothLeScanner ?: return false
        scanner.startScan(callback)
        scanCallback = callback
        return true
    }

    fun stopScan() {
        scanner.stopScan(scanCallback)
    }

    /**
     * 第二步,连接ble设备
     */
    fun connectDevice(
        context: Context,
        device: BluetoothDevice,
        callback: ConnectCallback
    ) {
        connectCallback = callback
        device.connectGatt(context, true, gattCallback)
    }

    fun disconnectDevice() {
        gatt?.disconnect()
        gatt?.close()
    }

    /**
     * 第三步,搜索ble服务提供的服务
     */
    fun discoverServices(gatt: BluetoothGatt, callback: DiscoverServicesCallback) {
        discoverServicesCallback = callback
        gatt.discoverServices()
    }

    /**
     * 读取特征值
     */
    fun readCharacteristic(
        characteristic: BluetoothGattCharacteristic,
        callback: ReadCharacteristicCallback
    ) {
        readCharacteristicCallback = callback
        gatt?.readCharacteristic(characteristic)
    }

    /**
     * 写入特征值
     */
    fun writeCharacteristic(
        characteristic: BluetoothGattCharacteristic,
        bytes: ByteArray
    ) {
        characteristic.value = bytes
        gatt?.writeCharacteristic(characteristic)
    }

    /**
     * 修改mtu
     */
    fun setMtu(mtu: Int) {
        gatt?.requestMtu(mtu)
    }

    /**
     * 启动Characteristic变化监听
     */
    fun startCharacteristicChangeNotify(
        characteristic: BluetoothGattCharacteristic,
        callback: CharacteristicChangedCallback
    ) {
        val gatt = gatt ?: return
        characteristicChangedCallback = callback
        if (gatt.setCharacteristicNotification(characteristic, true)) {
            val descriptor = characteristic.getDescriptor(
                UUID.fromString(UUID_DESCRIPTOR_CLIENT_CHARACTERISTIC_CONFIGURATION)
            )
            descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            gatt.writeDescriptor(descriptor)
        }
    }

    /**
     * 停止Characteristic变化监听
     */
    fun stopCharacteristicChangeNotify(characteristic: BluetoothGattCharacteristic) {
        val gatt = gatt ?: return

        characteristicChangedCallback = null
        if (gatt.setCharacteristicNotification(characteristic, true)) {
            val descriptor = characteristic.getDescriptor(
                UUID.fromString(UUID_DESCRIPTOR_CLIENT_CHARACTERISTIC_CONFIGURATION)
            )
            descriptor.value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
            gatt.writeDescriptor(descriptor)
        }
    }

    /**
     * 绑定设备
     */
    fun bond(device: BluetoothDevice) {
        val result = hidHost?.connect(device)
        Log.d(TAG,"bond $result")
    }

    fun isCharacteristicReadable(characteristic: BluetoothGattCharacteristic): Boolean {
        return (characteristic.properties and BluetoothGattCharacteristic.PROPERTY_READ) != 0
    }

    fun isCharacteristicWriteable(characteristic: BluetoothGattCharacteristic): Boolean {
        return (characteristic.properties and BluetoothGattCharacteristic.PROPERTY_WRITE) != 0
    }

    fun isCharacteristicNotify(characteristic: BluetoothGattCharacteristic): Boolean {
        return (characteristic.properties and BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0
    }

    fun getService(uuid: String): BluetoothGattService? {
        return gatt?.getService(UUID.fromString(uuid))
    }

    fun getCharacteristic(
        serviceUuid: String,
        characteristicUuid: String
    ): BluetoothGattCharacteristic? {
        return gatt
            ?.getService(UUID.fromString(serviceUuid))
            ?.getCharacteristic(UUID.fromString(characteristicUuid))
    }

    interface ConnectCallback {
        fun onConnected(gatt: BluetoothGatt)
    }

    interface DiscoverServicesCallback {
        fun onServicesDiscovered(services: MutableList<BluetoothGattService>)
    }

    interface ReadCharacteristicCallback {
        fun onCharacteristicRead(characteristic: BluetoothGattCharacteristic)
    }

    interface CharacteristicChangedCallback {
        fun onCharacteristicChanged(characteristic: BluetoothGattCharacteristic)
    }
}