package com.saku.uidemo.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saku.uidemo.R;
import com.saku.uidemo.data.Pie;
import com.saku.uidemo.views.MenuChart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.saku.uidemo.dagger.components.CoffeeShop;
import com.saku.uidemo.dagger.components.DaggerCoffeeShop;
import com.saku.uidemo.dagger.data.CoffeeMaker;
import com.saku.uidemo.dagger.data.Thermosiphon;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pie> mPies = new ArrayList<>();
    private MenuChart mMenuChart;
//    @Inject
    Thermosiphon mThermosiphon;

//    @Inject
//    ElectricHeater mElectricHeater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
//
//        initData();
//
//        mMenuChart = (MenuChart) findViewById(R.id.menu_chart);
//        mMenuChart.setPieData(mPies);
//        mMenuChart.setStartAngle(180);  //设置起始角度
//        mMenuChart.setPieShowingAngle(180);//设置总共角度
//        mMenuChart.setCenterBitmap(R.mipmap.menu, UIUtils.dp2px(MainActivity.this, 60), UIUtils.dp2px(MainActivity.this, 60));



        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("OneTravel://rentcar/zhima?bussinessId=270&sid=rentcar"));
//                MainActivity.this.startActivity(intent);

//                DaggerCoffeeShop.builder().dripCoffeeModule(new DripCoffeeModule()).build();
                final CoffeeShop coffeeShop = DaggerCoffeeShop.builder().build();
                final CoffeeMaker maker = coffeeShop.maker();
                maker.brew();

//                coffeeShop.inject(MainActivity.this);   // 或者下面这种方式提供mThermosiphon
//                mThermosiphon = coffeeShop.getPump();
//                mThermosiphon.pump();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initData() {
        Pie Pie = new Pie();
        Pie.setName("不辣，川菜一点都不辣 T_T");
        Pie.setWeight(1);
        Pie.setLabel("CHUAN");
        Pie.setLabelColor(0xffd81e06);
        Pie.setDrawableId(R.mipmap.btm_chuan);
        mPies.add(Pie);


        Pie Pie2 = new Pie();
        Pie2.setName("咸，鲜，清淡");
        Pie2.setWeight(1);
        Pie2.setLabel("YUE");
        Pie2.setDrawableId(R.mipmap.btm_yue);
        Pie2.setLabelColor(0xff90f895);
        mPies.add(Pie2);


        Pie Pie5 = new Pie();
        Pie5.setName("重油盐辣，腊味");
        Pie5.setWeight(1);
        Pie5.setLabel("XIANG");
        Pie5.setDrawableId(R.mipmap.btm_xiang);
        Pie5.setLabelColor(0xffe16531);
        mPies.add(Pie5);

        Pie Pie4 = new Pie();
        Pie4.setName("咸甜");
        Pie4.setWeight(1);
        Pie4.setLabel("MIN");
        Pie4.setDrawableId(R.mipmap.btm_min);
        Pie4.setLabelColor(0xfff5c9cb);
        mPies.add(Pie4);


        Pie Pie3 = new Pie();
        Pie3.setName("甜，黄酒味");
        Pie3.setLabel("SU");
        Pie3.setWeight(1);
        Pie3.setDrawableId(R.mipmap.btm_jiang);
        Pie3.setLabelColor(0xfff4ed61);
        mPies.add(Pie3);

        Pie Pie6 = new Pie();
        Pie6.setName("鲜，浓油赤酱");
        Pie6.setWeight(1);
        Pie6.setLabel("LU");
        Pie6.setDrawableId(R.mipmap.btm_lu);
        Pie6.setLabelColor(0xff944a48);
        mPies.add(Pie6);

    }




    void listadapter(){
        RecyclerView rv = new RecyclerView(this);

    }

    public abstract static class ListX<I, T> implements DeX<List<T>>{
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = null;
            return new MyViewHolder(view);
        }

        public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<T> data, I itemModel) ;
//        {
//            holder.itemView.setBackgroundColor(Color.RED);
//        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<T> data) {
            onBindViewHolder(holder, position, data, (I) data.get(position));
        }

//        @Override
//        public boolean isTypeFit(List<T> list, int position, Integer itemType) {
//            return list.get(position).type == itemType;
//        }


//        @Override
//        public boolean isTypeFit(T list, int position, Integer itemType) {
////                        return list.get(position) instanceof ItemModel1;
//            return position %4 == 0;
////            return list.get(position).type == itemType;
//        }
    }

    public interface DeX<T> {
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);
//        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, ItemModel itemModel);
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, T data);
        public boolean isTypeFit(T list, int position, Integer itemType);
    }

//    Map<Integer, ListX> map1 = new HashMap<>();
//    Map<Integer, X2> map2 = new HashMap<>();
//    Map<Integer, X3> map3 = new HashMap<>();

    Map<Integer, DeX> map = new HashMap<>();


    abstract class ItemModel {
        int type;
    }

    class ItemModel1 extends ItemModel {}
    class ItemModel2 extends ItemModel {}
    class ItemModel3 extends ItemModel {}

//    List<ItemModel> itemModels = new ArrayList<>();
    List<ItemModel> itemModels = new ArrayList<>();


    public abstract class CAdapter<T> extends RecyclerView.Adapter {
        private T data;

        public CAdapter(T data, Map<Integer, DeX<T>> map) {
            this.data = data;

//            map.put(1, new ListXDescedant());
//            map.put(2, new X2());
//            map.put(3, new X3());

        }

        @Override
        public int getItemViewType(int position) {
            boolean fit = false;
            int viewType = -1;
            for (Map.Entry<Integer, DeX> entry : map.entrySet()) {
                final Integer itemType = entry.getKey();
                final DeX deX = entry.getValue();
                fit = deX.isTypeFit(data, position, itemType);
                if (fit) {
                    viewType = itemType;
                    break;
                }
            }

            if (fit) {
                return viewType;
            } else {
                throw new RuntimeException("itemModel type is wrong");
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            final RecyclerView.ViewHolder holder = map.get(viewType).onCreateViewHolder(parent, viewType);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            final int viewType = getItemViewType(position);
//            map.get(viewType).onBindViewHolder(holder, position, list.get(position));
            map.get(viewType).onBindViewHolder(holder, position, data);
        }

//        @Override
//        public int getItemCount() {
//            return list.size();
//        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
