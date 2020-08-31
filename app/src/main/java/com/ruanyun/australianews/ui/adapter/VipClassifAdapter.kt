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
import com.ruanyun.australianews.model.ClassifyInfo
import com.ruanyun.australianews.model.HotInfo

class VipClassifAdapter(
    context: Context,
    listData: MutableList<ClassifyInfo>
) : RecyclerView.Adapter<VipClassifAdapter.ClassifViewHolder>(){

     var contet:Context
     var listData:List<ClassifyInfo>

    val iso:String

    init {
        this.contet=context
        this.listData=listData
        this.iso=App.app.iso
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ClassifViewHolder {
      return  ClassifViewHolder(
            LayoutInflater.from(contet)
                .inflate(R.layout.rv_vip_item_classiff, p0, false)
        )
    }

    override fun getItemCount(): Int {
       return listData.size
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(ViewHolder: ClassifViewHolder, i: Int) {
//        ViewHolder.jiage.paint.isAntiAlias=true
//        ViewHolder.jiage.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

      var objinfo =  listData.get(i)

        ViewHolder.image_hangyebaogao.loadImage(ApiManger.IMG_URL+objinfo.mainPhoto)

        ViewHolder.tv_classif.text=objinfo.title

        ViewHolder.rl_hangyebaogao.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                onCliskListener?.onClisk(v,objinfo.title,objinfo.oid)
            }

        })
    }

    class ClassifViewHolder : RecyclerView.ViewHolder{

        val rl_hangyebaogao:RelativeLayout
        val image_hangyebaogao:ImageView
        val tv_classif:TextView

        constructor(itemView: View) :super(itemView){

            rl_hangyebaogao=  itemView.findViewById<RelativeLayout>(R.id.rl_hangyebaogao)
            image_hangyebaogao=  itemView.findViewById<ImageView>(R.id.image_hangyebaogao)
            tv_classif=  itemView.findViewById<TextView>(R.id.tv_classif)

        }

    }

    interface OnCliskListener {
        fun onClisk(view: View?, title: String,id:String)
    }

    var onCliskListener: OnCliskListener? = null

    fun setOnCliakListener(onCliakListener: OnCliskListener?) {
        onCliskListener = onCliakListener
    }

}