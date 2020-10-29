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
import com.ruanyun.australianews.util.DateUtil

class SpecialColumnAdapter constructor(context : Context, listData:List<com.ruanyun.australianews.model.DingYueZhuanLan.DatasEntity>) : RecyclerView.Adapter<SpecialColumnAdapter.SpecialColumnViewHolder>() {


    lateinit var contet: Context
    lateinit var listData: List<com.ruanyun.australianews.model.DingYueZhuanLan.DatasEntity>

    init {
        this.contet = context
        this.listData = listData
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SpecialColumnViewHolder {
        return SpecialColumnViewHolder(
            LayoutInflater.from(contet)
                .inflate(R.layout.recy_item_special_column, p0, false)
        )
    }

    override fun getItemCount(): Int {

        return listData.size
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(ViewHolder: SpecialColumnViewHolder, p1: Int) {

        val  info=listData.get(p1)

        if (info.payAmountType=="1"){
            ViewHolder.jin_e.text ="¥"+info.payAmount
        }else if (info.payAmountType=="2"){
            ViewHolder.jin_e.text ="$"+info.payAmount
        }else{
            ViewHolder.jin_e.text ="A$"+info.payAmount
        }

        ViewHolder.title.text=info.afnNewsColumn.title

        ViewHolder.tv_daoqi.text=info.validityEndTime

        ViewHolder.tv_kaishi.text=info.validityStartTime

        ViewHolder.ll_item.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onCliskListener?.onClisk(v, p1)
            }

        })
    }

    class SpecialColumnViewHolder : RecyclerView.ViewHolder {
        var ll_item: LinearLayout
        var jin_e: TextView
        var tv_kaishi: TextView
        var tv_daoqi: TextView
        var title: TextView

        constructor(itemView: View) : super(itemView) {
            ll_item = itemView.findViewById<LinearLayout>(R.id.ll_item)
            jin_e = itemView.findViewById<TextView>(R.id.jin_e)
            tv_kaishi = itemView.findViewById<TextView>(R.id.tv_kaishi)
            tv_daoqi = itemView.findViewById<TextView>(R.id.tv_daoqi)
            title = itemView.findViewById<TextView>(R.id.title)

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