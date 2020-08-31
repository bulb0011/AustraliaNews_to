package com.ruanyun.australianews.model;

import java.util.List;

public class VipColumnInfo {


    /**
     * pageTotalCount : true
     * pageNumber : 1
     * datas : [{"endDate":null,"userOid":"","flag3":"","flag2":"","mainPhoto":"20200804120659350.jpg","flag1":"","oid":"4028818773b7a3fb0173b7a6c0ba0000","title":"（会员专栏）拯救疫情下的行业","content":"<p>qw45e6rt.,kmjnh<\/p>","sysUser":null,"createTimeStr":"","uv":0,"priceUsd":30,"commentInfoPagination":null,"isDelete":0,"updateTime":null,"commentCount":0,"beginDate":null,"createTime":null,"isTop":0,"afnInfoAllList":[{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","specialOffercny":98,"endDate":null,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":1,"priceType":1,"mainPhoto":"20200803172208117.jpg","specialOfferusd":28,"updateTime":"2020-08-13 17:13:56","isColumn":1,"oid":"4028818773b394260173b3a0e99d0026","title":"欧盟对中111pdf","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":120,"createTime":"2020-08-03 17:22:08","normalPriceusd":30,"contentType":1,"createTimeStr":"","mark":false}],"priceCny":120,"isHot":0,"mark":false,"priceAud":50,"status":1,"watchCount":0},{"endDate":null,"userOid":"","flag3":"","flag2":"","mainPhoto":"20200804120659350.jpg","flag1":"","oid":"01234567890123456785ee98530c3caa","title":"（会员专栏）拯救疫情下的行业1","content":"<p>qw45e6rt.,kmjnh<\/p>","sysUser":null,"createTimeStr":"","uv":0,"priceUsd":30,"commentInfoPagination":null,"isDelete":0,"updateTime":null,"commentCount":0,"beginDate":null,"createTime":null,"isTop":0,"afnInfoAllList":[{"columnOid":"01234567890123456785ee98530c3caa","specialOffercny":98,"endDate":null,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":2,"priceType":1,"mainPhoto":"20200805171528474.jpg","specialOfferusd":28,"updateTime":"2020-08-20 14:24:16","isColumn":1,"oid":"01234567890123456785efc05065eb0e","title":"经济学人智库：企业对经济前景的悲观情绪有所缓解","keyWord":"经济学人智库：企业对经济前景的悲观情绪有所缓解","normalPriceaud":50,"beginDate":null,"normalPricecny":100,"createTime":"2020-07-01 11:37:42","normalPriceusd":30,"contentType":0,"createTimeStr":"","mark":false}],"priceCny":120,"isHot":0,"mark":false,"priceAud":50,"status":1,"watchCount":0}]
     * maxPageNumber : 1
     * pageSize : 10
     * totalRows : 2
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
         * endDate : null
         * userOid :
         * flag3 :
         * flag2 :
         * mainPhoto : 20200804120659350.jpg
         * flag1 :
         * oid : 4028818773b7a3fb0173b7a6c0ba0000
         * title : （会员专栏）拯救疫情下的行业
         * content : <p>qw45e6rt.,kmjnh</p>
         * sysUser : null
         * createTimeStr :
         * uv : 0
         * priceUsd : 30
         * commentInfoPagination : null
         * isDelete : 0
         * updateTime : null
         * commentCount : 0
         * beginDate : null
         * createTime : null
         * isTop : 0
         * afnInfoAllList : [{"columnOid":"4028818773b7a3fb0173b7a6c0ba0000","specialOffercny":98,"endDate":null,"specialOfferaud":48,"commentInfoPagination":null,"isDelete":1,"newstypeOid":"4028818773c18ea70173c19040750000","dataType":1,"priceType":1,"mainPhoto":"20200803172208117.jpg","specialOfferusd":28,"updateTime":"2020-08-13 17:13:56","isColumn":1,"oid":"4028818773b394260173b3a0e99d0026","title":"欧盟对中111pdf","keyWord":"bran","normalPriceaud":50,"beginDate":null,"normalPricecny":120,"createTime":"2020-08-03 17:22:08","normalPriceusd":30,"contentType":1,"createTimeStr":"","mark":false}]
         * priceCny : 120
         * isHot : 0
         * mark : false
         * priceAud : 50
         * status : 1
         * watchCount : 0
         */

        private Object endDate;
        private String userOid;
        private String flag3;
        private String flag2;
        private String mainPhoto;
        private String flag1;
        private String oid;
        private String title;
        private String content;
        private Object sysUser;
        private String createTimeStr;
        private int uv;
        private int priceUsd;
        private Object commentInfoPagination;
        private int isDelete;
        private Object updateTime;
        private int commentCount;
        private Object beginDate;
        private Object createTime;
        private int isTop;
        private int priceCny;
        private int isHot;
        private boolean mark;
        private int priceAud;
        private int status;
        private int watchCount;
        private List<AfnInfoAllListBean> afnInfoAllList;

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public String getUserOid() {
            return userOid;
        }

        public void setUserOid(String userOid) {
            this.userOid = userOid;
        }

        public String getFlag3() {
            return flag3;
        }

        public void setFlag3(String flag3) {
            this.flag3 = flag3;
        }

        public String getFlag2() {
            return flag2;
        }

        public void setFlag2(String flag2) {
            this.flag2 = flag2;
        }

        public String getMainPhoto() {
            return mainPhoto;
        }

        public void setMainPhoto(String mainPhoto) {
            this.mainPhoto = mainPhoto;
        }

        public String getFlag1() {
            return flag1;
        }

        public void setFlag1(String flag1) {
            this.flag1 = flag1;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getSysUser() {
            return sysUser;
        }

        public void setSysUser(Object sysUser) {
            this.sysUser = sysUser;
        }

        public String getCreateTimeStr() {
            return createTimeStr;
        }

        public void setCreateTimeStr(String createTimeStr) {
            this.createTimeStr = createTimeStr;
        }

        public int getUv() {
            return uv;
        }

        public void setUv(int uv) {
            this.uv = uv;
        }

        public int getPriceUsd() {
            return priceUsd;
        }

        public void setPriceUsd(int priceUsd) {
            this.priceUsd = priceUsd;
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

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public Object getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Object beginDate) {
            this.beginDate = beginDate;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public int getIsTop() {
            return isTop;
        }

        public void setIsTop(int isTop) {
            this.isTop = isTop;
        }

        public int getPriceCny() {
            return priceCny;
        }

        public void setPriceCny(int priceCny) {
            this.priceCny = priceCny;
        }

        public int getIsHot() {
            return isHot;
        }

        public void setIsHot(int isHot) {
            this.isHot = isHot;
        }

        public boolean isMark() {
            return mark;
        }

        public void setMark(boolean mark) {
            this.mark = mark;
        }

        public int getPriceAud() {
            return priceAud;
        }

        public void setPriceAud(int priceAud) {
            this.priceAud = priceAud;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWatchCount() {
            return watchCount;
        }

        public void setWatchCount(int watchCount) {
            this.watchCount = watchCount;
        }

        public List<AfnInfoAllListBean> getAfnInfoAllList() {
            return afnInfoAllList;
        }

        public void setAfnInfoAllList(List<AfnInfoAllListBean> afnInfoAllList) {
            this.afnInfoAllList = afnInfoAllList;
        }

        public static class AfnInfoAllListBean {
            /**
             * columnOid : 4028818773b7a3fb0173b7a6c0ba0000
             * specialOffercny : 98
             * endDate : null
             * specialOfferaud : 48
             * commentInfoPagination : null
             * isDelete : 1
             * newstypeOid : 4028818773c18ea70173c19040750000
             * dataType : 1
             * priceType : 1
             * mainPhoto : 20200803172208117.jpg
             * specialOfferusd : 28
             * updateTime : 2020-08-13 17:13:56
             * isColumn : 1
             * oid : 4028818773b394260173b3a0e99d0026
             * title : 欧盟对中111pdf
             * keyWord : bran
             * normalPriceaud : 50
             * beginDate : null
             * normalPricecny : 120
             * createTime : 2020-08-03 17:22:08
             * normalPriceusd : 30
             * contentType : 1
             * createTimeStr :
             * mark : false
             */

            private String columnOid;
            private int specialOffercny;
            private Object endDate;
            private int specialOfferaud;
            private Object commentInfoPagination;
            private int isDelete;
            private String newstypeOid;
            private int dataType;
            private int priceType;
            private String mainPhoto;
            private int specialOfferusd;
            private String updateTime;
            private int isColumn;
            private String oid;
            private String title;
            private String keyWord;
            private int normalPriceaud;
            private Object beginDate;
            private int normalPricecny;
            private String createTime;
            private int normalPriceusd;
            private int contentType;
            private String createTimeStr;
            private boolean mark;

            public String getColumnOid() {
                return columnOid;
            }

            public void setColumnOid(String columnOid) {
                this.columnOid = columnOid;
            }

            public int getSpecialOffercny() {
                return specialOffercny;
            }

            public void setSpecialOffercny(int specialOffercny) {
                this.specialOffercny = specialOffercny;
            }

            public Object getEndDate() {
                return endDate;
            }

            public void setEndDate(Object endDate) {
                this.endDate = endDate;
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

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
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

            public int getNormalPricecny() {
                return normalPricecny;
            }

            public void setNormalPricecny(int normalPricecny) {
                this.normalPricecny = normalPricecny;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
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

            public boolean isMark() {
                return mark;
            }

            public void setMark(boolean mark) {
                this.mark = mark;
            }
        }
    }
}
