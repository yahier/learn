package com.yahier.learn.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.yahier.learn.R;
import com.yahier.learn.adapter.Fragment1Adapter;
import com.yahier.learn.util.ToastUtil;

/**
 * Created by Administrator on 2016/10/31.
 */

public class SearchAct extends ThemeAct {
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_search);
        setLabel("搜索");
        init();


    }

    void init() {
        input = (EditText) findViewById(R.id.input);
        input.setText(getIntent().getStringExtra("word"));
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Fragment1Adapter adapter = new Fragment1Adapter(this);
        mRecyclerView.setAdapter(adapter);

        input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    ToastUtil.showToast("重新搜索结果");
                }
                return false;
            }
        });
    }
}
