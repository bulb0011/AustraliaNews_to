package com.ruanyun.australianews.ui.vip;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.jpush.JsonElement;
import com.google.gson.jpush.JsonParser;
import com.ruanyun.australianews.R;
import com.ruanyun.australianews.base.BaseActivity;
import com.ruanyun.australianews.data.ApiManger;
import com.ruanyun.australianews.model.VIPSouSuoInfo;
import com.ruanyun.australianews.ui.WebViewActivity;
import com.ruanyun.australianews.ui.adapter.SouSuoAdapter;
import com.ruanyun.australianews.util.C;

import java.io.IOException;
import java.util.List;

import jiguang.chat.utils.ToastUtil;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShouSuoActivity extends BaseActivity {

    private EditText et_search;
    private ImageView iv_back;
    private TextView tv_search;
    private RecyclerView rv_list;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sousuo);

        et_search =(EditText) findViewById(R.id.et_search);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_search = (TextView) findViewById(R.id.tv_search);
        rv_list = (RecyclerView) findViewById(R.id.rv_list);

        initEvent();
    }

    String content;

    void initEvent(){

        tv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content= et_search.getText().toString().trim();

                if (!TextUtils.isEmpty(content)){
                    Sousuo(content);
                }else
                    ToastUtil.shortToast(mContext,"搜索为空！");

                //隐藏软键盘
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);

            }
        });

        et_search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){

                    content= et_search.getText().toString().trim();

                    if (!TextUtils.isEmpty(content)){
                        Sousuo(content);
                    }else
                        ToastUtil.shortToast(mContext,"搜索为空！");

                    //隐藏软键盘
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                }
                return false;
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShouSuoActivity.this.finish();
            }
        });

    }

    void Sousuo(String content) {

        ApiManger.getApiService().vipSouSuo(content, 100)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        try {

                          String json =  response.body().string();

                          JsonElement je = new JsonParser().parse(json);

                          String data =je.getAsJsonObject().get("data").toString();

                          Gson gson= new Gson();

                          VIPSouSuoInfo vipSouSuoInfo= gson.fromJson(data, VIPSouSuoInfo.class);

                          List<VIPSouSuoInfo.DatasEntity> datas =  vipSouSuoInfo.getDatas();

                            SouSuoAdapter souSuoAdapter;

                        if (datas!=null && datas.size()>0) {

                            souSuoAdapter = new SouSuoAdapter(ShouSuoActivity.this,datas);

                            LinearLayoutManager layoutManager =new  LinearLayoutManager(mContext);
                            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            rv_list.setLayoutManager(layoutManager);
                            rv_list.setNestedScrollingEnabled(false);

                            rv_list.setAdapter(souSuoAdapter);

                            souSuoAdapter.setOnCliakListener(new SouSuoAdapter.OnCliskListener() {
                                @Override
                                public void onClisk(View view, int i) {

                                    VIPSouSuoInfo.DatasEntity Entity =  datas.get(i);
                                    if (Entity.getDataType()==1){
                                        String s="";
                                        if (Entity.getContentType()==1){

                                            s= C.IntentKey.VIP_TYPE_PDF;
                                        }else if (Entity.getContentType()==2){

                                            s=C.IntentKey.VIP_TYPE_VIDEO;
                                        }else if (Entity.getContentType()==3){

                                            s=C.IntentKey.VIP_TYPE_MP3;
                                        }

                                        Intent starter =new Intent(mContext, VipDetailsActivity.class);
                                        starter.putExtra("type",s);
                                        starter.putExtra("id",Entity.getOid());
                                        mContext.startActivity(starter);

                                    }else  if (Entity.getDataType()==2){

                                        Intent starter =new Intent(mContext, WebViewActivity.class);
                                        starter.putExtra(C.IntentKey.WEB_VIEW_URL,Entity.getBaseUrl());
                                        mContext.startActivity(starter);

                                    } else if (Entity.getDataType()==3){
                                        Intent starter =new Intent(mContext, SpecialColumnActivity.class);
                                        starter.putExtra("columnOid",Entity.getOid());
                                        mContext.startActivity(starter);

                                    }
//


                                }

                            });

                        } else {
                            ToastUtil.shortToast(ShouSuoActivity.this,"搜索无内容！");
                        }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

    }
}
