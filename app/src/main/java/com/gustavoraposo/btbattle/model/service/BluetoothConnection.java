package com.gustavoraposo.btbattle.model.service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;

public class BluetoothConnection {
    private Context context;
    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothCallback mBluetoothCallback;

    public BluetoothConnection(Context context, BluetoothCallback callback){
        this.context = context;
        this.mBluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        this.mBluetoothAdapter = mBluetoothManager.getAdapter();
        this.mBluetoothCallback = callback;
    }

    public void connect(BluetoothDevice device){
        if(mBluetoothAdapter != null && device != null){
            mBluetoothGatt = device.connectGatt(context, true, mBluetoothCallback.getCallback());
        }
    }

    public void disconnect(){
        if(mBluetoothAdapter != null && mBluetoothGatt != null){
            mBluetoothGatt.disconnect();
            mBluetoothGatt.close();
        }
    }
}
