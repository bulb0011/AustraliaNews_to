package com.ruanyun.australianews.model;

import java.util.List;

public class HotInfo {

    /**
     * pageTotalCount : true
     * pageNumber : 1
     * datas : [{"columnOid":"","totalPagenum":133,"city":"","endDate":null,"userOid":"","flag3":"","flag2":"","mainPhoto":"20200907140257881.jpg","recommendation":"","flag1":"","limitedtimeFreeId":"","specialOfferusd":28,"isColumn":0,"oid":"4028818773b394260173b3a0e99d0026","citys":null,"title":"欧盟对中111pdf","content":"","afnFreeTime":null,"afnNewsDirectoryList":[],"afnnewsDirectoryOid":"","normalPriceusd":30,"sysUser":null,"afnNewsColumn":null,"contentType":1,"createTimeStr":"","uv":0,"specialOffercny":0.01,"specialOfferaud":0.01,"afnNewsType":null,"commentInfoPagination":null,"isDelete":0,"newstypeOid":"","priceType":1,"updateTime":null,"commentCount":0,"keyWord":"bran","normalPriceaud":0.01,"beginDate":null,"normalPricecny":0.01,"createTime":null,"isTop":0,"isHot":0,"mark":false,"watchCount":0},{"columnOid":"","totalPagenum":0,"city":"","endDate":null,"userOid":"","flag3":"","flag2":"","mainPhoto":"20200731124746871.jpg","recommendation":"","flag1":"","limitedtimeFreeId":"","specialOfferusd":28,"isColumn":0,"oid":"4028818773a32d410173a332d75d0000","citys":null,"title":"欧盟对中1234pdf","content":"","afnFreeTime":null,"afnNewsDirectoryList":[],"afnnewsDirectoryOid":"","normalPriceusd":30,"sysUser":null,"afnNewsColumn":null,"contentType":1,"createTimeStr":"","uv":0,"specialOffercny":0.01,"specialOfferaud":0.01,"afnNewsType":null,"commentInfoPagination":null,"isDelete":0,"newstypeOid":"","priceType":2,"updateTime":null,"commentCount":0,"keyWord":"bran","normalPriceaud":0.01,"beginDate":null,"normalPricecny":0.01,"createTime":null,"isTop":0,"isHot":0,"mark":false,"watchCount":0}]
     * maxPageNumber : 10
     * pageSize : 2
     * totalRows : 19
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
         * columnOid :
         * totalPagenum : 133
         * city :
         * endDate : null
         * userOid :
         * flag3 :
         * flag2 :
         * mainPhoto : 20200907140257881.jpg
         * recommendation :
         * flag1 :
         * limitedtimeFreeId :
         * specialOfferusd : 28
         * isColumn : 0
         * oid : 4028818773b394260173b3a0e99d0026
         * citys : null
         * title : 欧盟对中111pdf
         * content :
         * afnFreeTime : null
         * afnNewsDirectoryList : []
         * afnnewsDirectoryOid :
         * normalPriceusd : 30
         * sysUser : null
         * afnNewsColumn : null
         * contentType : 1
         * createTimeStr :
         * uv : 0
         * specialOffercny : 0.01
         * specialOfferaud : 0.01
         * afnNewsType : null
         * commentInfoPagination : null
         * isDelete : 0
         * newstypeOid :
         * priceType : 1
         * updateTime : null
         * commentCount : 0
         * keyWord : bran
         * normalPriceaud : 0.01
         * beginDate : null
         * normalPricecny : 0.01
         * createTime : null
         * isTop : 0
         * isHot : 0
         * mark : false
         * watchCount : 0
         */
        private String columnOid;
        private int totalPagenum;
        private String city;
        private String endDate;
        private String userOid;
        private String flag3;
        private String flag2;
        private String mainPhoto;
        private String recommendation;
        private String flag1;
        private String limitedtimeFreeId;
        private int specialOfferusd;
        private int isColumn;
        private String oid;
        private String citys;
        private String title;
        private String content;
        private String afnFreeTime;
        private List<?> afnNewsDirectoryList;
        private String afnnewsDirectoryOid;
        private int normalPriceusd;
        private String sysUser;
        private String afnNewsColumn;
        private int contentType;
        private String createTimeStr;
        private int uv;
        private double specialOffercny;
        private double specialOfferaud;
        private String afnNewsType;
        private String commentInfoPagination;
        private int isDelete;
        private String newstypeOid;
        private int priceType;
        private String updateTime;
        private int commentCount;
        private String keyWord;
        private double normalPriceaud;
        private String beginDate;
        private double normalPricecny;
        private String createTime;
        private int isTop;
        private int isHot;
        private boolean mark;
        private int watchCount;

        public void setColumnOid(String columnOid) {
            this.columnOid = columnOid;
        }

        public void setTotalPagenum(int totalPagenum) {
            this.totalPagenum = totalPagenum;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public void setUserOid(String userOid) {
            this.userOid = userOid;
        }

        public void setFlag3(String flag3) {
            this.flag3 = flag3;
        }

        public void setFlag2(String flag2) {
            this.flag2 = flag2;
        }

        public void setMainPhoto(String mainPhoto) {
            this.mainPhoto = mainPhoto;
        }

        public void setRecommendation(String recommendation) {
            this.recommendation = recommendation;
        }

        public void setFlag1(String flag1) {
            this.flag1 = flag1;
        }

        public void setLimitedtimeFreeId(String limitedtimeFreeId) {
            this.limitedtimeFreeId = limitedtimeFreeId;
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

        public void setCitys(String citys) {
            this.citys = citys;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAfnFreeTime(String afnFreeTime) {
            this.afnFreeTime = afnFreeTime;
        }

        public void setAfnNewsDirectoryList(List<?> afnNewsDirectoryList) {
            this.afnNewsDirectoryList = afnNewsDirectoryList;
        }

        public void setAfnnewsDirectoryOid(String afnnewsDirectoryOid) {
            this.afnnewsDirectoryOid = afnnewsDirectoryOid;
        }

        public void setNormalPriceusd(int normalPriceusd) {
            this.normalPriceusd = normalPriceusd;
        }

        public void setSysUser(String sysUser) {
            this.sysUser = sysUser;
        }

        public void setAfnNewsColumn(String afnNewsColumn) {
            this.afnNewsColumn = afnNewsColumn;
        }

        public void setContentType(int contentType) {
            this.contentType = contentType;
        }

        public void setCreateTimeStr(String createTimeStr) {
            this.createTimeStr = createTimeStr;
        }

        public void setUv(int uv) {
            this.uv = uv;
        }

        public void setSpecialOffercny(double specialOffercny) {
            this.specialOffercny = specialOffercny;
        }

        public void setSpecialOfferaud(double specialOfferaud) {
            this.specialOfferaud = specialOfferaud;
        }

        public void setAfnNewsType(String afnNewsType) {
            this.afnNewsType = afnNewsType;
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

        public void setPriceType(int priceType) {
            this.priceType = priceType;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
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

        public void setBeginDate(String beginDate) {
            this.beginDate = beginDate;
        }

        public void setNormalPricecny(double normalPricecny) {
            this.normalPricecny = normalPricecny;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setIsTop(int isTop) {
            this.isTop = isTop;
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

        public String getColumnOid() {
            return columnOid;
        }

        public int getTotalPagenum() {
            return totalPagenum;
        }

        public String getCity() {
            return city;
        }

        public String getEndDate() {
            return endDate;
        }

        public String getUserOid() {
            return userOid;
        }

        public String getFlag3() {
            return flag3;
        }

        public String getFlag2() {
            return flag2;
        }

        public String getMainPhoto() {
            return mainPhoto;
        }

        public String getRecommendation() {
            return recommendation;
        }

        public String getFlag1() {
            return flag1;
        }

        public String getLimitedtimeFreeId() {
            return limitedtimeFreeId;
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

        public String getCitys() {
            return citys;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAfnFreeTime() {
            return afnFreeTime;
        }

        public List<?> getAfnNewsDirectoryList() {
            return afnNewsDirectoryList;
        }

        public String getAfnnewsDirectoryOid() {
            return afnnewsDirectoryOid;
        }

        public int getNormalPriceusd() {
            return normalPriceusd;
        }

        public String getSysUser() {
            return sysUser;
        }

        public String getAfnNewsColumn() {
            return afnNewsColumn;
        }

        public int getContentType() {
            return contentType;
        }

        public String getCreateTimeStr() {
            return createTimeStr;
        }

        public int getUv() {
            return uv;
        }

        public double getSpecialOffercny() {
            return specialOffercny;
        }

        public double getSpecialOfferaud() {
            return specialOfferaud;
        }

        public String getAfnNewsType() {
            return afnNewsType;
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

        public int getPriceType() {
            return priceType;
        }

        public String getUpdateTime() {
            return updateTime;
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

        public String getBeginDate() {
            return beginDate;
        }

        public double getNormalPricecny() {
            return normalPricecny;
        }

        public String getCreateTime() {
            return createTime;
        }

        public int getIsTop() {
            return isTop;
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
