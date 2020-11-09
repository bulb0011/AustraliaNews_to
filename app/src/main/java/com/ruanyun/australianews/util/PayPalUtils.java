package com.ruanyun.australianews.util;

import android.app.Activity;
import android.content.Intent;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import java.math.BigDecimal;

public class PayPalUtils {

//        private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
        private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_NO_NETWORK;;
//    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_PRODUCTION;
    private static PayPalConfiguration config;
    private static final int REQUEST_CODE_PAY_PAL = 111;
    private static final PayPalUtils PAY_PAL_UTILS = new PayPalUtils();
    private static Activity activity;
    private static Back back;

    private PayPalUtils() {
    }

    public static PayPalUtils newInstance(Activity mActivity, String clientId, Back mBack) {
        activity = mActivity;
        back = mBack;
        Intent intent = new Intent(activity, PayPalService.class);
        config = new PayPalConfiguration()
                .environment(CONFIG_ENVIRONMENT)
                .clientId(clientId);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        activity.startService(intent);
        return PAY_PAL_UTILS;
    }

    //价格，货币码(如：USD)，AUD(澳元) CNY（人民币） 商品名
    //价格，货币，商品名称，订单号
    public void startPay(BigDecimal price, String currentcy, String goodsName, String orderNumber) 			{

        PayPalPayment payment =  new PayPalPayment(price, currentcy, goodsName,
                PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(activity, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
        activity.startActivityForResult(intent, REQUEST_CODE_PAY_PAL);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PAY_PAL && back != null) {
            if (resultCode == Activity.RESULT_OK) {
                PaymentConfirmation paymentResult =
                        data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                back.onResult(paymentResult, paymentResult == null ? "payment result is null." : 			null);
            } else if (resultCode == Activity.RESULT_CANCELED) {
                back.onResult(null, "user canceled.");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                back.onResult(null, "An invalid Payment or PayPalConfiguration was submitted");
            } else {
                back.onResult(null, "unknow error.");
            }
        }
    }

    public void onDestroy() {
        if (activity != null) {
            activity.stopService(new Intent(activity, PayPalService.class));
        }
        activity = null;
        back = null;
    }

    public interface Back {
        public void onResult(PaymentConfirmation paymentResult, String errorMsg);
    }

}
