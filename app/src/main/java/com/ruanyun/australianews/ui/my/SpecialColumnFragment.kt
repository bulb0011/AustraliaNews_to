package com.ruanyun.australianews.ui.my

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.model.DingYueKeCheng
import com.ruanyun.australianews.model.DingYueZhuanLan
import com.ruanyun.australianews.ui.adapter.SpecialColumnAdapter
import kotlinx.android.synthetic.main.fragment_special_column.*
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
            .enqueue(object : Callback<DingYueZhuanLan> {
                override fun onFailure(call: Call<DingYueZhuanLan>, t: Throwable) {

                }

                override fun onResponse(call: Call<DingYueZhuanLan>, response: Response<DingYueZhuanLan>) {

                    val listData= response.body()!!.data.datas

                    val layoutManager = LinearLayoutManager(context)

                    layoutManager.orientation = LinearLayoutManager.VERTICAL

                    rv_list_specialcolumn.layoutManager = layoutManager

                    rv_list_specialcolumn.isNestedScrollingEnabled = false

                    val adapter = context?.let { SpecialColumnAdapter(it, listData) }

                    rv_list_specialcolumn.adapter=adapter

                }
            })
    }

}