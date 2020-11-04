package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.model.AppVipInfo
import com.ruanyun.australianews.model.YaunYiInfo
import com.ruanyun.australianews.ui.adapter.VipQuanYiAdapter
import jiguang.chat.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_add_vip.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class AddVipActivity :BaseActivity() {

    companion object{
        fun start(context: Context) {
            val starter = Intent(context, AddVipActivity::class.java)
            context.startActivity(starter)
        }
    }

    var id=""
    var jiage=""
    var dianji=true
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_add_vip)

        intData();

        bt_add_vip.clickWithTrigger {
            SelectPayActivity.start(this, 4,id,jiage)
        }
        topbar.setTopBarClickListener(this)

        tv_quanyi.clickWithTrigger{
            if (dianji){
                adapterVipReMen = VipQuanYiAdapter(context, listData)
                rv_remincanpin.adapter = adapterVipReMen
                dianji=false
                tv_quanyi.text="收起权益"
            }else{
                adapterVipReMen = VipQuanYiAdapter(context, itemList)
                rv_remincanpin.adapter = adapterVipReMen
                dianji=true
                tv_quanyi.text="查看更多权益"
            }

        }
    }

    private var itemList = java.util.ArrayList<com.ruanyun.australianews.model.YaunYiInfo.DataEntity>()
    private var listData = java.util.ArrayList<com.ruanyun.australianews.model.YaunYiInfo.DataEntity>()
    lateinit var adapterVipReMen : VipQuanYiAdapter
    fun intData(){

        //会员权益
        ApiManger.getApiService().getAppVipEquityList(App.app.userOid)
            . enqueue(object : Callback<YaunYiInfo> {
                override fun onFailure(call: Call<YaunYiInfo>, t: Throwable) {
                }
                override fun onResponse(
                    call: Call<YaunYiInfo>,
                    response: Response<YaunYiInfo>
                ) {
                    val layoutManager = LinearLayoutManager(context)
                    layoutManager.orientation = LinearLayoutManager.VERTICAL
                    rv_remincanpin.layoutManager = layoutManager
                    rv_remincanpin.isNestedScrollingEnabled = false

                    listData= response.body()!!.data as ArrayList<YaunYiInfo.DataEntity>

                    if(listData.size>3){
                        for (index in 0..2){
                            itemList.add(listData[index])
                        }
                         adapterVipReMen = VipQuanYiAdapter(context, itemList)
                    }else{
                         adapterVipReMen = VipQuanYiAdapter(context, listData)
                        tv_quanyi.visibility= View.GONE
                    }

                    rv_remincanpin.adapter = adapterVipReMen

//                    val json = response.body()!!.string()
//
//                    val je = JsonParser().parse(json)
//
//                    val data = je.asJsonObject["data"].toString()
//
//                    val gson = Gson()
//
//                    val hotinfo= gson.fromJson<HotInfo>(data,HotInfo::class.java)
//
//                    val listDatasEntity = hotinfo.datas

                }
            })
        ApiManger.getApiService().AppVipInfo(App.getInstance().userOid)
            .enqueue(object : Callback<AppVipInfo> {
                override fun onFailure(call: Call<AppVipInfo>, t: Throwable) {
                }
                override fun onResponse( call: Call<AppVipInfo>,response: Response<AppVipInfo>) {

                    val iso=App.app.iso

                    val data=response.body()!!.getData()
                    if(data==null){
                        ToastUtil.shortToast(this@AddVipActivity,"数据错误！")
                        return
                    }
                    id=data.oid

                    //国内
                    if(iso=="cn"||iso=="CN"){
                        jiage=data.priceCny.toString()

                    }
                    //澳洲
                    else if(iso=="au"|| iso=="AU") {
                        jiage=data.priceAud.toString()
                    }
                    //其他地区
                    else{
                        jiage=data.priceAud.toString()
                    }

                }
            })
    }

}