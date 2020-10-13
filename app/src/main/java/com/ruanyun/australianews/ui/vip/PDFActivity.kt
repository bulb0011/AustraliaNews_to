package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.listener.OnRenderListener
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.model.NewsDirectoryDetails
import com.ruanyun.australianews.util.C
import kotlinx.android.synthetic.main.activity_pdf.*
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PDFActivity :BaseActivity() {

    companion object{

        fun start(context: Context,infoId:String) {
            val starter = Intent(context, PDFActivity::class.java)
            starter.putExtra("infoId",infoId)
            context.startActivity(starter)
        }

    }


    private val handler = Handler()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_pdf)

        initDta(infoId = intent.getStringExtra("infoId"))


        topbar.setTopBarClickListener(this)

    }

    fun initDta(infoId:String){

        showLoading()

        ApiManger.getApiService().getVipNewInfoDirectoryDetails(infoId, App.getInstance().userOid)
            .enqueue(object : Callback<NewsDirectoryDetails> {
                override fun onFailure(call: Call<NewsDirectoryDetails>, t: Throwable) {

                }

                override fun onResponse(call: Call<NewsDirectoryDetails>, response: Response<NewsDirectoryDetails>) {

                    val detailIfo=response!!.body()!!.data

//                    setViewData(detailIfo)

                    initPTF(ApiManger.IMG_URL+detailIfo.fileUrl)

                }
            })
    }

    override fun onTopBarRightImgClick() {
        super.onTopBarRightImgClick()
    }

   fun initPTF(fileurl:String){

       Log.e("dengpao",fileurl)


       Thread(Runnable {
            try {
                val url =
                    URL(fileurl)
                val connection =
                    url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.doInput = true
                connection.connectTimeout = 10000
                connection.readTimeout = 10000
                connection.connect()
                if (connection.responseCode == 200) {
                    val `is` = connection.inputStream
                    handler.post(Runnable {
                        pdfView.fromStream(`is`)
                            .swipeHorizontal(true) //设置不可水平滑动
                            .enableAnnotationRendering(true) //设置翻页监听
                            .onPageChange(OnPageChangeListener { page, pageCount ->

                                Log.e("dengpao","sss" + "页数：" + (page + 1) + "/" + pageCount)

                                if ((page+1)==pageCount){
                                    FinishActivity.start(this, C.IntentKey.VIP_TYPE_PDF)
                                }

                            }) //设置每一页适应屏幕宽，默认适应屏幕高
                            .onRender(OnRenderListener {nbPages,pageWidth,pageHeight->
                                pdfView.fitToWidth();
                            })
                            .onLoad(OnLoadCompleteListener {
                                Log.e("dengpo","加载完成")
                                disMissLoading()
                            })
                            .load()
                    })
                } else {
                    Log.e("dengpao", "sss" + connection.responseCode)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }).start()
    }

    override fun onTopBarRightTextClick() {
        super.onTopBarRightTextClick()
        SelectPayActivity.start(this,C.IntentKey.VIP_TYPE_PDF)
    }


}