package com.ruanyun.australianews.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.ext.loadImage
import java.text.DecimalFormat

class VipQuanYiAdapter(
    context: Context,
    listData: MutableList<com.ruanyun.australianews.model.YaunYiInfo.DataEntity>
) : RecyclerView.Adapter<VipQuanYiAdapter.ReMenViewHolder>(){

     var contet:Context
     var listData:List<com.ruanyun.australianews.model.YaunYiInfo.DataEntity>

    init {
        this.contet=context
        this.listData=listData
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ReMenViewHolder {
      return  ReMenViewHolder(
            LayoutInflater.from(contet)
                .inflate(R.layout.recycle_item_vipquanyi, p0, false)
        )
    }

    override fun getItemCount(): Int {
       return listData.size
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(ViewHolder: ReMenViewHolder, i: Int) {
//        ViewHolder.jiage.paint.isAntiAlias=true
//        ViewHolder.jiage.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

       val info=listData[i]

        ViewHolder.tv_1.text = info.title
        ViewHolder.tv_2.text = info.remarks


    }

    class ReMenViewHolder : RecyclerView.ViewHolder{

        var tv_1:TextView
        var tv_2:TextView

        constructor(itemView: View) :super(itemView){
            tv_1=itemView.findViewById<TextView>(R.id.tv_1)
            tv_2=itemView.findViewById<TextView>(R.id.tv_2)
        }

    }

    interface OnCliskListener {
        fun onClisk(view: View?, po: Int,type:Int,id:String)
    }

    var onCliskListener: OnCliskListener? = null

    fun setOnCliakListener(onCliakListener: OnCliskListener?) {
        onCliskListener = onCliakListener
    }

}