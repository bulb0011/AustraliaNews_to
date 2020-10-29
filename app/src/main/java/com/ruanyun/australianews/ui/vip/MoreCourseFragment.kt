package com.ruanyun.australianews.ui.vip

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.ruanyun.australianews.App
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.BaseFragment
import com.ruanyun.australianews.data.ApiManger
import com.ruanyun.australianews.model.HotInfo
import com.ruanyun.australianews.ui.adapter.MoreCourseAdapter
import com.ruanyun.australianews.util.C
import kotlinx.android.synthetic.main.fragment_more_course.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        //最热产品
        ApiManger.getApiService().getHotInfoList(App.app.userOid)
            . enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    val layoutManager = LinearLayoutManager(context)

                    layoutManager.orientation = LinearLayoutManager.VERTICAL

                    rv_more_course_list.layoutManager = layoutManager

                    rv_more_course_list.isNestedScrollingEnabled = false

                    val json = response.body()!!.string()

                    val je = JsonParser().parse(json)

                    val data = je.asJsonObject["data"].toString()

                    val gson = Gson()

                    val hotinfo= gson.fromJson<HotInfo>(data,HotInfo::class.java)

                    val listDatasEntity = hotinfo.datas

                    val adapter = context?.let { MoreCourseAdapter(it,listDatasEntity) }

                    rv_more_course_list.adapter=adapter

                    adapter?.setOnCliakListener(object :MoreCourseAdapter.OnCliskListener{
                        override fun onClisk(view: View?, po: Int) {

                            val type= listDatasEntity[po].contentType

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
                                    listDatasEntity[po].oid
                                )
                            }
                        }
                    })

                }

            })


    }



}