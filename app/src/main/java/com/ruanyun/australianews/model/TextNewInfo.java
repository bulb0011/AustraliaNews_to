package com.ruanyun.australianews.model;

import java.util.List;

public class TextNewInfo {


    /**
     * access_token :
     * msg : 获取成功
     * code : 0
     * data : {"pageTotalCount":true,"pageNumber":1,"datas":[{"jumpType":0,"specialOffercny":0.01,"specialOfferaud":0.01,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b33333","title":"欧盟对中33333","type":1,"baseWebsite":"","newsType":2,"commentCount":2,"normalPriceaud":0.01,"outUrl":"","baseUrl":"","normalPricecny":0.01,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":20},{"jumpType":0,"specialOffercny":0.01,"specialOfferaud":0.01,"priceType":2,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b22222","title":"欧盟对中22222","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":0.01,"outUrl":"","baseUrl":"","normalPricecny":0.01,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":24},{"jumpType":0,"specialOffercny":0.01,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b40000","title":"欧盟对中","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":0.01,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":24},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":2,"mainPhoto":"20200805171528474.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"01234567890123456785efc05065eb0e","title":"经济学人智库：企业对经济前景的悲观情绪有所缓解","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"https://www.prnasia.com/story/284076-1.shtml","normalPricecny":100,"videoUrl":"","createTime":"2020-07-01 11:37:42","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":41},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b11111","title":"欧盟对中11111","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":33},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b44444","title":"欧盟对中44444","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":8},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b55555","title":"欧盟对中55555","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":6},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b66666","title":"欧盟对中66666","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":13},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b77777","title":"欧盟对中77777","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":11},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b88888","title":"欧盟对中88888","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":11}],"maxPageNumber":2,"pageSize":10,"totalRows":13}
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
         * pageTotalCount : true
         * pageNumber : 1
         * datas : [{"jumpType":0,"specialOffercny":0.01,"specialOfferaud":0.01,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b33333","title":"欧盟对中33333","type":1,"baseWebsite":"","newsType":2,"commentCount":2,"normalPriceaud":0.01,"outUrl":"","baseUrl":"","normalPricecny":0.01,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":20},{"jumpType":0,"specialOffercny":0.01,"specialOfferaud":0.01,"priceType":2,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b22222","title":"欧盟对中22222","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":0.01,"outUrl":"","baseUrl":"","normalPricecny":0.01,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":24},{"jumpType":0,"specialOffercny":0.01,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b40000","title":"欧盟对中","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":0.01,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":24},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":2,"mainPhoto":"20200805171528474.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"01234567890123456785efc05065eb0e","title":"经济学人智库：企业对经济前景的悲观情绪有所缓解","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"https://www.prnasia.com/story/284076-1.shtml","normalPricecny":100,"videoUrl":"","createTime":"2020-07-01 11:37:42","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":41},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b11111","title":"欧盟对中11111","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":33},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b44444","title":"欧盟对中44444","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":8},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b55555","title":"欧盟对中55555","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":6},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b66666","title":"欧盟对中66666","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":13},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b77777","title":"欧盟对中77777","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":11},{"jumpType":0,"specialOffercny":98,"specialOfferaud":48,"priceType":1,"mainPhoto":"20200814170451959.jpg","limitedtimeFreeId":"4028818773b317f90173b32048a30026","specialOfferusd":28,"oid":"4028818a73ec12bb0173ec3717b88888","title":"欧盟对中88888","type":1,"baseWebsite":"","newsType":2,"commentCount":0,"normalPriceaud":50,"outUrl":"","baseUrl":"","normalPricecny":100,"videoUrl":"","createTime":"2020-08-14 17:04:52","linkUrl":"","normalPriceusd":30,"isHot":2,"mark":false,"watchCount":11}]
         * maxPageNumber : 2
         * pageSize : 10
         * totalRows : 13
         */
        private boolean pageTotalCount;
        private int pageNumber;
        private List<DatasEntity> datas;
        private int maxPageNumber;
        private int pageSize;
        private int totalRows;

        public void setPageTotalCount(boolean pageTotalCount) {
            this.pageTotalCount = pageTotalCount;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public void setDatas(List<DatasEntity> datas) {
            this.datas = datas;
        }

        public void setMaxPageNumber(int maxPageNumber) {
            this.maxPageNumber = maxPageNumber;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public void setTotalRows(int totalRows) {
            this.totalRows = totalRows;
        }

        public boolean isPageTotalCount() {
            return pageTotalCount;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public List<DatasEntity> getDatas() {
            return datas;
        }

        public int getMaxPageNumber() {
            return maxPageNumber;
        }

        public int getPageSize() {
            return pageSize;
        }

        public int getTotalRows() {
            return totalRows;
        }

        public class DatasEntity {
            /**
             * jumpType : 0
             * specialOffercny : 0.01
             * specialOfferaud : 0.01
             * priceType : 1
             * mainPhoto : 20200814170451959.jpg
             * limitedtimeFreeId : 4028818773b317f90173b32048a30026
             * specialOfferusd : 28
             * oid : 4028818a73ec12bb0173ec3717b33333
             * title : 欧盟对中33333
             * type : 1
             * baseWebsite :
             * newsType : 2
             * commentCount : 2
             * normalPriceaud : 0.01
             * outUrl :
             * baseUrl :
             * normalPricecny : 0.01
             * videoUrl :
             * createTime : 2020-08-14 17:04:52
             * linkUrl :
             * normalPriceusd : 30
             * isHot : 2
             * mark : false
             * watchCount : 20
             */
            private int jumpType;
            private double specialOffercny;
            private double specialOfferaud;
            private int priceType;
            private String mainPhoto;
            private String limitedtimeFreeId;
            private int specialOfferusd;
            private String oid;
            private String title;
            private int type;
            private String baseWebsite;
            private int newsType;
            private int commentCount;
            private double normalPriceaud;
            private String outUrl;
            private String baseUrl;
            private double normalPricecny;
            private String videoUrl;
            private String createTime;
            private String linkUrl;
            private int normalPriceusd;
            private int isHot;
            private boolean mark;
            private int watchCount;

            public void setJumpType(int jumpType) {
                this.jumpType = jumpType;
            }

            public void setSpecialOffercny(double specialOffercny) {
                this.specialOffercny = specialOffercny;
            }

            public void setSpecialOfferaud(double specialOfferaud) {
                this.specialOfferaud = specialOfferaud;
            }

            public void setPriceType(int priceType) {
                this.priceType = priceType;
            }

            public void setMainPhoto(String mainPhoto) {
                this.mainPhoto = mainPhoto;
            }

            public void setLimitedtimeFreeId(String limitedtimeFreeId) {
                this.limitedtimeFreeId = limitedtimeFreeId;
            }

            public void setSpecialOfferusd(int specialOfferusd) {
                this.specialOfferusd = specialOfferusd;
            }

            public void setOid(String oid) {
                this.oid = oid;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setBaseWebsite(String baseWebsite) {
                this.baseWebsite = baseWebsite;
            }

            public void setNewsType(int newsType) {
                this.newsType = newsType;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public void setNormalPriceaud(double normalPriceaud) {
                this.normalPriceaud = normalPriceaud;
            }

            public void setOutUrl(String outUrl) {
                this.outUrl = outUrl;
            }

            public void setBaseUrl(String baseUrl) {
                this.baseUrl = baseUrl;
            }

            public void setNormalPricecny(double normalPricecny) {
                this.normalPricecny = normalPricecny;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public void setLinkUrl(String linkUrl) {
                this.linkUrl = linkUrl;
            }

            public void setNormalPriceusd(int normalPriceusd) {
                this.normalPriceusd = normalPriceusd;
            }

            public void setIsHot(int isHot) {
                this.isHot = isHot;
            }

            public void setMark(boolean mark) {
                this.mark = mark;
            }

            public void setWatchCount(int watchCount) {
                this.watchCount = watchCount;
            }

            public int getJumpType() {
                return jumpType;
            }

            public double getSpecialOffercny() {
                return specialOffercny;
            }

            public double getSpecialOfferaud() {
                return specialOfferaud;
            }

            public int getPriceType() {
                return priceType;
            }

            public String getMainPhoto() {
                return mainPhoto;
            }

            public String getLimitedtimeFreeId() {
                return limitedtimeFreeId;
            }

            public int getSpecialOfferusd() {
                return specialOfferusd;
            }

            public String getOid() {
                return oid;
            }

            public String getTitle() {
                return title;
            }

            public int getType() {
                return type;
            }

            public String getBaseWebsite() {
                return baseWebsite;
            }

            public int getNewsType() {
                return newsType;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public double getNormalPriceaud() {
                return normalPriceaud;
            }

            public String getOutUrl() {
                return outUrl;
            }

            public String getBaseUrl() {
                return baseUrl;
            }

            public double getNormalPricecny() {
                return normalPricecny;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public String getCreateTime() {
                return createTime;
            }

            public String getLinkUrl() {
                return linkUrl;
            }

            public int getNormalPriceusd() {
                return normalPriceusd;
            }

            public int getIsHot() {
                return isHot;
            }

            public boolean isMark() {
                return mark;
            }

            public int getWatchCount() {
                return watchCount;
            }
        }
    }
}
