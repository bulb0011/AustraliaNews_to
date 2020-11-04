package com.ruanyun.australianews.model;

import java.util.List;

public class newsAfnInfoAll {


    /**
     * mainPhoto : 20201029124327585.jpg
     * specialOfferusd : null
     * oid : ff8080817571f5f00175720629f80003
     * title : 专业人事套餐
     * type : null
     * outUrl : null
     * videoUrl : null
     * normalPriceusd : null
     * contentType : null
     * createTimeStr : 2020-10-29 12:43:28
     * specialOffercny : null
     * priceUsd : null
     * specialOfferaud : null
     * isDelete : 1
     * dataType : 3
     * priceType : null
     * updateTime : 1604289166000
     * baseWebsite : null
     * keyWord : null
     * commentCount : 0
     * normalPriceaud : null
     * baseUrl : null
     * normalPricecny : null
     * createTime : 1603935808000
     * priceCny : null
     * afnInfoAllList : [{"columnOid":"ff8080817571f5f00175720629f80003","totalPagenum":1,"endDate":null,"mainPhoto":"20201029124858996.jpg","specialOfferusd":0.01,"oid":"ff8080817571f5f00175720b379d000a","isColumn":1,"title":"什么是取款功能（Redraw Facility）？","normalPriceusd":1,"contentType":1,"createTimeStr":null,"specialOffercny":0.01,"specialOfferaud":0.01,"newstypeOid":"4028818773c18ea70173c19040750000","isDelete":1,"commentInfoPagination":null,"dataType":1,"priceType":2,"updateTime":1603942287000,"keyWord":"什么是取款功能（Redraw Facility）？","normalPriceaud":1,"beginDate":null,"normalPricecny":1,"createTime":1603936139000,"mark":false},{"columnOid":"ff8080817571f5f00175720629f80003","totalPagenum":1,"endDate":null,"mainPhoto":"20201029124654317.jpg","specialOfferusd":null,"oid":"ff8080817571f5f00175720950a80008","isColumn":1,"title":"还款频率与还款速度有什么样的关系","normalPriceusd":null,"contentType":1,"createTimeStr":null,"specialOffercny":null,"specialOfferaud":null,"newstypeOid":"4028818773c18ea70173c19040750000","isDelete":1,"commentInfoPagination":null,"dataType":1,"priceType":3,"updateTime":1603936014000,"keyWord":"还款频率与还款速度有什么样的关系","normalPriceaud":null,"beginDate":null,"normalPricecny":null,"createTime":1603936014000,"mark":false}]
     * isHot : 2
     * mark : false
     * watchCount : 65
     * priceAud : null
     * status : 1
     */
    private String mainPhoto;
    private String specialOfferusd;
    private String oid;
    private String title;
    private String type;
    private String outUrl;
    private String videoUrl;
    private String normalPriceusd;
    private String contentType;
    private String createTimeStr;
    private String specialOffercny;
    private String priceUsd;
    private String specialOfferaud;
    private int isDelete;
    private int dataType;
    private String priceType;
    private long updateTime;
    private String baseWebsite;
    private String keyWord;
    private int commentCount;
    private String normalPriceaud;
    private String baseUrl;
    private String normalPricecny;
    private long createTime;
    private String priceCny;
    private List<AfnInfoAllListEntity> afnInfoAllList;
    private int isHot;
    private boolean mark;
    private int watchCount;
    private String priceAud;
    private int status;

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public void setSpecialOfferusd(String specialOfferusd) {
        this.specialOfferusd = specialOfferusd;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOutUrl(String outUrl) {
        this.outUrl = outUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setNormalPriceusd(String normalPriceusd) {
        this.normalPriceusd = normalPriceusd;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public void setSpecialOffercny(String specialOffercny) {
        this.specialOffercny = specialOffercny;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public void setSpecialOfferaud(String specialOfferaud) {
        this.specialOfferaud = specialOfferaud;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public void setBaseWebsite(String baseWebsite) {
        this.baseWebsite = baseWebsite;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setNormalPriceaud(String normalPriceaud) {
        this.normalPriceaud = normalPriceaud;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setNormalPricecny(String normalPricecny) {
        this.normalPricecny = normalPricecny;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setPriceCny(String priceCny) {
        this.priceCny = priceCny;
    }

    public void setAfnInfoAllList(List<AfnInfoAllListEntity> afnInfoAllList) {
        this.afnInfoAllList = afnInfoAllList;
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

    public void setPriceAud(String priceAud) {
        this.priceAud = priceAud;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public String getSpecialOfferusd() {
        return specialOfferusd;
    }

    public String getOid() {
        return oid;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getOutUrl() {
        return outUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getNormalPriceusd() {
        return normalPriceusd;
    }

    public String getContentType() {
        return contentType;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public String getSpecialOffercny() {
        return specialOffercny;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public String getSpecialOfferaud() {
        return specialOfferaud;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public int getDataType() {
        return dataType;
    }

    public String getPriceType() {
        return priceType;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public String getBaseWebsite() {
        return baseWebsite;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public String getNormalPriceaud() {
        return normalPriceaud;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getNormalPricecny() {
        return normalPricecny;
    }

    public long getCreateTime() {
        return createTime;
    }

    public String getPriceCny() {
        return priceCny;
    }

    public List<AfnInfoAllListEntity> getAfnInfoAllList() {
        return afnInfoAllList;
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

    public String getPriceAud() {
        return priceAud;
    }

    public int getStatus() {
        return status;
    }

    public class AfnInfoAllListEntity {
        /**
         * columnOid : ff8080817571f5f00175720629f80003
         * totalPagenum : 1
         * endDate : null
         * mainPhoto : 20201029124858996.jpg
         * specialOfferusd : 0.01
         * oid : ff8080817571f5f00175720b379d000a
         * isColumn : 1
         * title : 什么是取款功能（Redraw Facility）？
         * normalPriceusd : 1
         * contentType : 1
         * createTimeStr : null
         * specialOffercny : 0.01
         * specialOfferaud : 0.01
         * newstypeOid : 4028818773c18ea70173c19040750000
         * isDelete : 1
         * commentInfoPagination : null
         * dataType : 1
         * priceType : 2
         * updateTime : 1603942287000
         * keyWord : 什么是取款功能（Redraw Facility）？
         * normalPriceaud : 1
         * beginDate : null
         * normalPricecny : 1
         * createTime : 1603936139000
         * mark : false
         */
        private String columnOid;
        private int totalPagenum;
        private String endDate;
        private String mainPhoto;
        private double specialOfferusd;
        private String oid;
        private int isColumn;
        private String title;
        private int normalPriceusd;
        private int contentType;
        private String createTimeStr;
        private double specialOffercny;
        private double specialOfferaud;
        private String newstypeOid;
        private int isDelete;
        private String commentInfoPagination;
        private int dataType;
        private int priceType;
        private long updateTime;
        private String keyWord;
        private int normalPriceaud;
        private String beginDate;
        private int normalPricecny;
        private long createTime;
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

        public void setSpecialOfferusd(double specialOfferusd) {
            this.specialOfferusd = specialOfferusd;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public void setIsColumn(int isColumn) {
            this.isColumn = isColumn;
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

        public void setSpecialOffercny(double specialOffercny) {
            this.specialOffercny = specialOffercny;
        }

        public void setSpecialOfferaud(double specialOfferaud) {
            this.specialOfferaud = specialOfferaud;
        }

        public void setNewstypeOid(String newstypeOid) {
            this.newstypeOid = newstypeOid;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public void setCommentInfoPagination(String commentInfoPagination) {
            this.commentInfoPagination = commentInfoPagination;
        }

        public void setDataType(int dataType) {
            this.dataType = dataType;
        }

        public void setPriceType(int priceType) {
            this.priceType = priceType;
        }

        public void setUpdateTime(long updateTime) {
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

        public void setNormalPricecny(int normalPricecny) {
            this.normalPricecny = normalPricecny;
        }

        public void setCreateTime(long createTime) {
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

        public double getSpecialOfferusd() {
            return specialOfferusd;
        }

        public String getOid() {
            return oid;
        }

        public int getIsColumn() {
            return isColumn;
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

        public double getSpecialOffercny() {
            return specialOffercny;
        }

        public double getSpecialOfferaud() {
            return specialOfferaud;
        }

        public String getNewstypeOid() {
            return newstypeOid;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public String getCommentInfoPagination() {
            return commentInfoPagination;
        }

        public int getDataType() {
            return dataType;
        }

        public int getPriceType() {
            return priceType;
        }

        public long getUpdateTime() {
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

        public int getNormalPricecny() {
            return normalPricecny;
        }

        public long getCreateTime() {
            return createTime;
        }

        public boolean isMark() {
            return mark;
        }
    }
}
