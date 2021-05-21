package com.gustavoraposo.btbattle.model.service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothProfile;

import java.util.UUID;

public class BluetoothCallback {

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattCharacteristic mNotifyCharacteristic;

    public BluetoothCallback(BluetoothAdapter bluetoothAdapter, BluetoothGatt bluetoothGatt){
        this.mBluetoothAdapter = bluetoothAdapter;
        this.mBluetoothGatt = bluetoothGatt;
    }

    private final UUID MyUUID = UUID.fromString("000ffe1-0000-1000-8000-00805f9b34fb");
    private final UUID CLIENT_CHARACTERISTIC_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private final UUID SERVICE = UUID.fromString("0000ffe0-0000-1000-8000-00805f9b34fb");


    private final BluetoothGattCallback callback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            super.onConnectionStateChange(gatt, status, newState);

            if (newState == BluetoothProfile.STATE_CONNECTED) {
//                sendBroadcast(new Intent(ACTION_GATT_CONNECTED));
                gatt.discoverServices();
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
//                sendBroadcast(new Intent(ACTION_GATT_DISCONNECTED));
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            super.onServicesDiscovered(gatt, status);
            BluetoothGattCharacteristic characteristic = mBluetoothGatt.getService(SERVICE).getCharacteristic(MyUUID);
            final int charaProp = characteristic.getProperties();
            if ((charaProp | BluetoothGattCharacteristic.PROPERTY_READ) > 0) {
                if (mNotifyCharacteristic != null) {
                    setCharacteristicNotification(mNotifyCharacteristic, false);
                    mNotifyCharacteristic = null;
                }
            }
            if ((charaProp | BluetoothGattCharacteristic.PROPERTY_NOTIFY) > 0) {
                mNotifyCharacteristic = characteristic;
                setCharacteristicNotification(characteristic, true);
            }
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            super.onCharacteristicChanged(gatt, characteristic);
        }
    };

    private void setCharacteristicNotification(BluetoothGattCharacteristic characteristic, boolean enabled) {
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            return;
        }
        this.mBluetoothGatt.setCharacteristicNotification(characteristic, enabled);

        if (MyUUID.equals(characteristic.getUuid())) {
            BluetoothGattDescriptor descriptor = characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG);
            descriptor.setValue(enabled ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            this.mBluetoothGatt.writeDescriptor(descriptor);
        }
    }

    public BluetoothGattCallback getCallback() {
        return callback;
    }

    public void write(byte[] value) {
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            return;
        }
        BluetoothGattService Service = mBluetoothGatt.getService(SERVICE);
        BluetoothGattCharacteristic characteristic = Service.getCharacteristic(MyUUID);
        characteristic.setValue(value);
        mBluetoothGatt.writeCharacteristic(characteristic);
    }
}
