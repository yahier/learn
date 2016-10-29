package com.yahier.learn.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yahier.learn.R;

/**
 * Created by Administrator on 2016/10/27.
 */

public class ThemeAct extends AppCompatActivity {
    protected RelativeLayout topBanner;
    TextView topLeft;
    TextView topMiddle;
    TextView mRightTv;
    ImageView topRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDelegate().getSupportActionBar().hide();
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.act_theme);
        topBanner = (RelativeLayout) findViewById(R.id.theme_top_banner);
        topLeft = (TextView) findViewById(R.id.theme_top_banner_left);
        topMiddle = (TextView) findViewById(R.id.theme_top_banner_middle);
        mRightTv = (TextView) findViewById(R.id.theme_top_tv_right);
        topRight = (ImageView) findViewById(R.id.theme_top_banner_right);
        topLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        FrameLayout  mainLayout = (FrameLayout) findViewById(R.id.mainLayout);
        View mainView = this.getLayoutInflater().inflate(layoutResID, null);
        mainLayout.addView(mainView);
    }
    protected void setLabel(Object... objs) {
        Object obj = objs[0];
        try {
            int StringId = Integer.parseInt(obj.toString());
            topMiddle.setText(StringId);
            return;
        } catch (Exception e) {
        }
        topMiddle.setText(obj.toString());
    }
    protected void setRightText(CharSequence text, View.OnClickListener listener) {
        mRightTv.setVisibility(View.VISIBLE);
        mRightTv.setText(text);
        mRightTv.setOnClickListener(listener);
    }

    public void enterAct(Class<?> mClass) {
        Intent intent = new Intent(this, mClass);
        startActivity(intent);
    }
}
