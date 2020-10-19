package com.ruanyun.australianews.ui.my

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.model.DingYueKeCheng
import com.ruanyun.australianews.model.TextInfo
import com.ruanyun.australianews.ui.adapter.CurriculumAdapter
import kotlinx.android.synthetic.main.fragment_my_curriculum.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *课程
 */
class CurriculumFragment :BaseFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val mCurriculumView = inflater.inflate(R.layout.fragment_my_curriculum, container, false)

        return  mCurriculumView
    }

    var mDataListCurriculum: MutableList<TextInfo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    private val isVisibleToUser = false
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser)
        {
            ApiManger.getApiService().dingYueKeCehng(1, App.getInstance().userOid,100)
                .enqueue(object : Callback<DingYueKeCheng> {
                    override fun onFailure(call: Call<DingYueKeCheng>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<DingYueKeCheng>, response: Response<DingYueKeCheng>) {

                        val listData= response.body()!!.data.datas

                        listData[1].afnInfoAll

                        val layoutManager = LinearLayoutManager(context)

                        layoutManager.orientation = LinearLayoutManager.VERTICAL

                        rv_list.layoutManager = layoutManager

                        rv_list.isNestedScrollingEnabled = false

                        val adapter = context?.let { CurriculumAdapter(it, listData) }

                        rv_list.adapter=adapter
                    }
                })

        }
    }

}