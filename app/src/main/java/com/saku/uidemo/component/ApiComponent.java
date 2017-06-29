package com.saku.uidemo.component;

import com.saku.uidemo.annotation.ApiScope;
import com.saku.uidemo.data.GeneralProduct;
import com.saku.uidemo.http.BaseData;
import com.saku.uidemo.module.ApiModule;

import dagger.Component;
import retrofit2.Call;


// singleton的component不能dependent singleton的component， 其他scope的可以dependent singleton的component
// singleton修饰的module的方法，依赖module的component也要被同样的scope修饰。

//@Singleton
@ApiScope
@Component(dependencies = {NetComponent.class}, modules = ApiModule.class)
//@Subcomponent(dependencies = NetComponent.class, modules = ApiModule.class)
public interface ApiComponent {

    Call<BaseData<GeneralProduct>> getGeneralProduct();

}
