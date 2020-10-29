package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.base.ResultBase
import com.ruanyun.australianews.data.ApiFailAction
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.data.ApiSuccessAction
import com.ruanyun.australianews.model.VipNewsType
import com.ruanyun.australianews.ui.adapter.VipColumnAdapter
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.RxUtil
import com.ruanyun.australianews.util.WebViewUrlUtil
import jiguang.chat.utils.ToastUtil
import jiguang.chat.utils.imagepicker.ImagePickerAdapter
import kotlinx.android.synthetic.main.activity_vip_list.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VipListActivity : BaseActivity() {

    companion object {

        fun start(context: Context,title:String,newsTypeOid:String) {
            val starter = Intent(context, VipListActivity::class.java)
            starter.putExtra(C.IntentKey.VIP_LIST_TITLE,title)
            starter.putExtra("newsTypeOid",newsTypeOid)
            context.startActivity(starter)
        }
    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_vip_list)

        topbar.setTopBarClickListener(this)

        val title = intent.getStringExtra(C.IntentKey.VIP_LIST_TITLE)
        val newsTypeOid = intent.getStringExtra("newsTypeOid")

        topbar.setTitleText(title)

        initData(newsTypeOid)

    }

    fun initData(newsTypeOid: String){
        ApiManger.getApiService().getNewsType(newsTypeOid,App.app.userOid)
            . enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
//                    val dataInfo=result.data

                    val json = response.body()!!.string()

                    val je = JsonParser().parse(json)

                    val data = je.asJsonObject["data"].toString()

                    val gson = Gson()

                    val dataInfo= gson.fromJson<VipNewsType>(data,VipNewsType::class.java)

                    val layoutManager = LinearLayoutManager(context)

                    layoutManager.orientation = LinearLayoutManager.VERTICAL

                    rv_one.layoutManager = layoutManager

                    rv_one.isNestedScrollingEnabled = false

                    val dataList=dataInfo.datas

//                    dataList[0].dataType=1

                  val  adapterVipReListOne = context.let { VipColumnAdapter(it, dataList) }

                    rv_one.adapter=adapterVipReListOne

                    initEvent(adapterVipReListOne,dataList)

                }
            })
    }



    fun initEvent(adapterVipReListOne: VipColumnAdapter,dataList:List<VipNewsType.DatasEntity>){

        adapterVipReListOne?.setOnItemClickListener(object :VipColumnAdapter.OnRecyclerViewItemClickListener {
            override fun onClisk(view: View?, i: Int,id:String) {

               val objInfo = dataList[i]

                if (objInfo.dataType==1){

                    var s=""

                    if (objInfo.contentType==1){

                        s=C.IntentKey.VIP_TYPE_PDF
                    }else if (objInfo.contentType==2){

                        s=C.IntentKey.VIP_TYPE_VIDEO
                    }else if (objInfo.contentType==3){

                        s=C.IntentKey.VIP_TYPE_MP3
                    }

                    context?.let {
                        VipDetailsActivity.start(
                            it,
                            s,
                            id
                        )
                    }

                }else{

                    WebViewUrlUtil.showVIPNewsWeb(this@VipListActivity,objInfo.title,
                        objInfo.mainPhoto,objInfo.oid,objInfo.createTime)
                }



            }
        })


    }

    override fun onTopBarLeftImgClick() {
        super.onTopBarLeftImgClick()
        finish()
    }

}