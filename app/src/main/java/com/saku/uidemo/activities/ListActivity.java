package com.saku.uidemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.saku.uidemo.R;
import com.saku.uidemo.activities.adapter.ListTextAdapter;
import com.saku.uidemo.data.MyText;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        List<MyText> mData = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            MyText myText = new MyText();
            myText.title = i + "_title expand title ";
            myText.desc = i +"＿So I have found a solution that does not involve calling notifyItemChanged so the view is not replaced. The con is that you have to manualy check the view consistency. For that, I have created a small library that allows exactly what I was looking for";
            mData.add(myText);
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ListTextAdapter adapter = new ListTextAdapter(this, mData);
        mRecyclerView.setAdapter(adapter);
    }
}
