package com.example.kaiyuanzhongguo;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

public class BannerBean extends BasePageBean <BannerBean.ResultBean.ItemsBean>{

    /**
     * code : 1
     * message : success
     * notice : {"like":0,"review":0,"softwareCount":0,"letter":0,"newsCount":16,"mention":0,"fans":0}
     * result : {"items":[{"detail":"","href":"","id":113086,"img":"https://static.oschina.net/uploads/space/2020/0201/090750_s1RE_4105562.jpg","name":"Linux Kernel 5.6 应对又一个\u201c千年虫\u201d问题","pubDate":"2020-02-10 15:12:13","type":6,"weight":8},{"detail":"","href":"","id":113218,"img":"https://attachments.tower.im/tower/6ed2a326c3131b54208fb24efebcb3fa?version=auto","name":"JVM 生态报告：Kotlin 第二受欢迎","pubDate":"2020-02-10 15:11:14","type":6,"weight":7},{"detail":"","href":"","id":113217,"img":"https://static.oschina.net/uploads/img/202002/10121912_M3F9.png","name":"Container Linux 将退役，让位 Fedora CoreOS","pubDate":"2020-02-10 15:09:42","type":6,"weight":6},{"detail":"","href":"https://oschina.gitee.io/gitee-2019-annual-report/?utm_source=APP_banner","id":0,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_19cbe90d-cd73-4f14-85bd-4723dfd0c856.png","name":"重磅推出：Gitee 2019 年度数据报告","pubDate":"2020-01-08 10:12:15","type":0,"weight":5}],"nextPageToken":"A4398F94EDF60667","prevPageToken":"B7DC67FBB70C320E","requestCount":4,"responseCount":4,"totalResults":4}
     * time : 2020-02-11 10:48:34
     */

    private int code;
    private String message;
    private NoticeBean notice;
    private ResultBean result;
    private String time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public List getItemDatas() {
        return result.items;
    }

    public static class NoticeBean {
        /**
         * like : 0
         * review : 0
         * softwareCount : 0
         * letter : 0
         * newsCount : 16
         * mention : 0
         * fans : 0
         */

        private int like;
        private int review;
        private int softwareCount;
        private int letter;
        private int newsCount;
        private int mention;
        private int fans;

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public int getReview() {
            return review;
        }

        public void setReview(int review) {
            this.review = review;
        }

        public int getSoftwareCount() {
            return softwareCount;
        }

        public void setSoftwareCount(int softwareCount) {
            this.softwareCount = softwareCount;
        }

        public int getLetter() {
            return letter;
        }

        public void setLetter(int letter) {
            this.letter = letter;
        }

        public int getNewsCount() {
            return newsCount;
        }

        public void setNewsCount(int newsCount) {
            this.newsCount = newsCount;
        }

        public int getMention() {
            return mention;
        }

        public void setMention(int mention) {
            this.mention = mention;
        }

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }
    }

    public static class ResultBean {
        /**
         * items : [{"detail":"","href":"","id":113086,"img":"https://static.oschina.net/uploads/space/2020/0201/090750_s1RE_4105562.jpg","name":"Linux Kernel 5.6 应对又一个\u201c千年虫\u201d问题","pubDate":"2020-02-10 15:12:13","type":6,"weight":8},{"detail":"","href":"","id":113218,"img":"https://attachments.tower.im/tower/6ed2a326c3131b54208fb24efebcb3fa?version=auto","name":"JVM 生态报告：Kotlin 第二受欢迎","pubDate":"2020-02-10 15:11:14","type":6,"weight":7},{"detail":"","href":"","id":113217,"img":"https://static.oschina.net/uploads/img/202002/10121912_M3F9.png","name":"Container Linux 将退役，让位 Fedora CoreOS","pubDate":"2020-02-10 15:09:42","type":6,"weight":6},{"detail":"","href":"https://oschina.gitee.io/gitee-2019-annual-report/?utm_source=APP_banner","id":0,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_19cbe90d-cd73-4f14-85bd-4723dfd0c856.png","name":"重磅推出：Gitee 2019 年度数据报告","pubDate":"2020-01-08 10:12:15","type":0,"weight":5}]
         * nextPageToken : A4398F94EDF60667
         * prevPageToken : B7DC67FBB70C320E
         * requestCount : 4
         * responseCount : 4
         * totalResults : 4
         */

        private String nextPageToken;
        private String prevPageToken;
        private int requestCount;
        private int responseCount;
        private int totalResults;
        private List<ItemsBean> items;

        public String getNextPageToken() {
            return nextPageToken;
        }

        public void setNextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
        }

        public String getPrevPageToken() {
            return prevPageToken;
        }

        public void setPrevPageToken(String prevPageToken) {
            this.prevPageToken = prevPageToken;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }

        public int getResponseCount() {
            return responseCount;
        }

        public void setResponseCount(int responseCount) {
            this.responseCount = responseCount;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * detail :
             * href :
             * id : 113086
             * img : https://static.oschina.net/uploads/space/2020/0201/090750_s1RE_4105562.jpg
             * name : Linux Kernel 5.6 应对又一个“千年虫”问题
             * pubDate : 2020-02-10 15:12:13
             * type : 6
             * weight : 8
             */

            private String detail;
            private String href;
            private int id;
            private String img;
            private String name;
            private String pubDate;
            private int type;
            private int weight;

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }
        }
    }
}
