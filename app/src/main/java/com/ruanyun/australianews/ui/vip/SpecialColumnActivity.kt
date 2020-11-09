package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.Gson
import com.google.gson.jpush.JsonParser
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.BuyInfo
import com.ruanyun.australianews.model.ColumnDetailsInfo
import com.ruanyun.australianews.model.ZhuanLanInfo
import com.ruanyun.australianews.model.ZhuanLanListInfo
import com.ruanyun.australianews.ui.adapter.ColumnAdapter
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.DateUtil
import com.ruanyun.australianews.util.WebViewUrlUtil
import jiguang.chat.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_special_column.*
import okhttp3.ResponseBody
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.util.*


class SpecialColumnActivity :BaseActivity(){

    companion object {
        fun start(context: Context,columnOid :String) {
            val starter = Intent(context, SpecialColumnActivity::class.java)
            starter.putExtra("columnOid",columnOid)
            context.startActivity(starter)
        }
        fun startTask(context: Context,columnOid :String) {
            val starter = Intent(context, SpecialColumnActivity::class.java)
            starter.putExtra("columnOid",columnOid)
            starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(starter)
        }

    }

    val dataList=ArrayList<ZhuanLanListInfo>()

    var upDate=""

    var columnOid=""

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_special_column)
        columnOid=intent.getStringExtra("columnOid")

        upDate=DateUtil.getCurrentTime()
//
//        adapter?.setOnCliakListener(object : ColumnAdapter.OnCliskListener{
//            override fun onClisk(view: View?, po: Int) {
//                if (po==1){
//                    context?.let {VipDetailsActivity.start(it, C.IntentKey.VIP_TYPE_PDF)}
//                }else if (po==2){
//                    context?.let { VipDetailsActivity.start(it, C.IntentKey.VIP_TYPE_VIDEO) }
//                }else if (po==3){
//                    context?.let { VipDetailsActivity.start(it, C.IntentKey.VIP_TYPE_MP3)}
//                }
//            }
//        })

        initData(columnOid)

        topbar.topBarLeftImg.clickWithTrigger { this?.finish() }

    }

    var isBuy=0
    var isClick=false

    var id=""
    var inamge_url=""

    var jiage=""

   lateinit var item:ZhuanLanInfo.DatasEntity

    lateinit var columnDetailsInfo : ColumnDetailsInfo

    private fun initData(columnOid: String?) {
        ApiManger.getApiService().ColumnInternalData(columnOid)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    val json: String = response.body()!!.string()

                    val je =JsonParser().parse(json)

                    val data = je.asJsonObject["data"].toString()

                    val gson = Gson()

                    val zhuanLanInfo= gson.fromJson(data, ZhuanLanInfo::class.java)

                    val zhuanLanListInfo=zhuanLanInfo.datas

                    item =  zhuanLanListInfo[0]

//                    val jsonStr = String(response.body()!!.bytes()) //把原始数据转为字符串
//
//                    Log.e("dengpao", "" + jsonStr)
//
//                    //再使用Retrofit自带的JSON解析（或者别的什么）
//                    //再使用Retrofit自带的JSON解析（或者别的什么）
//    //                    val coupon = Gson().fromJson(response.body().toString(), ZhuanLanListInfo::class.java)
//
//                    val JSONObject = JSONObject(jsonStr)
//
//                    val datajson = JSONObject.getJSONObject("data")
//
//                    val dataArr = datajson.getJSONArray("datas")
//
//                    for (i in 0 until dataArr.length()) {
//                        val zhuanLanListInfo = ZhuanLanListInfo()
//                        zhuanLanListInfo.oid = dataArr.getJSONObject(i).getString("oid")
//                        zhuanLanListInfo.columnOid = dataArr.getJSONObject(i).getString("columnOid")
//                        zhuanLanListInfo.totalPagenum =
//                            dataArr.getJSONObject(i).getInt("totalPagenum")
//                        zhuanLanListInfo.mainPhoto = dataArr.getJSONObject(i).getString("mainPhoto")
//                        zhuanLanListInfo.specialOfferusd =
//                            dataArr.getJSONObject(i).getInt("specialOfferusd")
//                        zhuanLanListInfo.isColumn = dataArr.getJSONObject(i).getInt("isColumn")
//                        zhuanLanListInfo.oid = dataArr.getJSONObject(i).getString("oid")
//                        zhuanLanListInfo.title = dataArr.getJSONObject(i).getString("title")
//                        zhuanLanListInfo.normalPriceusd =
//                            dataArr.getJSONObject(i).getInt("normalPriceusd")
//                        zhuanLanListInfo.contentType =
//                            dataArr.getJSONObject(i).getInt("contentType")
//                        zhuanLanListInfo.specialOffercny =
//                            dataArr.getJSONObject(i).getInt("specialOffercny")
//                        zhuanLanListInfo.specialOfferaud =
//                            dataArr.getJSONObject(i).getInt("specialOfferaud")
//                        zhuanLanListInfo.isDelete = dataArr.getJSONObject(i).getInt("isDelete")
//                        zhuanLanListInfo.newstypeOid =
//                            dataArr.getJSONObject(i).getString("newstypeOid")
//                        zhuanLanListInfo.dataType = dataArr.getJSONObject(i).getInt("dataType")
//                        zhuanLanListInfo.priceType = dataArr.getJSONObject(i).getInt("priceType")
//                        zhuanLanListInfo.updateTime =
//                            dataArr.getJSONObject(i).getString("updateTime")
//                        zhuanLanListInfo.keyWord = dataArr.getJSONObject(i).getString("keyWord")
//                        zhuanLanListInfo.normalPriceaud =
//                            dataArr.getJSONObject(i).getInt("normalPriceaud")
//                        zhuanLanListInfo.normalPricecny =
//                            dataArr.getJSONObject(i).getInt("normalPricecny")
//                        zhuanLanListInfo.createTime =
//                            dataArr.getJSONObject(i).getString("createTime")
//                        zhuanLanListInfo.isMark = dataArr.getJSONObject(i).getBoolean("mark")
//                        dataList.add(zhuanLanListInfo)
//                    }

                    val layoutManager = LinearLayoutManager(context)
                    layoutManager.orientation = LinearLayoutManager.VERTICAL

                    rv_one.layoutManager = layoutManager

                    rv_one.isNestedScrollingEnabled = false

                    val adapter = context?.let { ColumnAdapter(it, zhuanLanListInfo) }

                    rv_one.adapter = adapter

                    if (adapter != null) {
                        initEvet(adapter,zhuanLanListInfo)
                    }

                }
            })

        //头部请求
        ApiManger.getApiService().getColumnDetails(columnOid, App.app.userOid)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    val json: String = response.body()!!.string()

                    val je =JsonParser().parse(json)

                    val data = je.asJsonObject["data"].toString()

                    val gson = Gson()

                    columnDetailsInfo= gson.fromJson(data, ColumnDetailsInfo::class.java)

                    imge_zhuanlan.loadImage(ApiManger.IMG_URL + columnDetailsInfo.mainPhoto)

                    id=columnDetailsInfo.oid
                    inamge_url=ApiManger.IMG_URL + columnDetailsInfo.mainPhoto

                    tv_title.text = columnDetailsInfo.title

                    if (columnDetailsInfo.status == 1) {
                        bt_tv.setText("更新中")
                    } else {
                        bt_tv.setText("已完结")
                    }

//                    tv_context.Html.fromHtml(columnDetailsInfo.content)
                    val varjs =
                        "<script type='text/javascript'> \nwindow.onload = function()\n{var \$img = document.getElementsByTagName('img');for(var p in  \$img){\$img[p].style.width = '100%'; \$img[p].style.height ='auto'}}</script>"

                    tv_context.loadDataWithBaseURL(null,varjs+columnDetailsInfo.content,"text/html","UTF-8",null);

                    val iso= App.app.iso
                    val df = DecimalFormat("#0.00")

                    if(columnDetailsInfo.isBuy!=1){//少一个专栏的或者

                        if (columnDetailsInfo.priceType==1){

                            bt_add_vip.text="订阅"
                            ll_mianfei.visibility=View.INVISIBLE
                            ll_jiage.visibility=View.VISIBLE

                            //国内
                            if(iso=="cn"||iso=="CN"){
                                tv_goumaijiage.text = "¥"+df.format(columnDetailsInfo.normalPricecny)
                                jiage=columnDetailsInfo.normalPricecny.toString()
                            }
                            //澳洲
                            else if(iso=="au"|| iso=="AU") {
                                tv_goumaijiage.text = "A$"+df.format(columnDetailsInfo.normalPriceaud)
                                jiage=columnDetailsInfo.normalPriceaud.toString()
                            }
                            //其他地区
                            else{
                                tv_goumaijiage.text = "$"+df.format(columnDetailsInfo.normalPriceusd)
                                jiage=columnDetailsInfo.normalPriceusd.toString()
                            }
                            isClick=false

                        }else if(columnDetailsInfo.priceType==2){
                            bt_add_vip.text="订阅"
                            tv_tejia.visibility=View.INVISIBLE

                            tv_mianfeiuedu.paint.isAntiAlias=true
                            tv_mianfeiuedu.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

//                            tv_mianfeiuedu.visibility=View.INVISIBLE

                            //国内
                            if(iso=="cn"||iso=="CN"){
                                tv_goumaijiage.text = "¥"+df.format(columnDetailsInfo.specialOffercny)
                                jiage=columnDetailsInfo.specialOffercny.toString()
                                tv_mianfeiuedu.text = "¥"+df.format(columnDetailsInfo.normalPricecny)
                            }
                            //澳洲
                            else if(iso=="au"|| iso=="AU") {
                                tv_goumaijiage.text = "A$"+df.format(columnDetailsInfo.specialOfferaud)
                                jiage=columnDetailsInfo.specialOfferaud.toString()
                                tv_mianfeiuedu.text = "¥"+df.format(columnDetailsInfo.normalPriceaud)
                            }
                            //其他地区
                            else{
                                tv_goumaijiage.text = "$"+df.format(columnDetailsInfo.specialOfferusd)
                                jiage=columnDetailsInfo.specialOfferusd.toString()
                                tv_mianfeiuedu.text = "¥"+df.format(columnDetailsInfo.normalPriceusd)
                            }

                            isClick=false
                        }

                        else if (columnDetailsInfo.priceType==3){

                            tv_mianfeiuedu.visibility=View.INVISIBLE

                            isClick=true

                            ll_mianfei.visibility=View.VISIBLE
                            ll_jiage.visibility=View.INVISIBLE

                            bt_add_vip.text="免费订阅"

                            //国内
                            if(iso=="cn"||iso=="CN"){
                                tv_mianfeiuedu.text = "¥"+df.format(columnDetailsInfo.specialOffercny)
                                jiage=columnDetailsInfo.specialOffercny.toString()
                            }
                            //澳洲
                            else if(iso=="au"|| iso=="AU") {
                                tv_mianfeiuedu.text = "A$"+df.format(columnDetailsInfo.specialOfferaud)
                                jiage=columnDetailsInfo.specialOfferaud.toString()
                            }
                            //其他地区
                            else{
                                tv_mianfeiuedu.text = "$"+df.format(columnDetailsInfo.specialOfferusd)
                                jiage=columnDetailsInfo.specialOfferusd.toString()
                            }

                            tv_mianfeiuedu.visibility=View.VISIBLE
                        }


                    }else if(columnDetailsInfo.isBuy==1 ||app.user.isVip==1 ){
                        rl_goumai.visibility=View.GONE
                        isClick=true
                    }


                }

            })

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun updateBuy( buyinfo: BuyInfo){
        if(buyinfo.isBuy==1){
            isClick=true
            rl_goumai.visibility=View.GONE
        }
    }

    fun initEvet(adapter:ColumnAdapter,dataList :List<ZhuanLanInfo.DatasEntity>){

        bt_add_vip.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {

                SelectPayActivity.start(this@SpecialColumnActivity,3,id,
                    inamge_url,columnDetailsInfo.priceType,
                    jiage,"0.00","专栏",tv_title.text.toString())
            }

        })

        adapter.setOnItemClickListener(object :ColumnAdapter.OnRecyclerViewItemClickListener{
            override fun onClisk(view: View?, i: Int) {

                val objInfo = dataList[i]

                if (objInfo.dataType==1){

                    var s=""

                    if (objInfo.contentType==1){

                        s= C.IntentKey.VIP_TYPE_PDF
                    }else if (objInfo.contentType==2){

                        s=C.IntentKey.VIP_TYPE_VIDEO
                    }else if (objInfo.contentType==3){

                        s=C.IntentKey.VIP_TYPE_MP3
                    }

                    context?.let {

                        if (isClick){
                            VipDetailsActivity.start(
                                it,
                                s,
                                objInfo.oid
                            )
                        }else{
                            ToastUtil.shortToast(mContext,"请购买此专栏！")
                        }

                    }

                }else{
                    if (isClick){
                        WebViewUrlUtil.showVIPNewsWeb(this@SpecialColumnActivity,objInfo.title,
                            objInfo.mainPhoto,objInfo.oid,objInfo.createTime)
                    }else{
                        ToastUtil.shortToast(mContext,"请购买此专栏！")
                    }

                }

            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        ApiManger.getApiService().saveAfnNewsColumnRecord(columnOid,App.app.userOid,upDate,DateUtil.getCurrentTime())
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
    }

}