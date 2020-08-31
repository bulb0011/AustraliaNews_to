package com.ruanyun.australianews.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ruanyun.australianews.R;
import com.ruanyun.australianews.model.TextInfo;

import java.util.List;

public class CurriculumAdapter extends RecyclerView.Adapter {

     Context context;

     List<TextInfo> listData;

    public CurriculumAdapter(Context context, List<TextInfo> textInfos) {
        this.context = context;
        this.listData = textInfos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        switch (i){
            case 1:
                return new ViewHolderOne(LayoutInflater.from(this.context).inflate(R.layout.rv_my_curriculum_item_one,viewGroup,false));
            case 2:
                return new ViewHolderTeo(LayoutInflater.from(this.context).inflate(R.layout.rv_my_curriculum_item_two,viewGroup,false));
            case 3:
                return new ViewHolderThreeu(LayoutInflater.from(this.context).inflate(R.layout.rv_my_curriculum_item_three,viewGroup,false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") int i) {
        TextInfo textInfo= listData.get(i);

        switch (textInfo.type){

            case 1:
                ViewHolderOne viewHolderOne   = (ViewHolderOne) viewHolder;
                viewHolderOne.tv_title.setText(textInfo.title);
                Glide.with(this.context).load(textInfo.image).into(viewHolderOne.iv_pic);
                viewHolderOne.rl_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onCliskListener!=null){
                            onCliskListener.onClisk(v,i);
                        }

                    }
                });
                break;
            case 2:
                ViewHolderTeo viewHolderTeo   = (ViewHolderTeo) viewHolder;
                viewHolderTeo.tv_title.setText(textInfo.title);
                Glide.with(this.context).load(textInfo.image).into(viewHolderTeo.iv_photo);
                viewHolderTeo.rl_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onCliskListener!=null){
                            onCliskListener.onClisk(v,i);
                        }
                    }
                });
                break;
            case 3:
                ViewHolderThreeu viewHolderThree   = (ViewHolderThreeu) viewHolder;
                viewHolderThree.tv_title.setText(textInfo.title);
                Glide.with(this.context).load(textInfo.image).into(viewHolderThree.iv_pic);
                viewHolderThree.rv_three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onCliskListener!=null){
                            onCliskListener.onClisk(v,i);
                        }
                    }
                });
                break;

        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listData.get(position).type;
    }


    class ViewHolderOne extends RecyclerView.ViewHolder{

        TextView  tv_title;
        ImageView  iv_pic;
        RelativeLayout  rl_layout;
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            tv_title=(TextView) itemView.findViewById(R.id.tv_title);
            iv_pic=(ImageView) itemView.findViewById(R.id.iv_pic);
            rl_layout=(RelativeLayout) itemView.findViewById(R.id.rl_layout);

        }
    }


    class ViewHolderTeo extends RecyclerView.ViewHolder{
        TextView  tv_title;
        ImageView  iv_photo;
        RelativeLayout  rl_layout;
        public ViewHolderTeo(@NonNull View itemView) {
            super(itemView);
            tv_title=(TextView) itemView.findViewById(R.id.tv_title);
            iv_photo=(ImageView) itemView.findViewById(R.id.iv_photo);
            rl_layout=(RelativeLayout) itemView.findViewById(R.id.rl_layout);

        }
    }

    class ViewHolderThreeu extends RecyclerView.ViewHolder{

        ImageView  iv_pic;
        TextView  tv_title;
        RelativeLayout rv_three;
        public ViewHolderThreeu(@NonNull View itemView) {
            super(itemView);
            iv_pic=(ImageView) itemView.findViewById(R.id.iv_pic);
            tv_title=(TextView) itemView.findViewById(R.id.tv_title);
            rv_three=(RelativeLayout) itemView.findViewById(R.id.rv_three);


        }
    }

   interface OnCliskListener {
      void onClisk(View view, int i);
    }

    OnCliskListener onCliskListener;

    public void setOnCliakListener(View view, int i){
        onCliskListener.onClisk(view,i);
    }

}
