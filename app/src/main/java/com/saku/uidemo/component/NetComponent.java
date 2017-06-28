package com.saku.uidemo.component;

import com.saku.uidemo.activities.ChooseCarActivity;
import com.saku.uidemo.http.RESTApi;
import com.saku.uidemo.module.AppModule;
import com.saku.uidemo.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit getRetrofit();
    void inject(ChooseCarActivity chooseCarActivity);

}
