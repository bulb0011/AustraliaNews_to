package com.ruanyun.australianews.model;

public class VipBannerInfo {


    /**
     * mainPhoto : 20200804120659350.jpg
     * oid : 4028818773bdc3ca0173bdca4f570002
     * title : 拯救疫情下的行业
     * type : 2
     * commonOid : 4028818773b7a3fb0173b7a6c0ba0000
     */

    private String mainPhoto;
    private String oid;
    private String title;
    private int type;
    private String commonOid;

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCommonOid() {
        return commonOid;
    }

    public void setCommonOid(String commonOid) {
        this.commonOid = commonOid;
    }
}
