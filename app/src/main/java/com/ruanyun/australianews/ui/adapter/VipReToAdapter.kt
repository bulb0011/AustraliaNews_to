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
import com.ruanyun.australianews.ext.loadCircleImage
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.NewsInfoNewsInfo
import java.util.*

class VipReToAdapter constructor(context :Context,listData:List<NewsInfoNewsInfo.DatasBean>) : RecyclerView.Adapter<VipReToAdapter.VipReToViewHolder>() {



    lateinit var contet: Context
    lateinit var listData:List<NewsInfoNewsInfo.DatasBean>

    init {
        this.contet=context
        this.listData=listData
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VipReToViewHolder {
       return  VipReToViewHolder(
           LayoutInflater.from(contet)
           .inflate(R.layout.vip_re_to_item, p0, false))
    }

    override fun getItemCount(): Int {

        return listData.size
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(ViewHolder: VipReToViewHolder, i: Int) {

       val objinfo=listData[i]

        ViewHolder.image.loadImage(ApiManger.IMG_URL+objinfo.mainPhoto)

        ViewHolder.tv_title.text=objinfo.title

        ViewHolder.tv_source.text=DateUtils.formatDate(DateUtils.parseDate(objinfo.createTime),"MM-dd HH:mm" )

        ViewHolder.rl_layout.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if (onCliskListener!=null) {
                    onCliskListener?.onClisk(v,i)
                }
            }
        })

    }

    class VipReToViewHolder : RecyclerView.ViewHolder {
        var image:ImageView
        var tv_title:TextView
        var tv_source:TextView
        var rl_layout: RelativeLayout

        constructor(itemView: View) :super(itemView){
            image=itemView.findViewById<ImageView>(R.id.iv_photo)
            tv_title=itemView.findViewById<TextView>(R.id.tv_title)
            tv_source=itemView.findViewById<TextView>(R.id.tv_source)
            rl_layout=itemView.findViewById<RelativeLayout>(R.id.rl_layout)

        }

    }

    interface OnCliskListener {
        fun onClisk(view: View?,i:Int)
    }

    var onCliskListener: OnCliskListener? = null

    fun setOnCliakListener(onCliakListener: OnCliskListener?) {
        onCliskListener = onCliakListener
    }


}