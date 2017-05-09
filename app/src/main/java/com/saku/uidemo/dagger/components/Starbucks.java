package com.saku.uidemo.dagger.components;

import com.saku.uidemo.activities.DaggerActivity;
import com.saku.uidemo.dagger.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = {CoffeeShop.class})   // coffeeshop中指定了module， starbucks不用重复指定相同的module可以直接使用提供的类
public interface Starbucks{
    void inject(DaggerActivity daggerActivity);
}
