package com.ruanyun.australianews.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ruanyun.australianews.R;

public class ViewHolderColumnTow extends RecyclerView.ViewHolder {

    public TextView tv_title;
    public TextView  tv_source;
    public ImageView iv_photo;
    public RelativeLayout rl_layout;
    public ViewHolderColumnTow(@NonNull View itemView) {
        super(itemView);
        tv_title=(TextView) itemView.findViewById(R.id.tv_title);
        tv_source=(TextView) itemView.findViewById(R.id.tv_source);
        iv_photo=(ImageView) itemView.findViewById(R.id.iv_photo);
        rl_layout=(RelativeLayout) itemView.findViewById(R.id.rl_layout);

    }

}
