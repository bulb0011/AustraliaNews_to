package com.ruanyun.australianews.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.ruanyun.australianews.R
import com.ruanyun.australianews.ext.loadCircleImage
import com.ruanyun.australianews.ext.loadImage

class VipReListTowAdapter constructor(context :Context, listData:List<String>) : RecyclerView.Adapter<VipReListTowAdapter.TowViewHolder>() {



    lateinit var contet: Context
    lateinit var listData:List<String>

    init {
        this.contet=context
        this.listData=listData
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TowViewHolder {
       return  TowViewHolder(
           LayoutInflater.from(contet)
           .inflate(R.layout.vip_re_to_item, p0, false))
    }

    override fun getItemCount(): Int {

        return listData.size
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(ViewHolder: TowViewHolder, p1: Int) {

        ViewHolder.image.loadImage("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595997457487&di=52b096a24548bb236156ba47161ebd48&imgtype=0&src=http%3A%2F%2Ft9.baidu.com%2Fit%2Fu%3D583874135%2C70653437%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D3607%26h%3D2408")

        ViewHolder.rl_layout.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                onCliskListener?.onClisk(v,p1)
            }

        })
    }

    class TowViewHolder : RecyclerView.ViewHolder {
        var image:ImageView
        var rl_layout:RelativeLayout

        constructor(itemView: View) :super(itemView){
            image=itemView.findViewById<ImageView>(R.id.iv_photo)
            rl_layout=itemView.findViewById<RelativeLayout>(R.id.rl_layout)

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