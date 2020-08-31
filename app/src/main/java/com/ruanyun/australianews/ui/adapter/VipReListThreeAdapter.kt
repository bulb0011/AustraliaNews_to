package com.ruanyun.australianews.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.ruanyun.australianews.R

class VipReListThreeAdapter constructor(context :Context, listData:List<String>) : RecyclerView.Adapter<VipReListThreeAdapter.ThreeViewHolder>(){

    lateinit var contet:Context
    lateinit var listData:List<String>

    init {
        this.contet=context
        this.listData=listData
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ThreeViewHolder {
      return  ThreeViewHolder(
            LayoutInflater.from(contet)
                .inflate(R.layout.vip_rv_list_three, p0, false)
        )
    }

    override fun getItemCount(): Int {
       return listData.size
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(ViewHolder: ThreeViewHolder, i: Int) {

//        ViewHolder.jiage.paint.isAntiAlias=true
//        ViewHolder.jiage.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

        ViewHolder.rllayout.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                onCliskListener?.onClisk(v,i)
            }

        })
    }

    class ThreeViewHolder : RecyclerView.ViewHolder{

//        var jiage:TextView

        var rllayout : RelativeLayout

        constructor(itemView: View) :super(itemView){
//            jiage=itemView.findViewById<ImageView>(R.id.iv_pic)
            rllayout=itemView.findViewById<RelativeLayout>(R.id.rv_three)
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