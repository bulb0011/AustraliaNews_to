package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.media.MediaPlayer
import android.os.Bundle
import android.text.Html
import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.NewsDirectoryDetails
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.getTime
import kotlinx.android.synthetic.main.activity_frequency_play.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat

class FrequencyPlayActivity :BaseActivity() {

    companion object{

        fun start(context: Context,infoId:String) {
            val starter = Intent(context, FrequencyPlayActivity::class.java)
            starter.putExtra("infoId",infoId)
            context.startActivity(starter)
        }

    }

    val mediaPlayer = MediaPlayer()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_frequency_play)

        initDta(infoId = intent.getStringExtra("infoId"))


        head_zanting.visibility=View.GONE

        head_bofang.clickWithTrigger {
            //[4]开始播放
            mediaPlayer.start()
            head_bofang.visibility=View.GONE
            head_zanting.visibility=View.VISIBLE
        }

        head_zanting.clickWithTrigger {
            //[4]暂停播放
            mediaPlayer.pause()
            head_bofang.visibility=View.VISIBLE
            head_zanting.visibility=View.GONE
        }

        tmg_fanui.clickWithTrigger{
            finish()
        }

    }

    fun initDta(infoId:String){
        ApiManger.getApiService().getVipNewInfoDirectoryDetails(infoId, App.getInstance().userOid)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                    val  hotinfo=GsonUtil.parseJson(result.data,HotInfo::class.java)

                    val json = response.body()!!.string()

                    val je = JsonParser().parse(json)

                    val data = je.asJsonObject["data"]

                    val gson = Gson()

                    val detailIfo= gson.fromJson<NewsDirectoryDetails>(data,NewsDirectoryDetails::class.java)

//                    val detailIfo=response!!.body()!!.data
                    if (detailIfo.afnNewsInfo!=null)
                    tupian.loadImage(ApiManger.IMG_URL+detailIfo.afnNewsInfo.mainPhoto)

                    tv_title.text=detailIfo.title

                    initMp(ApiManger.IMG_URL+detailIfo.fileUrl)

                    tv_name.text=detailIfo.afnNewsInfo.title

                    tv_context.text= Html.fromHtml(detailIfo.content)

                    tv_shijian.text= getTime.stM((detailIfo.afnNewsInfo.normalPricecny).toInt())

                    initjiage(detailIfo.afnNewsInfo)


                }
            })
    }


    fun initMp(fileUrl:String){
        //1，创建一个多媒体播放器
        try {
            mediaPlayer.setDataSource(fileUrl)
            //[3]准备播放
            mediaPlayer.prepare()
            mediaPlayer.setOnCompletionListener(object : MediaPlayer.OnCompletionListener {
                override fun onCompletion(mp: MediaPlayer?) {
                    head_bofang.visibility=View.VISIBLE
                    head_zanting.visibility=View.GONE
                    FinishActivity.start(this@FrequencyPlayActivity, C.IntentKey.VIP_TYPE_MP3)
                }
            })

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun initjiage(detailIfo: NewsDirectoryDetails.AfnNewsInfoEntity){

        val iso=App.app.iso
        val df = DecimalFormat("#0.00")
        //价格正常
        if (detailIfo.priceType==1){
            zhiqianjiege.paint.isAntiAlias=false
            zhiqianjiege.visibility= View.GONE

            //国内
            if(iso=="cn"||iso=="CN"){

                tv_jiage.text = "¥"+df.format(detailIfo.normalPricecny)
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                tv_jiage.text = "A$"+df.format(detailIfo.normalPriceaud)
            }
            //其他地区
            else{
                tv_jiage.text  = "$"+df.format(detailIfo.normalPriceusd)
            }

        }
        //特价
        else if (detailIfo.priceType==2){

            zhiqianjiege.visibility= View.VISIBLE

            zhiqianjiege.paint.isAntiAlias=true
            zhiqianjiege.paint.flags= Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

            //国内
            if(iso=="cn"||iso=="CN"){
                tv_jiage.text= "¥"+df.format(detailIfo.specialOffercny)
                zhiqianjiege.text = "¥"+df.format(detailIfo.normalPricecny)
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                tv_jiage.text= "A$"+df.format(detailIfo.specialOfferaud)
                zhiqianjiege.text = "A$"+df.format(detailIfo.normalPriceaud)
            }
            //其他地区
            else{
                tv_jiage.text= "$"+df.format(detailIfo.specialOfferusd)
                zhiqianjiege.text = "$"+df.format(detailIfo.normalPriceusd)
            }

        }
        //限时免费
        else{

            zhiqianjiege.visibility= View.VISIBLE
            zhiqianjiege.paint.isAntiAlias=true
            zhiqianjiege.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

            //国内
            if(iso=="cn"||iso=="CN"){
                tv_jiage.text= "限时免费"
                zhiqianjiege.text = "¥"+df.format(detailIfo.normalPricecny)
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                tv_jiage.text= "限时免费"
                zhiqianjiege.text = "A$"+df.format(detailIfo.normalPriceaud)
            }
            //其他地区
            else{
                tv_jiage.text= "限时免费"
                zhiqianjiege.text = "$"+df.format(detailIfo.normalPriceusd)
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.pause()
        mediaPlayer.release()
    }

}