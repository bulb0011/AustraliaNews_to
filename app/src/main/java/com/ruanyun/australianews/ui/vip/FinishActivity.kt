package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.util.C
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity :BaseActivity() {

    companion object{
        fun start(context: Context,type:String, productType:Int, productOid:String,
                  inamge_url:String,price_Type:Int, jige:String,zhiqianjiage:String, tv_label:String, tv_title:String) {
            val starter = Intent(context, FinishActivity::class.java)
            starter.putExtra("type",type)
            starter.putExtra("productType",productType)
            starter.putExtra("productOid",productOid)
            starter.putExtra("inamge_url",inamge_url)
            starter.putExtra("price_Type",price_Type)
            starter.putExtra("jige",jige)
            starter.putExtra("zhiqianjiage",zhiqianjiage)
            starter.putExtra("tv_label",tv_label)
            starter.putExtra("tv_title",tv_title)

            context.startActivity(starter)
        }
    }
    var inamge_url=""
    var tv_titl=""
    var price_Type=1
    var jige=""
    var zhiqianjiage=""
    var tvlabel=""
    var productOid=""

    var type=""
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_finish)

        type = intent.getStringExtra("type")

        inamge_url= intent.getStringExtra("inamge_url")
        tv_titl= intent.getStringExtra("tv_title")
        price_Type=intent.getIntExtra("price_Type",1)
        jige= intent.getStringExtra("jige")
        zhiqianjiage =intent.getStringExtra("zhiqianjiage")
        tvlabel= intent.getStringExtra("tv_label")
        productOid=intent.getStringExtra("productOid")

        image.loadImage(inamge_url)
        tv_name.text=tv_titl

        if (C.IntentKey.VIP_TYPE_PDF.equals(type)){
            tv_tishiwenz.text="试读结束"

        }else if (C.IntentKey.VIP_TYPE_MP3.equals(type)){
            tv_tishiwenz.text="试听结束"
        }

        tv_fanhui.clickWithTrigger{
            this.finish()
        }

        bt_lijigoumai.clickWithTrigger{
            SelectPayActivity.start(this,1,productOid,
                inamge_url,price_Type,jige,zhiqianjiage,tvlabel,tv_titl)
        }

        bt_jiaruhuiyuan.clickWithTrigger{
            AddVipActivity.start(this)
        }



    }
}