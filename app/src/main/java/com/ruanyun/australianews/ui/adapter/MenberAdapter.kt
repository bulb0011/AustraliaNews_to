package com.ruanyun.australianews.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.ruanyun.australianews.R

class MenberAdapter constructor(context : Context, listData:List<com.ruanyun.australianews.model.DingYueKeCheng.DataEntity.DatasEntity>) : RecyclerView.Adapter<MenberAdapter.MenberViewHolder>() {


     var contet: Context
     var listData: List<com.ruanyun.australianews.model.DingYueKeCheng.DataEntity.DatasEntity>

    init {
        this.contet = context
        this.listData = listData
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MenberViewHolder {
        return MenberViewHolder(
            LayoutInflater.from(contet)
                .inflate(R.layout.recy_item_member, p0, false)
        )
    }

    override fun getItemCount(): Int {

        return listData.size
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(ViewHolder: MenberViewHolder, p1: Int) {

        val  info=listData.get(p1)

        if (info.payAmountType=="1"){
            ViewHolder.jin_e.text ="¥"+info.payAmount
        }else if (info.payAmountType=="2"){
            ViewHolder.jin_e.text ="$"+info.payAmount
        }else{
            ViewHolder.jin_e.text ="A$"+info.payAmount
        }


//        ViewHolder.tv_daoqi.text="到期日期："+info.validityEndTime.substring(0,11)
        ViewHolder.tv_daoqi.text=info.validityEndTime

        ViewHolder.tv_kaishi.text=info.validityStartTime

        ViewHolder.ll_item_menber.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onCliskListener?.onClisk(v, p1)
            }

        })
    }

    class MenberViewHolder : RecyclerView.ViewHolder {
        var ll_item_menber: LinearLayout
        var jin_e: TextView
        var tv_daoqi: TextView
        var tv_kaishi: TextView

        constructor(itemView: View) : super(itemView) {
            ll_item_menber = itemView.findViewById(R.id.ll_item_menber)
            jin_e = itemView.findViewById(R.id.jin_e)
            tv_kaishi = itemView.findViewById<TextView>(R.id.tv_kaishi)
            tv_daoqi = itemView.findViewById<TextView>(R.id.tv_daoqi)

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