package com.ruanyun.australianews.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.ruanyun.australianews.R
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.VipColumnInfo

class MoreSpecialColumnAdapter constructor(context : Context, listData:List<VipColumnInfo.DatasBean>) : RecyclerView.Adapter<MoreSpecialColumnAdapter.MoreSpecialColumnHolder>(){

        lateinit var contet:Context
        lateinit var listData:List<VipColumnInfo.DatasBean>

        init {
            this.contet=context
            this.listData=listData
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MoreSpecialColumnHolder {
            return  MoreSpecialColumnHolder(
                LayoutInflater.from(contet)
                    .inflate(R.layout.rv_vip_item_more_special_column, p0, false)
            )
        }

        override fun getItemCount(): Int {
            return listData.size
        }

        @SuppressLint("RecyclerView")
        override fun onBindViewHolder(ViewHolder: MoreSpecialColumnHolder, i: Int) {

            ViewHolder.image_one.loadImage(listData.get(i))
            ViewHolder.iamge_to.loadImage(listData.get(i))

            val info=listData[i].afnInfoAllList

            ViewHolder.image_one.loadImage(ApiManger.IMG_URL+info[0].mainPhoto)
            ViewHolder.iamge_to.loadImage(ApiManger.IMG_URL+info[1].mainPhoto)

            ViewHolder.tv_one.text=info[0].title
            ViewHolder.tv_tow.text=info[1].title

            ViewHolder.tv_title.text=listData.get(i).title

            ViewHolder.item_ll.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    if (onCliskListener!=null){
                        onCliskListener?.onClisk(v,i,listData[i].oid)
                    }
                }

            })
        }

        class MoreSpecialColumnHolder : RecyclerView.ViewHolder{


            var item_ll : LinearLayout
            var image_one : ImageView
            var iamge_to : ImageView
            var tv_one : TextView
            var tv_tow : TextView
            var tv_title : TextView

            constructor(itemView: View) :super(itemView){

                item_ll=itemView.findViewById<LinearLayout>(R.id.item_ll)
                image_one=itemView.findViewById<ImageView>(R.id.image_one)
                iamge_to=itemView.findViewById<ImageView>(R.id.iamge_to)
                tv_one=itemView.findViewById<TextView>(R.id.tv_one)
                tv_tow=itemView.findViewById<TextView>(R.id.tv_tow)
                tv_title=itemView.findViewById<TextView>(R.id.tv_title)


            }

        }

        interface OnCliskListener {
            fun onClisk(view: View?, po: Int,id:String)
        }

        var onCliskListener: OnCliskListener? = null

        fun setOnCliakListener(onCliakListener: OnCliskListener?) {
            onCliskListener = onCliakListener
        }

}