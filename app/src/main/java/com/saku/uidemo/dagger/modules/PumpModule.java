package com.saku.uidemo.dagger.modules;

import android.util.Log;

import com.saku.uidemo.dagger.data.Heater;
import com.saku.uidemo.dagger.data.Pump;
import com.saku.uidemo.dagger.data.Thermosiphon;

import dagger.Module;
import dagger.Provides;

@Module
public class PumpModule {
    public static final String TAG = PumpModule.class.getSimpleName();

    @Provides
    public Pump providePump(Thermosiphon pump){
        Log.i(TAG, "providePump: ");
        return pump;
    }
}
