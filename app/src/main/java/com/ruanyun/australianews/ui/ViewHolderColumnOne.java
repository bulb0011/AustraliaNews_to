package com.ruanyun.australianews.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ruanyun.australianews.R;

public class ViewHolderColumnOne extends RecyclerView.ViewHolder{

    public TextView tv_title;
    public TextView tv_label;
    public TextView  tvupdatetime;
    public TextView  jiage;
    public ImageView iv_pic;
    public RelativeLayout rl_layout;
    public ViewHolderColumnOne(@NonNull View itemView) {
        super(itemView);
        tv_title=(TextView) itemView.findViewById(R.id.tv_title);
        tv_label=(TextView) itemView.findViewById(R.id.tv_label);
        tvupdatetime=(TextView) itemView.findViewById(R.id.tv_update_time);
        jiage=(TextView) itemView.findViewById(R.id.jiage);
        iv_pic=(ImageView) itemView.findViewById(R.id.iv_pic);
        rl_layout=(RelativeLayout) itemView.findViewById(R.id.rl_layout);
    }
}
