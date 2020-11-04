package com.ruanyun.australianews.ui.main

import `in`.srain.cube.views.ptr.PtrClassicDefaultHeader
import `in`.srain.cube.views.ptr.PtrFrameLayout
import `in`.srain.cube.views.ptr.PtrHandler
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.jpush.JsonParser
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.base.ResultBase
import com.ruanyun.australianews.data.ApiFailAction
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.data.ApiSuccessAction
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.*
import com.ruanyun.australianews.ui.WebViewActivity
import com.ruanyun.australianews.ui.adapter.AdverViewHolderTo
import com.ruanyun.australianews.ui.adapter.VipClassifAdapter
import com.ruanyun.australianews.ui.adapter.VipReMenAdapter
import com.ruanyun.australianews.ui.adapter.VipReToAdapter
import com.ruanyun.australianews.ui.my.MyMessageListActivity
import com.ruanyun.australianews.ui.vip.*
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.CommonUtil.dp2px
import com.ruanyun.australianews.util.FileUtil
import com.ruanyun.australianews.util.RxUtil
import com.ruanyun.australianews.util.WebViewUrlUtil
import com.ruanyun.australianews.util.WebViewUrlUtil.Companion.ADVERTISING_DETAILS
import com.ruanyun.australianews.widget.MyConvenientBanner
import jiguang.chat.utils.ToastUtil
import kotlinx.android.synthetic.main.fragment_vip.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class VipFragment :BaseFragment(){

    lateinit var convenientBanner: MyConvenientBanner<VipBannerInfo>

    val advertList = arrayListOf<VipBannerInfo>()

    var columnOid=""

    // 滚动偏移距离
    private var height: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContentView = inflater.inflate(R.layout.fragment_vip, container, false)
//        registerBus()
        return mContentView
    }

    override fun onResume() {
        super.onResume()
        convenientBanner.startTurning(4000)
    }

    override fun onPause() {
        super.onPause()
        convenientBanner.stopTurning()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        context?.let { initData(it) }

        convenientBanner = getView(R.id.banner)
        convenientBanner.setPageIndicator(MyConvenientBanner.indicators)
        convenientBanner.setPageIndicatorAlign(MyConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
        convenientBanner.setPageIndicatorMargins(0,0,dp2px(10f),dp2px(5f))


        initView()

        ll_soushuo.clickWithTrigger {
           val init = Intent(mContext, ShouSuoActivity::class.java)
            startActivity(init)
        }

        img_dinbyue.clickWithTrigger { MyMessageListActivity.start(mContext) }


        //专栏查看更多
        rl_zhuanglian.clickWithTrigger {

           if(isLoginToActivity)SpecialColumnActivity.start(mContext,columnOid)
        }

        //这里是一个自定义的头部刷新布局,自带的也有一个布局  new PtrDefaultHandler();
        //这里是一个自定义的头部刷新布局,自带的也有一个布局  new PtrDefaultHandler();
        val header = PtrClassicDefaultHeader(getContext())
        //将头布局添加
        //将头布局添加
        refresh_layoutto.addPtrUIHandler(header)
        refresh_layoutto.headerView=header

        refresh_layoutto.setPtrHandler(object : PtrHandler {
            override fun onRefreshBegin(frame: PtrFrameLayout?) {
                context?.let { initData(it) }
                refresh_layoutto.refreshComplete()
            }

            override fun checkCanDoRefresh(
                frame: PtrFrameLayout?,
                content: View?,
                header: View?
            ): Boolean {
               return height<=20
            }
        })


        nestedScrollView.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener{
            override fun onScrollChange(p0: NestedScrollView?, p1: Int, p2: Int, p3: Int, p4: Int) {
                height=p2
            }
        })

        initEvent()

    }
    var mDataList: MutableList<String> = ArrayList()

    fun initView(){

        remenInIt()

    }

 lateinit  var  adapterVipReMen :VipReMenAdapter
 lateinit  var  adapterClassif :VipClassifAdapter
 lateinit  var  adapterVipReTo :VipReToAdapter

    private fun remenInIt() {
//        rv_remincanpin.adapter= this.context?.let { VipReMenAdapter(it,mDataList) }
    }


    fun initData(context :Context){

        //最热产品
        ApiManger.getApiService().getHotInfoList(App.app.userOid)
            . enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
//                   val  hotinfo=GsonUtil.parseJson(result.data.toString(),HotInfo::class.java)
                    val layoutManager = LinearLayoutManager(context)

                    layoutManager.orientation = LinearLayoutManager.VERTICAL
                    rv_remincanpin.layoutManager = layoutManager
                    rv_remincanpin.isNestedScrollingEnabled = false

                    val json = response.body()!!.string()

                    val je = JsonParser().parse(json)

                    val data = je.asJsonObject["data"].toString()

                    val gson = Gson()

                    val hotinfo= gson.fromJson<HotInfo>(data,HotInfo::class.java)

                    val listDatasEntity = hotinfo.datas

                    adapterVipReMen = VipReMenAdapter(context, listDatasEntity)

                    rv_remincanpin.adapter = adapterVipReMen

                    adapterVipReMen?.setOnCliakListener(object : VipReMenAdapter.OnCliskListener {
                        override fun onClisk(view: View?, po: Int,type:Int,id:String) {

                            if(isLoginToActivity){
                                var s=""
                                if (type==1){

                                    s=C.IntentKey.VIP_TYPE_PDF
                                }else if (type==2){

                                    s=C.IntentKey.VIP_TYPE_VIDEO
                                }else if (type==3){

                                    s=C.IntentKey.VIP_TYPE_MP3
                                }

                                context?.let {
                                    VipDetailsActivity.start(
                                        it,
                                        s,
                                        id
                                    )
                                }
                            }
                        }
                    })

                }

            })



        //分类
        ApiManger.getApiService().getClassifList().compose(RxUtil.normalSchedulers())
            .subscribe(object : ApiSuccessAction<ResultBase<List<ClassifyInfo>>>() {
                override fun onSuccess(result: ResultBase<List<ClassifyInfo>>) {
//                   val  hotinfo=GsonUtil.parseJson(result.data.toString(),HotInfo::class.java)
                    val layoutManager = LinearLayoutManager(context)
                    layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                    rv_classify.layoutManager = layoutManager
                    rv_classify.isNestedScrollingEnabled = false
                    Log.e("dengpao", result.data.toString())
                    adapterClassif = VipClassifAdapter(context,
                        result.data as MutableList<ClassifyInfo>
                    )
                    rv_classify.adapter = adapterClassif

                    adapterClassif?.setOnCliakListener(object : VipClassifAdapter.OnCliskListener{
                        override fun onClisk(view: View?, title: String, id: String) {
                            if(isLoginToActivity) VipListActivity.start(mContext,title,id)
                        }
                    })

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


        //banner图
        ApiManger.getApiService().getVipBanner().compose(RxUtil.normalSchedulers())
            .subscribe(object : ApiSuccessAction<ResultBase<List<VipBannerInfo>>>() {
                override fun onSuccess(result: ResultBase<List<VipBannerInfo>>) {
//                   val  hotinfo=GsonUtil.parseJson(result.data.toString(),HotInfo::class.java)

                    advertList.addAll(result.data as MutableList<VipBannerInfo>)

                    convenientBanner.setPages( { AdverViewHolderTo() } , advertList).setOnItemClickListener{

//                        WebViewUrlUtil.showAdvertDetailsWeb(mContext, advertList[it])

                        if(isLoginToActivity){

                        val info= advertList[it]
                            if (info.type==1) {
                                var s=""
                                if (info.contentType==1){
                                    s=C.IntentKey.VIP_TYPE_PDF
                                }else if (info.contentType==2){
                                    s=C.IntentKey.VIP_TYPE_VIDEO
                                }else if (info.contentType==3){
                                    s=C.IntentKey.VIP_TYPE_MP3
                                }
                                context?.let {
                                    VipDetailsActivity.start(
                                        it,
                                        s,
                                        info.commonOid
                                    )
                                }
                            }else if (info.type==2){
                                SpecialColumnActivity.start(mContext,info.commonOid)
                            }else{
                                WebViewActivity.start(context, FileUtil.getWebViewUrl(ADVERTISING_DETAILS, advertList[it].commonOid))
                            }
                        }
                    }

                    convenientBanner?.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{

                        override fun onPageScrollStateChanged(p0: Int) {
                        }

                        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                        }

                        override fun onPageSelected(p0: Int) {
                            tv_banner.text=advertList.get(p0).title
                        }
                    })

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



        //最下面的新闻
//        ApiManger.getApiService().getNewsInfoByNewsType(App.app.cityName,App.app.userOid).compose(RxUtil.normalSchedulers())
//            .subscribe(object : ApiSuccessAction<ResultBase<NewsInfoNewsInfo>>() {
//                override fun onSuccess(result: ResultBase<NewsInfoNewsInfo>) {
////                   val  hotinfo=GsonUtil.parseJson(result.data.toString(),HotInfo::class.java)
//
//                    val   data =  result.data.datas
//                    val  vipColumnInfo =  data.datas
//
////                    mDataList.add("")
//
//                    val layoutManager = LinearLayoutManager(context)
//
//                    layoutManager.orientation = LinearLayoutManager.VERTICAL
//
//                    rv_to.layoutManager = layoutManager
//
//                    rv_to.isNestedScrollingEnabled = false
//
//                    adapterVipReTo = context?.let { VipReToAdapter(it, vipColumnInfo) }
//
//                    rv_to.adapter=adapterVipReTo
//
//                    adapterVipReTo.setOnCliakListener(object : VipReToAdapter.OnCliskListener{
//                        override fun onClisk(view: View?,i:Int) {
//                            ToastUtil.shortToast(mContext,"$"+i)
//
//                           val objInfo= vipColumnInfo[i]
//
//                            WebViewUrlUtil.showVIPNewsWeb(mContext,objInfo.title,objInfo.mainPhoto,objInfo.oid,objInfo.createTime)
//
//                        }
//                    })
//
//                }
//                override fun onError(erroCode: Int, erroMsg: String) {
////                disMissLoading()
//                    showToast(erroMsg)
//                }
//            }, object : ApiFailAction() {
//                override fun onFail(msg: String) {
////                disMissLoading()
//                    showToast(msg)
//                }
//            })
        ApiManger.getApiService().getNewsInfoByNewsType(App.app.cityName,App.app.userOid,100)
            .enqueue(object : Callback<TextNewInfo> {
                override fun onFailure(call: Call<TextNewInfo>, t: Throwable) {

                }

                override fun onResponse(call: Call<TextNewInfo>, response: Response<TextNewInfo>) {

                    if (response!=null&&response.code()==200){
                        val   data =  response.body()!!.data
                        val  vipColumnInfo =  data.datas

                        val layoutManager = LinearLayoutManager(context)

                        layoutManager.orientation = LinearLayoutManager.VERTICAL

                        rv_to.layoutManager = layoutManager

                        rv_to.isNestedScrollingEnabled = false

                        adapterVipReTo = context?.let { VipReToAdapter(it, vipColumnInfo) }

                        rv_to.adapter=adapterVipReTo

                        adapterVipReTo.setOnCliakListener(object : VipReToAdapter.OnCliskListener{
                            override fun onClisk(view: View?,i:Int) {
                                if(isLoginToActivity){
                                    val objInfo= vipColumnInfo[i]
                                    WebViewUrlUtil.showVIPNewsWeb(mContext,objInfo.title,objInfo.mainPhoto,objInfo.oid,objInfo.createTime)
                                }
                            }
                        })
                    }

                }

            })


    }
    fun initEvent(){
        //热门更多
        gengduo.clickWithTrigger{
            if(isLoginToActivity) MoreActivity.start(mContext)
        }


        zhanlan()
    }

    fun zhanlan(){
        //专栏数据
        ApiManger.getApiService().getVipNewColumnList(2,100)
            . enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    response.body().toString()

                    val jsonStr = String(response.body()!!.bytes()) //把原始数据转为字符串

                    val JSONObject = JSONObject(jsonStr)

                    val datajson = JSONObject.getJSONObject("data")

                    val dataArr = datajson.getJSONArray("datas")

                    val dataList=ArrayList<VipColumnInfo.DatasBean>()

                    for (i in 0 until dataArr.length()) {

                        val ColumnInfo = VipColumnInfo.DatasBean()

                        ColumnInfo.oid= dataArr.getJSONObject(i).getString("oid")

                        ColumnInfo.title=dataArr.getJSONObject(i).getString("title")

                        val afnInfoAllList = dataArr.getJSONObject(i).getJSONArray("afnInfoAllList")

                        val dataBean=ArrayList<VipColumnInfo.DatasBean.AfnInfoAllListBean>()

                        for (j in 0 until afnInfoAllList.length()) {

                            val  ListBean=VipColumnInfo.DatasBean.AfnInfoAllListBean()

                            ListBean.title= afnInfoAllList.getJSONObject(j).getString("title")

                            ListBean.mainPhoto=afnInfoAllList.getJSONObject(j).getString("mainPhoto")
                            ListBean.columnOid = afnInfoAllList.getJSONObject(j).getString("columnOid")
                            dataBean.add(ListBean)

                        }

                        ColumnInfo.afnInfoAllList=dataBean

                        dataList.add(ColumnInfo)

                    }

                    val info=dataList[0].afnInfoAllList

                    image_one.loadImage(ApiManger.IMG_URL+info[0].mainPhoto)

                    iamge_to.loadImage(ApiManger.IMG_URL+info[1].mainPhoto)

                    columnOid=dataList[0].oid

                    tv_title_zhaunlan.text=dataList[0].title

                    tv_one.text=info[0].title
                    tv_tow.text=info[1].title

                }
            })
    }

}


