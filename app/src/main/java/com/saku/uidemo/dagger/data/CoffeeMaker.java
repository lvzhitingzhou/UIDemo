package com.saku.uidemo.dagger.data;

import android.util.Log;

import javax.inject.Inject;

import dagger.Lazy;

public class CoffeeMaker {
    public static final String TAG = CoffeeMaker.class.getSimpleName();
    private Lazy<Heater> mHeater;
    private Pump mPump;

    @Inject
    public CoffeeMaker(Lazy<Heater> heater, Pump pump) {
        this.mHeater = heater;
        this.mPump = pump;
        Log.i(TAG, "CoffeeMaker: constructing");
    }

    public void brew() {
        mHeater.get().on();
        mPump.pump();
        Log.i(TAG, "brew: heater is on");
        mHeater.get().off();
    }
}
