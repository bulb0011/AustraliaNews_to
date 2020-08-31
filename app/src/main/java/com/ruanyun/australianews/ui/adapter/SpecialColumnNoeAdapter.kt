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
import com.ruanyun.australianews.R
import jiguang.chat.application.JGApplication.context

class SpecialColumnNoeAdapter(contex:Context,listData:List<String> ) : RecyclerView.Adapter<SpecialColumnNoeAdapter.SpecialColumnNoeHolder>(){

     var contet: Context
     var listData:List<String>

    init {
        this.contet=context
        this.listData=listData
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SpecialColumnNoeHolder {
        return  SpecialColumnNoeHolder(
            LayoutInflater.from(contet)
                .inflate(R.layout.rv_vip_item_remen, p0, false)
        )
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(ViewHolder: SpecialColumnNoeHolder, p1: Int) {


        ViewHolder.rllayout.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                onCliskListener?.onClisk(v,p1)
            }

        })

        if (p1==1){

            ViewHolder.tvlabel.text="PDF"

        }else  if(p1==2){
            ViewHolder.tvlabel.text="视频"
        }
        else  if(p1==3){
            ViewHolder.tvlabel.text="音频"
        }


    }

    override fun getItemCount(): Int {
        return listData.size
    }


    class SpecialColumnNoeHolder : RecyclerView.ViewHolder{

        var jiage: TextView

        var rllayout : RelativeLayout

        var tvtitle : TextView
        var tvlabel : TextView
        var tvupdatetime : TextView
        var tvjianjie : TextView
        var ivpic : ImageView

        constructor(itemView: View) :super(itemView){
            jiage=itemView.findViewById<TextView>(R.id.jiage)
            tvtitle=itemView.findViewById<TextView>(R.id.tv_title)
            tvlabel=itemView.findViewById<TextView>(R.id.tv_label)
            tvupdatetime=itemView.findViewById<TextView>(R.id.tv_update_time)
            tvjianjie=itemView.findViewById<TextView>(R.id.tv_jianjie)
            ivpic=itemView.findViewById<ImageView>(R.id.iv_pic)
            rllayout=itemView.findViewById<RelativeLayout>(R.id.rl_layout)
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