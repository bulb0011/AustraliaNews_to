package com.ruanyun.australianews.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ruanyun.australianews.R;
import com.ruanyun.australianews.model.BuyInfo;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

import jiguang.chat.utils.ToastUtil;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
	
	private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";
	
    private IWXAPI api;
	public static final String WX_ID = "wxacdd7c584e315282";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result);
        
    	api = WXAPIFactory.createWXAPI(this, WX_ID);
        api.handleIntent(getIntent(), this);

    }

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
        api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq req) {
	}

	@Override
	public void onResp(BaseResp resp) {
		Log.d("dengpao", "onPayFinish, errCode = " + resp.errCode);

		if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
//			AlertDialog.Builder builder = new AlertDialog.Builder(this);
//			builder.setTitle(R.string.app_tip);
//			builder.setMessage(getString(R.string.pay_result_callback_msg, String.valueOf(resp.errCode)));
//			builder.show();

			if(resp.errCode == -2){
				ToastUtil.shortToast(this,"取消支付！");
			}else if (resp.errCode == 0){

				BuyInfo buyInfo=new BuyInfo();
				buyInfo.isBuy=1;
				EventBus.getDefault().post(buyInfo);

				ToastUtil.shortToast(this,"支付成功！");
			}else {
				ToastUtil.shortToast(this,"支付错误！");
			}

			this.finish();

		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}