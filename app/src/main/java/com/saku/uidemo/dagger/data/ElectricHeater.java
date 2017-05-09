package com.saku.uidemo.dagger.data;

import android.util.Log;

public class ElectricHeater implements Heater {
    public static final String TAG = ElectricHeater.class.getSimpleName();
    private boolean isHot;

    public ElectricHeater() {
        Log.i(TAG, "ElectricHeater: constructing");
    }

    @Override
    public void on() {
        Log.i(TAG, "on: is heating");
        isHot = true;
    }

    @Override
    public void off() {
        Log.i(TAG, "off: ");
        isHot = false;
    }

    @Override
    public boolean isHot() {
        Log.i(TAG, "isHot: " + isHot);
        return isHot;
    }
}
