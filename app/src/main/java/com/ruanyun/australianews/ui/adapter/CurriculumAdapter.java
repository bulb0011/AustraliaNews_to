package com.ruanyun.australianews.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ruanyun.australianews.App;
import com.ruanyun.australianews.R;
import com.ruanyun.australianews.data.ApiManger;

import java.text.DecimalFormat;
import java.util.List;

public class CurriculumAdapter extends RecyclerView.Adapter {

     Context context;

     List<com.ruanyun.australianews.model.DingYueKeCheng.DataEntity.DatasEntity> listData;

    public CurriculumAdapter(Context context, List<com.ruanyun.australianews.model.DingYueKeCheng.DataEntity.DatasEntity> textInfos) {
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
        com.ruanyun.australianews.model.DingYueKeCheng.DataEntity.DatasEntity.AfnInfoAllEntity afnInfoAllEntity= listData.get(i).getAfnInfoAll();

        switch (afnInfoAllEntity.getDataType()){

            case 1:
                ViewHolderOne viewHolderOne   = (ViewHolderOne) viewHolder;

                if (afnInfoAllEntity.getContentType()==1) {
                    viewHolderOne.tv_label.setText("PDF");
                } else  if (afnInfoAllEntity.getContentType()==2){
                    viewHolderOne.tv_label.setText("视频");
                }else
                    viewHolderOne.tv_label.setText("音频");


                viewHolderOne.tv_title.setText(afnInfoAllEntity.getTitle());
                Glide.with(this.context).load(ApiManger.IMG_URL+afnInfoAllEntity.getMainPhoto()).into(viewHolderOne.iv_pic);
                viewHolderOne.tv_jianjie.setText(afnInfoAllEntity.getCreateTimeStr());

                String iso= App.app.iso;
                DecimalFormat df =new DecimalFormat("#0.00");
                //价格正常
                if (afnInfoAllEntity.getPriceType()==1){
                    
                    viewHolderOne.zhiqianjiege.getPaint().setAntiAlias(false);
                    viewHolderOne.zhiqianjiege.setVisibility(View.GONE);

                    //国内
                    if(iso=="cn"||iso=="CN"){
                        viewHolderOne.tv_jianjie.setText("¥"+df.format(afnInfoAllEntity.getNormalPricecny()));
                    }
                    //澳洲
                    else if(iso=="au"|| iso=="AU") {
                        viewHolderOne.tv_jianjie.setText("A$"+df.format(afnInfoAllEntity.getNormalPriceaud()));
                    }
                    //其他地区
                    else{
                        viewHolderOne.tv_jianjie.setText("$"+df.format(afnInfoAllEntity.getNormalPriceusd()));
                    }

                }
                //特价
                else if (afnInfoAllEntity.getPriceType()==2){

                    viewHolderOne.zhiqianjiege.setVisibility(View.VISIBLE);
                    viewHolderOne.zhiqianjiege.getPaint().setAntiAlias(true);

                    viewHolderOne.zhiqianjiege.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

                    //国内
                    if(iso=="cn"||iso=="CN"){
                        viewHolderOne.tv_jianjie.setText("¥"+df.format(afnInfoAllEntity.getSpecialOffercny()));
                        viewHolderOne.zhiqianjiege.setText("¥"+df.format(afnInfoAllEntity.getNormalPricecny()));
                    }
                    //澳洲
                    else if(iso=="au"|| iso=="AU") {
                        viewHolderOne.tv_jianjie.setText( "A$"+df.format(afnInfoAllEntity.getSpecialOfferaud()));
                        viewHolderOne.zhiqianjiege.setText( "A$"+df.format(afnInfoAllEntity.getNormalPriceaud()));

                    }
                    //其他地区
                    else{
                        viewHolderOne.tv_jianjie.setText( "$"+df.format(afnInfoAllEntity.getSpecialOfferusd()));
                        viewHolderOne.zhiqianjiege.setText("$"+df.format(afnInfoAllEntity.getNormalPriceusd()));
                    }

                }
                //限时免费
                else{

                    viewHolderOne.zhiqianjiege.setVisibility(View.VISIBLE);
                    viewHolderOne.zhiqianjiege.getPaint().setAntiAlias(true);
                    viewHolderOne.zhiqianjiege.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

                    //国内
                    if(iso=="cn"||iso=="CN"){
                        viewHolderOne.tv_jianjie.setText("限时免费");
                        viewHolderOne.zhiqianjiege.setText( "¥"+df.format(afnInfoAllEntity.getNormalPricecny()));
                    }
                    //澳洲
                    else if(iso=="au"|| iso=="AU") {
                        viewHolderOne.tv_jianjie.setText("限时免费");
                        viewHolderOne.zhiqianjiege.setText( "A$"+df.format(afnInfoAllEntity.getNormalPriceaud()));
                    }
                    //其他地区
                    else{
                        viewHolderOne.tv_jianjie.setText("限时免费");
                        viewHolderOne.zhiqianjiege.setText( "$"+df.format(afnInfoAllEntity.getNormalPriceusd()));
                    }

                }

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
                viewHolderTeo.tv_title.setText(afnInfoAllEntity.getTitle());
                Glide.with(this.context).load(ApiManger.IMG_URL+afnInfoAllEntity.getMainPhoto()).into(viewHolderTeo.iv_photo);
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
                viewHolderThree.tv_title.setText(afnInfoAllEntity.getTitle());
                Glide.with(this.context).load(ApiManger.IMG_URL+afnInfoAllEntity.getMainPhoto()).into(viewHolderThree.iv_pic);
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
        return listData.get(position).getAfnInfoAll().getDataType();
    }


    class ViewHolderOne extends RecyclerView.ViewHolder{

        TextView  tv_title;
        TextView  tv_jianjie;
        TextView  zhiqianjiege;
        TextView  tv_label;
        TextView  tv_jiage;
        ImageView  iv_pic;
        RelativeLayout  rl_layout;
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            tv_title=(TextView) itemView.findViewById(R.id.tv_title);
            tv_jianjie=(TextView) itemView.findViewById(R.id.tv_jianjie);
            tv_jiage=(TextView) itemView.findViewById(R.id.tv_jiage);
            tv_label=(TextView) itemView.findViewById(R.id.tv_label);
            zhiqianjiege=(TextView) itemView.findViewById(R.id.zhiqianjiege);
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
