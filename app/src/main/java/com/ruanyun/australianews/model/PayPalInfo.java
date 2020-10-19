package com.ruanyun.australianews.model;

import java.util.List;

public class PayPalInfo {


    /**
     * access_token :
     * msg : 获取成功
     * code : 0
     * data : {"create_time":"2020-10-17T16:01:54Z","purchase_units":[{"payee":{"email_address":"sb-hzn6754623@business.example.com","merchant_id":"CDEAZES6W4ZF2"},"amount":{"breakdown":{"item_total":{"value":"48.00","currency_code":"AUD"}},"value":"48.00","currency_code":"AUD"},"reference_id":"ff808081752b9a850175374ba742019a","soft_descriptor":"课程购买","custom_id":"ff808081752b9a850175374ba742019a","description":"课程购买"}],"links":[{"method":"GET","rel":"self","href":"https://api.sandbox.paypal.com/v2/checkout/orders/7B4421205E673194G"},{"method":"GET","rel":"approve","href":"https://www.sandbox.paypal.com/checkoutnow?token=7B4421205E673194G"},{"method":"PATCH","rel":"update","href":"https://api.sandbox.paypal.com/v2/checkout/orders/7B4421205E673194G"},{"method":"POST","rel":"capture","href":"https://api.sandbox.paypal.com/v2/checkout/orders/7B4421205E673194G/capture"}],"id":"7B4421205E673194G","intent":"CAPTURE","status":"CREATED"}
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
         * create_time : 2020-10-17T16:01:54Z
         * purchase_units : [{"payee":{"email_address":"sb-hzn6754623@business.example.com","merchant_id":"CDEAZES6W4ZF2"},"amount":{"breakdown":{"item_total":{"value":"48.00","currency_code":"AUD"}},"value":"48.00","currency_code":"AUD"},"reference_id":"ff808081752b9a850175374ba742019a","soft_descriptor":"课程购买","custom_id":"ff808081752b9a850175374ba742019a","description":"课程购买"}]
         * links : [{"method":"GET","rel":"self","href":"https://api.sandbox.paypal.com/v2/checkout/orders/7B4421205E673194G"},{"method":"GET","rel":"approve","href":"https://www.sandbox.paypal.com/checkoutnow?token=7B4421205E673194G"},{"method":"PATCH","rel":"update","href":"https://api.sandbox.paypal.com/v2/checkout/orders/7B4421205E673194G"},{"method":"POST","rel":"capture","href":"https://api.sandbox.paypal.com/v2/checkout/orders/7B4421205E673194G/capture"}]
         * id : 7B4421205E673194G
         * intent : CAPTURE
         * status : CREATED
         */
        private String create_time;
        private List<Purchase_unitsEntity> purchase_units;
        private List<LinksEntity> links;
        private String id;
        private String intent;
        private String status;

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public void setPurchase_units(List<Purchase_unitsEntity> purchase_units) {
            this.purchase_units = purchase_units;
        }

        public void setLinks(List<LinksEntity> links) {
            this.links = links;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setIntent(String intent) {
            this.intent = intent;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreate_time() {
            return create_time;
        }

        public List<Purchase_unitsEntity> getPurchase_units() {
            return purchase_units;
        }

        public List<LinksEntity> getLinks() {
            return links;
        }

        public String getId() {
            return id;
        }

        public String getIntent() {
            return intent;
        }

        public String getStatus() {
            return status;
        }

        public class Purchase_unitsEntity {
            /**
             * payee : {"email_address":"sb-hzn6754623@business.example.com","merchant_id":"CDEAZES6W4ZF2"}
             * amount : {"breakdown":{"item_total":{"value":"48.00","currency_code":"AUD"}},"value":"48.00","currency_code":"AUD"}
             * reference_id : ff808081752b9a850175374ba742019a
             * soft_descriptor : 课程购买
             * custom_id : ff808081752b9a850175374ba742019a
             * description : 课程购买
             */
            private PayeeEntity payee;
            private AmountEntity amount;
            private String reference_id;
            private String soft_descriptor;
            private String custom_id;
            private String description;

            public void setPayee(PayeeEntity payee) {
                this.payee = payee;
            }

            public void setAmount(AmountEntity amount) {
                this.amount = amount;
            }

            public void setReference_id(String reference_id) {
                this.reference_id = reference_id;
            }

            public void setSoft_descriptor(String soft_descriptor) {
                this.soft_descriptor = soft_descriptor;
            }

            public void setCustom_id(String custom_id) {
                this.custom_id = custom_id;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public PayeeEntity getPayee() {
                return payee;
            }

            public AmountEntity getAmount() {
                return amount;
            }

            public String getReference_id() {
                return reference_id;
            }

            public String getSoft_descriptor() {
                return soft_descriptor;
            }

            public String getCustom_id() {
                return custom_id;
            }

            public String getDescription() {
                return description;
            }

            public class PayeeEntity {
                /**
                 * email_address : sb-hzn6754623@business.example.com
                 * merchant_id : CDEAZES6W4ZF2
                 */
                private String email_address;
                private String merchant_id;

                public void setEmail_address(String email_address) {
                    this.email_address = email_address;
                }

                public void setMerchant_id(String merchant_id) {
                    this.merchant_id = merchant_id;
                }

                public String getEmail_address() {
                    return email_address;
                }

                public String getMerchant_id() {
                    return merchant_id;
                }
            }

            public class AmountEntity {
                /**
                 * breakdown : {"item_total":{"value":"48.00","currency_code":"AUD"}}
                 * value : 48.00
                 * currency_code : AUD
                 */
                private BreakdownEntity breakdown;
                private String value;
                private String currency_code;

                public void setBreakdown(BreakdownEntity breakdown) {
                    this.breakdown = breakdown;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public void setCurrency_code(String currency_code) {
                    this.currency_code = currency_code;
                }

                public BreakdownEntity getBreakdown() {
                    return breakdown;
                }

                public String getValue() {
                    return value;
                }

                public String getCurrency_code() {
                    return currency_code;
                }

                public class BreakdownEntity {
                    /**
                     * item_total : {"value":"48.00","currency_code":"AUD"}
                     */
                    private Item_totalEntity item_total;

                    public void setItem_total(Item_totalEntity item_total) {
                        this.item_total = item_total;
                    }

                    public Item_totalEntity getItem_total() {
                        return item_total;
                    }

                    public class Item_totalEntity {
                        /**
                         * value : 48.00
                         * currency_code : AUD
                         */
                        private String value;
                        private String currency_code;

                        public void setValue(String value) {
                            this.value = value;
                        }

                        public void setCurrency_code(String currency_code) {
                            this.currency_code = currency_code;
                        }

                        public String getValue() {
                            return value;
                        }

                        public String getCurrency_code() {
                            return currency_code;
                        }
                    }
                }
            }
        }

        public class LinksEntity {
            /**
             * method : GET
             * rel : self
             * href : https://api.sandbox.paypal.com/v2/checkout/orders/7B4421205E673194G
             */
            private String method;
            private String rel;
            private String href;

            public void setMethod(String method) {
                this.method = method;
            }

            public void setRel(String rel) {
                this.rel = rel;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getMethod() {
                return method;
            }

            public String getRel() {
                return rel;
            }

            public String getHref() {
                return href;
            }
        }
    }
}
