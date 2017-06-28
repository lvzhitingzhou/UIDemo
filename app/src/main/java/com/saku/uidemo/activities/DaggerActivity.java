package com.saku.uidemo.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.saku.uidemo.R;
import com.saku.uidemo.dagger.components.CoffeeShop;
import com.saku.uidemo.dagger.components.DaggerCoffeeShop;
import com.saku.uidemo.dagger.components.DaggerStarbucks;
import com.saku.uidemo.dagger.components.Starbucks;
import com.saku.uidemo.dagger.data.Thermosiphon;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {

    @Inject
    Thermosiphon mThermosiphon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                final CoffeeShop coffeeShop = DaggerCoffeeShop.builder().build();

                final Starbucks starbucks =
                        DaggerStarbucks.builder().coffeeShop(coffeeShop).build();
                starbucks.inject(DaggerActivity.this);

                mThermosiphon.pump();
            }
        });
    }

}
