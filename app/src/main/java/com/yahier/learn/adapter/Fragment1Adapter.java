package com.yahier.learn.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yahier.learn.R;
import com.yahier.learn.act.DetailAct;
import com.yahier.learn.item.Skill;

import java.util.ArrayList;
import java.util.Random;


public class Fragment1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Skill> zhihuDailyItems = new ArrayList<>();
    private Context mContext;
    private String mImageUrl;


    public Fragment1Adapter(Context context) {
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ZhihuViewHolder(LayoutInflater.from(mContext).inflate(R.layout.skill_item, parent, false));
    }


    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {

        ZhihuViewHolder ho = (ZhihuViewHolder)holder;
        ho.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailAct.class);
                mContext.startActivity(intent);
            }
        });

        ho.bind(position);



    }


    @Override
    public int getItemCount() {
        return 20;
    }


    private int getDataItemCount() {
        return zhihuDailyItems.size();
    }


    public void clearData() {
        zhihuDailyItems.clear();
        notifyDataSetChanged();
    }


    private class ZhihuViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView img;

        ZhihuViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvTitle);
            img = (ImageView) itemView.findViewById(R.id.img);
        }

        public void bind(int position){


        }

    }


}
