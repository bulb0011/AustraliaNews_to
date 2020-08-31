package com.ruanyun.australianews.model;

import java.util.List;

public class VipNewsType  {


    /**
     * pageTotalCount : true
     * pageNumber : 1
     * datas : [{"columnOid":"01234567890123456785ee98530c3caa","totalPagenum":2,"endDate":null,"mainPhoto":"20200730173206000.jpg","specialOfferusd":28,"isColumn":1,"oid":"40288187739f0f7b01739f10a9790000","title":"欧盟对中音频","normalPriceusd":30,"contentType":3,"createTimeStr":"","specialOffercny":98,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":1,"priceType":1,"updateTime":"2020-08-24 16:42:42","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":120.01,"createTime":"2020-07-30 17:32:06","mark":false},{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200805171528474.jpg","specialOfferusd":28,"isColumn":1,"oid":"01234567890123456785efc05065eb0e","title":"经济学人智库：企业对经济前景的悲观情绪有所缓解","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":98,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"updateTime":"2020-08-20 16:33:37","keyWord":"经济学人智库：企业对经济前景的悲观情绪有所缓解","normalPriceaud":50,"beginDate":null,"normalPricecny":100,"createTime":"2020-07-01 11:37:42","mark":false},{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200814170451959.jpg","specialOfferusd":28,"isColumn":1,"oid":"4028818a73ec12bb0173ec3717b11111","title":"欧盟对中11111","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":98,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"updateTime":"2020-08-20 16:32:02","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":100,"createTime":"2020-08-14 17:04:52","mark":false},{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200814170451959.jpg","specialOfferusd":28,"isColumn":1,"oid":"4028818a73ec12bb0173ec3717b22222","title":"欧盟对中22222","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":98,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"updateTime":"2020-08-20 16:32:02","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":100,"createTime":"2020-08-14 17:04:52","mark":false},{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200814170451959.jpg","specialOfferusd":28,"isColumn":1,"oid":"4028818a73ec12bb0173ec3717b33333","title":"欧盟对中33333","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":98,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"updateTime":"2020-08-20 16:32:02","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":100,"createTime":"2020-08-14 17:04:52","mark":false},{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200814170451959.jpg","specialOfferusd":28,"isColumn":1,"oid":"4028818a73ec12bb0173ec3717b40000","title":"欧盟对中","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":98,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"updateTime":"2020-08-20 16:32:02","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":100,"createTime":"2020-08-14 17:04:52","mark":false},{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200814170451959.jpg","specialOfferusd":28,"isColumn":1,"oid":"4028818a73ec12bb0173ec3717b44444","title":"欧盟对中44444","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":98,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"updateTime":"2020-08-20 16:32:02","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":100,"createTime":"2020-08-14 17:04:52","mark":false},{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200814170451959.jpg","specialOfferusd":28,"isColumn":1,"oid":"4028818a73ec12bb0173ec3717b55555","title":"欧盟对中55555","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":98,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"updateTime":"2020-08-20 16:32:02","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":100,"createTime":"2020-08-14 17:04:52","mark":false},{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200814170451959.jpg","specialOfferusd":28,"isColumn":1,"oid":"4028818a73ec12bb0173ec3717b66666","title":"欧盟对中66666","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":98,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"updateTime":"2020-08-20 16:32:02","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":100,"createTime":"2020-08-14 17:04:52","mark":false},{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200814170451959.jpg","specialOfferusd":28,"isColumn":1,"oid":"4028818a73ec12bb0173ec3717b77777","title":"欧盟对中77777","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":98,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"updateTime":"2020-08-20 16:32:02","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":100,"createTime":"2020-08-14 17:04:52","mark":false}]
     * maxPageNumber : 2
     * pageSize : 10
     * totalRows : 13
     */

    private boolean pageTotalCount;
    private int pageNumber;
    private int maxPageNumber;
    private int pageSize;
    private int totalRows;
    private List<DatasBean> datas;

    public boolean isPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(boolean pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getMaxPageNumber() {
        return maxPageNumber;
    }

    public void setMaxPageNumber(int maxPageNumber) {
        this.maxPageNumber = maxPageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * columnOid : 01234567890123456785ee98530c3caa
         * totalPagenum : 2
         * endDate : null
         * mainPhoto : 20200730173206000.jpg
         * specialOfferusd : 28
         * isColumn : 1
         * oid : 40288187739f0f7b01739f10a9790000
         * title : 欧盟对中音频
         * normalPriceusd : 30
         * contentType : 3
         * createTimeStr :
         * specialOffercny : 98
         * specialOfferaud : 48
         * commentInfoPagination : null
         * isDelete : 1
         * newstypeOid : 4028818773c18ea70173c19040750000
         * dataType : 1
         * priceType : 1
         * updateTime : 2020-08-24 16:42:42
         * keyWord : bran
         * normalPriceaud : 50
         * beginDate : null
         * normalPricecny : 120.01
         * createTime : 2020-07-30 17:32:06
         * mark : false
         */

        private String columnOid;
        private int totalPagenum;
        private Object endDate;
        private String mainPhoto;
        private int specialOfferusd;
        private int isColumn;
        private String oid;
        private String title;
        private int normalPriceusd;
        private int contentType;
        private String createTimeStr;
        private int specialOffercny;
        private int specialOfferaud;
        private Object commentInfoPagination;
        private int isDelete;
        private String newstypeOid;
        private int dataType;
        private int priceType;
        private String updateTime;
        private String keyWord;
        private int normalPriceaud;
        private Object beginDate;
        private double normalPricecny;
        private String createTime;
        private boolean mark;

        public String getColumnOid() {
            return columnOid;
        }

        public void setColumnOid(String columnOid) {
            this.columnOid = columnOid;
        }

        public int getTotalPagenum() {
            return totalPagenum;
        }

        public void setTotalPagenum(int totalPagenum) {
            this.totalPagenum = totalPagenum;
        }

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public String getMainPhoto() {
            return mainPhoto;
        }

        public void setMainPhoto(String mainPhoto) {
            this.mainPhoto = mainPhoto;
        }

        public int getSpecialOfferusd() {
            return specialOfferusd;
        }

        public void setSpecialOfferusd(int specialOfferusd) {
            this.specialOfferusd = specialOfferusd;
        }

        public int getIsColumn() {
            return isColumn;
        }

        public void setIsColumn(int isColumn) {
            this.isColumn = isColumn;
        }

        public String getOid() {
            return oid;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getNormalPriceusd() {
            return normalPriceusd;
        }

        public void setNormalPriceusd(int normalPriceusd) {
            this.normalPriceusd = normalPriceusd;
        }

        public int getContentType() {
            return contentType;
        }

        public void setContentType(int contentType) {
            this.contentType = contentType;
        }

        public String getCreateTimeStr() {
            return createTimeStr;
        }

        public void setCreateTimeStr(String createTimeStr) {
            this.createTimeStr = createTimeStr;
        }

        public int getSpecialOffercny() {
            return specialOffercny;
        }

        public void setSpecialOffercny(int specialOffercny) {
            this.specialOffercny = specialOffercny;
        }

        public int getSpecialOfferaud() {
            return specialOfferaud;
        }

        public void setSpecialOfferaud(int specialOfferaud) {
            this.specialOfferaud = specialOfferaud;
        }

        public Object getCommentInfoPagination() {
            return commentInfoPagination;
        }

        public void setCommentInfoPagination(Object commentInfoPagination) {
            this.commentInfoPagination = commentInfoPagination;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public String getNewstypeOid() {
            return newstypeOid;
        }

        public void setNewstypeOid(String newstypeOid) {
            this.newstypeOid = newstypeOid;
        }

        public int getDataType() {
            return dataType;
        }

        public void setDataType(int dataType) {
            this.dataType = dataType;
        }

        public int getPriceType() {
            return priceType;
        }

        public void setPriceType(int priceType) {
            this.priceType = priceType;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getKeyWord() {
            return keyWord;
        }

        public void setKeyWord(String keyWord) {
            this.keyWord = keyWord;
        }

        public int getNormalPriceaud() {
            return normalPriceaud;
        }

        public void setNormalPriceaud(int normalPriceaud) {
            this.normalPriceaud = normalPriceaud;
        }

        public Object getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Object beginDate) {
            this.beginDate = beginDate;
        }

        public double getNormalPricecny() {
            return normalPricecny;
        }

        public void setNormalPricecny(double normalPricecny) {
            this.normalPricecny = normalPricecny;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public boolean isMark() {
            return mark;
        }

        public void setMark(boolean mark) {
            this.mark = mark;
        }
    }
}
