package com.saku.uidemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;

import com.saku.uidemo.R;
import com.saku.uidemo.activities.adapter.CarListAdapter;
import com.saku.uidemo.activities.typeProcessor.BaseTypeHolder;
import com.saku.uidemo.activities.typeProcessor.CarTypeProcessor;
import com.saku.uidemo.data.GeneralProduct;
import com.saku.uidemo.data.ProductBaseInfo;
import com.saku.uidemo.data.ProductCompositeInfo;
import com.saku.uidemo.data.ProductPriceInfo;
import com.saku.uidemo.data.listdata.BaseInfoData;
import com.saku.uidemo.data.listdata.BottomData;
import com.saku.uidemo.data.listdata.DailyPriceData;
import com.saku.uidemo.data.listdata.ItemData;
import com.saku.uidemo.data.listdata.MiddleData;
import com.saku.uidemo.data.listdata.CarTypesData;
import com.saku.uidemo.http.ApiCallback;
import com.saku.uidemo.http.BaseData;
import com.saku.uidemo.utils.DaggerHelper;
import com.saku.uidemo.utils.SetUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ChooseCarActivity extends AppCompatActivity {
    public static final String TAG = ChooseCarActivity.class.getSimpleName();

    private LinearLayout mLlTopAddr;
    private RecyclerView mRvCar;
    private LinearLayout mLlLicence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_car);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getCarList();

    }

    private void initView() {
        mLlTopAddr = (LinearLayout) findViewById(R.id.ll_top_addr);
        mRvCar = (RecyclerView) findViewById(R.id.rv_car);
        mLlLicence = (LinearLayout) findViewById(R.id.ll_licence);
        mRvCar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        mRvCar.setAdapter(new BaseCarAdapter());
    }

    private void getCarList() {
        final Call<BaseData<GeneralProduct>> generalProductCall = DaggerHelper.getInstance().getApiComponent().getGeneralProduct();
        generalProductCall.enqueue(new ApiCallback<GeneralProduct>() {
            @Override
            public void onSuccess(GeneralProduct data) {
                Log.i(TAG, "onSuccess: data = " + data);
                final List<ItemData> itemDatas = convertData2ItemDataList(data.products);
                setData2RecyclerView(itemDatas);
            }

            @Override
            public void onFail(int errCode, String errMsg) {
                Log.i(TAG, "onFail: errCode = " + errCode);

            }
        });

    }

    private List<ItemData> convertData2ItemDataList(List<ProductCompositeInfo> products) {

        if (SetUtils.isEmpty(products)) {
            return null;
        }

        List<ItemData> convertedData = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            final ProductCompositeInfo product = products.get(i);
            final ProductBaseInfo productBaseInfo = product.productBaseInfo;
            final ProductPriceInfo productPriceInfo = product.productPriceInfo;
            if (productBaseInfo == null || productPriceInfo == null) {
                continue;
            }
            BaseInfoData baseInfo = new BaseInfoData(productBaseInfo, productPriceInfo);
            convertedData.add(baseInfo);
            MiddleData middleData = new MiddleData(productBaseInfo);
            convertedData.add(middleData);
            CarTypesData carTypesData = new CarTypesData(productBaseInfo);
            convertedData.add(carTypesData);
            DailyPriceData dailyPriceData = new DailyPriceData(productPriceInfo);
            convertedData.add(dailyPriceData);
            convertedData.add(new BottomData(i));
        }
        return convertedData;
    }

    public void setData2RecyclerView(List<ItemData> itemDataList) {
        BaseTypeHolder<List<ItemData>> typeHolder = new CarTypeProcessor(this);
        this.mRvCar.setAdapter(new CarListAdapter(itemDataList, typeHolder));
    }
}
