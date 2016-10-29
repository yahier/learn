package com.yahier.learn.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yahier.learn.R;
import com.yahier.learn.act.DetailAct;
import com.yahier.learn.item.Skill;

import java.util.ArrayList;


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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailAct.class);
                mContext.startActivity(intent);
            }
        });


    }




    @Override
    public int getItemCount() {
        return 10;
    }



    private int getDataItemCount() {
        return zhihuDailyItems.size();
    }


    public void clearData() {
        zhihuDailyItems.clear();
        notifyDataSetChanged();
    }



    class ZhihuViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ZhihuViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvTitle);

        }
    }


}
