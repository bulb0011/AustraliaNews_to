package com.ruanyun.australianews.ui.my

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.jpush.JsonParser
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.model.DingYueZhuanLan
import com.ruanyun.australianews.model.VIPSouSuoInfo
import com.ruanyun.australianews.ui.adapter.SpecialColumnAdapter
import com.ruanyun.australianews.ui.vip.SpecialColumnActivity
import kotlinx.android.synthetic.main.fragment_special_column.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * 专栏
 */
class SpecialColumnFragment :BaseFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val mSpecialColumnView = inflater.inflate(R.layout.fragment_special_column, container, false)

        return  mSpecialColumnView
    }

   lateinit var mDataListSpecialColumn: MutableList<String>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    private val isVisibleToUser = false
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        ApiManger.getApiService().dingYueKeCehngZhuanLan(3, App.getInstance().userOid,100)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                }
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                    val json = response.body()!!.string()

                    val je =JsonParser().parse(json)

                    val data = je.asJsonObject["data"].toString()

                    val gson = Gson()

                    val dingYueZhuanLan = gson.fromJson(data, DingYueZhuanLan::class.java)

                    val listData= dingYueZhuanLan.datas

                    if (listData!=null&&listData.size>0) {

                        tv_meiyoushuju.visibility=View.INVISIBLE
                        rv_list_specialcolumn.visibility=View.VISIBLE

                        val layoutManager = LinearLayoutManager(context)

                        layoutManager.orientation = LinearLayoutManager.VERTICAL

                        rv_list_specialcolumn.layoutManager = layoutManager

                        rv_list_specialcolumn.isNestedScrollingEnabled = false

                        val adapter = context?.let { SpecialColumnAdapter(it, listData) }

                        rv_list_specialcolumn.adapter=adapter

                        adapter!!.setOnCliakListener(object :SpecialColumnAdapter.OnCliskListener{
                            override fun onClisk(view: View?, po: Int) {

                                SpecialColumnActivity.start(mContext,listData[po].afnNewsColumn.oid)
                            }

                        })

                    } else {
                        tv_meiyoushuju.visibility=View.VISIBLE
                        rv_list_specialcolumn.visibility=View.INVISIBLE
                    }

                }
            })
    }

}