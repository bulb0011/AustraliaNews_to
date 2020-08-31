package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import android.content.res.Configuration;
import android.widget.ImageView
import com.ruanyun.australianews.App
import com.ruanyun.australianews.base.ResultBase
import com.ruanyun.australianews.data.ApiFailAction
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.data.ApiSuccessAction
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.NewsDirectoryDetails
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.RxUtil
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity :BaseActivity() {

    companion object{
        fun start(context: Context,infoId:String) {
            val starter = Intent(context, VideoActivity::class.java)
            starter.putExtra("infoId",infoId)
            context.startActivity(starter)
        }
    }

    private var isPlay = false
    private var isPause = false

    //增加封面
    lateinit var  imageView : ImageView

    private var orientationUtils: OrientationUtils? = null
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_video)

        initDta(infoId = intent.getStringExtra("infoId"), context = this@VideoActivity.context)

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

    }

    fun initEvent(){

        fins_iamge.clickWithTrigger { finish() }

        bu_lijigoumai.clickWithTrigger{

            SelectPayActivity.start(this, C.IntentKey.VIP_TYPE_VIDEO)
        }
        rb_jiaruhiyuan.clickWithTrigger{

            SelectPayActivity.start(this,C.IntentKey.VIP_TYPE_ADD_VIP)
        }
    }

    fun initDta(infoId:String,context: Context){
        ApiManger.getApiService().getVipNewInfoDirectoryDetails(infoId, App.getInstance().userOid).compose(RxUtil.normalSchedulers())
            .subscribe(object : ApiSuccessAction<ResultBase<NewsDirectoryDetails>>() {
                override fun onSuccess(result: ResultBase<NewsDirectoryDetails>) {
//                   val  hotinfo=GsonUtil.parseJson(result.data.toString(),HotInfo::class.java)

                    val detailIfo=result.data

                    val url=ApiManger.IMG_URL+detailIfo.fileUrl

                    val gsyVideoOption = GSYVideoOptionBuilder()

                    tttt.text=detailIfo.content

//            .setThumbImageView(imageView)

                    imageView= ImageView(context)
                    imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                    imageView.loadImage(ApiManger.IMG_URL+detailIfo.afnNewsInfo.mainPhoto)

                    tttt.setText(detailIfo.content)

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