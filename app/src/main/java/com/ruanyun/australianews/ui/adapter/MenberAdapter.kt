package com.ruanyun.australianews.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ruanyun.australianews.R

class MenberAdapter constructor(context : Context, listData:List<String>) : RecyclerView.Adapter<MenberAdapter.MenberViewHolder>() {


     var contet: Context
     var listData: List<String>

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

        ViewHolder.ll_item_menber.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onCliskListener?.onClisk(v, p1)
            }

        })
    }

    class MenberViewHolder : RecyclerView.ViewHolder {
        var ll_item_menber: LinearLayout

        constructor(itemView: View) : super(itemView) {
            ll_item_menber = itemView.findViewById(R.id.ll_item_menber)

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