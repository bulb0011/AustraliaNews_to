package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.util.C
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity :BaseActivity() {

    companion object{
        fun start(context: Context,type:String) {
            val starter = Intent(context, FinishActivity::class.java)

            starter.putExtra("type",type)

            context.startActivity(starter)
        }
    }

    var type=""
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_finish)

        type = intent.getStringExtra("type")

        if (C.IntentKey.VIP_TYPE_PDF.equals(type)){
            tv_tishiwenz.text="试读结束"

        }else if (C.IntentKey.VIP_TYPE_MP3.equals(type)){
            tv_tishiwenz.text="试听结束"
        }

        tv_fanhui.clickWithTrigger{
            this.finish()
        }

        bt_lijigoumai.clickWithTrigger{
            SelectPayActivity.start(this,type)
        }

        bt_jiaruhuiyuan.clickWithTrigger{
            AddVipActivity.start(this)
        }



    }
}