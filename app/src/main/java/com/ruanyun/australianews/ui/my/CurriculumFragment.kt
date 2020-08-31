package com.ruanyun.australianews.ui.my

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.model.TextInfo
import com.ruanyun.australianews.ui.adapter.CurriculumAdapter
import kotlinx.android.synthetic.main.fragment_my_curriculum.*

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

        val textInfo=TextInfo()
        textInfo.image="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596884551038&di=90018cf0bd3eea6254255d5f7b64bacd&imgtype=0&src=http%3A%2F%2Fbos.pgzs.com%2Frbpiczy%2FWallpaper%2F2013%2F2%2F21%2F924e9018181449b78f6659d050079fee-3.jpg"
        textInfo.title="这是一个标题"
        textInfo.type=1
        val textInfo1=TextInfo()
        textInfo1.image="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596884474667&di=3a8ba4285e059d9f9e4368ca2f10bedb&imgtype=0&src=http%3A%2F%2Ffile.digitaling.com%2FeImg%2Fuimages%2F20150824%2F1440412608821067.jpg"
        textInfo1.title="这是一个标题"
        textInfo1.type=2
        val textInfo2=TextInfo()
        textInfo2.image="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596884551038&di=90018cf0bd3eea6254255d5f7b64bacd&imgtype=0&src=http%3A%2F%2Fbos.pgzs.com%2Frbpiczy%2FWallpaper%2F2013%2F2%2F21%2F924e9018181449b78f6659d050079fee-3.jpg"
        textInfo2.title="这是一个标题"
        textInfo2.type=3
        mDataListCurriculum.add(textInfo)
        mDataListCurriculum.add(textInfo1)
        mDataListCurriculum.add(textInfo2)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val layoutManager = LinearLayoutManager(context)

        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rv_list.layoutManager = layoutManager

        rv_list.isNestedScrollingEnabled = false

        val adapter = context?.let { CurriculumAdapter(it, mDataListCurriculum) }

        rv_list.adapter=adapter

    }

}