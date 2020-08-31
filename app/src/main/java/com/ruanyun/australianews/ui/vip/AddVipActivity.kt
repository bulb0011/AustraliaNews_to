package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.util.C
import kotlinx.android.synthetic.main.activity_add_vip.*

class AddVipActivity :BaseActivity() {

    companion object{
        fun start(context: Context) {
            val starter = Intent(context, AddVipActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_add_vip)

        bt_add_vip.clickWithTrigger {
            SelectPayActivity.start(this, C.IntentKey.VIP_TYPE_ADD_VIP)
        }

    }
}