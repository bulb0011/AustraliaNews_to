package com.ruanyun.australianews.ui.vip

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.model.TextNewInfo
import com.ruanyun.australianews.ui.adapter.MorePayAdapter
import com.ruanyun.australianews.util.WebViewUrlUtil
import kotlinx.android.synthetic.main.fragment_more_pay.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoerPayFragment : BaseFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more_pay,container,false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        //最下面的新闻
//        ApiManger.getApiService().getNewsInfoByNewsType(App.app.cityName,App.app.userOid).compose(
//            RxUtil.normalSchedulers())
//            .subscribe(object : ApiSuccessAction<ResultBase<NewsInfoNewsInfo>>() {
//                override fun onSuccess(result: ResultBase<NewsInfoNewsInfo>) {
//
//                    val  vipColumnInfo =  result.data.datas
//
//                    val layoutManager = LinearLayoutManager(context)
//
//                    layoutManager.orientation = LinearLayoutManager.VERTICAL
//
//                    rv_more_pay_list.layoutManager = layoutManager
//
//                    rv_more_pay_list.isNestedScrollingEnabled = false
//
//                    val adapter = context?.let { MorePayAdapter(it, vipColumnInfo) }
//
//                    rv_more_pay_list.adapter=adapter
//
//                    if (adapter != null) {
//                        adapter.setOnCliakListener(object : MorePayAdapter.OnCliskListener{
//                            override fun onClisk(view: View?,i:Int) {
//
//                                val objInfo= vipColumnInfo[i]
//
//                                WebViewUrlUtil.showVIPNewsWeb(mContext,objInfo.title,objInfo.mainPhoto,objInfo.oid,objInfo.createTime)
//
//                            }
//                        })
//                    }
//
//                }
//                override fun onError(erroCode: Int, erroMsg: String) {
////                disMissLoading()
//                    showToast(erroMsg)
//                }
//            }, object : ApiFailAction() {
//                override fun onFail(msg: String) {
////                disMissLoading()
//                    showToast(msg)
//                }
//            })
//

        ApiManger.getApiService().getNewsInfoByNewsType(App.app.cityName,App.app.userOid,100)
            .enqueue(object : Callback<TextNewInfo> {
                override fun onFailure(call: Call<TextNewInfo>, t: Throwable) {

                }

                override fun onResponse(call: Call<TextNewInfo>, response: Response<TextNewInfo>) {

                    val   data =  response.body()!!.data
                    val  vipColumnInfo =  data.datas

                    val layoutManager = LinearLayoutManager(context)

                    layoutManager.orientation = LinearLayoutManager.VERTICAL

                    rv_more_pay_list.layoutManager = layoutManager

                    rv_more_pay_list.isNestedScrollingEnabled = false

                    val adapter = context?.let { MorePayAdapter(it, vipColumnInfo) }

                    rv_more_pay_list.adapter=adapter

                    if (adapter != null) {
                        adapter.setOnCliakListener(object : MorePayAdapter.OnCliskListener{
                            override fun onClisk(view: View?,i:Int) {

                                val objInfo= vipColumnInfo[i]

                                WebViewUrlUtil.showVIPNewsWeb(mContext,objInfo.title,objInfo.mainPhoto,objInfo.oid,objInfo.createTime)

                            }
                        })
                    }

                }


            })




    }
}