package com.ruanyun.australianews.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.model.ChannelInfo
import com.ruanyun.australianews.util.C
import kotlinx.android.synthetic.main.fragment_webview.webview


/**
 * A simple [Fragment] subclass.
 * Use the [WebviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WebviewFragment : BaseFragment() {

    private var channelInfo: ChannelInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        channelInfo = bundle?.getParcelable(C.IntentKey.CHANNEL_INFO)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initWebView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContentView = inflater.inflate(R.layout.fragment_webview, container, false)
        // Inflate the layout for this fragment
        return mContentView
    }

    fun initWebView(){
        val webSettings = webview.settings
        webSettings.javaScriptEnabled = true
//        webView.removeJavascriptInterface("searchBoxJavaBridge_")
        // init webview settings
        webSettings.allowContentAccess = true
        webSettings.databaseEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        webSettings.setAppCacheEnabled(false)
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        webSettings.setSupportZoom(true)
        webview.isVerticalScrollBarEnabled = false
        webview.isHorizontalScrollBarEnabled = false
        webview.isLongClickable = false

        val js="\$('.jin-timeline_title a').hide();"



        if("行情".equals(channelInfo?.title)){

            webview.loadUrl("http://afn.resolr.com/aozhoucaijing/hangqing/hangqing.html")
        }else if("7x24".equals(channelInfo?.title)){

            webview.loadUrl("https://www.jin10.com/example/jin10.com.html?fontSize=14px&theme=white")
        }


        webview.webViewClient = object : WebViewClient(){
            override fun onPageFinished(p0: WebView?, p1: String?) {
                super.onPageFinished(p0, p1)
                webview.evaluateJavascript(js, null)
            }
        }


    }

    fun getTitle():String{
        return channelInfo?.title?:""
    }
}