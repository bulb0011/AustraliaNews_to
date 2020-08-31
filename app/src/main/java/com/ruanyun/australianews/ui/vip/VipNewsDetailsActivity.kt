package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.SeekBar
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.ResultBase
import com.ruanyun.australianews.data.ApiFailAction
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.data.ApiSuccessAction
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.model.CollectionBrowseNewsInfo
import com.ruanyun.australianews.model.Event
import com.ruanyun.australianews.model.NewsCommentCountInfo
import com.ruanyun.australianews.model.ShareJsonInfo
import com.ruanyun.australianews.model.params.DeleteCollectionParams
import com.ruanyun.australianews.model.params.NewsCommentParams
import com.ruanyun.australianews.model.uimodel.LifeReleaseCommonUiModel
import com.ruanyun.australianews.ui.TtsHolder
import com.ruanyun.australianews.ui.WebViewActivity
import com.ruanyun.australianews.ui.news.NewsCommentActivity
import com.ruanyun.australianews.util.*
import com.ruanyun.australianews.widget.LeaveMessageDialogFragment
import com.ruanyun.australianews.widget.LoadingDialog
import com.ruanyun.australianews.widget.SharePopWindow
import com.ruanyun.australianews.widget.SlideDialog
import kotlinx.android.synthetic.main.activity_news_web_view.*
import kotlinx.android.synthetic.main.layout_news_bottom.*

/**
 * @description 新闻详情
 * @author hdl
 * @date 2019/12/23
 */
open class VipNewsDetailsActivity : WebViewActivity() {

    companion object {

        fun startNewsDetails(
            context: Context,
            url: String?,
            newsInfoOid: String?,
            type: Int,
            json: String,
            commonTime: String?
        ) {
            val starter = Intent(context, VipNewsDetailsActivity::class.java)
            starter.putExtra(C.IntentKey.WEB_VIEW_URL, url)
            starter.putExtra(C.IntentKey.NEWS_INFO_OID, newsInfoOid)
            starter.putExtra(C.IntentKey.SHARE_INFO_JSON, json)
            starter.putExtra(C.IntentKey.TYPE, type)
            starter.putExtra(C.IntentKey.SHARE_INFO_COMMONTIME, commonTime)
            context.startActivity(starter)
        }


    }

    var newsCommentCountInfo: NewsCommentCountInfo? = null

    lateinit var leaveMessageDialogFragment: LeaveMessageDialogFragment
    lateinit var sharePopWindow: SharePopWindow

    var isChina = true

    var title = ""

    lateinit var ttsholder: TtsHolder

    var text = ""


    override fun initView() {
        super.initView()

            ll_en_zhong.visibility = View.INVISIBLE

        val commonTime = intent.getStringExtra(C.IntentKey.SHARE_INFO_COMMONTIME)

        tv_shijian.text = StringUtil.getLifeTime(commonTime)



        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(webview: WebView?, url: String?): Boolean {

                if (url!!.startsWith("http:") || url.startsWith("https:")) {
                    webview!!.loadUrl(url)
                } else {
                    try {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(intent)
                    } catch (e: Exception) {
                        return false
                    }
                }
                return true
            }

            override fun onPageFinished(p0: WebView?, url: String?) {
                super.onPageFinished(p0, url)
                rl_bottom.visibility = View.VISIBLE
                if (url!!.contains("app/tipInfo/getTipInfo")) {
                    rl_bottom.visibility = View.GONE
                    rl_bofang.visibility = View.GONE
                    rl_xuanfu.visibility = View.GONE
                }
                if (isLoadError) {
                    emptyview.showLoadFail()
                }
//                textile()


//                webView.evaluateJavascript("getffont(2)",object : ValueCallback<String>{
//                    override fun onReceiveValue(p0: String?) {
//
//                    }
//
//                })
            }

            override fun onReceivedError(p0: WebView?, p1: Int, p2: String?, p3: String?) {
                super.onReceivedError(p0, p1, p2, p3)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    return
                }
                isLoadError = true
                // 在这里显示自定义错误页
                LogX.e(
                    "retrofit",
                    "onReceivedError() : p0 = [$p0], p1 = [$p1], p2 = [$p2], p3 = [$p3]"
                )
            }

            override fun onReceivedError(
                p0: WebView?,
                request: WebResourceRequest?,
                p2: WebResourceError?
            ) {
                super.onReceivedError(p0, request, p2)
                LogX.e(
                    "retrofit",
                    "onReceivedError2() : p0 = [$p0], request = [$request], p2 = [$p2]"
                )
                isLoadError = request?.isForMainFrame ?: false
            }
        }

        leaveMessageDialogFragment = LeaveMessageDialogFragment.newInstance()
        leaveMessageDialogFragment.block = {
            if (presenter.newsInfoType ?: 1 > 0 && presenter.newsInfoType != LifeReleaseCommonUiModel.LIFE_BUSINESS_TRANSFER_INFO) {
                addComment(it)
            } else {
                addWealthComment(it)
            }
        }
        sharePopWindow = SharePopWindow(mContext)

        val shareJson = intent.getStringExtra(C.IntentKey.SHARE_INFO_JSON)
        if (shareJson.isNullOrEmpty()) {

        } else {
            val newsInfo = GsonUtil.parseJson(shareJson, ShareJsonInfo::class.java)
            sharePopWindow.share_title = newsInfo.share_title
            title = newsInfo.share_title

            if (title_txt != null) {
                title_txt.text = title
            }

            val shareText = newsInfo.share_text
            if (!shareText.isNullOrEmpty()) {
                sharePopWindow.share_text = shareText
            }
            sharePopWindow.share_image = newsInfo.share_image
            sharePopWindow.share_url = newsInfo.share_url
        }

        iv_back.clickWithTrigger {
            goBack()
        }
        tv_comment.clickWithTrigger {
            if (isLoginToActivity) {
                leaveMessageDialogFragment.show(supportFragmentManager, mContext)
            }
        }
        iv_comment.clickWithTrigger {
            NewsCommentActivity.start(mContext, presenter.newsInfoOid, presenter.newsInfoType)
        }
        iv_collect.clickWithTrigger {
            if (isLoginToActivity) {
                if (newsCommentCountInfo?.mark == true) {
                    if (presenter.newsInfoType ?: 1 > 0 && presenter.newsInfoType != LifeReleaseCommonUiModel.LIFE_BUSINESS_TRANSFER_INFO) {
                        deleteFavorites()
                    } else {
                        deleteWealthFavorites()
                    }
                } else {
                    if (presenter.newsInfoType ?: 1 > 0 && presenter.newsInfoType != LifeReleaseCommonUiModel.LIFE_BUSINESS_TRANSFER_INFO) {
                        addFavorites()
                    } else {
                        addWealthFavorites()
                    }
                }
            }
        }
        iv_share.clickWithTrigger {
//            if(isLoginToActivity) {
            sharePopWindow.show(iv_share)
//            }
        }
        if (presenter.newsInfoType == LifeReleaseCommonUiModel.LIFE_REPAST_INFO) {
            iv_back.visibility = View.GONE
            tv_comment.visibility = View.GONE
            iv_comment.visibility = View.GONE
            tv_comment_count.visibility = View.GONE
        }
        presenter.getNewsCommentCount()

        if (image_return != null) {
            image_return.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    finish()
                }
            })
        }

        /**
         *改变文字
         */
        wenz_size.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var shuzhi=0

                var slidedailog = SlideDialog(this@VipNewsDetailsActivity)

                slidedailog.setOnSeekBarChangeListener(object : SlideDialog.OnSlideSeekBarChangeListener{
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {

                        shuzhi=progress

                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        var s= 0
                        if (shuzhi<45){
                            seekBar?.progress=0
                            s=0
                        }else if(shuzhi<55)  {
                            seekBar?.progress=50
                            s=1
                        }else{
                            seekBar?.progress=100
                            s=2
                        }

                        javascript("getffont("+s+")")

                    }

                })

            }

        })

    }

    private fun isXinWen() {
        if (isChina) {
            zhong.setTextColor(resources.getColor(R.color.theme_color))
            en.setTextColor(resources.getColor(R.color.text_black))

        } else {
            zhong.setTextColor(resources.getColor(R.color.text_black))
            en.setTextColor(resources.getColor(R.color.theme_color))
        }

        tv_title.setText(title)

        rl_xuanfu.visibility = View.GONE
        iv_kaishi.visibility = View.GONE
        head_zanting.visibility = View.GONE
    }




    override fun getContentViewId(): Int {
        return com.ruanyun.australianews.R.layout.activity_vip_news_web_view
    }

    override fun updateNewsInfo(info: NewsCommentCountInfo) {
        super.updateNewsInfo(info)
        newsCommentCountInfo = info
        if (info.commentQuantity > 0) {
            tv_comment_count.visibility = View.VISIBLE
            if (info.commentQuantity > 999) {
                tv_comment_count.text = "999+"
            } else {
                tv_comment_count.text = "${info.commentQuantity}"
            }
        } else {
            tv_comment_count.visibility = View.GONE
        }
        iv_collect.isSelected = info.mark
    }

    /**
     * 添加收藏
     */
    private fun addFavorites() {
        showLoadingView(com.ruanyun.australianews.R.string.in_load)
        val disposable = ApiManger.getApiService()
            .addFavorites(app.userOid, presenter.newsInfoOid, "${presenter.newsInfoType}")
            .compose(RxUtil.normalSchedulers<ResultBase<CollectionBrowseNewsInfo>>())
            .subscribe(object : ApiSuccessAction<ResultBase<CollectionBrowseNewsInfo>>() {
                override fun onSuccess(result: ResultBase<CollectionBrowseNewsInfo>) {
                    disMissLoading()
                    showToast("收藏成功")
                    iv_collect.isSelected = true
                    newsCommentCountInfo?.collectionInfo = result.data.oid
                }

                override fun onError(errorCode: Int, errorMsg: String) {
                    super.onError(errorCode, errorMsg)
                    disMissLoading()
                    showToast(errorMsg)
                }
            }, object : ApiFailAction() {
                override fun onFail(msg: String) {
                    super.onFail(msg)
                    disMissLoading()
                    showToast(msg)
                }
            })
        addSubscrebe(disposable)
    }

    /**
     * 删除收藏
     */
    private fun deleteFavorites() {
        val params = DeleteCollectionParams()
        params.type = 2
        params.userOid = app.userOid
        params.collectionInfoOids = newsCommentCountInfo?.collectionInfo
        showLoadingView(com.ruanyun.australianews.R.string.in_load)
        val subscription = ApiManger.getApiService().deleteCollectionInfo(params)
            .compose(RxUtil.normalSchedulers<ResultBase<*>>())
            .subscribe(object : ApiSuccessAction<ResultBase<*>>() {
                override fun onSuccess(result: ResultBase<*>) {
                    disMissLoadingView()
                    showToast("取消收藏成功")
                    iv_collect.isSelected = false
                    newsCommentCountInfo?.collectionInfo = null
                }

                override fun onError(erroCode: Int, erroMsg: String) {
                    super.onError(erroCode, erroMsg)
                    disMissLoadingView()
                    showToast(erroMsg)
                }
            }, object : ApiFailAction() {
                override fun onFail(msg: String) {
                    super.onFail(msg)
                    disMissLoadingView()
                    showToast(msg)
                }
            })
        addSubscrebe(subscription)
    }

    /**
     * 添加财富收藏
     */
    private fun addWealthFavorites() {
        val type = when (presenter.newsInfoType) {
            LifeReleaseCommonUiModel.WEALTH_ACTIVITYS -> 1
            LifeReleaseCommonUiModel.WEALTH_FUND -> 2
            LifeReleaseCommonUiModel.WEALTH_CIVIL_ESTATE -> 3
            LifeReleaseCommonUiModel.WEALTH_COMMERCE_ESTATE -> 4
            LifeReleaseCommonUiModel.WEALTH_FARM_ESTATE -> 5
            LifeReleaseCommonUiModel.WEALTH_HOUSING_MARKET -> 6
            LifeReleaseCommonUiModel.LIFE_BUSINESS_TRANSFER_INFO -> 7
            else -> 0
        }
        showLoadingView(com.ruanyun.australianews.R.string.in_load)
        val disposable =
            ApiManger.getApiService().addWealthFavorites(app.userOid, presenter.newsInfoOid, type)
                .compose(RxUtil.normalSchedulers<ResultBase<*>>())
                .subscribe(object : ApiSuccessAction<ResultBase<*>>() {
                    override fun onSuccess(result: ResultBase<*>) {
                        disMissLoading()
                        showToast("收藏成功")
                        iv_collect.isSelected = true
                        newsCommentCountInfo?.mark = true
                    }

                    override fun onError(errorCode: Int, errorMsg: String) {
                        super.onError(errorCode, errorMsg)
                        disMissLoading()
                        showToast(errorMsg)
                    }
                }, object : ApiFailAction() {
                    override fun onFail(msg: String) {
                        super.onFail(msg)
                        disMissLoading()
                        showToast(msg)
                    }
                })
        addSubscrebe(disposable)
    }

    /**
     * 删除财富收藏
     */
    private fun deleteWealthFavorites() {
        val type = when (presenter.newsInfoType) {
            LifeReleaseCommonUiModel.WEALTH_ACTIVITYS -> 1
            LifeReleaseCommonUiModel.WEALTH_FUND -> 2
            LifeReleaseCommonUiModel.WEALTH_CIVIL_ESTATE -> 3
            LifeReleaseCommonUiModel.WEALTH_COMMERCE_ESTATE -> 4
            LifeReleaseCommonUiModel.WEALTH_FARM_ESTATE -> 5
            LifeReleaseCommonUiModel.WEALTH_HOUSING_MARKET -> 6
            LifeReleaseCommonUiModel.LIFE_BUSINESS_TRANSFER_INFO -> 7
            else -> 0
        }
        showLoadingView(com.ruanyun.australianews.R.string.in_load)
        val subscription = ApiManger.getApiService()
            .deleteWealthFavorites(app.userOid, presenter.newsInfoOid, type)
            .compose(RxUtil.normalSchedulers<ResultBase<*>>())
            .subscribe(object : ApiSuccessAction<ResultBase<*>>() {
                override fun onSuccess(result: ResultBase<*>) {
                    disMissLoadingView()
                    showToast("取消收藏成功")
                    iv_collect.isSelected = false
                    newsCommentCountInfo?.mark = false
                }

                override fun onError(erroCode: Int, erroMsg: String) {
                    super.onError(erroCode, erroMsg)
                    disMissLoadingView()
                    showToast(erroMsg)
                }
            }, object : ApiFailAction() {
                override fun onFail(msg: String) {
                    super.onFail(msg)
                    disMissLoadingView()
                    showToast(msg)
                }
            })
        addSubscrebe(subscription)
    }

    /**
     * 添加新闻、生活评论
     */
    private fun addComment(s: String) {
        showLoadingView(com.ruanyun.australianews.R.string.in_load)
        val subscription = ApiManger.getApiService()
            .addComment(presenter.newsInfoOid, app.userOid, s, "${presenter.newsInfoType}")
            .compose(RxUtil.normalSchedulers<ResultBase<*>>())
            .subscribe(object : ApiSuccessAction<ResultBase<*>>() {
                override fun onSuccess(result: ResultBase<*>) {
                    disMissLoadingView()
                    showToast("评论成功")
                    newsCommentCountInfo?.let {
                        it.commentQuantity++
                        updateNewsInfo(it)
                    }
                    leaveMessageDialogFragment.addSuccess()
                    EventNotifier.getInstance().addSuccessSuccess()
                }

                override fun onError(erroCode: Int, erroMsg: String) {
                    super.onError(erroCode, erroMsg)
                    disMissLoadingView()
                    showToast(erroMsg)
                }
            }, object : ApiFailAction() {
                override fun onFail(msg: String) {
                    super.onFail(msg)
                    disMissLoadingView()
                    showToast(msg)
                }
            })
        addSubscrebe(subscription)
    }

    /**
     * 添加财富评论
     */
    private fun addWealthComment(s: String) {
        val type = when (presenter.newsInfoType) {
            LifeReleaseCommonUiModel.WEALTH_ACTIVITYS -> 1
            LifeReleaseCommonUiModel.WEALTH_FUND -> 2
            LifeReleaseCommonUiModel.WEALTH_CIVIL_ESTATE -> 3
            LifeReleaseCommonUiModel.WEALTH_COMMERCE_ESTATE -> 4
            LifeReleaseCommonUiModel.WEALTH_FARM_ESTATE -> 5
            LifeReleaseCommonUiModel.WEALTH_HOUSING_MARKET -> 6
            LifeReleaseCommonUiModel.LIFE_BUSINESS_TRANSFER_INFO -> 7
            else -> 0
        }
        showLoadingView(com.ruanyun.australianews.R.string.in_load)
        val subscription =
            ApiManger.getApiService().addWealthComment(presenter.newsInfoOid, app.userOid, s, type)
                .compose(RxUtil.normalSchedulers<ResultBase<*>>())
                .subscribe(object : ApiSuccessAction<ResultBase<*>>() {
                    override fun onSuccess(result: ResultBase<*>) {
                        disMissLoadingView()
                        showToast("评论成功")
                        newsCommentCountInfo?.let {
                            it.commentQuantity++
                            updateNewsInfo(it)
                        }
                        leaveMessageDialogFragment.addSuccess()
                        EventNotifier.getInstance().addSuccessSuccess()
                    }

                    override fun onError(erroCode: Int, erroMsg: String) {
                        super.onError(erroCode, erroMsg)
                        disMissLoadingView()
                        showToast(erroMsg)
                    }
                }, object : ApiFailAction() {
                    override fun onFail(msg: String) {
                        super.onFail(msg)
                        disMissLoadingView()
                        showToast(msg)
                    }
                })
        addSubscrebe(subscription)
    }

//    override fun updateUserInfo(event: Event<String>) {
//        super.updateUserInfo(event)
//        if (C.EventKey.UPDATE_USER_INFO == event.key) {
//            presenter.getNewsCommentCount()
//        }
//    }


    /**
     * 刷新页面
     * @param event
     */
    override fun addCommentSuccess(event: Event<String>) {
        if (C.EventKey.ADD_COMMENT_SUCCESS == event.key) {
            presenter.getNewsCommentCount()
            if (presenter.newsInfoType == NewsCommentParams.NEWS) {
                javascript("newsCommentLoadMore('${presenter.newsInfoOid}')")
            } else {
                val type = if (presenter.newsInfoType ?: 0 > 0) {
                    presenter.newsInfoType
                } else {
                    when (presenter.newsInfoType) {
                        LifeReleaseCommonUiModel.WEALTH_ACTIVITYS -> 1
                        LifeReleaseCommonUiModel.WEALTH_FUND -> 2
                        LifeReleaseCommonUiModel.WEALTH_CIVIL_ESTATE -> 3
                        LifeReleaseCommonUiModel.WEALTH_COMMERCE_ESTATE -> 4
                        LifeReleaseCommonUiModel.WEALTH_FARM_ESTATE -> 5
                        LifeReleaseCommonUiModel.WEALTH_HOUSING_MARKET -> 6
                        else -> 0
                    }
                }
                javascript("detailsCommentSubmit('${presenter.newsInfoOid}',${type})")
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (::ttsholder.isInitialized) {
            ttsholder.stopSpeaking()
        }

    }

}