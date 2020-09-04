package com.ruanyun.australianews.ui.main

import android.content.Context
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.internal.LinkedTreeMap
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.base.ResultBase
import com.ruanyun.australianews.data.ApiFailAction
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.data.ApiSuccessAction
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.util.CommonUtil.dp2px
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.*
import com.ruanyun.australianews.ui.adapter.AdverViewHolderTo
import com.ruanyun.australianews.ui.adapter.VipClassifAdapter
import com.ruanyun.australianews.ui.adapter.VipReMenAdapter
import com.ruanyun.australianews.ui.adapter.VipReToAdapter
import com.ruanyun.australianews.ui.my.MySubscibeActivity
import com.ruanyun.australianews.ui.vip.MoreActivity
import com.ruanyun.australianews.ui.vip.SpecialColumnActivity
import com.ruanyun.australianews.ui.vip.VipDetailsActivity
import com.ruanyun.australianews.ui.vip.VipListActivity
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.RxUtil
import com.ruanyun.australianews.util.WebViewUrlUtil
import com.ruanyun.australianews.widget.MyConvenientBanner
import jiguang.chat.utils.ToastUtil
import kotlinx.android.synthetic.main.fragment_vip.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import java.util.*

import retrofit2.Callback
import retrofit2.Response
import rx.functions.Action1


class VipFragment :BaseFragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContentView = inflater.inflate(R.layout.fragment_vip, container, false)
//        registerBus()
        return mContentView
    }

    lateinit var convenientBanner: MyConvenientBanner<VipBannerInfo>

    override fun onResume() {
        super.onResume()
        convenientBanner.startTurning(4000)
    }

    override fun onPause() {
        super.onPause()
        convenientBanner.stopTurning()

    }

   val advertList = arrayListOf<VipBannerInfo>()

   var columnOid=""

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        context?.let { initData(it) }

        Log.e("dengpao","App.app.userOid"+App.app.userOid)
        Log.e("dengpao","App.app.cityName"+App.app.cityName)

        convenientBanner = getView(R.id.banner)
        convenientBanner.setPageIndicator(MyConvenientBanner.indicators)
        convenientBanner.setPageIndicatorAlign(MyConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
        convenientBanner.setPageIndicatorMargins(0,0,dp2px(10f),dp2px(5f))


        initView()

        ll_soushuo.clickWithTrigger { SearchActivity.start(mContext, SearchActivity.HOME_SEARCH) }

        img_dinbyue.clickWithTrigger { MySubscibeActivity.start(mContext) }

        //专栏查看更多
        rl_zhuanglian.clickWithTrigger {
            SpecialColumnActivity.start(mContext,columnOid)
        }

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
        ApiManger.getApiService().getHotInfoList(App.app.userOid).compose(RxUtil.normalSchedulers())
            .subscribe(object : ApiSuccessAction<ResultBase<HotInfo>>() {
                override fun onSuccess(result: ResultBase<HotInfo>) {
//                   val  hotinfo=GsonUtil.parseJson(result.data.toString(),HotInfo::class.java)
                    val layoutManager = LinearLayoutManager(context)

                    layoutManager.orientation = LinearLayoutManager.VERTICAL
                    rv_remincanpin.layoutManager = layoutManager
                    rv_remincanpin.isNestedScrollingEnabled = false

                    adapterVipReMen = VipReMenAdapter(context, result.data.datas)

                    rv_remincanpin.adapter = adapterVipReMen

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

                   val  vipBannerInfo =  VipBannerInfo()

                    vipBannerInfo.title = "标题"
                    vipBannerInfo.mainPhoto="20200804120659350.jpg"

                    advertList.add(vipBannerInfo)

                    convenientBanner.setPages( { AdverViewHolderTo() } , advertList).setOnItemClickListener{
                        ToastUtil.shortToast(mContext,"111")
                    }

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
        ApiManger.getApiService().getNewsInfoByNewsType(App.app.cityName,App.app.userOid).compose(RxUtil.normalSchedulers())
            .subscribe(object : ApiSuccessAction<ResultBase<NewsInfoNewsInfo>>() {
                override fun onSuccess(result: ResultBase<NewsInfoNewsInfo>) {
//                   val  hotinfo=GsonUtil.parseJson(result.data.toString(),HotInfo::class.java)

                    val  vipColumnInfo =  result.data.datas

//                    mDataList.add("")

                    val layoutManager = LinearLayoutManager(context)

                    layoutManager.orientation = LinearLayoutManager.VERTICAL

                    rv_to.layoutManager = layoutManager

                    rv_to.isNestedScrollingEnabled = false

                    adapterVipReTo = context?.let { VipReToAdapter(it, vipColumnInfo) }

                    rv_to.adapter=adapterVipReTo

                    adapterVipReTo.setOnCliakListener(object : VipReToAdapter.OnCliskListener{
                        override fun onClisk(view: View?,i:Int) {
                            ToastUtil.shortToast(mContext,"$"+i)

                           val objInfo= vipColumnInfo[i]

                            WebViewUrlUtil.showVIPNewsWeb(mContext,objInfo.title,objInfo.mainPhoto,objInfo.oid,objInfo.createTime)

                        }
                    })

                    initEvent()


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
    fun initEvent(){

        adapterVipReMen?.setOnCliakListener(object : VipReMenAdapter.OnCliskListener {
            override fun onClisk(view: View?, po: Int,type:Int,id:String) {
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
        })

        convenientBanner.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                tv_banner.text=advertList.get(p0).title
            }
        })

        //热门更多
        tv_gengduo.clickWithTrigger { MoreActivity.start(mContext) }

        adapterClassif.setOnCliakListener(object : VipClassifAdapter.OnCliskListener{
            override fun onClisk(view: View?, title: String, id: String) {
                VipListActivity.start(mContext,title,id)
            }
        })


        zhanlan()
    }

    fun zhanlan(){
        //专栏数据
        ApiManger.getApiService().getVipNewColumnList(2)
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

                        Log.e("aaa",dataArr.getJSONObject(i).getString("oid"))

                        val ColumnInfo = VipColumnInfo.DatasBean()

                        ColumnInfo.oid= dataArr.getJSONObject(i).getString("oid")

                        ColumnInfo.title=dataArr.getJSONObject(i).getString("title")

                        val afnInfoAllList = dataArr.getJSONObject(i).getJSONArray("afnInfoAllList")

                        val dataBean=ArrayList<VipColumnInfo.DatasBean.AfnInfoAllListBean>()

                        for (j in 0 until afnInfoAllList.length()) {

                            val  ListBean=VipColumnInfo.DatasBean.AfnInfoAllListBean()

                            ListBean.title= afnInfoAllList.getJSONObject(j).getString("title")

                            ListBean.mainPhoto=afnInfoAllList.getJSONObject(j).getString("mainPhoto")
                            ListBean.columnOid = afnInfoAllList.getJSONObject(j).getString("mainPhoto")
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


