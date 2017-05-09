package com.saku.uidemo.dagger.data;

import android.util.Log;

import javax.inject.Inject;

public class Thermosiphon implements Pump {
    public static final String TAG = Thermosiphon.class.getSimpleName();

    private final Heater mHeater;

    @Inject
    public Thermosiphon(Heater heater){
        this.mHeater = heater;
        Log.i(TAG, "Thermosiphon: construting");
    }

    @Override
    public void pump() {
        if (mHeater.isHot()) {
            Log.i(TAG, "pump: is hot");
        }
    }
}
