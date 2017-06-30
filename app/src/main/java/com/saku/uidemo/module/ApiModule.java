package com.saku.uidemo.module;

import com.saku.uidemo.annotation.ApiScope;
import com.saku.uidemo.data.GeneralProduct;
import com.saku.uidemo.http.BaseData;
import com.saku.uidemo.http.RESTApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    Call<BaseData<GeneralProduct>> provideGeneralProduct(RESTApi restApi) {
        return restApi.getCarList();
    }

//    @Singleton
    @Provides
    @ApiScope
    RESTApi provideRESTApi(Retrofit retrofit) {
        return retrofit.create(RESTApi.class);
    }
}
