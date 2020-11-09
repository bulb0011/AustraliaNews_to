package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.google.gson.Gson
import com.paypal.android.sdk.payments.PayPalService
import com.paypal.android.sdk.payments.PaymentConfirmation
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ext.loadImage
import com.ruanyun.australianews.model.*
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.PayPalHelper
import com.ruanyun.australianews.util.PayPalUtils
import com.ruanyun.australianews.util.ThirdPayMgr
import com.ruanyun.australianews.widget.CommonDialog
import com.ruanyun.australianews.wxapi.WXPayEntryActivity
import com.tencent.mm.opensdk.modelpay.PayReq
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import jiguang.chat.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_select_pay.*
import okhttp3.ResponseBody
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigDecimal
import java.text.DecimalFormat

class SelectPayActivity :BaseActivity() {

    companion object{
        fun start(context: Context,type :String) {
            val starter = Intent(context, SelectPayActivity::class.java)
            starter.putExtra("type",type)
            context.startActivity(starter)
        }

        fun start(context: Context,productType :Int, productOid:String) {
            val starter = Intent(context, SelectPayActivity::class.java)
            starter.putExtra("productType",productType)
            starter.putExtra("productOid",productOid)
            context.startActivity(starter)
        }

        fun start(context: Context,productType :Int, productOid:String, jiage : String) {
            val starter = Intent(context, SelectPayActivity::class.java)
            starter.putExtra("productType",productType)
            starter.putExtra("productOid",productOid)
            starter.putExtra("jige",jiage)
            context.startActivity(starter)
        }

        fun start(context:Context, productType:Int, productOid:String,
                  inamge_url:String,price_Type:Int, jige:String,zhiqianjiage:String, tv_label:String, tv_title:String) {
            val starter = Intent(context, SelectPayActivity::class.java)
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

        val iso=App.app.iso
    }

    var  productType=0
    var  productOid=""
    var  payAmountType=0
    var payWay = 1;
    private var thirdPayMgr: ThirdPayMgr? = null
    private var mWeChatApi: IWXAPI? = null
    var jiage=""

   var currentcy="AUD"
   var jjj=0.00
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_select_pay)

        productType=intent.getIntExtra("productType",4)
        productOid=intent.getStringExtra("productOid")

        jjj=intent.getStringExtra("jige").toDouble()

        payAmountType = 1;
        initPayPal()
        //国内
        if(iso=="cn"||iso=="CN"){
            payAmountType=1
            jiage="¥"
            currentcy="CNY"
        }
        //澳洲
        else if(iso=="au"|| iso=="AU") {
            payAmountType=3
            jiage="A$"
            currentcy="AUD"

            fl_wenxin.visibility=View.GONE
        }
        //其他地区
        else{
            payAmountType=3
            jiage="A$"
            currentcy="AUD"
            fl_wenxin.visibility=View.GONE
        }


        if (productType == 4){
            rl_add_vip.visibility=View.VISIBLE
            rl_merchandise.visibility=View.GONE
            vip_jiguang.text=jiage+intent.getStringExtra("jige")
            tv_jine.text=jiage+intent.getStringExtra("jige")
        }else{
            rl_add_vip.visibility=View.GONE
            rl_merchandise.visibility=View.VISIBLE

            val inamge_url= intent.getStringExtra("inamge_url")
            val tv_titl= intent.getStringExtra("tv_title")
            val  price_Type=intent.getIntExtra("price_Type",1)
            val jige_to= intent.getStringExtra("jige")
            val zhiqianjiage =intent.getStringExtra("zhiqianjiage")
            val tvlabel= intent.getStringExtra("tv_label")

            tv_title.text=tv_titl
            iv_pic.loadImage(inamge_url)
            tv_label.text=tvlabel


            //价格正常
            if (price_Type==1){

                zhiqianjiege.paint.isAntiAlias=false
                zhiqianjiege.visibility= View.GONE
                tv_jiage_to.text=jiage+jige_to
                tv_jine.text=jiage+jige_to

            }else if (price_Type==2){
                zhiqianjiege.visibility= View.VISIBLE
                zhiqianjiege.paint.isAntiAlias=true
                zhiqianjiege.paint.flags= Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

                zhiqianjiege.text = zhiqianjiage
                tv_jiage_to.text = jiage+jige_to
                tv_jine.text=jiage+jige_to

            }else{
                zhiqianjiege.visibility= View.VISIBLE
                zhiqianjiege.paint.isAntiAlias=true
                zhiqianjiege.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG

                zhiqianjiege.text = zhiqianjiage
                tv_jiage_to.text = jiage+jige_to
                tv_jine.text=jiage+jige_to

            }

        }

        topbar.setTopBarClickListener(this)
        initEvent()
        ckb_wenxin.isChecked=true

        PayPalHelper.getInstance().stopPayPalService(this);

    }

    fun initEvent(){

        fl_wenxin.clickWithTrigger {
            ckb_wenxin.isChecked=true
            ckb_zhifubao.isChecked=false
            ckb_paypal.isChecked=false
            payWay=1
        }

        ckb_wenxin.clickWithTrigger{
            ckb_wenxin.isChecked=true
            ckb_zhifubao.isChecked=false
            ckb_paypal.isChecked=false
            payWay=1
        }

        fl_zhifubao.clickWithTrigger {
            ckb_wenxin.isChecked=false
            ckb_zhifubao.isChecked=true
            ckb_paypal.isChecked=false
            payWay=2
        }

        ckb_zhifubao.clickWithTrigger {
            ckb_wenxin.isChecked=false
            ckb_zhifubao.isChecked=true
            ckb_paypal.isChecked=false
            payWay=2
        }

        fl_paypal.clickWithTrigger {
            ckb_wenxin.isChecked=false
            ckb_zhifubao.isChecked=false
            ckb_paypal.isChecked=true
            payWay=3
        }

        ckb_paypal.clickWithTrigger {
            ckb_wenxin.isChecked=false
            ckb_zhifubao.isChecked=false
            ckb_paypal.isChecked=true
            payWay=3
        }

        tb_zhifu.clickWithTrigger {
            if (payWay==1){
                WxPay()
            }else if (payWay==2){
                alipayPay()
            }else if (payWay==3){
                payPal()

            }
        }

    }
  lateinit var  payPalUtils: PayPalUtils

    fun payPal(){

        if(payAmountType==1){
            ToastUtil.shortToast(mContext,"PayPal不支持人民币")
            return
        }
        ApiManger.getApiService().afnAppPayPayPal(productType, productOid,payAmountType,payWay,App.getInstance().userOid)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    val json = response.body()!!.string()

                    val gson = Gson()

                    val data = gson.fromJson(json, PayPalInfo::class.java)

                    if (TextUtils.isEmpty(data.data.id)){
                        ToastUtil.shortToast(this@SelectPayActivity,"参数错误")
                        return
                    }

                    val df = DecimalFormat("#0.00")

                    payPalUtils.startPay(BigDecimal(df.format(jjj)), currentcy, data.data.purchase_units[0].soft_descriptor,data.data.id)
                }
            })
    }

//   fun afnAppPayPayPal(){
//       ApiManger.getApiService().afnAppPayPayPal(productType, productOid,payAmountType,payWay,App.getInstance().userOid)
//           .enqueue(object : Callback<PayPalInfo> {
//               override fun onFailure(call: Call<PayPalInfo>, t: Throwable) {
//               }
//               override fun onResponse(
//                   call: Call<PayPalInfo>,
//                   response: Response<PayPalInfo>
//               ) {
//                   PayPalHelper.getInstance().doPayPalPay(mContext);
//               }
//            })
//    }
    fun alipayPay(){

        if(iso=="cn"||iso=="CN"){
            ChAlipayPay()
        }else{
            AlipayPay()
        }



    }

   fun AlipayPay(){
       ApiManger.getApiService().afnAppPay(productType, productOid,payAmountType,payWay,App.getInstance().userOid)
           .enqueue(object : Callback<ResponseBody> {
               override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
               }
               override fun onResponse(
                   call: Call<ResponseBody>,
                   response: Response<ResponseBody>
               ) {

                   val json = response.body()!!.string()

                   val gson = Gson()

                   val data = gson.fromJson(json, AliPayInfo::class.java)

                   if (TextUtils.isEmpty(data.data.order_string)){
                       ToastUtil.shortToast(this@SelectPayActivity,"参数错误")
                       return
                   }

                   val datas=data.data?.order_string

                   if (thirdPayMgr == null) {
                       thirdPayMgr = ThirdPayMgr()
                   }

                   thirdPayMgr!!.alipay(this@SelectPayActivity, datas, object : ThirdPayMgr.payCallback {
                       override fun onPaySuccess() {
                           val buyInfo = BuyInfo()
                           buyInfo.isBuy = 1
                           EventBus.getDefault().post(buyInfo)
                           ToastUtil.shortToast(this@SelectPayActivity,"支付成功")
                           this@SelectPayActivity.finish()
                       }

                       override fun onPayCancel() {
                           ToastUtil.shortToast(this@SelectPayActivity,"支付取消")
                       }

                       override fun onPayFail(msg: String) {
                           ToastUtil.shortToast(this@SelectPayActivity,"支付失败")
                       }
                   })

               }
           })
   }

    fun ChAlipayPay(){
        ApiManger.getApiService().afnAppPay(productType, productOid,payAmountType,payWay,App.getInstance().userOid)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    val json = response.body()!!.string()

                    val gson = Gson()

                    val data = gson.fromJson(json, PayInfo::class.java)

                    if (TextUtils.isEmpty(data.data.body)){
                        ToastUtil.shortToast(this@SelectPayActivity,"参数错误")
                        return
                    }

                    val datas=data.data?.body

                    if (thirdPayMgr == null) {
                        thirdPayMgr = ThirdPayMgr()
                    }

                    thirdPayMgr!!.alipay(this@SelectPayActivity, datas, object : ThirdPayMgr.payCallback {
                        override fun onPaySuccess() {
                            val buyInfo = BuyInfo()
                            buyInfo.isBuy = 1
                            EventBus.getDefault().post(buyInfo)
                            ToastUtil.shortToast(this@SelectPayActivity,"支付成功")
                            this@SelectPayActivity.finish()
                        }

                        override fun onPayCancel() {
                            ToastUtil.shortToast(this@SelectPayActivity,"支付取消")
                        }

                        override fun onPayFail(msg: String) {
                            ToastUtil.shortToast(this@SelectPayActivity,"支付失败")
                        }
                    })

                }
            })
    }

    fun WxPay(){
        ApiManger.getApiService().afnAppPayWx(productType, productOid,payAmountType,payWay,App.getInstance().userOid)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }
                override fun onResponse(call: Call<ResponseBody>,response: Response<ResponseBody>) {

                    val json = response.body()!!.string()

                    val gson = Gson()

                    val data = gson.fromJson(json, PayInfoWx::class.java)

                    if (TextUtils.isEmpty(data.data.getWxPayParam().partnerid)){
                        ToastUtil.shortToast(this@SelectPayActivity,"参数错误")
                        return
                    }

                    if (mWeChatApi == null) {
                        mWeChatApi = WXAPIFactory.createWXAPI(App.getInstance().applicationContext, null)
                    }

                   val wxpayparam=data.data.getWxPayParam();

                    val req = PayReq()
                    //应用ID
                    req.appId = WXPayEntryActivity.WX_ID
                    //商户号
                    req.partnerId = wxpayparam.partnerid
                    //预支付交易会话ID
                    req.prepayId = wxpayparam.prepayid

                    //扩展字段
                    req.packageValue = "Sign=WXPay"
                    //随机字符串
                    req.nonceStr = wxpayparam.noncestr
                    //时间戳
                    req.timeStamp = wxpayparam.timestamp
                    //签名
                    req.sign = wxpayparam.sign
                    mWeChatApi!!.sendReq(req)

                    this@SelectPayActivity.finish()
                }
            })
    }

    override fun onTopBarLeftImgClick() {

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        payPalUtils.onActivityResult(requestCode, resultCode, data);

//        PayPalHelper.getInstance().confirmPayResult(mContext, requestCode, resultCode, data,object:PayPalHelper.DoResult{
//            override fun invalidPaymentConfiguration() {
//            }
//
//            override fun confirmSuccess(id: String?) {
//                ToastUtil.shortToast(this@SelectPayActivity,"支付成功" + id);
//            }
//            override fun confirmFuturePayment() {
//            }
//
//            override fun confirmNetWorkError() {
//                ToastUtil.shortToast(this@SelectPayActivity,"支付失败");
//            }
//
//            override fun customerCanceled() {
//                ToastUtil.shortToast(this@SelectPayActivity,"支付取消");
//            }
//
//        })
    }

    fun initPayPal(){
        payPalUtils= PayPalUtils.newInstance(this
            , C.CONFIG_CLIENT_ID//此处为paypalclientid
            , object : PayPalUtils.Back {
                override fun onResult(paymentResult: PaymentConfirmation?, errorMsg: String?) {
                    if (errorMsg != null) {
                        ToastUtil.shortToast(this@SelectPayActivity,"支付失败")
                    } else if (paymentResult != null && paymentResult.proofOfPayment != null && paymentResult.proofOfPayment.paymentId != null
                    ) {

                        //订单号，上传至服务器校验
                        val paymentId =
                            paymentResult.proofOfPayment.paymentId
                        val buyInfo = BuyInfo()
                        buyInfo.isBuy = 1
                        EventBus.getDefault().post(buyInfo)
                        ToastUtil.shortToast(this@SelectPayActivity,"支付成功")
                        this@SelectPayActivity.finish()

                    } else {

                        ToastUtil.shortToast(this@SelectPayActivity,"支付取消")
                    }
                }

            })

    }

    override fun onDestroy() {
        stopService(Intent(this, PayPalService::class.java))
        if(payPalUtils!=null)
            payPalUtils.onDestroy()
        super.onDestroy()

    }

}