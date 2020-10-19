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
import com.ruanyun.australianews.ui.adapter.MenberAdapter
import kotlinx.android.synthetic.main.fragment_member.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/**
 * 会员
 */
class MemberFragment :BaseFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mContentView = inflater.inflate(R.layout.fragment_member, container, false)

        return  mContentView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val isVisibleToUser = false
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        ApiManger.getApiService().dingYueKeCehng(2, App.getInstance().userOid,100)
            .enqueue(object : Callback<DingYueKeCheng> {
                override fun onFailure(call: Call<DingYueKeCheng>, t: Throwable) {

                }

                override fun onResponse(call: Call<DingYueKeCheng>, response: Response<DingYueKeCheng>) {
                    val listData= response.body()!!.data.datas

                    val layoutManager = LinearLayoutManager(context)

                    layoutManager.orientation = LinearLayoutManager.VERTICAL

                    rv_list_member.layoutManager = layoutManager

                    rv_list_member.isNestedScrollingEnabled = false

                    val adapter = context?.let { MenberAdapter(it, listData) }

                    rv_list_member.adapter=adapter
                }
            })
    }

}