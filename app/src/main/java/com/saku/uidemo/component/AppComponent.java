package com.saku.uidemo.component;

import android.app.Application;
import android.content.Context;

import com.saku.uidemo.data.ProductBaseInfo;
import com.saku.uidemo.data.listdata.BaseInfoData;
import com.saku.uidemo.module.AppModule;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    final class Initializer {
        public static AppComponent init(Application application) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(application))
                    .build();
        }
    }

    Context getContext();

//    BaseInfoData getBaseInfoData(ProductBaseInfo productBaseInfo);
//    BaseInfoData getBaseInfoData();

}
