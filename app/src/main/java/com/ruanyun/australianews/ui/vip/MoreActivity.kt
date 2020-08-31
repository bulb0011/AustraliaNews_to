package com.ruanyun.australianews.ui.vip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.AttributeSet
import android.view.View
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.base.ResultBase
import com.ruanyun.australianews.data.ApiFailAction
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.data.ApiSuccessAction
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.model.HotInfo
import com.ruanyun.australianews.util.RxUtil
import kotlinx.android.synthetic.main.activity_vip_more.*

class MoreActivity :BaseActivity() {

    companion object{
        fun start(context: Context) {
            val starter = Intent(context, MoreActivity::class.java)
            context.startActivity(starter)
        }
    }



    private val mTitlesArrays =arrayOf("课程", "专栏", "付费新闻")

    private var mFragments = arrayListOf<Fragment>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.activity_vip_more)

        mFragments!!.add(MoreCourseFragment())
        mFragments!!.add(MoreSpecialColumnFragment())
        mFragments!!.add(MoerPayFragment())

        val pagerAdapter = MyPagerAdapter(supportFragmentManager, mFragments!!)
        vp.setAdapter(pagerAdapter)

        tab.setViewPager(vp, mTitlesArrays);//tab和ViewPager进行关联
        image_fanhui.clickWithTrigger { finish() }

    }

    private class MyPagerAdapter (fm: FragmentManager?, listData :List<Fragment>) : FragmentPagerAdapter(fm) {
        var listData :List<Fragment>

        init {
            this.listData=listData
        }

        override fun getCount(): Int {
            return listData.size
        }

        override fun getItem(position: Int): Fragment {
            return listData.get(position)
        }
    }

}