package me.linjw.demo.ble

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.PERMISSION_DENIED
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        private const val REQUEST_CODE_ACCESS_COARSE_LOCATION = 0x123
    }

    private val adapter = DeviceListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BleHelper.init(this.application)

        findViewById<RecyclerView>(R.id.devices).let {
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            it.adapter = adapter
        }
    }

    override fun onStart() {
        super.onStart()
        startScan()

        // 从连接页面回到主页就断开连接
        BleHelper.disconnectDevice()
    }

    override fun onStop() {
        super.onStop()
        stopScan()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PERMISSION_GRANTED) {
            startScan()
        }
    }

    private fun startScan() {
        // 打开蓝牙功能
        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        if (!bluetoothManager.adapter.isEnabled) {
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                startScan()
            }.launch(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE))
            return
        }

        // 判断GPS是否打开
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "GPS功能没有打开", Toast.LENGTH_SHORT).show()
            return
        }

        // 判断是否有模糊定位的权限
        if (PERMISSION_DENIED
            == PermissionChecker.checkCallingOrSelfPermission(this, ACCESS_COARSE_LOCATION)
        ) {
            requestPermissions(arrayOf(ACCESS_COARSE_LOCATION), REQUEST_CODE_ACCESS_COARSE_LOCATION)
            return
        }

        BleHelper.startScan(this, object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult?) {
                super.onScanResult(callbackType, result)
                result?.let { adapter.onDeviceFound(it) }
            }
        })
    }

    private fun stopScan() {
        BleHelper.stopScan()
    }
}