package com.ruanyun.australianews.ui.vip

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.model.VipColumnInfo
import com.ruanyun.australianews.ui.adapter.MoreSpecialColumnAdapter
import kotlinx.android.synthetic.main.fragment_more_special_column.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response

class MoreSpecialColumnFragment :BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more_special_column,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        //专栏数据
//        ApiManger.getApiService().getVipNewColumnListTo().compose(RxUtil.normalSchedulers())
//            .subscribe(object : ApiSuccessAction<ResultBase<VipColumnInfo>>() {
//                override fun onSuccess(result: ResultBase<VipColumnInfo>) {
////                   val  hotinfo=GsonUtil.parseJson(result.data.toString(),HotInfo::class.java)
//
//                    val  vipColumnInfo =  result.data.datas
//
//                    val layoutManager = LinearLayoutManager(context)
//
//                    layoutManager.orientation = LinearLayoutManager.VERTICAL
//
//                    rv_mores_pecial_column_list.layoutManager = layoutManager
//
//                    rv_mores_pecial_column_list.isNestedScrollingEnabled = false
//
//                    val adapter = context?.let { MoreSpecialColumnAdapter(it, vipColumnInfo) }
//
//                    rv_mores_pecial_column_list.adapter=adapter
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


///专栏数据
        ApiManger.getApiService().getVipNewColumnList(2,100)
            . enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    response.body().toString()

                    val jsonStr = String(response.body()!!.bytes()) //把原始数据转为字符串

                    val JSONObject = JSONObject(jsonStr)

                    val datajson = JSONObject.getJSONObject("data")

                    val dataArr = datajson.getJSONArray("datas")

                    val dataList=ArrayList<VipColumnInfo.DatasBean>()

                    for (i in 0 until dataArr.length()) {

                        val ColumnInfo = VipColumnInfo.DatasBean()

                        ColumnInfo.oid= dataArr.getJSONObject(i).getString("oid")

                        ColumnInfo.title=dataArr.getJSONObject(i).getString("title")

                        val afnInfoAllList = dataArr.getJSONObject(i).getJSONArray("afnInfoAllList")

                        val dataBean=ArrayList<VipColumnInfo.DatasBean.AfnInfoAllListBean>()

                        for (j in 0 until afnInfoAllList.length()) {

                            val  ListBean=VipColumnInfo.DatasBean.AfnInfoAllListBean()

                            ListBean.title= afnInfoAllList.getJSONObject(j).getString("title")

                            ListBean.mainPhoto=afnInfoAllList.getJSONObject(j).getString("mainPhoto")
                            ListBean.columnOid = afnInfoAllList.getJSONObject(j).getString("mainPhoto")
                            dataBean.add(ListBean)

                        }

                        ColumnInfo.afnInfoAllList=dataBean

                        dataList.add(ColumnInfo)


                    }
                    val layoutManager = LinearLayoutManager(context)

                    layoutManager.orientation = LinearLayoutManager.VERTICAL

                    rv_mores_pecial_column_list.layoutManager = layoutManager

                    rv_mores_pecial_column_list.isNestedScrollingEnabled = false

                    val adapter = context?.let { MoreSpecialColumnAdapter(it, dataList) }

                    rv_mores_pecial_column_list.adapter=adapter

                    adapter?.setOnCliakListener(object : MoreSpecialColumnAdapter.OnCliskListener{
                        override fun onClisk(view: View?, po: Int, id: String) {

                            SpecialColumnActivity.start(mContext,id)
                        }
                    })

                }
            })



    }

}