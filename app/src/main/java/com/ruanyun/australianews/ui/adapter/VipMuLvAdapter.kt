package com.ruanyun.australianews.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.ruanyun.australianews.R
import com.ruanyun.australianews.model.VipDetailIfo

class VipMuLvAdapter constructor(context : Context, listData:List<com.ruanyun.australianews.model.VipDetailIfo.AfnNewsDirectoryListEntity>) : RecyclerView.Adapter<VipMuLvAdapter.MuLvViewHolder>() {

    lateinit var contet: Context
    lateinit var listData:List<com.ruanyun.australianews.model.VipDetailIfo.AfnNewsDirectoryListEntity>

    init {
        this.contet=context
        this.listData=listData
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MuLvViewHolder {
        return  MuLvViewHolder(
            LayoutInflater.from(contet)
                .inflate(R.layout.vip_rv_mulv, p0, false))
    }

    override fun getItemCount(): Int {
      return  listData.size
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(viewHolder: MuLvViewHolder, p1: Int) {

        val info= listData.get(p1)

        viewHolder.title.text=info.title

        viewHolder.rl_layout.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {

                if (onCliskListener!=null) {
                    onCliskListener?.onClisk(v,p1,info.oid)
                }
            }
        })

    }

    class MuLvViewHolder : RecyclerView.ViewHolder{

        val title : TextView
        val rl_layout : RelativeLayout


        constructor(itemView: View) :super(itemView){

            title= itemView.findViewById<TextView>(R.id.title)
            rl_layout= itemView.findViewById<RelativeLayout>(R.id.rl_layout)

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