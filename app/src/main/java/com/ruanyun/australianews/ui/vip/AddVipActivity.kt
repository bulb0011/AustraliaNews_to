package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.model.AppVipInfo
import jiguang.chat.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_add_vip.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddVipActivity :BaseActivity() {

    companion object{
        fun start(context: Context) {
            val starter = Intent(context, AddVipActivity::class.java)
            context.startActivity(starter)
        }
    }

    var id=""
    var jiage=""

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_add_vip)

        intData();

        bt_add_vip.clickWithTrigger {
            SelectPayActivity.start(this, 4,id,jiage)
        }
        topbar.setTopBarClickListener(this)
    }

    fun intData(){

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