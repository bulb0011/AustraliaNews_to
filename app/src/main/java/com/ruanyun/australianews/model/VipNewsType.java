package com.ruanyun.australianews.model;

import java.util.List;

public class VipNewsType  {


    /**
     * pageTotalCount : true
     * pageNumber : 1
     * datas : [{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200814170451959.jpg","specialOfferusd":28,"isColumn":1,"oid":"4028818a73ec12bb0173ec3717b33333","title":"欧盟对中33333","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":0.01,"specialOfferaud":0.01,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"updateTime":"2020-10-07 15:18:50","keyWord":"bran","normalPriceaud":0.01,"beginDate":null,"normalPricecny":0.01,"createTime":"2020-08-14 17:04:52","mark":false},{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","totalPagenum":0,"endDate":null,"mainPhoto":"20200814170451959.jpg","specialOfferusd":28,"isColumn":1,"oid":"4028818a73ec12bb0173ec3717b22222","title":"欧盟对中22222","normalPriceusd":30,"contentType":0,"createTimeStr":"","specialOffercny":0.01,"specialOfferaud":0.01,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":2,"updateTime":"2020-10-07 15:18:33","keyWord":"bran","normalPriceaud":0.01,"beginDate":null,"normalPricecny":0.01,"createTime":"2020-08-14 17:04:52","mark":false}]
     * maxPageNumber : 5
     * pageSize : 2
     * totalRows : 9
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
         * columnOid : 4028818773b7a3fb0173b7a6c0ba0000
         * totalPagenum : 0
         * endDate : null
         * mainPhoto : 20200814170451959.jpg
         * specialOfferusd : 28
         * isColumn : 1
         * oid : 4028818a73ec12bb0173ec3717b33333
         * title : 欧盟对中33333
         * normalPriceusd : 30
         * contentType : 0
         * createTimeStr :
         * specialOffercny : 0.01
         * specialOfferaud : 0.01
         * commentInfoPagination : null
         * isDelete : 1
         * newstypeOid : 4028818773c18ea70173c19040750000
         * dataType : 2
         * priceType : 1
         * updateTime : 2020-10-07 15:18:50
         * keyWord : bran
         * normalPriceaud : 0.01
         * beginDate : null
         * normalPricecny : 0.01
         * createTime : 2020-08-14 17:04:52
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
        private double specialOffercny;
        private double specialOfferaud;
        private String commentInfoPagination;
        private int isDelete;
        private String newstypeOid;
        private int dataType;
        private int priceType;
        private String updateTime;
        private String keyWord;
        private double normalPriceaud;
        private String beginDate;
        private double normalPricecny;
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

        public void setSpecialOffercny(double specialOffercny) {
            this.specialOffercny = specialOffercny;
        }

        public void setSpecialOfferaud(double specialOfferaud) {
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

        public void setNormalPriceaud(double normalPriceaud) {
            this.normalPriceaud = normalPriceaud;
        }

        public void setBeginDate(String beginDate) {
            this.beginDate = beginDate;
        }

        public void setNormalPricecny(double normalPricecny) {
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

        public double getSpecialOffercny() {
            return specialOffercny;
        }

        public double getSpecialOfferaud() {
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

        public double getNormalPriceaud() {
            return normalPriceaud;
        }

        public String getBeginDate() {
            return beginDate;
        }

        public double getNormalPricecny() {
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
