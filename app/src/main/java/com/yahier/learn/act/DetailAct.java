package com.yahier.learn.act;

import android.os.Bundle;

import com.yahier.learn.R;

/**
 * Created by lenovo on 2016/10/29.
 * 发布页面
 */

public class DetailAct extends ThemeAct {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_detail);
        setLabel("详情");
    }
}
