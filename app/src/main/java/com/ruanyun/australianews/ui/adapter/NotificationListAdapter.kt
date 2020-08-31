package com.ruanyun.australianews.ui.adapter

import android.content.Context
import android.view.View
import com.ruanyun.australianews.R
import com.ruanyun.australianews.base.refreshview.impl.RvCommonAdapter
import com.ruanyun.australianews.model.NotificationInfo
import com.ruanyun.australianews.util.StringUtil
import com.zhy.adapter.recyclerview.base.ViewHolder

/**
 * @description 消息通知列表
 * @author hdl
 * @date 2018/11/27
 */
class NotificationListAdapter(context: Context?, layoutId: Int, datas: MutableList<NotificationInfo>?) : RvCommonAdapter<NotificationInfo>(context, layoutId, datas) {

    override fun convert(holder: ViewHolder?, item: NotificationInfo, position: Int) {
        holder?.setText(R.id.tv_time, StringUtil.getTimeStrFromFormatStr("yyyy-MM-dd HH:mm", item.createTime))
        holder?.setText(R.id.tv_title, item.title)

        //1.系统公告通知、3.系统订阅通知、4.系统上新通知
        if (item.type==1){
            holder?.setText(R.id.tv_meg, "公告")
        }
        else if (item.type==3){
            holder?.setText(R.id.tv_meg, "订阅")
        }else{
            holder?.setText(R.id.tv_meg, "上新")
        }

        val unread = holder?.getView<View>(R.id.unread)
        unread?.visibility = /*if (item.status == 0) View.VISIBLE else */View.GONE
    }

}
