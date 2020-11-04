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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ruanyun.australianews.App;
import com.ruanyun.australianews.R;
import com.ruanyun.australianews.data.ApiManger;
import com.ruanyun.australianews.model.VIPSouSuoInfo;

import java.text.DecimalFormat;
import java.util.List;

import cn.addapp.pickers.util.DateUtils;

public class SouSuoAdapter extends RecyclerView.Adapter  {

    List<VIPSouSuoInfo.DatasEntity> datasEntityList;
    Context context;

    public SouSuoAdapter(Context context, List<VIPSouSuoInfo.DatasEntity>  datasEntityList) {
        this.datasEntityList=datasEntityList;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        switch (i){
            case 1:
                return new ViewHolderTuWen(LayoutInflater.from(this.context).inflate(R.layout.rv_vip_item_remen,viewGroup,false));
            case 2:
                return new ViewHolderXinWen(LayoutInflater.from(this.context).inflate(R.layout.vip_re_to_item,viewGroup,false));
            case 3:
                return new ViewHolderZhuanLan(LayoutInflater.from(this.context).inflate(R.layout.item_zhuanlan,viewGroup,false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {

        VIPSouSuoInfo.DatasEntity datasEntity  =datasEntityList.get(i);

        switch (datasEntity.getDataType()){
            case 1:

                ViewHolderTuWen viewHolderOne   = (ViewHolderTuWen) viewHolder;

                if (datasEntity.getContentType()==1) {
                    viewHolderOne.tv_label.setText("PDF");
                } else  if (datasEntity.getContentType()==2){
                    viewHolderOne.tv_label.setText("视频");
                }else
                    viewHolderOne.tv_label.setText("音频");

                viewHolderOne.tv_title.setText(datasEntity.getTitle());
                Glide.with(this.context).load(ApiManger.IMG_URL+datasEntity.getMainPhoto()).into(viewHolderOne.iv_pic);
                viewHolderOne.tv_jianjie.setText(datasEntity.getKeyWord());
                String iso= App.app.iso;
                DecimalFormat df =new DecimalFormat("#0.00");
                //价格正常
                if (datasEntity.getPriceType()==1){

                    viewHolderOne.tv_jianjie.getPaint().setAntiAlias(false);
                    viewHolderOne.tv_jianjie.setVisibility(View.GONE);

                    //国内
                    if(iso=="cn"||iso=="CN"){
                        viewHolderOne.tv_jiage.setText("¥"+df.format(datasEntity.getNormalPricecny()));
                    }
                    //澳洲
                    else if(iso=="au"|| iso=="AU") {
                        viewHolderOne.tv_jiage.setText("A$"+df.format(datasEntity.getNormalPriceaud()));
                    }
                    //其他地区
                    else{
                        viewHolderOne.tv_jiage.setText("$"+df.format(datasEntity.getNormalPriceusd()));
                    }

                }
                //特价
                else if (datasEntity.getPriceType()==2){

                    viewHolderOne.zhiqianjiege.setVisibility(View.VISIBLE);
                    viewHolderOne.zhiqianjiege.getPaint().setAntiAlias(true);

                    viewHolderOne.zhiqianjiege.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

                    //国内
                    if(iso=="cn"||iso=="CN"){
                        viewHolderOne.tv_jianjie.setText("¥"+df.format(datasEntity.getSpecialOffercny()));
                        viewHolderOne.zhiqianjiege.setText("¥"+df.format(datasEntity.getNormalPricecny()));
                    }
                    //澳洲
                    else if(iso=="au"|| iso=="AU") {
                        viewHolderOne.tv_jianjie.setText( "A$"+df.format(datasEntity.getSpecialOfferaud()));
                        viewHolderOne.zhiqianjiege.setText( "A$"+df.format(datasEntity.getNormalPriceaud()));

                    }
                    //其他地区
                    else{
                        viewHolderOne.tv_jianjie.setText( "$"+df.format(datasEntity.getSpecialOfferusd()));
                        viewHolderOne.zhiqianjiege.setText("$"+df.format(datasEntity.getNormalPriceusd()));
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
                        viewHolderOne.zhiqianjiege.setText( "¥"+df.format(datasEntity.getNormalPricecny()));
                    }
                    //澳洲
                    else if(iso=="au"|| iso=="AU") {
                        viewHolderOne.tv_jianjie.setText("限时免费");
                        viewHolderOne.zhiqianjiege.setText( "A$"+df.format(datasEntity.getNormalPriceaud()));
                    }
                    //其他地区
                    else{
                        viewHolderOne.tv_jianjie.setText("限时免费");
                        viewHolderOne.zhiqianjiege.setText( "¥"+df.format(datasEntity.getNormalPriceusd()));
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

                ViewHolderXinWen viewHolderXinWen  = (ViewHolderXinWen) viewHolder;

                Glide.with(this.context).load(ApiManger.IMG_URL+datasEntity.getMainPhoto()).into(viewHolderXinWen.iv_photo);

                viewHolderXinWen.tv_title.setText(datasEntity.getTitle());

                viewHolderXinWen.tv_source.setText(DateUtils.formatDate(DateUtils.parseDate(datasEntity.getCreateTime()),"MM-dd HH:mm" ));

                viewHolderXinWen.rl_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onCliskListener!=null){
                            onCliskListener.onClisk(v,i);
                        }
                    }
                });
                break;
            case 3:

                ViewHolderZhuanLan viewHolderZhuanLan  = (ViewHolderZhuanLan) viewHolder;

                viewHolderZhuanLan.tv_title_zhaunlan.setText(datasEntity.getTitle());

                if (datasEntity.getAfnInfoAllList()!=null&&datasEntity.getAfnInfoAllList().size()>2){

                    VIPSouSuoInfo.DatasEntity.AfnInfoAllListEntity allListEntity  = datasEntity.getAfnInfoAllList().get(0);
                    Glide.with(this.context).load(ApiManger.IMG_URL+allListEntity.getMainPhoto()).into(viewHolderZhuanLan.image_one);
                    viewHolderZhuanLan.tv_one.setText(allListEntity.getTitle());

                    VIPSouSuoInfo.DatasEntity.AfnInfoAllListEntity allListEntityTo  =datasEntity.getAfnInfoAllList().get(1);
                    Glide.with(this.context).load(ApiManger.IMG_URL+allListEntityTo.getMainPhoto()).into(viewHolderZhuanLan.iamge_to);
                    viewHolderZhuanLan.tv_tow.setText(allListEntityTo.getTitle());
                }

                viewHolderZhuanLan.ll_zhualan.setOnClickListener(new View.OnClickListener() {
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
        return datasEntityList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return datasEntityList.get(position).getDataType();
    }


    class ViewHolderTuWen extends RecyclerView.ViewHolder{
        TextView tv_label;
        TextView  tv_title;
        TextView  tv_jianjie;
        TextView  tv_jiage;
        TextView  zhiqianjiege;
        ImageView  iv_pic;
        RelativeLayout  rl_layout;
        public ViewHolderTuWen(@NonNull View itemView) {
            super(itemView);
            tv_label=(TextView)itemView.findViewById(R.id.tv_label);
            tv_title=(TextView) itemView.findViewById(R.id.tv_title);
            tv_jianjie=(TextView) itemView.findViewById(R.id.tv_jianjie);
            zhiqianjiege=(TextView) itemView.findViewById(R.id.jiage);
            tv_jiage=(TextView) itemView.findViewById(R.id.tv_update_time);
            iv_pic=(ImageView) itemView.findViewById(R.id.iv_pic);
            rl_layout=(RelativeLayout) itemView.findViewById(R.id.rl_layout);

        }
    }


    class ViewHolderZhuanLan extends RecyclerView.ViewHolder{
        TextView tv_title_zhaunlan;
        ImageView image_one;
        ImageView iamge_to;
        TextView tv_one;
        TextView tv_tow;
        LinearLayout ll_zhualan;
        public ViewHolderZhuanLan(@NonNull View itemView) {
            super(itemView);
            tv_title_zhaunlan=(TextView)itemView.findViewById(R.id.tv_title_zhaunlan);
            tv_one=(TextView)itemView.findViewById(R.id.tv_one);
            tv_tow=(TextView)itemView.findViewById(R.id.tv_tow);
            image_one=(ImageView)itemView.findViewById(R.id.image_one);
            iamge_to=(ImageView)itemView.findViewById(R.id.iamge_to);
            ll_zhualan=(LinearLayout)itemView.findViewById(R.id.ll_zhualan);
        }
    }

    class ViewHolderXinWen extends RecyclerView.ViewHolder{
            TextView tv_title;
            TextView tv_source;
            ImageView iv_photo;
        RelativeLayout rl_layout;
        public ViewHolderXinWen(@NonNull View itemView) {
            super(itemView);
            tv_title=(TextView)itemView.findViewById(R.id.tv_title);
            tv_source=(TextView)itemView.findViewById(R.id.tv_source);
            iv_photo=(ImageView)itemView.findViewById(R.id.iv_photo);
            rl_layout=(RelativeLayout)itemView.findViewById(R.id.rl_layout);
        }
    }

    public interface OnCliskListener {
        void onClisk(View view, int i);
    }

    public OnCliskListener onCliskListener;

    public void setOnCliakListener(OnCliskListener onCliskListener) {
        this.onCliskListener=onCliskListener;
    }

}
