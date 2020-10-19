package com.ruanyun.australianews.model;

import java.util.List;

public class VipDetailIfo {

    /**
     * access_token :
     * msg : 获取成功
     * code : 0
     * data : {"columnOid":"","totalPagenum":0,"city":"","endDate":null,"userOid":"","flag3":"","flag2":"","mainPhoto":"20200730173206000.jpg","recommendation":"<p>2345YTR345THGRF<\/p>","flag1":"","limitedtimeFreeId":"","specialOfferusd":28,"isColumn":0,"oid":"40288187739f0f7b01739f10a9790000","citys":null,"title":"欧盟对中音频","content":"<p>AERHWEJYJHTGR<\/p>","afnFreeTime":null,"afnNewsDirectoryList":[{"afnNewsInfo":null,"uv":0,"userOid":"","afnNewsinfoOid":"","isDelete":0,"flag3":"","flag2":"","flag1":"","updateTime":null,"oid":"4028818773b8213e0173b832137b0000","sort":1,"title":"欧盟对中","pdfPagenum":0,"content":"","commentCount":0,"keyWord":"bran","duration":0,"createTime":null,"fileUrl":"","sysUser":null,"mark":false,"watchCount":0},{"afnNewsInfo":null,"uv":0,"userOid":"","afnNewsinfoOid":"","isDelete":0,"flag3":"","flag2":"","flag1":"","updateTime":null,"oid":"4028818a73ea8ece0173ea9301440000","sort":2,"title":"欧盟对中222","pdfPagenum":0,"content":"","commentCount":0,"keyWord":"bran","duration":0,"createTime":null,"fileUrl":"","sysUser":null,"mark":false,"watchCount":0}],"afnnewsDirectoryOid":"","normalPriceusd":30,"sysUser":null,"afnNewsColumn":null,"contentType":3,"createTimeStr":"","uv":0,"specialOffercny":0.01,"specialOfferaud":0.01,"afnNewsType":null,"commentInfoPagination":null,"isDelete":0,"newstypeOid":"","priceType":1,"updateTime":null,"commentCount":0,"keyWord":"bran","normalPriceaud":0.01,"beginDate":null,"normalPricecny":0.01,"createTime":null,"isTop":0,"isHot":0,"mark":false,"watchCount":0}
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
         * columnOid :
         * totalPagenum : 0
         * city :
         * endDate : null
         * userOid :
         * flag3 :
         * flag2 :
         * mainPhoto : 20200730173206000.jpg
         * recommendation : <p>2345YTR345THGRF</p>
         * flag1 :
         * limitedtimeFreeId :
         * specialOfferusd : 28
         * isColumn : 0
         * oid : 40288187739f0f7b01739f10a9790000
         * citys : null
         * title : 欧盟对中音频
         * content : <p>AERHWEJYJHTGR</p>
         * afnFreeTime : null
         * afnNewsDirectoryList : [{"afnNewsInfo":null,"uv":0,"userOid":"","afnNewsinfoOid":"","isDelete":0,"flag3":"","flag2":"","flag1":"","updateTime":null,"oid":"4028818773b8213e0173b832137b0000","sort":1,"title":"欧盟对中","pdfPagenum":0,"content":"","commentCount":0,"keyWord":"bran","duration":0,"createTime":null,"fileUrl":"","sysUser":null,"mark":false,"watchCount":0},{"afnNewsInfo":null,"uv":0,"userOid":"","afnNewsinfoOid":"","isDelete":0,"flag3":"","flag2":"","flag1":"","updateTime":null,"oid":"4028818a73ea8ece0173ea9301440000","sort":2,"title":"欧盟对中222","pdfPagenum":0,"content":"","commentCount":0,"keyWord":"bran","duration":0,"createTime":null,"fileUrl":"","sysUser":null,"mark":false,"watchCount":0}]
         * afnnewsDirectoryOid :
         * normalPriceusd : 30
         * sysUser : null
         * afnNewsColumn : null
         * contentType : 3
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
        private List<AfnNewsDirectoryListEntity> afnNewsDirectoryList;
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

        public void setAfnNewsDirectoryList(List<AfnNewsDirectoryListEntity> afnNewsDirectoryList) {
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

        public List<AfnNewsDirectoryListEntity> getAfnNewsDirectoryList() {
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

        public class AfnNewsDirectoryListEntity {
            /**
             * afnNewsInfo : null
             * uv : 0
             * userOid :
             * afnNewsinfoOid :
             * isDelete : 0
             * flag3 :
             * flag2 :
             * flag1 :
             * updateTime : null
             * oid : 4028818773b8213e0173b832137b0000
             * sort : 1
             * title : 欧盟对中
             * pdfPagenum : 0
             * content :
             * commentCount : 0
             * keyWord : bran
             * duration : 0
             * createTime : null
             * fileUrl :
             * sysUser : null
             * mark : false
             * watchCount : 0
             */
            private String afnNewsInfo;
            private int uv;
            private String userOid;
            private String afnNewsinfoOid;
            private int isDelete;
            private String flag3;
            private String flag2;
            private String flag1;
            private String updateTime;
            private String oid;
            private int sort;
            private String title;
            private int pdfPagenum;
            private String content;
            private int commentCount;
            private String keyWord;
            private int duration;
            private String createTime;
            private String fileUrl;
            private String sysUser;
            private boolean mark;
            private int watchCount;

            public void setAfnNewsInfo(String afnNewsInfo) {
                this.afnNewsInfo = afnNewsInfo;
            }

            public void setUv(int uv) {
                this.uv = uv;
            }

            public void setUserOid(String userOid) {
                this.userOid = userOid;
            }

            public void setAfnNewsinfoOid(String afnNewsinfoOid) {
                this.afnNewsinfoOid = afnNewsinfoOid;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public void setFlag3(String flag3) {
                this.flag3 = flag3;
            }

            public void setFlag2(String flag2) {
                this.flag2 = flag2;
            }

            public void setFlag1(String flag1) {
                this.flag1 = flag1;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public void setOid(String oid) {
                this.oid = oid;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setPdfPagenum(int pdfPagenum) {
                this.pdfPagenum = pdfPagenum;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public void setKeyWord(String keyWord) {
                this.keyWord = keyWord;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public void setFileUrl(String fileUrl) {
                this.fileUrl = fileUrl;
            }

            public void setSysUser(String sysUser) {
                this.sysUser = sysUser;
            }

            public void setMark(boolean mark) {
                this.mark = mark;
            }

            public void setWatchCount(int watchCount) {
                this.watchCount = watchCount;
            }

            public String getAfnNewsInfo() {
                return afnNewsInfo;
            }

            public int getUv() {
                return uv;
            }

            public String getUserOid() {
                return userOid;
            }

            public String getAfnNewsinfoOid() {
                return afnNewsinfoOid;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public String getFlag3() {
                return flag3;
            }

            public String getFlag2() {
                return flag2;
            }

            public String getFlag1() {
                return flag1;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public String getOid() {
                return oid;
            }

            public int getSort() {
                return sort;
            }

            public String getTitle() {
                return title;
            }

            public int getPdfPagenum() {
                return pdfPagenum;
            }

            public String getContent() {
                return content;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public String getKeyWord() {
                return keyWord;
            }

            public int getDuration() {
                return duration;
            }

            public String getCreateTime() {
                return createTime;
            }

            public String getFileUrl() {
                return fileUrl;
            }

            public String getSysUser() {
                return sysUser;
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
