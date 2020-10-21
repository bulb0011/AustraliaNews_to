package com.ruanyun.australianews.ui.main

import `in`.srain.cube.views.ptr.PtrFrameLayout
import `in`.srain.cube.views.ptr.PtrHandler
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.AppBarLayout
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.base.ResultBase
import com.ruanyun.australianews.data.ApiFailAction
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.data.ApiSuccessAction
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ext.getStr
import com.ruanyun.australianews.ext.setStatusBarHeightPaddingTop
import com.ruanyun.australianews.model.AdvertInfoBase
import com.ruanyun.australianews.model.ChannelInfo
import com.ruanyun.australianews.model.Event
import com.ruanyun.australianews.model.HomeResultBase
import com.ruanyun.australianews.ui.CityListActivity
import com.ruanyun.australianews.ui.WebViewActivity
import com.ruanyun.australianews.ui.adapter.AdverViewHolder
import com.ruanyun.australianews.ui.login.LoginActivity
import com.ruanyun.australianews.ui.news.ChannelManagerActivity
import com.ruanyun.australianews.util.*
import com.ruanyun.australianews.util.CommonUtil.dp2px
import com.ruanyun.australianews.widget.MyConvenientBanner
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.layout_news_header.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @author hdl
 * @description 新闻
 * @date 2019/5/5
 */
class NewsFragment : BaseFragment() {

    companion object {
        var itemHead=0
        const val REQUEST_CODE_CHANNEL = 1001
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContentView = inflater.inflate(R.layout.fragment_news, container, false)
        registerBus()
        return mContentView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unRegisterBus()
    }

    lateinit var adapter: TitleFragmentAdapter
    lateinit var convenientBanner: MyConvenientBanner<AdvertInfoBase>
    // 滚动偏移距离
    private var height: Int = 0
    private var minimumHeight: Int = 0

    var myCurrentTab =0

    var isdinaji=false


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        refresh_layout.autoRefresh()
    }

    override fun onResume() {
        super.onResume()
        convenientBanner.startTurning(4000)
        tab.setCurrentTab(myCurrentTab)
        tab_to.setCurrentTab(myCurrentTab)
        tab_new.setCurrentTab(myCurrentTab)
    }

    override fun onPause() {
        super.onPause()
        convenientBanner.stopTurning()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                REQUEST_CODE_CHANNEL -> {
                    val databaseSubscribedList = DbHelper.getInstance().getSubscribedList(app.isLogin)
                    updateChannelTab(databaseSubscribedList)
                    val position = data?.getIntExtra(C.IntentKey.CLICK_POSITION, -1)
                    if (position != null && position>=0) {
                        viewpager.currentItem = position
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initView() {
        if(Build.VERSION.SDK_INT >= 23){
            rl_topbar.setStatusBarHeightPaddingTop()
            PixelSizeUtil.setStatusBarHeightView(view_status_bar_height)
        }
        if(Build.VERSION.SDK_INT >= 21){
            viewpager.isNestedScrollingEnabled = true
        }

        rl_tip_login.visibility = if(app.user!=null) View.GONE else View.VISIBLE
        rl_tip_login_to.visibility = if(app.user!=null) View.GONE else View.VISIBLE
        updateMinimumHeight()
        convenientBanner = getView(R.id.banner)
        convenientBanner.setPageIndicator(MyConvenientBanner.indicators)
        convenientBanner.setPageIndicatorAlign(MyConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
        convenientBanner.setPageIndicatorMargins(0,0,dp2px(10f),dp2px(25f))

        adapter = TitleFragmentAdapter(childFragmentManager, DbHelper.getInstance().getSubscribedList(app.isLogin))
        adapter.notifyDataSetChanged()
        viewpager.adapter = adapter
        viewpager.offscreenPageLimit = 1
        tab.setViewPager(viewpager)

        tab_to.setViewPager(viewpager)//头部的表单
        tab_new.setViewPager(viewpager)

        tab_layout.visibility = View.GONE
        rl_tip_login_to.visibility = View.GONE

        tab_layout_new.visibility = View.GONE

//        view_is.visibility = View.GONE

//        tab_to.setOnClickListener {  }

        app_bar_layout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (height == Math.abs(verticalOffset)) {
                return@OnOffsetChangedListener
            }
            val appBarLayoutMaxSlidingDistance = appBarLayout.measuredHeight //减去1个偏移量

            height = Math.abs(verticalOffset)

            if (verticalOffset < -(appBarLayoutMaxSlidingDistance/2)) {
                if (rl_topbar.visibility != View.VISIBLE) {
                    rl_topbar.visibility = View.VISIBLE
                    tab_layout.visibility = View.VISIBLE
                    rl_tip_login_to.visibility=View.VISIBLE
//                    adapter.setRefreshViewEnable(false)
                }
            } else {
                if (rl_topbar.visibility != View.GONE) {
                    rl_topbar.visibility = View.GONE
                    tab_layout.visibility = View.GONE
                    rl_tip_login_to.visibility=View.GONE
//                    adapter.setRefreshViewEnable(false)
                }
            }
//            if (verticalOffset < -dp2px(150f)) {
//                if (view_status_bar_height.visibility != View.VISIBLE) {
//                    view_status_bar_height.visibility = View.VISIBLE
//                }
//            } else {
//                if (view_status_bar_height.visibility != View.GONE) {
//                    view_status_bar_height.visibility = View.GONE
//                }
//            }
        })

        refresh_layout.setPtrHandler(object : PtrHandler {
            override fun onRefreshBegin(frame: PtrFrameLayout?) {
                getHomeResultBase()
                if(tab.tabCount>0) {
                    EventNotifier.getInstance().updateNewsList(tab.getTitleView(tab.currentTab)?.getStr())
                    EventNotifier.getInstance().updateNewsList(tab.getTitleView(tab_to.currentTab)?.getStr())
                }
            }

            override fun checkCanDoRefresh(frame: PtrFrameLayout?, content: View?, header: View?): Boolean {
                return height <= 0
            }
        })
        refresh_layout.disableWhenHorizontalMove(true)


        huilv.clickWithTrigger{WebViewActivity.startHtml(mContext, "汇率", "http://afn.resolr.com/aozhoucaijing/huilv/huilv.html",true,1)}

        tv_search1.clickWithTrigger { SearchActivity.start(mContext, SearchActivity.HOME_SEARCH) }
        tv_search2.clickWithTrigger { SearchActivity.start(mContext, SearchActivity.HOME_SEARCH) }

        tv_login.clickWithTrigger {
            LoginActivity.start(mContext)
        }

        tv_login_to.clickWithTrigger {
            LoginActivity.start(mContext)
        }

        iv_tip_login_close.clickWithTrigger {
            rl_tip_login.visibility = View.GONE
            rl_tip_login_to.visibility = View.GONE

            isdinaji=true

            if (rl_topbar.visibility == View.VISIBLE) {
                app_bar_layout.setExpanded(false, false)
            }
            updateMinimumHeight()
        }

        iv_tip_login_close_to.clickWithTrigger {
            rl_tip_login.visibility = View.GONE
            rl_tip_login_to.visibility = View.GONE
            isdinaji=true
            if (rl_topbar.visibility == View.VISIBLE) {
                app_bar_layout.setExpanded(false, false)
            }
            updateMinimumHeight()
        }

        iv_subscribe.clickWithTrigger {
            if (isLoginToActivity) {
                ChannelManagerActivity.start(this, REQUEST_CODE_CHANNEL)
            }
        }

        iv_subscribe_to.clickWithTrigger {
            if (isLoginToActivity) {
                ChannelManagerActivity.start(this, REQUEST_CODE_CHANNEL)
            }
        }


        iv_expansion.clickWithTrigger {
            EventBus.getDefault().post(Event(C.EventKey.SCROLL_TO_TOP, ""))
            app_bar_layout.setExpanded(true, true)
        }


//        tv_push_record.clickWithTrigger { if(isLoginToActivity) MyPushRecordNewListActivity.start(mContext) }
//        tv_house_rent.clickWithTrigger { HouseRentListActivity.start(mContext) }
//        tv_recruitment_info.clickWithTrigger { RecruitmentListActivity.start(mContext) }
//        tv_more_services.clickWithTrigger {
//            showActivity(LifeMainActivity::class.java)
//        }
        tv_push_record.clickWithTrigger { WebViewActivity.startHtml(mContext, "行情", "file:///android_asset/quotes.html"); }
        tv_house_rent.clickWithTrigger { WebViewActivity.startHtml(mContext, "7x24", "file:///android_asset/7_24.html"); }
        tv_recruitment_info.clickWithTrigger { ActivitysListActivity.start(mContext) }
        tv_more_services.clickWithTrigger {
            if (isLoginToActivity) {
                ChannelManagerActivity.start(this, REQUEST_CODE_CHANNEL)
            }
        }

        tv_city.text = app.cityName
        tv_city.clickWithTrigger {
            CityListActivity.start(mContext)
        }

        /**
         * 滑动的监听
         */
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {

                itemHead=p0

                if(p0==1){
//                    viewpager.visibility=View.GONE
//                    webview.visibility=View.VISIBLE
////                    WebViewActivity.startHtml(mContext, "7x24", "https://www.jin10.com/example/jin10.com.html?fontSize=14px&theme=white",true);
//                    webview.loadUrl("https://www.jin10.com/example/jin10.com.html?fontSize=14px&theme=white")
                    banner.visibility=View.GONE
                    huilv.visibility=View.GONE
//                    view_is.visibility = View.VISIBLE
                    tab_layout_new.visibility = View.VISIBLE
                    rl_tip_login.visibility = View.GONE
                    rl_tip_login_to.visibility = View.GONE
                    app_bar_layout.setExpanded(false, false)
                    updateMinimumHeight()
                }else
                    if (p0==2){
//                    viewpager.visibility=View.GONE
//                    webview.visibility=View.VISIBLE
////                    WebViewActivity.startHtml(mContext, "行情", "http://afn.resolr.com/aozhoucaijing/hangqing/hangqing.html",true,1)
//                    webview.loadUrl("http://afn.resolr.com/aozhoucaijing/hangqing/hangqing.html")
                        banner.visibility=View.GONE
                        huilv.visibility=View.GONE
//                    view_is.visibility = View.VISIBLE
                        tab_layout_new.visibility = View.VISIBLE
                        rl_tip_login.visibility = View.GONE
                        rl_tip_login_to.visibility = View.GONE
                        app_bar_layout.setExpanded(false, false)
                        updateMinimumHeight()
                    }
                    else{
                        viewpager.visibility=View.VISIBLE
                        banner.visibility=View.VISIBLE
                        huilv.visibility=View.VISIBLE
                        tab_layout_new.visibility = View.GONE
//                    view_is.visibility = View.GONE
                        if (!isdinaji){
                            rl_tip_login.visibility = if(app.user!=null) View.GONE else View.VISIBLE
                            rl_tip_login_to.visibility = if(app.user!=null) View.GONE else View.VISIBLE
                        }

                        myCurrentTab=p0
                        updateMinimumHeight()
                    }
            }
        })



    }


    private fun updateMinimumHeight() {
        var tipLoginHeight = if (rl_tip_login.visibility == View.VISIBLE){
//            rl_tip_login.layoutParams.height + view_tab_top_line.layoutParams.height
            rl_tip_login.layoutParams.height
        } else 0

//        tipLoginHeight=tipLoginHeight

        if (rl_tip_login_to.visibility ==View.VISIBLE ){
            tipLoginHeight = tipLoginHeight+rl_tip_login_to.layoutParams.height
        }

        if (rl_tip_login.visibility == View.VISIBLE){
//            minimumHeight = PixelSizeUtil.unDisplayViewSize(rl_topbar)[1] + tab_layout.layoutParams.height + tipLoginHeight - rl_tip_login.layoutParams.height - view_tab_top_line.layoutParams.height
            minimumHeight = PixelSizeUtil.unDisplayViewSize(rl_topbar)[1] + tab_layout.layoutParams.height + tipLoginHeight - rl_tip_login.layoutParams.height
        }else{
            minimumHeight = PixelSizeUtil.unDisplayViewSize(rl_topbar)[1] + tab_layout.layoutParams.height
        }

        if(huilv.visibility == View.GONE){
            minimumHeight = minimumHeight-huilv.layoutParams.height-banner.layoutParams.height-view_xiahua.layoutParams.height-view_tab_top_line.layoutParams.height
        }

        collapsing_toolbar_layout.minimumHeight = minimumHeight
    }

    /**
     * 获取首页信息
     */
    private fun getHomeResultBase() {

        LogX.e("dengpao","app.userOid+"+app.userOid+"app.cityName+"+app.cityName)

        val subscription = ApiManger.getApiService().getHomeResultBase(app.userOid, app.cityName)
            .compose(RxUtil.normalSchedulers<ResultBase<HomeResultBase>>())
            .subscribe(object : ApiSuccessAction<ResultBase<HomeResultBase>>() {
                override fun onSuccess(result: ResultBase<HomeResultBase>) {
                    refresh_layout.refreshComplete()
                    val advertList = result.data.adverInfoList?: arrayListOf()

                    LogX.e("dengpao","首页联网"+GsonUtil.toJson(result))

                    convenientBanner.setPages({ AdverViewHolder() }, advertList).setOnItemClickListener{
                        if(advertList.isNotEmpty()) {
                            WebViewUrlUtil.showAdvertDetailsWeb(mContext, advertList[it])
                        }
                    }
                    if(advertList.isEmpty()){
                        convenientBanner.setBackgroundColor(ContextCompat.getColor(mContext, R.color.theme_color))
                    }else {
                        convenientBanner.setBackgroundColor(ContextCompat.getColor(mContext, R.color.transparent))
                    }
                }

                override fun onError(erroCode: Int, erroMsg: String) {
                    refresh_layout.refreshComplete()
                    showToast(erroMsg)
                }
            }, object : ApiFailAction() {
                override fun onFail(msg: String) {
                    refresh_layout.refreshComplete()
                    showToast(msg)
                }
            })



        addSubscrebe(subscription)
    }

    /**
     * 用户信息更新、退出登录
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun updateUserInfo(event: Event<String>) {
        if (C.EventKey.UPDATE_USER_INFO == event.key) {
            if(app.user!=null && rl_tip_login.visibility != View.GONE){
                rl_tip_login.visibility = View.GONE
                rl_tip_login_to.visibility = View.GONE
                if (rl_topbar.visibility == View.VISIBLE) {
                    app_bar_layout.setExpanded(false, false)
                }
                updateMinimumHeight()
            }else if(app.user==null){
                rl_tip_login.visibility = View.VISIBLE
//                rl_tip_login_to.visibility = View.VISIBLE
                updateMinimumHeight()
            }
        }
    }

    /**
     * 频道列表数据变化
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun updateChannelList(event: Event<String>) {
        if (C.EventKey.UPDATE_CHANNEL_LIST == event.key) {
            updateChannelTab(DbHelper.getInstance().getSubscribedList(app.isLogin))
        }
    }

    /**
     * 刷新频道Tab
     */
    private fun updateChannelTab(databaseSubscribedList: List<ChannelInfo>) {
        if(databaseSubscribedList.isNotEmpty()) {
            adapter.channels = databaseSubscribedList
            adapter.notifyDataSetChanged()
            tab.notifyDataSetChanged()
            tab_to.notifyDataSetChanged()
            tab_new.notifyDataSetChanged()
        }else {
//            CacheHelper.getInstance().requestChannelList()
        }
    }

    /**
     * 城市切换
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun switchCitySuccess(event: Event<String>) {
        if (C.EventKey.SWITCH_CITY_SUCCESS == event.key) {
            tv_city.text = app.cityName
            getHomeResultBase()
            if(tab.tabCount>0) {
                EventNotifier.getInstance().updateNewsList(tab.getTitleView(tab.currentTab)?.getStr())
            }
        }
    }
}
