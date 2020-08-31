package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.base.ResultBase
import com.ruanyun.australianews.data.ApiFailAction
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.data.ApiSuccessAction
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.VipDetailIfo
import com.ruanyun.australianews.ui.adapter.VipMuLvAdapter
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.RxUtil
import com.ruanyun.australianews.widget.SharePopWindow
import jiguang.chat.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_vip_details.*


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
    var isZhanKai=true

    var type=""

    var id=""

    var InfoId=""

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


//        zhiqianjiege.paint.isAntiAlias=true
//        zhiqianjiege.paint.flags= Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG


        ll_gaodu.setLayoutParams(LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 207))

        rv_neirongmulv.setLayoutParams(LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 207))

        bt_add_vip.clickWithTrigger{
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
                rv_neirongmulv.setLayoutParams(LinearLayout.
                LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                isZhanKai=false
            }else{
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
            xiahua_neirong.visibility=View.INVISIBLE
            xiahua_mulv.visibility=View.VISIBLE

            tv_neirongianjie.visibility=View.GONE
            rv_mulv.visibility=View.VISIBLE

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

        fenxiang.clickWithTrigger {
            sharePopWindow.show(fenxiang)
        }

    }

    fun initData(){

        ApiManger.getApiService().getVipNewInfo(id, App.getInstance().userOid).compose(RxUtil.normalSchedulers())
            .subscribe(object : ApiSuccessAction<ResultBase<VipDetailIfo>>() {
                override fun onSuccess(result: ResultBase<VipDetailIfo>) {
//                   val  hotinfo=GsonUtil.parseJson(result.data.toString(),HotInfo::class.java)
                    val detailIfo=result.data

                    InfoId=detailIfo.afnNewsDirectoryList[0].oid

                    setViewData(detailIfo)

                }
                override fun onError(erroCode: Int, erroMsg: String) {
//                disMissLoading()
                    showToast(erroMsg)
                }
            }, object : ApiFailAction() {
                override fun onFail(msg: String) {
//                disMissLoading()
                    showToast(msg)
                }
            })

    }

    fun setViewData(detailIfo:VipDetailIfo){

        val iso=App.app.iso

        iv_pic.loadImage(ApiManger.IMG_URL+detailIfo.mainPhoto)

        tv_title.text=detailIfo.title

        mingrentuijian.text=detailIfo.recommendation

        tv_neirongianjie.text=detailIfo.content

        sharePopWindow = SharePopWindow(mContext)
        sharePopWindow.share_title = detailIfo.title
        sharePopWindow.share_text = detailIfo.recommendation
        sharePopWindow.share_image = ApiManger.IMG_URL+detailIfo.mainPhoto
        sharePopWindow.share_url = "https://www.baidu.com"


        //价格正常
        if (detailIfo.priceType==1){
            zhiqianjiege.paint.isAntiAlias=false
            zhiqianjiege.visibility= View.GONE

            //国内
            if(iso=="cn"||iso=="CN"){

                tv_jiage.text = "¥"+detailIfo.normalPricecny.toString()
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                tv_jiage.text = "A$"+detailIfo.normalPriceaud.toString()
            }
            //其他地区
            else{
                tv_jiage.text  = "$"+detailIfo.normalPriceusd.toString()
            }

        }
        //特价
        else if (detailIfo.priceType==2){

            zhiqianjiege.visibility= View.VISIBLE

            zhiqianjiege.paint.isAntiAlias=true
            zhiqianjiege.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

            //国内
            if(iso=="cn"||iso=="CN"){
                tv_jiage.text= "¥"+detailIfo.specialOffercny.toString()
                zhiqianjiege.text = "¥"+detailIfo.normalPricecny.toString()
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                tv_jiage.text= "A$"+detailIfo.specialOfferaud.toString()
                zhiqianjiege.text = "A$"+detailIfo.normalPriceaud.toString()
            }
            //其他地区
            else{
                tv_jiage.text= "$"+detailIfo.specialOfferusd.toString()
                zhiqianjiege.text = "$"+detailIfo.normalPriceusd.toString()
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
                zhiqianjiege.text = "¥"+detailIfo.normalPricecny.toString()
            }
            //澳洲
            else if(iso=="au"|| iso=="AU") {
                tv_jiage.text= "限时免费"
                zhiqianjiege.text = "A$"+detailIfo.normalPriceaud.toString()
            }
            //其他地区
            else{
                tv_jiage.text= "限时免费"
                zhiqianjiege.text = "$"+detailIfo.normalPriceusd.toString()
            }

        }


        val layoutManager = LinearLayoutManager(context)

        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rv_mulv.layoutManager = layoutManager

        rv_mulv.isNestedScrollingEnabled = false

        val adapter = context?.let { VipMuLvAdapter(it, detailIfo.afnNewsDirectoryList) }

        rv_mulv.adapter=adapter

        adapter?.setOnCliakListener(object :VipMuLvAdapter.OnCliskListener{
            override fun onClisk(view: View?, po: Int, id: String) {

                InfoId=id

                if(C.IntentKey.VIP_TYPE_VIDEO.equals(type)){
                    VideoActivity.start(this@VipDetailsActivity,InfoId)

                }else if (C.IntentKey.VIP_TYPE_PDF.equals(type)){
                    PDFActivity.start(this@VipDetailsActivity,InfoId)

                }else if (C.IntentKey.VIP_TYPE_MP3.equals(type)){
                    FrequencyPlayActivity.start(this@VipDetailsActivity,InfoId)
                }
            }
        })



    }

}