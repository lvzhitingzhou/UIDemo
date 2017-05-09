package com.saku.uidemo.dagger.modules;

import android.util.Log;

import com.saku.uidemo.dagger.data.ElectricHeater;
import com.saku.uidemo.dagger.data.Heater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//@Module(includes = PumpModule.class)
@Module
public class DripCoffeeModule {
    public static final String TAG = DripCoffeeModule.class.getSimpleName();

    @Singleton
    @Provides
    Heater provideHeater(){
        Log.i(TAG, "provideHeater: ");
        return new ElectricHeater();
    }
}
