package com.ruanyun.australianews.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import cn.addapp.pickers.util.DateUtils
import com.ruanyun.australianews.R
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.ext.loadImage


class MorePayAdapter constructor(context : Context, listData:List<com.ruanyun.australianews.model.TextNewInfo.DataEntity.DatasEntity>) : RecyclerView.Adapter<MorePayAdapter.MorePayHolder>(){
    //NewsInfoNewsInfo.DatasBean
        lateinit var contet:Context
        lateinit var listData:List<com.ruanyun.australianews.model.TextNewInfo.DataEntity.DatasEntity>

        init {
            this.contet=context
            this.listData=listData
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MorePayHolder {
            return  MorePayHolder(
                LayoutInflater.from(contet)
                    .inflate(R.layout.re_item_more_pay, p0, false)
            )
        }

        override fun getItemCount(): Int {
            return listData.size
        }

        @SuppressLint("RecyclerView")
        override fun onBindViewHolder(ViewHolder: MorePayHolder, i: Int) {

            val objinfo=listData[i]

            ViewHolder.iv_photo.loadImage(ApiManger.IMG_URL+objinfo.mainPhoto)

            ViewHolder.tv_title.text=objinfo.title

            ViewHolder.tv_source.text=
                DateUtils.formatDate(DateUtils.parseDate(objinfo.createTime),"MM-dd HH:mm" )



            ViewHolder.rl_layout.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    if (onCliskListener!=null){
                        onCliskListener?.onClisk(v,i)
                    }
                }

            })
        }

        class MorePayHolder : RecyclerView.ViewHolder{


            var rl_layout : RelativeLayout
            var iv_photo : ImageView
            var tv_title : TextView
            var tv_source : TextView

            constructor(itemView: View) :super(itemView){

                rl_layout=itemView.findViewById<RelativeLayout>(R.id.rl_layout)
                iv_photo=itemView.findViewById<ImageView>(R.id.iv_photo)
                tv_title=itemView.findViewById<TextView>(R.id.tv_title)
                tv_source=itemView.findViewById<TextView>(R.id.tv_source)
            }

        }

        interface OnCliskListener {
            fun onClisk(view: View?, po: Int)
        }

        var onCliskListener: OnCliskListener? = null

        fun setOnCliakListener(onCliakListener: OnCliskListener?) {
            onCliskListener = onCliakListener
        }

}