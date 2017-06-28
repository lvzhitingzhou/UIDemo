package com.saku.uidemo.component;

import com.saku.uidemo.annotation.ApiScope;
import com.saku.uidemo.data.GeneralProduct;
import com.saku.uidemo.http.BaseData;
import com.saku.uidemo.http.RESTApi;
import com.saku.uidemo.module.RESTModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;
import retrofit2.Call;
import retrofit2.Retrofit;

//@Singleton
@ApiScope
@Component(dependencies = {NetComponent.class}, modules = RESTModule.class)
//@Subcomponent(dependencies = NetComponent.class, modules = RESTModule.class)
public interface ApiComponent {

    Call<BaseData<GeneralProduct>> getGeneralProduct();

}
