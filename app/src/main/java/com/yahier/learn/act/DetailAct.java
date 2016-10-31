package com.yahier.learn.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yahier.learn.R;

/**
 * Created by lenovo on 2016/10/29.
 * 发布页面
 */

public class DetailAct extends ThemeAct implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_detail);
        setLabel("详情");

        findViewById(R.id.tvChat).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.tvChat:
                startActivity(new Intent(this, ChatActivity.class).putExtra("userId", "bingo"));
                break;
        }
    }
}
