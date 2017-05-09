package com.saku.uidemo.dagger.components;

import com.saku.uidemo.activities.MainActivity;
import com.saku.uidemo.dagger.data.CoffeeMaker;
import com.saku.uidemo.dagger.data.ElectricHeater;
import com.saku.uidemo.dagger.data.Thermosiphon;
import com.saku.uidemo.dagger.modules.DripCoffeeModule;
import com.saku.uidemo.dagger.modules.PumpModule;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
//@Component(modules = {DripCoffeeModule.class})   // 这种方式对应DripCoffeeModule类的module注解用includes包括pumpModule.class
@Component(modules = {DripCoffeeModule.class, PumpModule.class})
public interface CoffeeShop {

    CoffeeMaker maker();

    Thermosiphon getPump();
//
//    ElectricHeater getHeater();

    void inject(MainActivity mainActivity);

}
