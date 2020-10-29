package com.ruanyun.australianews.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ruanyun.australianews.App;
import com.ruanyun.australianews.R;
import com.ruanyun.australianews.data.ApiManger;
import com.ruanyun.australianews.model.VipNewsType;
import com.ruanyun.australianews.ui.ViewHolderColumnOne;
import com.ruanyun.australianews.ui.ViewHolderColumnTow;

import java.text.DecimalFormat;
import java.util.List;

public class VipColumnAdapter extends RecyclerView.Adapter {

     Context context;

     List<VipNewsType.DatasEntity> listData;

    public VipColumnAdapter(Context context, List<VipNewsType.DatasEntity> textInfos) {
        this.context = context;
        this.listData = textInfos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        switch (i){
            case 1:
                return new ViewHolderColumnOne(LayoutInflater.from(this.context).inflate(R.layout.rv_vip_item_remen,viewGroup,false));
            case 2:

                return new ViewHolderColumnTow(LayoutInflater.from(this.context).inflate(R.layout.vip_re_to_item,viewGroup,false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") int i) {
        VipNewsType.DatasEntity objinfo= listData.get(i);
        String iso= App.app.iso;

        switch (objinfo.getDataType()){

            case 1:
                ViewHolderColumnOne viewHolderOne   = (ViewHolderColumnOne) viewHolder;
                viewHolderOne.tv_title.setText(objinfo.getTitle());

                if (objinfo.getContentType()==1){
                    viewHolderOne.tv_label.setText("PDF");
                }else if (objinfo.getContentType()==2){
                    viewHolderOne.tv_label.setText("视频");
                }else{
                    viewHolderOne.tv_label.setText("音频");
                }
                DecimalFormat df =new DecimalFormat("#0.00");
                //价格正常
                if (objinfo.getPriceType()==1){
                    viewHolderOne.jiage.getPaint().setAntiAlias(false);
                    viewHolderOne.tvupdatetime.setVisibility(View.GONE);
                    //国内
                    if(iso=="cn"||iso=="CN"){
                        viewHolderOne.jiage.setText("¥"+df.format(objinfo.getNormalPricecny()));
                    }
                    //澳洲
                    else if(iso=="au"|| iso=="AU") {
                        viewHolderOne.jiage.setText("A$"+df.format(objinfo.getNormalPriceaud()));
                    }
                    //其他地区
                    else{
                        viewHolderOne.jiage.setText("$"+df.format(objinfo.getNormalPriceusd()));
                    }

                }
                //特价
                else if (objinfo.getPriceType()==2){

                    viewHolderOne.tvupdatetime.setVisibility(View.VISIBLE);

                    viewHolderOne.jiage.getPaint().setAntiAlias(true);
                    viewHolderOne.jiage.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);

                    //国内
                    if(iso=="cn"||iso=="CN"){
                        viewHolderOne.tvupdatetime.setText("¥"+df.format(objinfo.getSpecialOffercny()));
                        viewHolderOne.jiage.setText("¥"+df.format(objinfo.getNormalPricecny()));
                    }
                    //澳洲
                    else if(iso=="au"|| iso=="AU") {
                        viewHolderOne.tvupdatetime.setText("A$"+df.format(objinfo.getSpecialOfferaud()));
                        viewHolderOne.jiage.setText("A$"+df.format(objinfo.getNormalPriceaud()));
                    }
                    //其他地区
                    else{
                        viewHolderOne.tvupdatetime.setText("$"+df.format(objinfo.getSpecialOfferusd()));
                        viewHolderOne.jiage.setText("$"+df.format(objinfo.getNormalPriceusd()));
                    }

                }
                //限时免费
                else{

                    viewHolderOne.tvupdatetime.setVisibility(View.VISIBLE);
                    viewHolderOne.jiage.getPaint().setAntiAlias(true);
                    viewHolderOne.jiage.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);

                    viewHolderOne.tvupdatetime.setText("限时免费");
                    //国内
                    if(iso=="cn"||iso=="CN"){

                        viewHolderOne.jiage.setText("¥"+df.format(objinfo.getNormalPricecny()));
                    }
                    //澳洲
                    else if(iso=="au"|| iso=="AU") {
                        viewHolderOne.jiage.setText("A$"+df.format(objinfo.getNormalPriceaud()));
                    }
                    //其他地区
                    else{
                        viewHolderOne.jiage.setText("$"+df.format(objinfo.getNormalPriceusd()));
                    }

                }

                Glide.with(this.context).load(ApiManger.IMG_URL+objinfo.getMainPhoto()).into(viewHolderOne.iv_pic);

                viewHolderOne.rl_layout.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if (onCliskListener!=null){
                            onCliskListener.onClisk(v,i,objinfo.getOid());
                        }
                    }
                });
                break;
            case 2:
                ViewHolderColumnTow viewHolderTeo   = (ViewHolderColumnTow) viewHolder;
                viewHolderTeo.tv_title.setText(objinfo.getTitle());
                viewHolderTeo.tv_source.setText(objinfo.getUpdateTime());

                Glide.with(this.context).load(ApiManger.IMG_URL+objinfo.getMainPhoto()).into(viewHolderTeo.iv_photo);

//                viewHolderTeo.rl_layout.setTag(i);
//                viewHolderTeo.rl_layout.setOnClickListener(this);
                viewHolderTeo.rl_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onCliskListener!=null){
                            onCliskListener.onClisk(v,i,objinfo.getOid());
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
        return listData.get(position).getDataType();
    }




//   public class ViewHolderTeo extends RecyclerView.ViewHolder{
//        TextView  tv_title;
//        TextView  tv_source;
//        ImageView  iv_photo;
//        RelativeLayout  rl_layout;
//        public ViewHolderTeo(@NonNull View itemView) {
//            super(itemView);
//            tv_title=(TextView) itemView.findViewById(R.id.tv_title);
//            tv_source=(TextView) itemView.findViewById(R.id.tv_source);
//            iv_photo=(ImageView) itemView.findViewById(R.id.iv_photo);
//            rl_layout=(RelativeLayout) itemView.findViewById(R.id.rl_layout);
//
//        }
//    }

    public interface OnRecyclerViewItemClickListener {
        void onClisk(View view, int i,String id);
    }

    OnRecyclerViewItemClickListener onCliskListener;

//    public void setOnCliakListener(View view, int i){
//        onCliskListener.onClisk(view,i);
//    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onCliskListener = listener;
    }


}
