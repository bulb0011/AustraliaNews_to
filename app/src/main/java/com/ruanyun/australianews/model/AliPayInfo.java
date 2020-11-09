package com.ruanyun.australianews.model;

public class AliPayInfo {


    /**
     * access_token :
     * msg : 获取成功
     * code : 0
     * data : {"order_no":"TR2011092000234020002221","msg":null,"error_msg":null,"success":true,"order_string":"secondary_merchant_name=Australian Financial News&secondary_merchant_id=2000234020&secondary_merchant_industry=5815&out_trade_no=3846185137544888320&subject=课程购买&total_fee=0.10&currency=AUD&body=课程购买&notify_url=https://alipayonline.omipay.com.cn/pay/notify&forex_biz=FP&payment_type=1&seller_id=2088821755869339&product_code=NEW_WAP_OVERSEAS_SELLER&sign=91d2289df0b0a2a208a0d0aa626e50f3&sign_type=MD5&service=mobile.securitypay.pay&partner=2088821755869339&_input_charset=utf-8","return_code":"SUCCESS"}
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
         * order_no : TR2011092000234020002221
         * msg : null
         * error_msg : null
         * success : true
         * order_string : secondary_merchant_name=Australian Financial News&secondary_merchant_id=2000234020&secondary_merchant_industry=5815&out_trade_no=3846185137544888320&subject=课程购买&total_fee=0.10&currency=AUD&body=课程购买&notify_url=https://alipayonline.omipay.com.cn/pay/notify&forex_biz=FP&payment_type=1&seller_id=2088821755869339&product_code=NEW_WAP_OVERSEAS_SELLER&sign=91d2289df0b0a2a208a0d0aa626e50f3&sign_type=MD5&service=mobile.securitypay.pay&partner=2088821755869339&_input_charset=utf-8
         * return_code : SUCCESS
         */
        private String order_no;
        private String msg;
        private String error_msg;
        private boolean success;
        private String order_string;
        private String return_code;

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setError_msg(String error_msg) {
            this.error_msg = error_msg;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public void setOrder_string(String order_string) {
            this.order_string = order_string;
        }

        public void setReturn_code(String return_code) {
            this.return_code = return_code;
        }

        public String getOrder_no() {
            return order_no;
        }

        public String getMsg() {
            return msg;
        }

        public String getError_msg() {
            return error_msg;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getOrder_string() {
            return order_string;
        }

        public String getReturn_code() {
            return return_code;
        }
    }
}
