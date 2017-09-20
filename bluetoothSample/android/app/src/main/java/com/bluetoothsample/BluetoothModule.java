package com.bluetoothsample;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by j.lee on 9/19/17.
 */

public class BluetoothModule extends ReactContextBaseJavaModule {
    BluetoothHeadset mBluetoothHeadset;
    ReactContext mReactContext;


    // Get the default adapter
    BluetoothAdapter mBluetoothAdapter;

    public BluetoothModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;

        // Get the default adapter
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    @Override
    public String getName() {
        return "BluetoothModule";
    }

    @ReactMethod
    public void printTest() {
        System.out.println("--------------------------------------[[printTest()]]--------------------------------------]]");
    }

    @ReactMethod
    public void connect() {
        System.out.println("--------------------------------------[[CONNECT() called]]--------------------------------------]]");
        if (mBluetoothAdapter != null) {
            System.out.println("--------------------------------------[[CONNECT() success]]--------------------------------------]]");
            // Establish connection to the proxy.
            mBluetoothAdapter.getProfileProxy(mReactContext, mProfileListener, BluetoothProfile.HEADSET);
        } else {
            System.out.println("--------------------------------------[[CONNECT failed]]--------------------------------------]]");
        }

    }

    @ReactMethod
    public void isConnected(Callback error, Callback success) {
        if (mBluetoothAdapter != null) {
            success.invoke(true);
        } else {
            error.invoke(true);
        }

    }

    private BluetoothProfile.ServiceListener mProfileListener = new BluetoothProfile.ServiceListener() {
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            if (profile == BluetoothProfile.HEADSET) {
                mBluetoothHeadset = (BluetoothHeadset) proxy;
            }
        }

        public void onServiceDisconnected(int profile) {
            if (profile == BluetoothProfile.HEADSET) {
                mBluetoothHeadset = null;
            }
        }
    };
}
