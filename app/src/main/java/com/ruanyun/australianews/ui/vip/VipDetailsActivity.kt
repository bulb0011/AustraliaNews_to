package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.meiqia.meiqiasdk.util.MQIntentBuilder
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.BuyInfo
import com.ruanyun.australianews.model.VipDetailIfo
import com.ruanyun.australianews.ui.adapter.VipMuLvAdapter
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.FileUtil
import com.ruanyun.australianews.widget.SharePopWindow
import jiguang.chat.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_vip_details.*
import okhttp3.ResponseBody
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat


class VipDetailsActivity :BaseActivity(){

    companion object{

        fun start(context: Context,type: String,id:String) {
            val starter = Intent(context, VipDetailsActivity::class.java)
            starter.putExtra("type",type)
            starter.putExtra("id",id)
            context.startActivity(starter)
        }

        fun start(context: Context,type: String) {
            val starter = Intent(context, VipDetailsActivity::class.java)
            starter.putExtra("type",type)
            context.startActivity(starter)
        }

    }
    var isZhanKai=false

    var type=""

    var id=""

    var InfoId=""

    var isBuy=2

    lateinit var sharePopWindow: SharePopWindow

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_vip_details)

        type = intent.getStringExtra("type")

        id = intent.getStringExtra("id")

        if(id!=null)initData()

        if(C.IntentKey.VIP_TYPE_VIDEO.equals(type)){
            tv_label.text="视频"
            tv_shidu.text="试看"

        }else if (C.IntentKey.VIP_TYPE_PDF.equals(type)){
            tv_label.text="PDF"
            tv_shidu.text="试读"

        }else if (C.IntentKey.VIP_TYPE_MP3.equals(type)){
            tv_label.text="音频"
            tv_shidu.text="试听"
        }

        EventBus.getDefault().register(this)

//        zhiqianjiege.paint.isAntiAlias=true
//        zhiqianjiege.paint.flags= Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG


        ll_gaodu.setLayoutParams(LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 207))

        rv_neirongmulv.setLayoutParams(LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 207))

        tv_chakanquanbu.visibility=View.VISIBLE
        tv_zhedieshouqi.visibility=View.INVISIBLE

        bt_add_vip.clickWithTrigger{
            if(isLoginToActivity)
            AddVipActivity.start(this)
        }

        rl_chakanquabu.clickWithTrigger{
            ll_gaodu.setLayoutParams(LinearLayout.
            LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }

        rv_mulv.visibility=View.GONE

        xiahua_mulv.visibility=View.INVISIBLE

        initEvent()


    }

    fun initEvent(){

        ll_neirongmulv.clickWithTrigger{
            if (isZhanKai){
                tv_chakanquanbu.visibility=View.VISIBLE
                tv_zhedieshouqi.visibility=View.INVISIBLE

                rv_neirongmulv.setLayoutParams(LinearLayout.
                LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                isZhanKai=false
            }else{
                tv_chakanquanbu.visibility=View.INVISIBLE
                tv_zhedieshouqi.visibility=View.VISIBLE


                rv_neirongmulv.setLayoutParams(LinearLayout.
                LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 207))
                isZhanKai=true
            }
        }

        rv_neurongjiajie.clickWithTrigger{
            xiahua_neirong.visibility=View.VISIBLE
            xiahua_mulv.visibility=View.INVISIBLE

            tv_neirongianjie.visibility=View.VISIBLE
            rv_mulv.visibility=View.GONE

            rv_neirongmulv.setLayoutParams(LinearLayout.
            LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 207))
        }

        rv_mlv.clickWithTrigger{
            isZhanKai=true
            xiahua_neirong.visibility=View.INVISIBLE
            xiahua_mulv.visibility=View.VISIBLE

            tv_neirongianjie.visibility=View.GONE
            rv_mulv.visibility=View.VISIBLE

            tv_chakanquanbu.visibility=View.VISIBLE
            tv_zhedieshouqi.visibility=View.INVISIBLE

            rv_neirongmulv.setLayoutParams(LinearLayout.
            LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200))


        }

        image_fanhui.clickWithTrigger{
            this.finish()
        }


        tv_shidu.clickWithTrigger{

            if (InfoId!="") {
                if(C.IntentKey.VIP_TYPE_VIDEO.equals(type)){
                    VideoActivity.start(this,InfoId)

                }else if (C.IntentKey.VIP_TYPE_PDF.equals(type)){
                    PDFActivity.start(this,InfoId)

                }else if (C.IntentKey.VIP_TYPE_MP3.equals(type)){
                    FrequencyPlayActivity.start(this,InfoId)
                }
            }else{
                ToastUtil.shortToast(this,"id为空")
            }
        }

        bofang.clickWithTrigger{

            if (InfoId!="") {
                if(C.IntentKey.VIP_TYPE_VIDEO.equals(type)){
                    VideoActivity.start(this,InfoId)

                }else if (C.IntentKey.VIP_TYPE_PDF.equals(type)){
                    PDFActivity.start(this,InfoId)

                }else if (C.IntentKey.VIP_TYPE_MP3.equals(type)){
                    FrequencyPlayActivity.start(this,InfoId)
                }
            }else{
                ToastUtil.shortToast(this,"id为空")
            }
        }

        fenxiang.clickWithTrigger {
            if(isLoginToActivity)
            sharePopWindow.show(fenxiang)
        }

        //链接客服
        iamge_kefu.clickWithTrigger {

            if (App.app.userOid!=null){
                val intent = MQIntentBuilder(this)
                    .setCustomizedId(App.app.userOid)
                    .build()
                startActivity(intent)
            }else{
                val intent = MQIntentBuilder(this)
                    .build()
                startActivity(intent)
            }

        }

        tv_goumai.clickWithTrigger {
            if(isLoginToActivity)
            SelectPayActivity.start(this,1,id,
                inamge_url,price_Type,jige,zhiqianjiage,tv_label.text.toString(),tv_title.text.toString())
        }
    }


    fun initData(){

        ApiManger.getApiService().getVipNewInfo(id, App.getInstance().userOid)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                    val json = response.body()!!.string()

                    val je = JsonParser().parse(json)

                    val data = je.asJsonObject["data"]

                    val gson = Gson()

                    val detailIfo= gson.fromJson<VipDetailIfo>(data,VipDetailIfo::class.java)

//                    val  hotinfo=GsonUtil.parseJson(result.data,HotInfo::class.java)
//                    val detailIfo=response.body()!!.data
//
//                    App.getInstance().cityName
//
//                    App.getInstance().userOid

                    if(detailIfo.afnNewsDirectoryList!=null && detailIfo.afnNewsDirectoryList.size>0){
                        InfoId=detailIfo.afnNewsDirectoryList[0].oid
                    }

                    isBuy = detailIfo.isBuy

                    setViewData(detailIfo)

                }
            })

    }

    val NEWS_DETAILS = "app/afnnewsinfo/getAfnNewsInfoDetails?region=%s&afnNewsInfoOid=%s&userOid=%s"//新闻详情

    var inamge_url=""
    var price_Type=1
    var jige=""
    var zhiqianjiage=""

    fun setViewData(detailIfo: com.ruanyun.australianews.model.VipDetailIfo){

        val iso=App.app.iso

        iv_pic.loadImage(ApiManger.IMG_URL+detailIfo.mainPhoto)

        inamge_url=ApiManger.IMG_URL+detailIfo.mainPhoto

        tv_title.text=detailIfo.title

//        val richText: CharSequence = Html.fromHtml(detailIfo.recommendation)
//
//        mingrentuijian.text=richText

        mingrentuijian.getSettings().setJavaScriptEnabled(true);

        mingrentuijian.loadDataWithBaseURL(null,C.varjs+detailIfo.recommendation,"text/html","UTF-8",null);

//        val richTextto: CharSequence = Html.fromHtml(detailIfo.content)
//        tv_neirongianjie.text=richTextto

        tv_neirongianjie.loadDataWithBaseURL(null,C.varjs+detailIfo.content,"text/html","UTF-8",null);


        sharePopWindow = SharePopWindow(mContext)
        sharePopWindow.share_title = detailIfo.title
        //
        sharePopWindow.share_text = detailIfo.recommendation
        sharePopWindow.share_image = ApiManger.IMG_URL+detailIfo.mainPhoto

        val url = FileUtil.getWebViewUrl(NEWS_DETAILS, App.getInstance().cityName, detailIfo.oid, App.getInstance().userOid)

        sharePopWindow.share_url = url

        price_Type=detailIfo.priceType

        val df = DecimalFormat("#0.00")
        //价格正常
        if (detailIfo.priceType==1){
            zhiqianjiege.paint.isAntiAlias=false
            zhiqianjiege.visibility= View.GONE

            //国内
            if(iso=="cn"||iso=="CN"){
                tv_jiage.text = "¥"+df.format(detailIfo.normalPricecny)
                jige="¥"+df.format(detailIfo.normalPricecny)
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                tv_jiage.text = "A$"+df.format(detailIfo.normalPriceaud)
                jige = "A$"+df.format(detailIfo.normalPriceaud)
            }
            //其他地区
            else{
                tv_jiage.text  = "$"+df.format(detailIfo.normalPriceusd)
                jige = "$"+df.format(detailIfo.normalPriceusd)
            }

        }
        //特价
        else if (detailIfo.priceType==2){

            zhiqianjiege.visibility= View.VISIBLE

            zhiqianjiege.paint.isAntiAlias=true
            zhiqianjiege.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

            //国内
            if(iso=="cn"||iso=="CN"){
                tv_jiage.text= "¥"+df.format(detailIfo.specialOffercny)
                zhiqianjiege.text = "¥"+df.format(detailIfo.normalPricecny)

                jige="¥"+df.format(detailIfo.normalPricecny)
                zhiqianjiage="¥"+df.format(detailIfo.normalPricecny)
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                tv_jiage.text= "A$"+df.format(detailIfo.specialOfferaud)
                zhiqianjiege.text = "A$"+df.format(detailIfo.normalPriceaud)

                jige="A$"+df.format(detailIfo.specialOfferaud)
                zhiqianjiage="A$"+df.format(detailIfo.normalPriceaud)
            }
            //其他地区
            else{
                tv_jiage.text= "$"+df.format(detailIfo.specialOfferusd)
                zhiqianjiege.text = "$"+df.format(detailIfo.normalPriceusd)

                jige="$"+df.format(detailIfo.specialOfferusd)
                zhiqianjiage="$"+df.format(detailIfo.normalPriceusd)
            }

        }
        //限时免费
        else{

            zhiqianjiege.visibility= View.VISIBLE
            zhiqianjiege.paint.isAntiAlias=true
            zhiqianjiege.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

            setIsBuy(1)

            //国内
            if(iso=="cn"||iso=="CN"){
                tv_jiage.text= "限时免费"
                zhiqianjiege.text = "¥"+df.format(detailIfo.normalPricecny)

                jige="限时免费"
                zhiqianjiage="¥"+df.format(detailIfo.normalPricecny)
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                tv_jiage.text= "限时免费"
                zhiqianjiege.text = "A$"+df.format(detailIfo.normalPriceaud)
                jige="限时免费"
                zhiqianjiage="A$"+df.format(detailIfo.normalPriceaud)
            }
            //其他地区
            else{
                tv_jiage.text= "限时免费"
                zhiqianjiege.text = "$"+df.format(detailIfo.normalPriceusd)

                jige="限时免费"
                zhiqianjiage="$"+df.format(detailIfo.normalPriceusd)
            }

        }

        tv_goumaijiage.text=tv_jiage.text
        tv_goumaijiage.visibility=View.GONE

        val layoutManager = LinearLayoutManager(context)

        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rv_mulv.layoutManager = layoutManager

        rv_mulv.isNestedScrollingEnabled = false

        val adapter = context?.let { VipMuLvAdapter(it, detailIfo.afnNewsDirectoryList) }

        rv_mulv.adapter=adapter

        adapter?.setOnCliakListener(object :VipMuLvAdapter.OnCliskListener{
            override fun onClisk(view: View?, po: Int, id: String) {

                InfoId=id

                if(isLoginToActivity){
                    if(C.IntentKey.VIP_TYPE_VIDEO.equals(type)){
                        VideoActivity.start(this@VipDetailsActivity,InfoId)

                    }else if (C.IntentKey.VIP_TYPE_PDF.equals(type)){
                        PDFActivity.start(this@VipDetailsActivity,InfoId)

                    }else if (C.IntentKey.VIP_TYPE_MP3.equals(type)){
                        FrequencyPlayActivity.start(this@VipDetailsActivity,InfoId)
                    }
                }
            }
        })

        setIsBuy(isBuy)

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
   fun updateBuy( buyinfo: BuyInfo){
        setIsBuy(buyinfo.isBuy)
    }

    fun setIsBuy(type : Int){
        isBuy=type
        updateIsBuy()
    }

    fun updateIsBuy(){
        if(isBuy==1){
            rl_goumai.visibility=View.VISIBLE
            rv_dibu.visibility=View.GONE
        }else{
            rl_goumai.visibility=View.GONE
            rv_dibu.visibility=View.VISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

}