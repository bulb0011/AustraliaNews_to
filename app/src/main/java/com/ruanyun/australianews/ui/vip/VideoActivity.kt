package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import android.content.res.Configuration;
import android.text.Html
import android.widget.ImageView
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.ruanyun.australianews.App
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.NewsDirectoryDetails
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.DateUtil
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import kotlinx.android.synthetic.main.activity_video.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideoActivity :BaseActivity() {

    companion object{
        fun start(context: Context,infoId:String, productType:Int, productOid:String,
                  inamge_url:String,price_Type:Int, jige:String,zhiqianjiage:String, tv_label:String, tv_title:String) {
            val starter = Intent(context, VideoActivity::class.java)
            starter.putExtra("infoId",infoId)
            starter.putExtra("productType",productType)
            starter.putExtra("productOid",productOid)
            starter.putExtra("inamge_url",inamge_url)
            starter.putExtra("price_Type",price_Type)
            starter.putExtra("jige",jige)
            starter.putExtra("zhiqianjiage",zhiqianjiage)
            starter.putExtra("tv_label",tv_label)
            starter.putExtra("tv_title",tv_title)
            context.startActivity(starter)
        }
    }

    private var isPlay = false
    private var isPause = false

    //增加封面
    lateinit var  imageView : ImageView

    var inamge_url=""
    var tv_titl=""
    var price_Type=1
    var jige=""
    var zhiqianjiage=""
    var tvlabel=""
    var productOid=""

    var infoId=""
    var upDate=""

    private var orientationUtils: OrientationUtils? = null
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_video)

        infoId = intent.getStringExtra("infoId")

        upDate=DateUtil.getCurrentTime()

        initDta(infoId, context = this@VideoActivity.context)

//        val url = "http://7xjmzj.com1.z0.glb.clouddn.com/20171026175005_JObCxCE2.mp4"
//        val url = "https://vdept.bdstatic.com/554c793745487948326e3267757a3831/437a323269356635/0c933d6c77d6077f58164519e2534425b27b9b5466d089ba9c47031d45c021ac67c00bd0b0190f2847ddead05300f6631946de32267c770e2155d6d7c358c47f.mp4?auth_key=1596188012-0-0-8383ba4fbc371a21e70bc4d288baa957"

        detail_player.enlargeImageRes = R.drawable.video_btn_fullscreen
        detail_player.shrinkImageRes = R.drawable.video_btn_narrow
        detail_player.backButton.clickWithTrigger {
            finish() }

        rv_jiashu.visibility=View.GONE

        detail_player!!.titleTextView.visibility = View.GONE
        detail_player!!.backButton.visibility = View.GONE

        //外部辅助的旋转，帮助全屏
        orientationUtils = OrientationUtils(this, detail_player)
        //初始化不打开外部的旋转
        orientationUtils!!.isEnable = false

        initEvent()

        inamge_url= intent.getStringExtra("inamge_url")
        tv_titl= intent.getStringExtra("tv_title")
        price_Type=intent.getIntExtra("price_Type",1)
        jige= intent.getStringExtra("jige")
        zhiqianjiage =intent.getStringExtra("zhiqianjiage")
        tvlabel= intent.getStringExtra("tv_label")
        productOid=intent.getStringExtra("productOid")

    }

    fun initEvent(){

        fins_iamge.clickWithTrigger { finish() }

        bu_lijigoumai.clickWithTrigger{

            SelectPayActivity.start(this,1,productOid,
                inamge_url,price_Type,jige,zhiqianjiage,tvlabel,tv_titl)
        }
        rb_jiaruhiyuan.clickWithTrigger{

            AddVipActivity.start(this)
        }
    }

    fun initDta(infoId:String,context: Context){
        ApiManger.getApiService().getVipNewInfoDirectoryDetails(infoId, App.getInstance().userOid)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

//                   val  hotinfo=GsonUtil.parseJson(result.data.toString(),HotInfo::class.java)
                    val json = response.body()!!.string()

                    val je = JsonParser().parse(json)

                    val data = je.asJsonObject["data"].toString()

                    val gson = Gson()

                    val detailIfo= gson.fromJson<NewsDirectoryDetails>(data,NewsDirectoryDetails::class.java)

//                    val detailIfo=response!!.body()!!.data

                    val url=ApiManger.IMG_URL+detailIfo.fileUrl

                    val gsyVideoOption = GSYVideoOptionBuilder()

                    tttt.loadDataWithBaseURL(null,C.varjs+detailIfo.content,"text/html","UTF-8",null);


//            .setThumbImageView(imageView)

                    imageView= ImageView(context)
                    imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                    imageView.loadImage(ApiManger.IMG_URL+detailIfo.afnNewsInfo.mainPhoto)

                    vido_title.text=detailIfo.title

                    gsyVideoOption
                        .setThumbImageView(imageView)
                        .setIsTouchWiget(true)
                        .setRotateViewAuto(false)
                        .setLockLand(false)
                        .setAutoFullWithSize(false)
                        .setShowFullAnimation(false)
                        .setNeedLockFull(true)
                        .setUrl(url)
                        .setCacheWithPlay(false)
//                        .setVideoTitle("测试视频")//全屏给的标题
                        .setVideoAllCallBack(object : GSYSampleCallBack() {
                            override fun onPrepared(url: String, vararg objects: Any) {
                                super.onPrepared(url, *objects)
                                //开始播放了才能旋转和全屏
                                orientationUtils!!.isEnable = true
                                isPlay = true
                            }

                            override fun onQuitFullscreen(
                                url: String,
                                vararg objects: Any
                            ) {
                                super.onQuitFullscreen(url, *objects)

//                    detail_player.startButton.visibility=View.GONE


                                if (orientationUtils != null) {
                                    orientationUtils!!.backToProtVideo()
                                }
                            }

                            override fun onAutoComplete(url: String?, vararg objects: Any?) {
                                super.onAutoComplete(url, *objects)

                                rv_jiashu.visibility=View.VISIBLE
                                rv_jiashu.setAlpha(0.5f);

                                detail_player.hideAllWidget()

                                detail_player.startButton.visibility=View.GONE
//                    detail_player.onSurfaceUpdated();

//                    gsyVideoOption.setThumbImageView(imageView)
                            }


                        }).setLockClickListener { view, lock ->
                            if (orientationUtils != null) {
                                //配合下方的onConfigurationChanged
                                orientationUtils!!.isEnable = !lock
                            }
                        }.build(detail_player)
                    detail_player!!.fullscreenButton
                        .setOnClickListener { //直接横屏
                            orientationUtils!!.resolveByClick()
                            //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                            detail_player!!.startWindowFullscreen(context, true, true)
                        }



//                    setViewData(detailIfo)

                }
            })
    }



    override fun onBackPressed() {
        if (orientationUtils != null) {
            orientationUtils!!.backToProtVideo()
        }
        if (GSYVideoManager.backFromWindowFull(this)) {
            return
        }
        super.onBackPressed()
    }


    override fun onPause() {
        detail_player!!.currentPlayer.onVideoPause()
        super.onPause()
        isPause = true
    }

    override fun onResume() {
        detail_player!!.currentPlayer.onVideoResume(false)
        super.onResume()
        isPause = false

//        gsyVideoOption.setThumbImageView(imageView)
//        imageView.setImageResource(R.mipmap.timga)
    }

    override fun onDestroy() {
        super.onDestroy()
       val endTime=DateUtil.getCurrentTime()
        ApiManger.getApiService().saveAfnNewsDirectoryRecord(infoId,App.app.userOid,upDate,
            endTime)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ){
                    val json: String = response.body()!!.string()

                    val je =JsonParser().parse(json)

                    val data = je.asJsonObject["data"].toString()
                }

            })

        if (isPlay) {
            detail_player!!.currentPlayer.release()
        }
        if (orientationUtils != null) orientationUtils!!.releaseListener()
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            detail_player!!.onConfigurationChanged(this, newConfig, orientationUtils, true, true)
        }
    }


}