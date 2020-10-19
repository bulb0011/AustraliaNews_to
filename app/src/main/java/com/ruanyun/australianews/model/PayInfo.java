package com.ruanyun.australianews.model;

public class PayInfo {


    /**
     * access_token :
     * msg : 获取成功
     * code : 0
     * data : {"msg":"成功","result_code":"SUCCESS","body":"alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2021001191666585&biz_content=%7B%22body%22%3A%22%BF%CE%B3%CC%B9%BA%C2%F2%22%2C%22out_trade_no%22%3A%22ff8080817520fb0d0175210847dd0000%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%B0%C4%B2%C6%BE%AD%22%2C%22timeout_express%22%3A%221h%22%2C%22total_amount%22%3A%220.01%22%7D&charset=GBK&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F47.93.19.198%3A8083%2Faozhoucaijing%2Fapp%2Fappalipay%2FappAliPayNotify&sign=qBKf3UAInkhdNxHcQCSB%2F0pjzXQp7WaPMB9qXciq5sWNcCiOLHxDp%2FX%2BwAfBWbkDCns6hX%2FY%2FmbM616XWumPCXMSgqO0V6An2gGc2TgkihvxPYJaZjpWgFu0qGaxO5jDrP2gZCFSzg%2Fo5DDn2p%2BDpRt%2Fw3hCZV2s533mLXi613RXQkD0S9PlqyU0d9IFuflpN89Y82QvF6UBVYOQS4ynClI%2BB4PHblX%2Bwffd67t4hZony1A3EjycDM6MbrzKq6RAJi6FHg5SSXOz8GOyEotCllfZAdna0qE9Tl2ZAMYXZxSqTcZ85ul5muWWLUhl2TEGFreZDUrnX7LfmL%2BpClOABQ%3D%3D&sign_type=RSA2&timestamp=2020-10-13+16%3A16%3A32&version=1.0"}
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
         * msg : 成功
         * result_code : SUCCESS
         * body : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2021001191666585&biz_content=%7B%22body%22%3A%22%BF%CE%B3%CC%B9%BA%C2%F2%22%2C%22out_trade_no%22%3A%22ff8080817520fb0d0175210847dd0000%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%B0%C4%B2%C6%BE%AD%22%2C%22timeout_express%22%3A%221h%22%2C%22total_amount%22%3A%220.01%22%7D&charset=GBK&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F47.93.19.198%3A8083%2Faozhoucaijing%2Fapp%2Fappalipay%2FappAliPayNotify&sign=qBKf3UAInkhdNxHcQCSB%2F0pjzXQp7WaPMB9qXciq5sWNcCiOLHxDp%2FX%2BwAfBWbkDCns6hX%2FY%2FmbM616XWumPCXMSgqO0V6An2gGc2TgkihvxPYJaZjpWgFu0qGaxO5jDrP2gZCFSzg%2Fo5DDn2p%2BDpRt%2Fw3hCZV2s533mLXi613RXQkD0S9PlqyU0d9IFuflpN89Y82QvF6UBVYOQS4ynClI%2BB4PHblX%2Bwffd67t4hZony1A3EjycDM6MbrzKq6RAJi6FHg5SSXOz8GOyEotCllfZAdna0qE9Tl2ZAMYXZxSqTcZ85ul5muWWLUhl2TEGFreZDUrnX7LfmL%2BpClOABQ%3D%3D&sign_type=RSA2&timestamp=2020-10-13+16%3A16%3A32&version=1.0
         */
        private String msg;
        private String result_code;
        private String body;
        private String prepayId;


        public String getPrepayId() {
            return prepayId;
        }

        public void setPrepayId(String prepayId) {
            this.prepayId = prepayId;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setResult_code(String result_code) {
            this.result_code = result_code;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getMsg() {
            return msg;
        }

        public String getResult_code() {
            return result_code;
        }

        public String getBody() {
            return body;
        }
    }
}
