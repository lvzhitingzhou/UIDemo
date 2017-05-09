package com.saku.uidemo.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.saku.uidemo.R;
import com.saku.uidemo.dagger.components.CoffeeShop;
import com.saku.uidemo.dagger.components.DaggerCoffeeShop;
import com.saku.uidemo.dagger.data.CoffeeMaker;
import com.saku.uidemo.dagger.data.ElectricHeater;
import com.saku.uidemo.dagger.data.Thermosiphon;
import com.saku.uidemo.dagger.modules.DripCoffeeModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
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

//                coffeeShop.inject(MainActivity.this);
                mThermosiphon = coffeeShop.getPump();
                mThermosiphon.pump();
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
}
