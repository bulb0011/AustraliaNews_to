package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.base.ResultBase
import com.ruanyun.australianews.data.ApiFailAction
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.data.ApiSuccessAction
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.ColumnDetailsInfo
import com.ruanyun.australianews.model.ZhuanLanListInfo
import com.ruanyun.australianews.ui.adapter.ColumnAdapter
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.RxUtil
import com.ruanyun.australianews.util.WebViewUrlUtil
import kotlinx.android.synthetic.main.activity_special_column.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class SpecialColumnActivity :BaseActivity(){

    companion object {
        fun start(context: Context,columnOid :String) {
            val starter = Intent(context, SpecialColumnActivity::class.java)
            starter.putExtra("columnOid",columnOid)
            context.startActivity(starter)
        }
    }

    val dataList=ArrayList<ZhuanLanListInfo>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_special_column)
        val columnOid=intent.getStringExtra("columnOid")


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

    }

    private fun initData(columnOid: String?) {
        ApiManger.getApiService().ColumnInternalData(columnOid)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    response.body().toString()

                    val jsonStr = String(response.body()!!.bytes()) //把原始数据转为字符串


                    Log.e("dengpao", "" + jsonStr)

                    //再使用Retrofit自带的JSON解析（或者别的什么）
                    //再使用Retrofit自带的JSON解析（或者别的什么）
    //                    val coupon = Gson().fromJson(response.body().toString(), ZhuanLanListInfo::class.java)

                    val JSONObject = JSONObject(jsonStr)

                    val datajson = JSONObject.getJSONObject("data")

                    val dataArr = datajson.getJSONArray("datas")

                    for (i in 0 until dataArr.length()) {
                        val zhuanLanListInfo = ZhuanLanListInfo()
                        zhuanLanListInfo.oid = dataArr.getJSONObject(i).getString("oid")
                        zhuanLanListInfo.columnOid = dataArr.getJSONObject(i).getString("columnOid")
                        zhuanLanListInfo.totalPagenum =
                            dataArr.getJSONObject(i).getInt("totalPagenum")
                        zhuanLanListInfo.mainPhoto = dataArr.getJSONObject(i).getString("mainPhoto")
                        zhuanLanListInfo.specialOfferusd =
                            dataArr.getJSONObject(i).getInt("specialOfferusd")
                        zhuanLanListInfo.isColumn = dataArr.getJSONObject(i).getInt("isColumn")
                        zhuanLanListInfo.oid = dataArr.getJSONObject(i).getString("oid")
                        zhuanLanListInfo.title = dataArr.getJSONObject(i).getString("title")
                        zhuanLanListInfo.normalPriceusd =
                            dataArr.getJSONObject(i).getInt("normalPriceusd")
                        zhuanLanListInfo.contentType =
                            dataArr.getJSONObject(i).getInt("contentType")
                        zhuanLanListInfo.specialOffercny =
                            dataArr.getJSONObject(i).getInt("specialOffercny")
                        zhuanLanListInfo.specialOfferaud =
                            dataArr.getJSONObject(i).getInt("specialOfferaud")
                        zhuanLanListInfo.isDelete = dataArr.getJSONObject(i).getInt("isDelete")
                        zhuanLanListInfo.newstypeOid =
                            dataArr.getJSONObject(i).getString("newstypeOid")
                        zhuanLanListInfo.dataType = dataArr.getJSONObject(i).getInt("dataType")
                        zhuanLanListInfo.priceType = dataArr.getJSONObject(i).getInt("priceType")
                        zhuanLanListInfo.updateTime =
                            dataArr.getJSONObject(i).getString("updateTime")
                        zhuanLanListInfo.keyWord = dataArr.getJSONObject(i).getString("keyWord")
                        zhuanLanListInfo.normalPriceaud =
                            dataArr.getJSONObject(i).getInt("normalPriceaud")
                        zhuanLanListInfo.normalPricecny =
                            dataArr.getJSONObject(i).getInt("normalPricecny")
                        zhuanLanListInfo.createTime =
                            dataArr.getJSONObject(i).getString("createTime")
                        zhuanLanListInfo.isMark = dataArr.getJSONObject(i).getBoolean("mark")
                        dataList.add(zhuanLanListInfo)
                    }

                    val layoutManager = LinearLayoutManager(context)
                    layoutManager.orientation = LinearLayoutManager.VERTICAL

                    rv_one.layoutManager = layoutManager

                    rv_one.isNestedScrollingEnabled = false

                    val adapter = context?.let { ColumnAdapter(it, dataList) }

                    rv_one.adapter = adapter

                    if (adapter != null) {
                        initEvet(adapter,dataList)
                    }

                }
            })

        //头部请求
        ApiManger.getApiService().getColumnDetails(columnOid, App.app.userOid)
            .compose(RxUtil.normalSchedulers())
            .subscribe(object : ApiSuccessAction<ResultBase<ColumnDetailsInfo>>() {
                override fun onSuccess(result: ResultBase<ColumnDetailsInfo>) {

                    val vipColumnInfo = result.data

                    imge_zhuanlan.loadImage(ApiManger.IMG_URL + vipColumnInfo.mainPhoto)

                    tv_title.text = vipColumnInfo.title

                    if (vipColumnInfo.status == 1) {
                        bt_tv.setText("更新中")
                    } else {
                        bt_tv.setText("已完结")
                    }

                    tv_context.text = vipColumnInfo.content


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

    fun initEvet(adapter:ColumnAdapter,dataList :ArrayList<ZhuanLanListInfo>){

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
                        VipDetailsActivity.start(
                            it,
                            s,
                            objInfo.oid
                        )
                    }

                }else{

                    WebViewUrlUtil.showVIPNewsWeb(this@SpecialColumnActivity,objInfo.title,
                        objInfo.mainPhoto,objInfo.oid,objInfo.createTime)
                }

            }
        })

    }

}