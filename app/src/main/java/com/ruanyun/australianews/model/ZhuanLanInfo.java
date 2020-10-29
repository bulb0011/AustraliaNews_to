package com.ruanyun.australianews.model;

import java.util.List;

public class ZhuanLanInfo {


    /**
     * pageTotalCount : true
     * pageNumber : 1
     * datas : [{"columnOid":"ff8080817548cceb01754945a5110071","totalPagenum":1,"endDate":null,"mainPhoto":"20201022171346108.jpg","specialOfferusd":0,"isColumn":1,"oid":"ff808081754e74cc01754ef11f5d0014","title":"如果现在我是刚需","normalPriceusd":30,"contentType":2,"createTimeStr":"","specialOffercny":0,"specialOfferaud":0,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c193e8510001","dataType":1,"priceType":1,"updateTime":"2020-10-23 16:51:22","keyWord":"如果现在我是刚需","normalPriceaud":0.01,"beginDate":null,"normalPricecny":0.01,"createTime":"2020-10-22 17:13:46","mark":false},{"columnOid":"ff8080817548cceb01754945a5110071","totalPagenum":2,"endDate":null,"mainPhoto":"20201021145133066.jpg","specialOfferusd":0,"isColumn":1,"oid":"ff8080817548cceb017549488e910074","title":"贷款前的自我评估","normalPriceusd":0,"contentType":1,"createTimeStr":"","specialOffercny":0,"specialOfferaud":0,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c194c4950003","dataType":1,"priceType":3,"updateTime":"2020-10-22 20:57:05","keyWord":"贷款前的自我评估","normalPriceaud":0,"beginDate":null,"normalPricecny":0,"createTime":"2020-10-21 14:51:33","mark":false},{"columnOid":"ff8080817548cceb01754945a5110071","totalPagenum":0,"endDate":null,"mainPhoto":"20201021171744381.jpg","specialOfferusd":0,"isColumn":1,"oid":"ff8080817548cceb017549ce6555009f","title":"长期高还款额","normalPriceusd":1,"contentType":0,"createTimeStr":"","specialOffercny":0,"specialOfferaud":0,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c193e8510001","dataType":2,"priceType":3,"updateTime":"2020-10-22 09:24:07","keyWord":"长期高还款额","normalPriceaud":1,"beginDate":null,"normalPricecny":1,"createTime":"2020-10-21 17:17:44","mark":false},{"columnOid":"ff8080817548cceb01754945a5110071","totalPagenum":11,"endDate":null,"mainPhoto":"20201021175954165.jpg","specialOfferusd":0,"isColumn":1,"oid":"ff8080817549e409017549f50034000e","title":"浮动利息与固定利息的选择","normalPriceusd":1,"contentType":1,"createTimeStr":"","specialOffercny":0,"specialOfferaud":0,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":1,"priceType":1,"updateTime":"2020-10-21 18:01:01","keyWord":"浮动利息与固定利息的选择","normalPriceaud":1,"beginDate":null,"normalPricecny":1,"createTime":"2020-10-21 17:59:54","mark":false},{"columnOid":"ff8080817548cceb01754945a5110071","totalPagenum":1,"endDate":null,"mainPhoto":"20201021145408069.jpg","specialOfferusd":0,"isColumn":1,"oid":"ff8080817548cceb0175494aebe90076","title":"\u201c本息同还\u201d还是\u201c只还利息\u201d","normalPriceusd":1,"contentType":1,"createTimeStr":"","specialOffercny":0,"specialOfferaud":0,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c193e8510001","dataType":1,"priceType":1,"updateTime":"2020-10-21 17:41:46","keyWord":"\u201c本息同还\u201d还是\u201c只还利息\u201d","normalPriceaud":1,"beginDate":null,"normalPricecny":1,"createTime":"2020-10-21 14:54:08","mark":false}]
     * maxPageNumber : 1
     * pageSize : 10
     * totalRows : 5
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
         * "isBuy":1                //类型：Number  必有字段  备注：是否已经购买 1是、2或其他为否
         * columnOid : ff8080817548cceb01754945a5110071
         * totalPagenum : 1
         * endDate : null
         * mainPhoto : 20201022171346108.jpg
         * specialOfferusd : 0
         * isColumn : 1
         * oid : ff808081754e74cc01754ef11f5d0014
         * title : 如果现在我是刚需
         * normalPriceusd : 30
         * contentType : 2
         * createTimeStr :
         * specialOffercny : 0
         * specialOfferaud : 0
         * commentInfoPagination : null
         * isDelete : 1
         * newstypeOid : 4028818773c18ea70173c193e8510001
         * dataType : 1
         * priceType : 1
         * updateTime : 2020-10-23 16:51:22
         * keyWord : 如果现在我是刚需
         * normalPriceaud : 0.01
         * beginDate : null
         * normalPricecny : 0.01
         * createTime : 2020-10-22 17:13:46
         * mark : false
         */
        private String columnOid;
        private int totalPagenum;
        private String endDate;
        private String mainPhoto;
        private float specialOfferusd;
        private int isColumn;
        private String oid;
        private String title;
        private float normalPriceusd;
        private int contentType;
        private String createTimeStr;
        private float specialOffercny;
        private float specialOfferaud;
        private String commentInfoPagination;
        private int isDelete;
        private String newstypeOid;
        private int dataType;
        private int priceType;
        private String updateTime;
        private String keyWord;
        private float normalPriceaud;
        private String beginDate;
        private float normalPricecny;
        private String createTime;
        private boolean mark;

        private int isBuy;

        public int getIsBuy() {
            return isBuy;
        }

        public void setIsBuy(int isBuy) {
            this.isBuy = isBuy;
        }



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

        public void setSpecialOfferusd(float specialOfferusd) {
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

        public void setNormalPriceusd(float normalPriceusd) {
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

        public void setSpecialOfferaud(float specialOfferaud) {
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

        public void setNormalPriceaud(float normalPriceaud) {
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

        public float getSpecialOfferusd() {
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

        public float getNormalPriceusd() {
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

        public float getSpecialOfferaud() {
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

        public float getNormalPriceaud() {
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
