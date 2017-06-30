package com.saku.uidemo.module;

import android.app.Application;
import android.content.Context;

import com.saku.uidemo.data.ProductBaseInfo;
import com.saku.uidemo.data.listdata.BaseInfoData;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    public Application provideAppliaction(){
        return mApplication;
    }

    @Provides
    public Context provideApplicationContext() {
        return  mApplication;
    }

//    @Provides
//    public BaseInfoData provideBaseInfoData(ProductBaseInfo info){
//        BaseInfoData data = new BaseInfoData(info,null);
//        return data;
//    }
}
