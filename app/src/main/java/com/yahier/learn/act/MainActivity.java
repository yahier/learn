package com.yahier.learn.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);

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


        LinearLayout linTvItem = (LinearLayout) findViewById(R.id.linTvItem);
        final int childCount = linTvItem.getChildCount();
        final TextView[] childs = new TextView[childCount];
        for (int i = 0; i < childCount; i++) {
            final int j = i;
            childs[i] = (TextView) linTvItem.getChildAt(i);
            childs[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewpager.setCurrentItem(j, true);
                    for (int a = 0; a < childCount; a++) {
                        if (j == a) {
                            childs[a].setTextColor(getResources().getColor(R.color.theme_color));
                        } else {
                            childs[a].setTextColor(getResources().getColor(R.color.black));
                        }
                    }

                }
            });
        }

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                for (int a = 0; a < childCount; a++) {
                    if (position == a) {
                        childs[a].setTextColor(getResources().getColor(R.color.theme_color));
                    } else {
                        childs[a].setTextColor(getResources().getColor(R.color.black));
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    void test() {
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, PublishAct.class);
                startActivity(intent);
            }
        }, 2000);
    }
}
