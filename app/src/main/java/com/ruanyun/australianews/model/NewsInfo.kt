package com.ruanyun.australianews.model

import android.text.TextUtils
import com.ruanyun.australianews.model.uimodel.LifeReleaseCommonUiModel
import com.ruanyun.australianews.util.*

/**
 * @author hdl
 * @description
 * @date 2019/5/5
 */
class NewsInfo : AdvertInfoBase, LifeReleaseCommonUiModel {
    var type: Int
    var pushShowType: Int
    var outUrl: String?
    var videoUrl: String?
    var createTime: String?
    var baseWebsite: String?
    var baseWebsiteName: String?
    var isHot: Int
    var commentCount: Int
    var watchCount: Int
    var newsType: Int
    var mainPhotoList: List<String>?

    //1图文，2视频，3外部
    constructor(
        type: Int = 0,
        pushShowType: Int = 0,
        outUrl: String?,
        videoUrl: String?,
        createTime: String?,
        baseWebsite: String?,
        baseWebsiteName: String?,
        isHot: Int = 0,
        commentCount: Int = 0,
        watchCount: Int = 0,
        newsType: Int = 0,
        mainPhotoList: List<String>?
    ) : super() {
        this.type = type
        this.pushShowType = pushShowType
        this.outUrl = outUrl
        this.videoUrl = videoUrl
        this.createTime = createTime
        this.baseWebsite = baseWebsite
        this.baseWebsiteName = baseWebsiteName
        this.isHot = isHot
        this.commentCount = commentCount
        this.watchCount = watchCount
        this.newsType = newsType
        this.mainPhotoList = mainPhotoList
    }

    override val commonOid: String?
        get() = oid
    override val commonTitle: String?
        get() = title
    override val commonTime: String?
        get() = createTime
    override val commonMainPhoto: String?
        get() = FileUtil.getImageUrl(mainPhoto)
    override val itemType: Int
        get() = pushShowType
    override fun getINewsInfo(): NewsInfo? {
        return this
    }


    companion object {
        const val TYPE_SINGLE_PICTURE = 1000

        const val TYPE_MANY_PICTURE = 2000

        const val TYPE_VIDEO = 3000

        var title=""
        var mainPhoto=""

        fun getSourceStr(item: NewsInfo): CharSequence? {
            val baseWebsite = if (TextUtils.isEmpty(item.baseWebsiteName)) {
                if (TextUtils.isEmpty(item.baseWebsite)) {
                    ""
                } else {
                    "${DbHelper.getInstance().getItemName(item.baseWebsite, C.ParentCode.NEWSINFO_WEBSITE)}  "
                }
            } else {
                "${item.baseWebsiteName}  "
            }
//            return "$baseWebsite${StringUtil.getWCount(item.watchCount)}浏览  ${StringUtil.getWCount(item.commentCount)}评论  ${StringUtil.getNewsTime(item.createTime)}"
//            return "$baseWebsite${StringUtil.getWCount(item.watchCount)}浏览  ${StringUtil.getNewsTime(item.createTime)}"

            LogX.e("dengpao","时间+"+item.createTime)

            return "  ${StringUtil.getNewsTime(item.createTime)}"

//            return "$baseWebsite"
        }

        fun getSourceStrPing(item: NewsInfo): CharSequence? {
            val baseWebsite = if (TextUtils.isEmpty(item.baseWebsiteName)) {
                if (TextUtils.isEmpty(item.baseWebsite)) {
                    ""
                } else {
                    "${DbHelper.getInstance().getItemName(item.baseWebsite, C.ParentCode.NEWSINFO_WEBSITE)}  "
                }
            } else {
                "${item.baseWebsiteName}  "
            }
//            return "$baseWebsite${StringUtil.getWCount(item.watchCount)}浏览  ${StringUtil.getWCount(item.commentCount)}评论  ${StringUtil.getNewsTime(item.createTime)}"
//            return "$baseWebsite${StringUtil.getWCount(item.watchCount)}浏览  ${StringUtil.getNewsTime(item.createTime)}"
            return "$baseWebsite  ${StringUtil.getNewsTime(item.createTime)}"

//            return "$baseWebsite"
        }


    }

}
