package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.widget.CommonDialog
import jiguang.chat.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_select_pay.*

class SelectPayActivity :BaseActivity() {

    companion object{
        fun start(context: Context,type :String) {
            val starter = Intent(context, SelectPayActivity::class.java)
            starter.putExtra("type",type)
            context.startActivity(starter)
        }
    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_select_pay)

        val type=intent.getStringExtra("type")

        if (C.IntentKey.VIP_TYPE_ADD_VIP.equals(type)){
            rl_add_vip.visibility=View.VISIBLE
            rl_merchandise.visibility=View.GONE
        }else{
            rl_add_vip.visibility=View.GONE
            rl_merchandise.visibility=View.VISIBLE
        }

        topbar.setTopBarClickListener(this)

        initEvent()



    }

    fun initEvent(){

        fl_wenxin.clickWithTrigger {
            ckb_wenxin.isChecked=true
            ckb_zhifubao.isChecked=false
            ckb_paypal.isChecked=false
        }
        fl_zhifubao.clickWithTrigger {
            ckb_wenxin.isChecked=false
            ckb_zhifubao.isChecked=true
            ckb_paypal.isChecked=false
        }
        fl_paypal.clickWithTrigger {
            ckb_wenxin.isChecked=false
            ckb_zhifubao.isChecked=false
            ckb_paypal.isChecked=true
        }

    }

    override fun onTopBarLeftImgClick() {
        ToastUtil.shortToast(this, "退出")

       val commondialog=CommonDialog(this).showDialog(R.layout.dialog_jiesuantai)

        commondialog.setOnClickListener(R.id.bt_likao, object :View.OnClickListener{
            override fun onClick(v: View?) {

                ToastUtil.shortToast(this@SelectPayActivity, "确认离开")
                commondialog.dismiss()
                this@SelectPayActivity.finish()
            }

        })

        commondialog.setOnClickListener(R.id.bt_jixuzhifu, object :View.OnClickListener{
            override fun onClick(v: View?) {
                ToastUtil.shortToast(this@SelectPayActivity, "继续支付")

                commondialog.dismiss()
            }

        })

    }

}