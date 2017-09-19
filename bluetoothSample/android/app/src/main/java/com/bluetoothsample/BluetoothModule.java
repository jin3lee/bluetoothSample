package com.bluetoothsample;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by j.lee on 9/19/17.
 */

public class BluetoothModule extends ReactContextBaseJavaModule {
    public BluetoothModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "Bluetooth";
    }

    @ReactMethod
    public void printTest() {
        System.out.println("TEST COMPLETED!!!!!!!!!!");
    }
}
