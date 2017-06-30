package com.saku.uidemo.component;

import com.google.gson.Gson;
import com.saku.uidemo.activities.ChooseCarActivity;
import com.saku.uidemo.http.RESTApi;
import com.saku.uidemo.module.AppModule;
import com.saku.uidemo.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit getRetrofit();
    Gson getGson();
    void inject(ChooseCarActivity chooseCarActivity);

}
