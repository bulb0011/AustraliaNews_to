package com.ruanyun.australianews.ui.my

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.ui.adapter.SpecialColumnAdapter
import kotlinx.android.synthetic.main.fragment_special_column.*

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

        val layoutManager = LinearLayoutManager(context)

        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rv_list_specialcolumn.layoutManager = layoutManager

        rv_list_specialcolumn.isNestedScrollingEnabled = false

        val adapter = context?.let { SpecialColumnAdapter(it, mDataListSpecialColumn) }

        rv_list_specialcolumn.adapter=adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mDataListSpecialColumn  = ArrayList()

        if (mDataListSpecialColumn.size==0) {
            mDataListSpecialColumn.add("")
            mDataListSpecialColumn.add("")
            mDataListSpecialColumn.add("")
        }
    }

}