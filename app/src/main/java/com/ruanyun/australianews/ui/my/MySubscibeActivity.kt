package com.ruanyun.australianews.ui.my

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseActivity
import com.ruanyun.australianews.ext.clickWithTrigger
import com.ruanyun.australianews.ui.main.SearchActivity
import kotlinx.android.synthetic.main.ativity_my_subscibe.*


class MySubscibeActivity :BaseActivity() {
    companion object {
        fun start(context: Context) {
            val starter = Intent(context, MySubscibeActivity::class.java)
            context.startActivity(starter)
        }
    }
    private val mTitlesArrays =arrayOf("课程", "专栏", "VIP会员")

    private var mFragments: ArrayList<Fragment>? = null

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.ativity_my_subscibe)

        mFragments = ArrayList()

        mFragments!!.add(CurriculumFragment())
        mFragments!!.add(SpecialColumnFragment())
        mFragments!!.add(MemberFragment())

        val pagerAdapter = MyPagerAdapter(supportFragmentManager, mFragments!!)
        vp.setAdapter(pagerAdapter)

        tab.setViewPager(vp, mTitlesArrays);//tab和ViewPager进行关联

        fenxiang.clickWithTrigger { SearchActivity.start(mContext, SearchActivity.HOME_SEARCH) }
    }


    private class MyPagerAdapter (fm: FragmentManager?,listData :List<Fragment>) : FragmentPagerAdapter(fm) {
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