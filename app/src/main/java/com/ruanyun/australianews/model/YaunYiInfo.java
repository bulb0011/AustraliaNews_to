package com.ruanyun.australianews.model;

import java.util.List;

public class YaunYiInfo {


    /**
     * access_token :
     * msg : 获取成功
     * code : 0
     * data : [{"userOid":"","isDelete":0,"flag3":"","flag2":"","flag1":"","updateTime":null,"oid":"4028818773d7933d0173d7a27d150041","sort":1,"title":"免费阅读","createTime":null,"memberType":0,"sysUser":null,"remarks":"所有频道下海量产品免费阅读","status":0},{"userOid":"","isDelete":0,"flag3":"","flag2":"","flag1":"","updateTime":null,"oid":"4028818773d7933d0173d7a467a50042","sort":2,"title":"优质资源","createTime":null,"memberType":0,"sysUser":null,"remarks":"所有频道下资源丰富，沪港通大收到免费阅读","status":0},{"userOid":"","isDelete":0,"flag3":"","flag2":"","flag1":"","updateTime":null,"oid":"4028818773d7933d0173d7a569fa0043","sort":3,"title":"会员畅读、畅听、畅看","createTime":null,"memberType":0,"sysUser":null,"remarks":"所有频道下海量产品","status":0}]
     */
    private String access_token;
    private String msg;
    private int code;
    private List<DataEntity> data;

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public class DataEntity {
        /**
         * userOid :
         * isDelete : 0
         * flag3 :
         * flag2 :
         * flag1 :
         * updateTime : null
         * oid : 4028818773d7933d0173d7a27d150041
         * sort : 1
         * title : 免费阅读
         * createTime : null
         * memberType : 0
         * sysUser : null
         * remarks : 所有频道下海量产品免费阅读
         * status : 0
         */
        private String userOid;
        private int isDelete;
        private String flag3;
        private String flag2;
        private String flag1;
        private String updateTime;
        private String oid;
        private int sort;
        private String title;
        private String createTime;
        private int memberType;
        private String sysUser;
        private String remarks;
        private int status;

        public void setUserOid(String userOid) {
            this.userOid = userOid;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public void setFlag3(String flag3) {
            this.flag3 = flag3;
        }

        public void setFlag2(String flag2) {
            this.flag2 = flag2;
        }

        public void setFlag1(String flag1) {
            this.flag1 = flag1;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setMemberType(int memberType) {
            this.memberType = memberType;
        }

        public void setSysUser(String sysUser) {
            this.sysUser = sysUser;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUserOid() {
            return userOid;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public String getFlag3() {
            return flag3;
        }

        public String getFlag2() {
            return flag2;
        }

        public String getFlag1() {
            return flag1;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public String getOid() {
            return oid;
        }

        public int getSort() {
            return sort;
        }

        public String getTitle() {
            return title;
        }

        public String getCreateTime() {
            return createTime;
        }

        public int getMemberType() {
            return memberType;
        }

        public String getSysUser() {
            return sysUser;
        }

        public String getRemarks() {
            return remarks;
        }

        public int getStatus() {
            return status;
        }
    }
}
