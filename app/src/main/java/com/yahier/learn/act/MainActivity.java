package com.yahier.learn.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.yahier.learn.R;
import com.yahier.learn.adapter.CommonFragmentPagerAdapter;
import com.yahier.learn.item.PersonBmob;
import com.yahier.learn.util.Http;
import com.yahier.learn.util.LogUtil;
import com.yahier.learn.util.ToastUtil;

import java.util.ArrayList;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static com.yahier.learn.R.string.password;

public class MainActivity extends FragmentActivity {
    ViewPager viewpager;
    String[] labels = new String[4];
    TextView tvMiddle;
    TextView tvRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        labels[0] = "首页";
        labels[1] = "发现";
        labels[2] = getResources().getString(R.string.message);
        labels[3] = "我的";
        findViewById(R.id.theme_top_banner_left).setVisibility(View.INVISIBLE);
        tvMiddle = (TextView) findViewById(R.id.theme_top_banner_middle);
        tvMiddle.setText(labels[0]);
        tvRight = (TextView) findViewById(R.id.theme_top_tv_right);
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginHuanxin();
            }
        }, 1000);
        //initBmob();
        //testRequest();
    }


    void initBmob() {
        Bmob.initialize(this, "e36da6917cbee0cb8c767f2ea6e1122e");
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                final PersonBmob p2 = new PersonBmob();
                p2.setName("lucky");
                p2.setAddress("北京海淀");
                p2.save(MainActivity.this, new SaveListener() {

                    @Override
                    public void onSuccess() {
                        ToastUtil.showToast(("添加数据成功，返回objectId为：" + p2.getObjectId()));
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        ToastUtil.showToast(("添加数据失败，：" + s));
                    }


                });

            }
        }, 2000);
    }

    //测试访问服务器数据 ok
    void testRequest() {
        //new Http().getLastZhihuNews();
        //new Http().testRequest2();
    }


    void updateUnreadLabel() {
        LogUtil.logE("main", "updateUnreadLabel");
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

                tvMiddle.setText(labels[position]);
                switch(position) {
                    case 0:
                        tvRight.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        setRightTv("附近", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtil.showToast("点击了附近");
                            }
                        });
                        break;
                    case 2:
                        tvRight.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        tvRight.setVisibility(View.INVISIBLE);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    void setRightTv(String value, View.OnClickListener clickListener) {
        tvRight.setText(value);
        tvRight.setOnClickListener(clickListener);
        tvRight.setVisibility(View.VISIBLE);
    }

    void loginHuanxin() {
        EMClient.getInstance().login("yahier", "123456", new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                LogUtil.logE("main", "登录聊天服务器成功！");
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                LogUtil.logE("main", "登录聊天服务器失败！" + message + " " + +code);
            }
        });

    }

}
