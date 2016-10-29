package com.yahier.learn.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.yahier.learn.R;
import com.yahier.learn.adapter.CommonFragmentPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    void initView(){
        viewpager = (ViewPager)findViewById(R.id.viewpager);

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        Frament1Home fragment1 = new Frament1Home();
        fragmentList.add(fragment1);

        Frament2Discover fragment2 = new Frament2Discover();
        fragmentList.add(fragment2);

        Frament3Message fragment3 = new Frament3Message();
        fragmentList.add(fragment3);

        Frament4Me fragment4 = new Frament4Me();
        fragmentList.add(fragment4);

        CommonFragmentPagerAdapter mAdapter = new CommonFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, null);
        viewpager.setAdapter(mAdapter);



    }

    void test(){
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this,PublishAct.class);
                startActivity(intent);
            }
        },2000);
    }
}
