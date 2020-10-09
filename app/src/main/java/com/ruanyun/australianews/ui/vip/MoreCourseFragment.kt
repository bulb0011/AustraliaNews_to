package com.ruanyun.australianews.ui.vip

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.base.ResultBase
import com.ruanyun.australianews.data.ApiFailAction
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.data.ApiSuccessAction
import com.ruanyun.australianews.model.HotInfo
import com.ruanyun.australianews.ui.adapter.MoreCourseAdapter
import com.ruanyun.australianews.util.C
import com.ruanyun.australianews.util.RxUtil
import kotlinx.android.synthetic.main.fragment_more_course.*


class MoreCourseFragment @SuppressLint constructor():BaseFragment(){

//     var mDataListCurriculum:List<HotInfo.HotInfoDatasBean>
//    init {
//        this.mDataListCurriculum=listData
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_more_course,container,false)
    }

    val mDataListCurriculum= arrayListOf<com.ruanyun.australianews.model.HotInfo.DatasEntity>()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //        //最热产品
        ApiManger.getApiService().getHotInfoList(App.app.userOid).compose(RxUtil.normalSchedulers())
            .subscribe(object : ApiSuccessAction<ResultBase<HotInfo>>() {
                override fun onSuccess(result: ResultBase<HotInfo>) {
//                        mDataListCurriculum.addAll(result.data.datas)

                    val layoutManager = LinearLayoutManager(context)

                    layoutManager.orientation = LinearLayoutManager.VERTICAL

                    rv_more_course_list.layoutManager = layoutManager

                    rv_more_course_list.isNestedScrollingEnabled = false

                    val adapter = context?.let { MoreCourseAdapter(it,result.data.datas) }

                    rv_more_course_list.adapter=adapter

                    adapter?.setOnCliakListener(object :MoreCourseAdapter.OnCliskListener{
                        override fun onClisk(view: View?, po: Int) {

                            val type= result.data.datas[po].contentType

                            var s=""
                            if (type==1){

                                s= C.IntentKey.VIP_TYPE_PDF
                            }else if (type==2){

                                s=C.IntentKey.VIP_TYPE_VIDEO
                            }else if (type==3){

                                s=C.IntentKey.VIP_TYPE_MP3
                            }

                            context?.let {
                                VipDetailsActivity.start(
                                    it,
                                    s,
                                    result.data.datas[po].oid
                                )
                            }
                        }
                    })
                }
                override fun onError(erroCode: Int, erroMsg: String) {
//                disMissLoading()
                    showToast(erroMsg)
                }
            }, object : ApiFailAction() {
                override fun onFail(msg: String) {
//                disMissLoading()
                    showToast(msg)
                }
            })


    }



}