/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package me.linjw.demo.ble;
/**
 * API for Bluetooth HID service
 *
 */
public interface IBluetoothHidHost extends android.os.IInterface
{
    /** Default implementation for IBluetoothHidHost. */
    public static class Default implements IBluetoothHidHost
    {
        // Public API
        @Override public boolean connect(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
        {
            return false;
        }
        @Override public boolean disconnect(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
        {
            return false;
        }
        @Override public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices() throws android.os.RemoteException
        {
            return null;
        }
        @Override public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) throws android.os.RemoteException
        {
            return null;
        }
        @Override public int getConnectionState(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
        {
            return 0;
        }
        @Override public boolean setConnectionPolicy(android.bluetooth.BluetoothDevice device, int connectionPolicy) throws android.os.RemoteException
        {
            return false;
        }
        @Override public int getConnectionPolicy(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
        {
            return 0;
        }
        /**
         * @hide
         */
        @Override public boolean getProtocolMode(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
        {
            return false;
        }
        /**
         * @hide
         */
        @Override public boolean virtualUnplug(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
        {
            return false;
        }
        /**
         * @hide
         */
        @Override public boolean setProtocolMode(android.bluetooth.BluetoothDevice device, int protocolMode) throws android.os.RemoteException
        {
            return false;
        }
        /**
         * @hide
         */
        @Override public boolean getReport(android.bluetooth.BluetoothDevice device, byte reportType, byte reportId, int bufferSize) throws android.os.RemoteException
        {
            return false;
        }
        /**
         * @hide
         */
        @Override public boolean setReport(android.bluetooth.BluetoothDevice device, byte reportType, java.lang.String report) throws android.os.RemoteException
        {
            return false;
        }
        /**
         * @hide
         */
        @Override public boolean sendData(android.bluetooth.BluetoothDevice device, java.lang.String report) throws android.os.RemoteException
        {
            return false;
        }
        /**
         * @hide
         */
        @Override public boolean getIdleTime(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
        {
            return false;
        }
        /**
         * @hide
         */
        @Override public boolean setIdleTime(android.bluetooth.BluetoothDevice device, byte idleTime) throws android.os.RemoteException
        {
            return false;
        }
        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }
    /** Local-side IPC implementation stub class. */
    public static abstract class Stub extends android.os.Binder implements IBluetoothHidHost
    {
        /** Construct the stub at attach it to the interface. */
        public Stub()
        {
            this.attachInterface(this, DESCRIPTOR);
        }
        /**
         * Cast an IBinder object into an me.linjw.demo.ble.IBluetoothHidHost interface,
         * generating a proxy if needed.
         */
        public static IBluetoothHidHost asInterface(android.os.IBinder obj)
        {
            if ((obj==null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin!=null)&&(iin instanceof IBluetoothHidHost))) {
                return ((IBluetoothHidHost)iin);
            }
            return new IBluetoothHidHost.Stub.Proxy(obj);
        }
        @Override public android.os.IBinder asBinder()
        {
            return this;
        }
        /** @hide */
        public static java.lang.String getDefaultTransactionName(int transactionCode)
        {
            switch (transactionCode)
            {
                case TRANSACTION_connect:
                {
                    return "connect";
                }
                case TRANSACTION_disconnect:
                {
                    return "disconnect";
                }
                case TRANSACTION_getConnectedDevices:
                {
                    return "getConnectedDevices";
                }
                case TRANSACTION_getDevicesMatchingConnectionStates:
                {
                    return "getDevicesMatchingConnectionStates";
                }
                case TRANSACTION_getConnectionState:
                {
                    return "getConnectionState";
                }
                case TRANSACTION_setConnectionPolicy:
                {
                    return "setConnectionPolicy";
                }
                case TRANSACTION_getConnectionPolicy:
                {
                    return "getConnectionPolicy";
                }
                case TRANSACTION_getProtocolMode:
                {
                    return "getProtocolMode";
                }
                case TRANSACTION_virtualUnplug:
                {
                    return "virtualUnplug";
                }
                case TRANSACTION_setProtocolMode:
                {
                    return "setProtocolMode";
                }
                case TRANSACTION_getReport:
                {
                    return "getReport";
                }
                case TRANSACTION_setReport:
                {
                    return "setReport";
                }
                case TRANSACTION_sendData:
                {
                    return "sendData";
                }
                case TRANSACTION_getIdleTime:
                {
                    return "getIdleTime";
                }
                case TRANSACTION_setIdleTime:
                {
                    return "setIdleTime";
                }
                default:
                {
                    return null;
                }
            }
        }
        /** @hide */
        public java.lang.String getTransactionName(int transactionCode)
        {
            return this.getDefaultTransactionName(transactionCode);
        }
        @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
        {
            java.lang.String descriptor = DESCRIPTOR;
            if (code >= android.os.IBinder.FIRST_CALL_TRANSACTION && code <= android.os.IBinder.LAST_CALL_TRANSACTION) {
                data.enforceInterface(descriptor);
            }
            switch (code)
            {
                case INTERFACE_TRANSACTION:
                {
                    reply.writeString(descriptor);
                    return true;
                }
            }
            switch (code)
            {
                case TRANSACTION_connect:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    boolean _result = this.connect(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                case TRANSACTION_disconnect:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    boolean _result = this.disconnect(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                case TRANSACTION_getConnectedDevices:
                {
                    java.util.List<android.bluetooth.BluetoothDevice> _result = this.getConnectedDevices();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    break;
                }
                case TRANSACTION_getDevicesMatchingConnectionStates:
                {
                    int[] _arg0;
                    _arg0 = data.createIntArray();
                    java.util.List<android.bluetooth.BluetoothDevice> _result = this.getDevicesMatchingConnectionStates(_arg0);
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    break;
                }
                case TRANSACTION_getConnectionState:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    int _result = this.getConnectionState(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_setConnectionPolicy:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _result = this.setConnectionPolicy(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                case TRANSACTION_getConnectionPolicy:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    int _result = this.getConnectionPolicy(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    break;
                }
                case TRANSACTION_getProtocolMode:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    boolean _result = this.getProtocolMode(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                case TRANSACTION_virtualUnplug:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    boolean _result = this.virtualUnplug(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                case TRANSACTION_setProtocolMode:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _result = this.setProtocolMode(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                case TRANSACTION_getReport:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    byte _arg1;
                    _arg1 = data.readByte();
                    byte _arg2;
                    _arg2 = data.readByte();
                    int _arg3;
                    _arg3 = data.readInt();
                    boolean _result = this.getReport(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                case TRANSACTION_setReport:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    byte _arg1;
                    _arg1 = data.readByte();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    boolean _result = this.setReport(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                case TRANSACTION_sendData:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    boolean _result = this.sendData(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                case TRANSACTION_getIdleTime:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    boolean _result = this.getIdleTime(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                case TRANSACTION_setIdleTime:
                {
                    android.bluetooth.BluetoothDevice _arg0;
                    if ((0!=data.readInt())) {
                        _arg0 = android.bluetooth.BluetoothDevice.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    byte _arg1;
                    _arg1 = data.readByte();
                    boolean _result = this.setIdleTime(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result)?(1):(0)));
                    break;
                }
                default:
                {
                    return super.onTransact(code, data, reply, flags);
                }
            }
            return true;
        }
        private static class Proxy implements IBluetoothHidHost
        {
            private android.os.IBinder mRemote;
            Proxy(android.os.IBinder remote)
            {
                mRemote = remote;
            }
            @Override public android.os.IBinder asBinder()
            {
                return mRemote;
            }
            public java.lang.String getInterfaceDescriptor()
            {
                return DESCRIPTOR;
            }
            // Public API
            @Override public boolean connect(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    boolean _status = mRemote.transact(Stub.TRANSACTION_connect, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().connect(device);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override public boolean disconnect(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    boolean _status = mRemote.transact(Stub.TRANSACTION_disconnect, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().disconnect(device);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices() throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<android.bluetooth.BluetoothDevice> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getConnectedDevices, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().getConnectedDevices();
                        }
                    }
                    _reply.readException();
                    _result = _reply.createTypedArrayList(android.bluetooth.BluetoothDevice.CREATOR);
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<android.bluetooth.BluetoothDevice> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeIntArray(states);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getDevicesMatchingConnectionStates, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().getDevicesMatchingConnectionStates(states);
                        }
                    }
                    _reply.readException();
                    _result = _reply.createTypedArrayList(android.bluetooth.BluetoothDevice.CREATOR);
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override public int getConnectionState(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getConnectionState, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().getConnectionState(device);
                        }
                    }
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override public boolean setConnectionPolicy(android.bluetooth.BluetoothDevice device, int connectionPolicy) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(connectionPolicy);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_setConnectionPolicy, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().setConnectionPolicy(device, connectionPolicy);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override public int getConnectionPolicy(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getConnectionPolicy, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().getConnectionPolicy(device);
                        }
                    }
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            /**
             * @hide
             */
            @Override public boolean getProtocolMode(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getProtocolMode, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().getProtocolMode(device);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            /**
             * @hide
             */
            @Override public boolean virtualUnplug(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    boolean _status = mRemote.transact(Stub.TRANSACTION_virtualUnplug, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().virtualUnplug(device);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            /**
             * @hide
             */
            @Override public boolean setProtocolMode(android.bluetooth.BluetoothDevice device, int protocolMode) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(protocolMode);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_setProtocolMode, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().setProtocolMode(device, protocolMode);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            /**
             * @hide
             */
            @Override public boolean getReport(android.bluetooth.BluetoothDevice device, byte reportType, byte reportId, int bufferSize) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    _data.writeByte(reportType);
                    _data.writeByte(reportId);
                    _data.writeInt(bufferSize);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getReport, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().getReport(device, reportType, reportId, bufferSize);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            /**
             * @hide
             */
            @Override public boolean setReport(android.bluetooth.BluetoothDevice device, byte reportType, java.lang.String report) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    _data.writeByte(reportType);
                    _data.writeString(report);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_setReport, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().setReport(device, reportType, report);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            /**
             * @hide
             */
            @Override public boolean sendData(android.bluetooth.BluetoothDevice device, java.lang.String report) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    _data.writeString(report);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendData, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().sendData(device, report);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            /**
             * @hide
             */
            @Override public boolean getIdleTime(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getIdleTime, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().getIdleTime(device);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            /**
             * @hide
             */
            @Override public boolean setIdleTime(android.bluetooth.BluetoothDevice device, byte idleTime) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((device!=null)) {
                        _data.writeInt(1);
                        device.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    _data.writeByte(idleTime);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_setIdleTime, _data, _reply, 0);
                    if (!_status) {
                        if (getDefaultImpl() != null) {
                            return getDefaultImpl().setIdleTime(device, idleTime);
                        }
                    }
                    _reply.readException();
                    _result = (0!=_reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            public static IBluetoothHidHost sDefaultImpl;
        }
        public static final java.lang.String DESCRIPTOR = "android.bluetooth.IBluetoothHidHost";
        static final int TRANSACTION_connect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_disconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_getConnectedDevices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_getDevicesMatchingConnectionStates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_getConnectionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_setConnectionPolicy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
        static final int TRANSACTION_getConnectionPolicy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
        static final int TRANSACTION_getProtocolMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
        static final int TRANSACTION_virtualUnplug = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
        static final int TRANSACTION_setProtocolMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
        static final int TRANSACTION_getReport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
        static final int TRANSACTION_setReport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
        static final int TRANSACTION_sendData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
        static final int TRANSACTION_getIdleTime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
        static final int TRANSACTION_setIdleTime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
        public static boolean setDefaultImpl(IBluetoothHidHost impl) {
            // Only one user of this interface can use this function
            // at a time. This is a heuristic to detect if two different
            // users in the same process use this function.
            if (Stub.Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl != null) {
                Stub.Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }
        public static IBluetoothHidHost getDefaultImpl() {
            return Stub.Proxy.sDefaultImpl;
        }
    }
    // Public API
    public boolean connect(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
    public boolean disconnect(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
    public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices() throws android.os.RemoteException;
    public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) throws android.os.RemoteException;
    public int getConnectionState(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
    public boolean setConnectionPolicy(android.bluetooth.BluetoothDevice device, int connectionPolicy) throws android.os.RemoteException;
    public int getConnectionPolicy(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
    /**
     * @hide
     */
    public boolean getProtocolMode(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
    /**
     * @hide
     */
    public boolean virtualUnplug(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
    /**
     * @hide
     */
    public boolean setProtocolMode(android.bluetooth.BluetoothDevice device, int protocolMode) throws android.os.RemoteException;
    /**
     * @hide
     */
    public boolean getReport(android.bluetooth.BluetoothDevice device, byte reportType, byte reportId, int bufferSize) throws android.os.RemoteException;
    /**
     * @hide
     */
    public boolean setReport(android.bluetooth.BluetoothDevice device, byte reportType, java.lang.String report) throws android.os.RemoteException;
    /**
     * @hide
     */
    public boolean sendData(android.bluetooth.BluetoothDevice device, java.lang.String report) throws android.os.RemoteException;
    /**
     * @hide
     */
    public boolean getIdleTime(android.bluetooth.BluetoothDevice device) throws android.os.RemoteException;
    /**
     * @hide
     */
    public boolean setIdleTime(android.bluetooth.BluetoothDevice device, byte idleTime) throws android.os.RemoteException;
}