package com.ruanyun.australianews.model.params;

import android.text.TextUtils;

import com.ruanyun.australianews.util.CommonUtil;

/**
 * @author hdl
 * @description 发布黄页
 * @date 2019/5/17
 */
public class ReleaseYellowPageParams {
    private String oid;//修改
    private String userOid;//当前登录人
    private String typeOid;//黄页类型Oid
    private String mainPhoto;//图片
    private String title;//标题
    private String city;//区域
    private String companyName;//公司名称
    private String companyAddress;//公司地址
    private String companyWebsite;//公司网址
    private String transactionNature;//交易性质 HOUSING_SOURCE
    private String description;//相关介绍
    private String linkMan;//联系人
    private String linkTel;//手机号
    private String email;//邮箱
    private String qq;//QQ
    private String weixin;//微信

    public boolean isNotEmpty(){
        if(TextUtils.isEmpty(title)){
            CommonUtil.showToast("请填写标题");
            return false;
        }
        if(TextUtils.isEmpty(city)){
            CommonUtil.showToast("请选择Suburb");
            return false;
        }
        if(TextUtils.isEmpty(companyName)){
            CommonUtil.showToast("请填写公司名称");
            return false;
        }
        if(TextUtils.isEmpty(companyAddress)){
            CommonUtil.showToast("请填写公司地址");
            return false;
        }
        if(TextUtils.isEmpty(transactionNature)){
            CommonUtil.showToast("请选择交易性质");
            return false;
        }
        if(TextUtils.isEmpty(description)){
            CommonUtil.showToast("请填写相关介绍");
            return false;
        }
        if(TextUtils.isEmpty(linkMan)){
            CommonUtil.showToast("请填写联系人");
            return false;
        }
//        if(TextUtils.isEmpty(linkTel)){
//            CommonUtil.showToast("请填写手机号");
//            return false;
//        }
//        if(TextUtils.isEmpty(email)){
//            CommonUtil.showToast("请填写邮箱");
//            return false;
//        }
//        if(TextUtils.isEmpty(qq)){
//            CommonUtil.showToast("请填写QQ");
//            return false;
//        }
//        if(TextUtils.isEmpty(weixin)){
//            CommonUtil.showToast("请填写微信");
//            return false;
//        }
        return true;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUserOid() {
        return userOid;
    }

    public void setUserOid(String userOid) {
        this.userOid = userOid;
    }

    public String getTypeOid() {
        return typeOid;
    }

    public void setTypeOid(String typeOid) {
        this.typeOid = typeOid;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getTransactionNature() {
        return transactionNature;
    }

    public void setTransactionNature(String transactionNature) {
        this.transactionNature = transactionNature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }
}
