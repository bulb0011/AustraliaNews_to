package com.ruanyun.australianews.model;

import java.util.List;

public class VIPSouSuoInfo {


    /**
     * pageTotalCount : true
     * pageNumber : 1
     * datas : [{"jumpType":0,"mainPhoto":"https://afndaily.com/wp-content/uploads/2020/06/Screen-Shot-2020-06-16-at-8.52.23-pm-1.png","specialOfferusd":8,"oid":"01234567890123456785ee98530c3c66","title":"欧盟对中国玻璃纤维布厂商征收关税","type":1,"outUrl":"","videoUrl":"","linkUrl":"","normalPriceusd":12,"contentType":0,"specialOffercny":0.01,"priceUsd":0,"specialOfferaud":0.01,"dataType":2,"priceType":1,"baseWebsite":"","commentCount":0,"keyWord":"玻璃纤维","normalPriceaud":0.02,"baseUrl":"https://afndaily.com/85748","normalPricecny":0.02,"createTime":"2020-06-17 10:51:28","afnInfoAllList":[],"priceCny":0,"isHot":2,"mark":false,"priceAud":0,"status":0,"watchCount":146},{"jumpType":0,"mainPhoto":"20200805171528474.jpg","specialOfferusd":28,"oid":"01234567890123456785efc05065eb0e","title":"经济学人智库：企业对经济前景的悲观情绪有所缓解","type":1,"outUrl":"","videoUrl":"","linkUrl":"","normalPriceusd":30,"contentType":0,"specialOffercny":98,"priceUsd":0,"specialOfferaud":48,"dataType":2,"priceType":2,"baseWebsite":"","commentCount":0,"keyWord":"经济学人智库：企业对经济前景的悲观情绪有所缓解","normalPriceaud":50,"baseUrl":"https://www.prnasia.com/story/284076-1.shtml","normalPricecny":100,"createTime":"2020-07-01 11:37:42","afnInfoAllList":[],"priceCny":0,"isHot":2,"mark":false,"priceAud":0,"status":0,"watchCount":74},{"jumpType":0,"mainPhoto":"20200615104537793.jpg","specialOfferusd":0,"oid":"01234567890123456785ee98530c3cee","title":"欧盟对中国玻璃纤维布厂商征收关税","type":0,"outUrl":"","videoUrl":"","linkUrl":"","normalPriceusd":0,"contentType":1,"specialOffercny":98,"priceUsd":0,"specialOfferaud":0,"dataType":1,"priceType":1,"baseWebsite":"","commentCount":0,"keyWord":"BrandZ, 中国平安","normalPriceaud":0,"baseUrl":"","normalPricecny":100,"createTime":"2020-07-30 12:01:55","afnInfoAllList":[],"priceCny":0,"isHot":2,"mark":false,"priceAud":0,"status":0,"watchCount":0}]
     * maxPageNumber : 1
     * pageSize : 10
     * totalRows : 3
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
         * mainPhoto : https://afndaily.com/wp-content/uploads/2020/06/Screen-Shot-2020-06-16-at-8.52.23-pm-1.png
         * specialOfferusd : 8
         * oid : 01234567890123456785ee98530c3c66
         * title : 欧盟对中国玻璃纤维布厂商征收关税
         * type : 1
         * outUrl :
         * videoUrl :
         * linkUrl :
         * normalPriceusd : 12
         * contentType : 0
         * specialOffercny : 0.01
         * priceUsd : 0
         * specialOfferaud : 0.01
         * dataType : 2
         * priceType : 1
         * baseWebsite :
         * commentCount : 0
         * keyWord : 玻璃纤维
         * normalPriceaud : 0.02
         * baseUrl : https://afndaily.com/85748
         * normalPricecny : 0.02
         * createTime : 2020-06-17 10:51:28
         * afnInfoAllList : []
         * priceCny : 0
         * isHot : 2
         * mark : false
         * priceAud : 0
         * status : 0
         * watchCount : 146
         */
        private int jumpType;
        private String mainPhoto;
        private int specialOfferusd;
        private String oid;
        private String title;
        private int type;
        private String outUrl;
        private String videoUrl;
        private String linkUrl;
        private double normalPriceusd;
        private int contentType;
        private double specialOffercny;
        private int priceUsd;
        private double specialOfferaud;
        private int dataType;
        private int priceType;
        private String baseWebsite;
        private int commentCount;
        private String keyWord;
        private double normalPriceaud;
        private String baseUrl;
        private double normalPricecny;
        private String createTime;
        private List<AfnInfoAllListEntity> afnInfoAllList;
        private int priceCny;
        private int isHot;
        private boolean mark;
        private int priceAud;
        private int status;
        private int watchCount;

        public void setJumpType(int jumpType) {
            this.jumpType = jumpType;
        }

        public void setMainPhoto(String mainPhoto) {
            this.mainPhoto = mainPhoto;
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

        public void setOutUrl(String outUrl) {
            this.outUrl = outUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        public void setNormalPriceusd(int normalPriceusd) {
            this.normalPriceusd = normalPriceusd;
        }

        public void setContentType(int contentType) {
            this.contentType = contentType;
        }

        public void setSpecialOffercny(double specialOffercny) {
            this.specialOffercny = specialOffercny;
        }

        public void setPriceUsd(int priceUsd) {
            this.priceUsd = priceUsd;
        }

        public void setSpecialOfferaud(double specialOfferaud) {
            this.specialOfferaud = specialOfferaud;
        }

        public void setDataType(int dataType) {
            this.dataType = dataType;
        }

        public void setPriceType(int priceType) {
            this.priceType = priceType;
        }

        public void setBaseWebsite(String baseWebsite) {
            this.baseWebsite = baseWebsite;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public void setKeyWord(String keyWord) {
            this.keyWord = keyWord;
        }

        public void setNormalPriceaud(double normalPriceaud) {
            this.normalPriceaud = normalPriceaud;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public void setNormalPricecny(double normalPricecny) {
            this.normalPricecny = normalPricecny;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setAfnInfoAllList(List<AfnInfoAllListEntity> afnInfoAllList) {
            this.afnInfoAllList = afnInfoAllList;
        }

        public void setPriceCny(int priceCny) {
            this.priceCny = priceCny;
        }

        public void setIsHot(int isHot) {
            this.isHot = isHot;
        }

        public void setMark(boolean mark) {
            this.mark = mark;
        }

        public void setPriceAud(int priceAud) {
            this.priceAud = priceAud;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setWatchCount(int watchCount) {
            this.watchCount = watchCount;
        }

        public int getJumpType() {
            return jumpType;
        }

        public String getMainPhoto() {
            return mainPhoto;
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

        public String getOutUrl() {
            return outUrl;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public double getNormalPriceusd() {
            return normalPriceusd;
        }

        public int getContentType() {
            return contentType;
        }

        public double getSpecialOffercny() {
            return specialOffercny;
        }

        public int getPriceUsd() {
            return priceUsd;
        }

        public double getSpecialOfferaud() {
            return specialOfferaud;
        }

        public int getDataType() {
            return dataType;
        }

        public int getPriceType() {
            return priceType;
        }

        public String getBaseWebsite() {
            return baseWebsite;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public String getKeyWord() {
            return keyWord;
        }

        public double getNormalPriceaud() {
            return normalPriceaud;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public double getNormalPricecny() {
            return normalPricecny;
        }

        public String getCreateTime() {
            return createTime;
        }

        public List<AfnInfoAllListEntity> getAfnInfoAllList() {
            return afnInfoAllList;
        }

        public int getPriceCny() {
            return priceCny;
        }

        public int getIsHot() {
            return isHot;
        }

        public boolean isMark() {
            return mark;
        }

        public int getPriceAud() {
            return priceAud;
        }

        public int getStatus() {
            return status;
        }

        public int getWatchCount() {
            return watchCount;
        }

        public class AfnInfoAllListEntity {
            /**
             * columnOid : ff808081753f01880175404b78090044
             * totalPagenum : 3
             * endDate : null
             * mainPhoto : 20201020130304542.jpg
             * specialOfferusd : 11
             * isColumn : 1
             * oid : ff808081753f0188017543bee28400d4
             * title : 政府大礼包的核算
             * normalPriceusd : 1
             * contentType : 2
             * createTimeStr :
             * specialOffercny : 12
             * specialOfferaud : 11
             * commentInfoPagination : null
             * isDelete : 1
             * newstypeOid : 4028818773c18ea70173c193e8510001
             * dataType : 1
             * priceType : 3
             * updateTime : 2020-10-20 21:06:52
             * keyWord : 政府大礼
             * normalPriceaud : 1
             * beginDate : null
             * normalPricecny : 1
             * createTime : 2020-10-20 13:03:05
             * mark : false
             */
            private String columnOid;
            private int totalPagenum;
            private String endDate;
            private String mainPhoto;
            private int specialOfferusd;
            private int isColumn;
            private String oid;
            private String title;
            private int normalPriceusd;
            private int contentType;
            private String createTimeStr;
            private float specialOffercny;
            private int specialOfferaud;
            private String commentInfoPagination;
            private int isDelete;
            private String newstypeOid;
            private int dataType;
            private int priceType;
            private String updateTime;
            private String keyWord;
            private int normalPriceaud;
            private String beginDate;
            private float normalPricecny;
            private String createTime;
            private boolean mark;

            public void setColumnOid(String columnOid) {
                this.columnOid = columnOid;
            }

            public void setTotalPagenum(int totalPagenum) {
                this.totalPagenum = totalPagenum;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public void setMainPhoto(String mainPhoto) {
                this.mainPhoto = mainPhoto;
            }

            public void setSpecialOfferusd(int specialOfferusd) {
                this.specialOfferusd = specialOfferusd;
            }

            public void setIsColumn(int isColumn) {
                this.isColumn = isColumn;
            }

            public void setOid(String oid) {
                this.oid = oid;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setNormalPriceusd(int normalPriceusd) {
                this.normalPriceusd = normalPriceusd;
            }

            public void setContentType(int contentType) {
                this.contentType = contentType;
            }

            public void setCreateTimeStr(String createTimeStr) {
                this.createTimeStr = createTimeStr;
            }

            public void setSpecialOffercny(float specialOffercny) {
                this.specialOffercny = specialOffercny;
            }

            public void setSpecialOfferaud(int specialOfferaud) {
                this.specialOfferaud = specialOfferaud;
            }

            public void setCommentInfoPagination(String commentInfoPagination) {
                this.commentInfoPagination = commentInfoPagination;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public void setNewstypeOid(String newstypeOid) {
                this.newstypeOid = newstypeOid;
            }

            public void setDataType(int dataType) {
                this.dataType = dataType;
            }

            public void setPriceType(int priceType) {
                this.priceType = priceType;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public void setKeyWord(String keyWord) {
                this.keyWord = keyWord;
            }

            public void setNormalPriceaud(int normalPriceaud) {
                this.normalPriceaud = normalPriceaud;
            }

            public void setBeginDate(String beginDate) {
                this.beginDate = beginDate;
            }

            public void setNormalPricecny(float normalPricecny) {
                this.normalPricecny = normalPricecny;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public void setMark(boolean mark) {
                this.mark = mark;
            }

            public String getColumnOid() {
                return columnOid;
            }

            public int getTotalPagenum() {
                return totalPagenum;
            }

            public String getEndDate() {
                return endDate;
            }

            public String getMainPhoto() {
                return mainPhoto;
            }

            public int getSpecialOfferusd() {
                return specialOfferusd;
            }

            public int getIsColumn() {
                return isColumn;
            }

            public String getOid() {
                return oid;
            }

            public String getTitle() {
                return title;
            }

            public int getNormalPriceusd() {
                return normalPriceusd;
            }

            public int getContentType() {
                return contentType;
            }

            public String getCreateTimeStr() {
                return createTimeStr;
            }

            public float getSpecialOffercny() {
                return specialOffercny;
            }

            public int getSpecialOfferaud() {
                return specialOfferaud;
            }

            public String getCommentInfoPagination() {
                return commentInfoPagination;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public String getNewstypeOid() {
                return newstypeOid;
            }

            public int getDataType() {
                return dataType;
            }

            public int getPriceType() {
                return priceType;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public String getKeyWord() {
                return keyWord;
            }

            public int getNormalPriceaud() {
                return normalPriceaud;
            }

            public String getBeginDate() {
                return beginDate;
            }

            public float getNormalPricecny() {
                return normalPricecny;
            }

            public String getCreateTime() {
                return createTime;
            }

            public boolean isMark() {
                return mark;
            }
        }
    }
}
