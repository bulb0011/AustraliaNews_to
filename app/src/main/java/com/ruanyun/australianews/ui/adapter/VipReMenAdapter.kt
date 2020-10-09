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

class VipReMenAdapter(
    context: Context,
    listData: MutableList<com.ruanyun.australianews.model.HotInfo.DatasEntity>
) : RecyclerView.Adapter<VipReMenAdapter.ReMenViewHolder>(){

     var contet:Context
     var listData:List<com.ruanyun.australianews.model.HotInfo.DatasEntity>

    val iso:String

    init {
        this.contet=context
        this.listData=listData
        this.iso=App.app.iso
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ReMenViewHolder {
      return  ReMenViewHolder(
            LayoutInflater.from(contet)
                .inflate(R.layout.rv_vip_item_remen, p0, false)
        )
    }

    override fun getItemCount(): Int {
       return listData.size
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(ViewHolder: ReMenViewHolder, i: Int) {
//        ViewHolder.jiage.paint.isAntiAlias=true
//        ViewHolder.jiage.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

        val objinfo =  listData.get(i)

        ViewHolder.ivpic.loadImage(ApiManger.IMG_URL+objinfo.mainPhoto)


        if (objinfo.contentType==1){
            ViewHolder.tvlabel.text ="PDF"
        }else if (objinfo.contentType==2){
            ViewHolder.tvlabel.text ="视频"
        }else{
            ViewHolder.tvlabel.text ="音频"
        }


        //价格正常
        if (objinfo.priceType==1){
            ViewHolder.jiage.paint.isAntiAlias=false
            //国内
            if(iso=="cn"||iso=="CN"){
                ViewHolder.tvupdatetime.visibility= View.GONE
                ViewHolder.jiage.text = "¥"+objinfo.normalPricecny.toString()
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                ViewHolder.tvupdatetime.visibility= View.GONE
                ViewHolder.jiage.text = "A$"+objinfo.normalPriceaud.toString()
            }
            //其他地区
            else{
                ViewHolder.tvupdatetime.visibility= View.GONE
                ViewHolder.jiage.text = "$"+objinfo.normalPriceusd.toString()
            }

        }
        //特价
        else if (objinfo.priceType==2){
            ViewHolder.tvupdatetime.visibility= View.VISIBLE

            ViewHolder.jiage.paint.isAntiAlias=true
            ViewHolder.jiage.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

            //国内
            if(iso=="cn"||iso=="CN"){
                ViewHolder.tvupdatetime.text= "¥"+objinfo.specialOffercny.toString()
                ViewHolder.jiage.text = "¥"+objinfo.normalPricecny.toString()
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                ViewHolder.tvupdatetime.text= "A$"+objinfo.specialOfferaud.toString()
                ViewHolder.jiage.text = "A$"+objinfo.normalPriceaud.toString()
            }
            //其他地区
            else{
                ViewHolder.tvupdatetime.text= "$"+objinfo.specialOfferusd.toString()
                ViewHolder.jiage.text = "$"+objinfo.normalPriceusd.toString()
            }

        }
        //限时免费
        else{

            ViewHolder.tvupdatetime.visibility= View.VISIBLE
            ViewHolder.jiage.paint.isAntiAlias=true
            ViewHolder.jiage.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

            //国内
            if(iso=="cn"||iso=="CN"){
                ViewHolder.tvupdatetime.text= "限时免费"
                ViewHolder.jiage.text = "¥"+objinfo.normalPricecny.toString()
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                ViewHolder.tvupdatetime.text= "限时免费"
                ViewHolder.jiage.text = "A$"+objinfo.normalPriceaud.toString()
            }
            //其他地区
            else{
                ViewHolder.tvupdatetime.text= "限时免费"
                ViewHolder.jiage.text = "$"+objinfo.normalPriceusd.toString()
            }

        }


//        if (objinfo.priceType==1){
//            ViewHolder.tvupdatetime.text ="PDF"
//
//            ViewHolder.jiage.paint.isAntiAlias=false
//
//        }else if (objinfo.priceType==2){
//
//            ViewHolder.tvupdatetime.text =objinfo.specialOffercny.toString()
//
//        }else{
//            ViewHolder.tvupdatetime.text ="限时免费"
//
//            ViewHolder.jiage.text=objinfo.normalPricecny.toString()
//        }

        ViewHolder.tvtitle.text=objinfo.title

        ViewHolder.tvjianjie.text=objinfo.keyWord

        ViewHolder.rllayout.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                onCliskListener?.onClisk(v,i,objinfo.contentType,objinfo.oid)
            }

        })
    }

    class ReMenViewHolder : RecyclerView.ViewHolder{

        var jiage:TextView

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
        fun onClisk(view: View?, po: Int,type:Int,id:String)
    }

    var onCliskListener: OnCliskListener? = null

    fun setOnCliakListener(onCliakListener: OnCliskListener?) {
        onCliskListener = onCliakListener
    }

}