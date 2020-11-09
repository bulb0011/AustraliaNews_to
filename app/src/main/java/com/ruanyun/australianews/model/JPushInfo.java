package com.ruanyun.australianews.model;

/**
 * @author hdl
 * @description
 * @date 2019/11/21
 */
public class JPushInfo {
    public int type;//1、2、3 新闻
    public String commonOid;
    public String videoUrl;//视频连接
    public String mainPhoto;
    public String outUrl;//外部链接

    public int contentType;

    public int commentCount; // 记录
    public int watchCount; //评论
    public String baseWebsite;// 来源
    public String commonTime; // 时间
    public String title;
}
