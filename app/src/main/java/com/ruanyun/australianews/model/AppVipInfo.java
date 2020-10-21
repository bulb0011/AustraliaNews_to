package com.ruanyun.australianews.model;

public class AppVipInfo {


    /**
     * access_token :
     * msg : 获取成功
     * code : 0
     * data : {"priceUsd":0.01,"userOid":"","effectiveTime":1,"isDelete":0,"flag3":"","flag2":"","timeType":3,"flag1":"","updateTime":null,"oid":"4028818773c82c240173c839117a0000","vipName":"开通澳财经VIP会员","createTime":null,"sysUser":null,"priceCny":0.01,"remarks":"可随时续费，有效期会在当前有效期后顺延一年","priceAud":0.02,"status":0}
     */
    private String access_token;
    private String msg;
    private int code;
    private DataEntity data;

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
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

    public DataEntity getData() {
        return data;
    }

    public class DataEntity {
        /**
         * priceUsd : 0.01
         * userOid :
         * effectiveTime : 1
         * isDelete : 0
         * flag3 :
         * flag2 :
         * timeType : 3
         * flag1 :
         * updateTime : null
         * oid : 4028818773c82c240173c839117a0000
         * vipName : 开通澳财经VIP会员
         * createTime : null
         * sysUser : null
         * priceCny : 0.01
         * remarks : 可随时续费，有效期会在当前有效期后顺延一年
         * priceAud : 0.02
         * status : 0
         */
        private double priceUsd;
        private String userOid;
        private int effectiveTime;
        private int isDelete;
        private String flag3;
        private String flag2;
        private int timeType;
        private String flag1;
        private String updateTime;
        private String oid;
        private String vipName;
        private String createTime;
        private String sysUser;
        private double priceCny;
        private String remarks;
        private double priceAud;
        private int status;

        public void setPriceUsd(double priceUsd) {
            this.priceUsd = priceUsd;
        }

        public void setUserOid(String userOid) {
            this.userOid = userOid;
        }

        public void setEffectiveTime(int effectiveTime) {
            this.effectiveTime = effectiveTime;
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

        public void setTimeType(int timeType) {
            this.timeType = timeType;
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

        public void setVipName(String vipName) {
            this.vipName = vipName;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setSysUser(String sysUser) {
            this.sysUser = sysUser;
        }

        public void setPriceCny(double priceCny) {
            this.priceCny = priceCny;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public void setPriceAud(double priceAud) {
            this.priceAud = priceAud;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public double getPriceUsd() {
            return priceUsd;
        }

        public String getUserOid() {
            return userOid;
        }

        public int getEffectiveTime() {
            return effectiveTime;
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

        public int getTimeType() {
            return timeType;
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

        public String getVipName() {
            return vipName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getSysUser() {
            return sysUser;
        }

        public double getPriceCny() {
            return priceCny;
        }

        public String getRemarks() {
            return remarks;
        }

        public double getPriceAud() {
            return priceAud;
        }

        public int getStatus() {
            return status;
        }
    }
}
