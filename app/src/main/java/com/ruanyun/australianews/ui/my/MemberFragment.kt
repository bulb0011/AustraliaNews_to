package com.ruanyun.australianews.ui.my

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.ui.adapter.MenberAdapter
import kotlinx.android.synthetic.main.fragment_member.*

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

    var mDataListMember: MutableList<String> = ArrayList()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.e("dengpao","######")

        val layoutManager = LinearLayoutManager(context)

        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rv_list_member.layoutManager = layoutManager

        rv_list_member.isNestedScrollingEnabled = false

        val adapter = context?.let { MenberAdapter(it, mDataListMember) }

        rv_list_member.adapter=adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataListMember.add("")
        mDataListMember.add("")
        mDataListMember.add("")
    }

}