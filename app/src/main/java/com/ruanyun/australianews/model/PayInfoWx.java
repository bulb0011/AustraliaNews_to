package com.ruanyun.australianews.model;

public class PayInfoWx {

    private String access_token;

    private String msg;

    private int code;

    private Data data;

    public void setAccess_token(String access_token){
        this.access_token = access_token;
    }
    public String getAccess_token(){
        return this.access_token;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }

    public class Data {
        private String msg;

        private WxPayParam wxPayParam;

        private String result_code;

        public void setMsg(String msg){
            this.msg = msg;
        }
        public String getMsg(){
            return this.msg;
        }
        public void setWxPayParam(WxPayParam wxPayParam){
            this.wxPayParam = wxPayParam;
        }
        public WxPayParam getWxPayParam(){
            return this.wxPayParam;
        }
        public void setResult_code(String result_code){
            this.result_code = result_code;
        }
        public String getResult_code(){
            return this.result_code;
        }

    }

    public class WxPayParam {

        private String appid;

        private String sign;

        private String partnerid;

        private String prepayid;

        private String noncestr;

        private String timestamp;

        public void setAppid(String appid){
            this.appid = appid;
        }
        public String getAppid(){
            return this.appid;
        }
        public void setSign(String sign){
            this.sign = sign;
        }
        public String getSign(){
            return this.sign;
        }
        public void setPartnerid(String partnerid){
            this.partnerid = partnerid;
        }
        public String getPartnerid(){
            return this.partnerid;
        }
        public void setPrepayid(String prepayid){
            this.prepayid = prepayid;
        }
        public String getPrepayid(){
            return this.prepayid;
        }
        public void setNoncestr(String noncestr){
            this.noncestr = noncestr;
        }
        public String getNoncestr(){
            return this.noncestr;
        }
        public void setTimestamp(String timestamp){
            this.timestamp = timestamp;
        }
        public String getTimestamp(){
            return this.timestamp;
        }

    }
}
