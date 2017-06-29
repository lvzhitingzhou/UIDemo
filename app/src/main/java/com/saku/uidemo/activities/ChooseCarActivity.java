package com.saku.uidemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;

import com.saku.uidemo.R;
import com.saku.uidemo.activities.adapter.BaseCarAdapter;
import com.saku.uidemo.data.GeneralProduct;
import com.saku.uidemo.http.ApiCallback;
import com.saku.uidemo.http.BaseData;
import com.saku.uidemo.utils.DaggerHelper;

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
                Log.i(TAG, "onSuccess: data = "+ data);

            }

            @Override
            public void onFail(int errCode, String errMsg) {
                Log.i(TAG, "onFail: errCode = "+ errCode);

            }
        });

    }

}
