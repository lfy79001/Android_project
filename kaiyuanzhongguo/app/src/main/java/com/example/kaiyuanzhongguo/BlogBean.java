package com.example.kaiyuanzhongguo;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

public class BlogBean extends BasePageBean <BlogBean.ResultBean.ItemsBean>{

    /**
     * code : 1
     * message : success
     * notice : {"like":0,"review":0,"letter":0,"mention":0,"fans":0}
     * result : {"items":[{"author":"爱宝贝丶","body":"        从本节开始，我们将进入http模块实现原理的讲解，关于h...","commentCount":0,"href":"https://my.oschina.net/zhangxufeng/blog/3164974","id":3164974,"original":true,"pubDate":"2020-02-11 08:24:35","recommend":true,"title":"nginx http模块数据存储结构","type":3,"viewCount":53},{"author":"ltysvx","body":"0x01简介     w3af是一个基于python开发的Web应用程序攻击和审计框架...","commentCount":0,"href":"https://my.oschina.net/u/3697324/blog/3164899","id":3164899,"original":true,"pubDate":"2020-02-10 19:38:52","recommend":true,"title":"在kali2019.4版本上安装w3af的那些事","type":3,"viewCount":117},{"author":"聚则","body":"本文作者：AntV 架构师-萧庆 简介 G6 是一个图关系可视化引擎，起始于我...","commentCount":0,"href":"https://my.oschina.net/u/4309229/blog/3164865","id":3164865,"original":true,"pubDate":"2020-02-10 17:42:22","recommend":true,"title":"AntV 架构演进-G6 篇","type":3,"viewCount":681},{"author":"腾讯云Serverless","body":"最近的一些疫情信息很让人揪心，为了方便大家掌握疫情信息，在空闲之余做...","commentCount":0,"href":"https://my.oschina.net/serverlesscloud/blog/3164755","id":3164755,"original":true,"pubDate":"2020-02-10 13:08:43","recommend":true,"title":"基于 Serverless +企业微信打造 nCoV 疫情监控小助手","type":3,"viewCount":188},{"author":"梁桂钊","body":"原文地址：梁桂钊的博客 博客地址：http://blog.720ui.com 欢迎关注公众...","commentCount":1,"href":"https://my.oschina.net/u/3789577/blog/3164648","id":3164648,"original":true,"pubDate":"2020-02-09 22:28:50","recommend":true,"title":"病毒与故障：漫谈计算机软件的故障应对","type":3,"viewCount":63},{"author":"腾讯云Serverless","body":"本文重点探讨下开发者使用 Serverless 时经常遇到的一些问题，以及如何解...","commentCount":0,"href":"https://my.oschina.net/serverlesscloud/blog/3164611","id":3164611,"original":true,"pubDate":"2020-02-09 20:10:48","recommend":true,"title":"Serverless 的运行原理与组件架构","type":3,"viewCount":117},{"author":"oj8kay","body":"文章里面的东西虽然涉及了人工智能，但是还是选择投在了前端的版块，一来...","commentCount":0,"href":"https://my.oschina.net/codingDog/blog/3164587","id":3164587,"original":true,"pubDate":"2020-02-09 18:35:34","recommend":true,"title":"如何获取一张普通图片的深度贴图（Depth Map）","type":3,"viewCount":107},{"author":"刘涛华","body":"上一章聊到在车联网或物联网中对数据库的需求，以及 IoTDB 的整体架构，...","commentCount":0,"href":"https://my.oschina.net/u/3374539/blog/3164528","id":3164528,"original":true,"pubDate":"2020-02-09 16:17:18","recommend":true,"title":"时序数据库 Apache-IoTDB 源码解析之文件格式简介（三）","type":3,"viewCount":116},{"author":"oj8kay","body":"海外党玩F***book的时候可能有接触过这个酷炫的3d图片效果： 只要通过客...","commentCount":2,"href":"https://my.oschina.net/codingDog/blog/3164412","id":3164412,"original":true,"pubDate":"2020-02-08 21:55:36","recommend":true,"title":"原生js+WebGL实现3D图片效果","type":3,"viewCount":377},{"author":"素小暖OSC","body":"一、前言 Orm框架的本质是简化编程中操作数据库的编码，发展到现在，基本...","commentCount":5,"href":"https://my.oschina.net/u/4006148/blog/3164407","id":3164407,"original":true,"pubDate":"2020-02-08 21:44:36","recommend":true,"title":"Spring Boot（四）：如何优雅的使用 Mybatis","type":3,"viewCount":655},{"author":"程序猿DD","body":"通过上一节的学习，我们已经学会如何应用Spring中的JdbcTemplate来完成对...","commentCount":0,"href":"https://my.oschina.net/didispace/blog/3164404","id":3164404,"original":true,"pubDate":"2020-02-08 21:28:09","recommend":true,"title":"Spring Boot 2.x基础教程：默认数据源Hikari的配置详解","type":3,"viewCount":132},{"author":"张凯强-zkqiang","body":"这是前一阵子群友发在群里的一道面试题，利用 Python 字典的特性，可以巧...","commentCount":0,"href":"https://my.oschina.net/u/4234347/blog/3164258","id":3164258,"original":true,"pubDate":"2020-02-08 12:39:26","recommend":true,"title":"一道快速考察 Python 基础的面试题","type":3,"viewCount":312},{"author":"刘涛华","body":"上一章聊到时序数据是什么样，物联网行业中的时序数据的特点：存量数据大...","commentCount":0,"href":"https://my.oschina.net/u/3374539/blog/3164203","id":3164203,"original":true,"pubDate":"2020-02-08 01:36:53","recommend":true,"title":"时序数据库 Apache-IoTDB 源码解析之系统架构（二）","type":3,"viewCount":1039},{"author":"腾讯云Serverless","body":"从行业趋势看，Serverless 是云计算必经的一场革命 2019 年，Serverles...","commentCount":0,"href":"https://my.oschina.net/serverlesscloud/blog/3164138","id":3164138,"original":true,"pubDate":"2020-02-07 21:00:32","recommend":true,"title":"Serverless 基本概念入门","type":3,"viewCount":124},{"author":"素小暖OSC","body":"在计算机技术日新月异的今天， Docker在国内发展的如火如荼，特别是在一...","commentCount":4,"href":"https://my.oschina.net/u/4006148/blog/3164071","id":3164071,"original":true,"pubDate":"2020-02-07 18:19:56","recommend":true,"title":"看完这篇，Docker你就入门了","type":3,"viewCount":3878},{"author":"腾讯云Serverless","body":"▎本文系译文：关于将设计思维与敏捷开发相结合的尝试 \u2014\u2014 成功与失败剖...","commentCount":0,"href":"https://my.oschina.net/serverlesscloud/blog/3164025","id":3164025,"original":true,"pubDate":"2020-02-07 16:15:52","recommend":true,"title":"如何将设计思维应用到精益初创公司的软件开发","type":3,"viewCount":48},{"author":"RancherLabs","body":"2019年，Kubernetes软件包管理器\u2014\u2014Helm发布了最新版本Helm 3，并且该版...","commentCount":0,"href":"https://my.oschina.net/u/3330830/blog/3163890","id":3163890,"original":true,"pubDate":"2020-02-07 11:03:00","recommend":true,"title":"一文教你一次性完成Helm 3迁移","type":3,"viewCount":139},{"author":"素小暖OSC","body":"IO的方式通常分为几种，同步阻塞的BIO、同步非阻塞的NIO、异步非阻塞的A...","commentCount":1,"href":"https://my.oschina.net/u/4006148/blog/3163873","id":3163873,"original":true,"pubDate":"2020-02-07 10:28:11","recommend":true,"title":"BIO、NIO、AIO 介绍和适用场景分析","type":3,"viewCount":1565},{"author":"知了一笑","body":"本文源码：GitHub·点这里 || GitEE·点这里 一、文档类型简介 1、Excel...","commentCount":0,"href":"https://my.oschina.net/cicadasmile/blog/3163864","id":3163864,"original":true,"pubDate":"2020-02-07 09:52:19","recommend":true,"title":"文件系统(01)：基于SpringBoot框架，管理Excel和PDF文件类型","type":3,"viewCount":420},{"author":"NebulaGraph","body":"天津某百货大楼内部相继出现 5 例新冠肺炎确诊病例，从起初的 3 个病例来...","commentCount":0,"href":"https://my.oschina.net/u/4169309/blog/3163862","id":3163862,"original":true,"pubDate":"2020-02-07 09:43:17","recommend":true,"title":"从天津百货大楼 5 病例\u201c迷局\u201d见新冠病毒传播路径","type":3,"viewCount":410}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":1000}
     * time : 2020-02-11 12:17:31
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
         * letter : 0
         * mention : 0
         * fans : 0
         */

        private int like;
        private int review;
        private int letter;
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

        public int getLetter() {
            return letter;
        }

        public void setLetter(int letter) {
            this.letter = letter;
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
         * items : [{"author":"爱宝贝丶","body":"        从本节开始，我们将进入http模块实现原理的讲解，关于h...","commentCount":0,"href":"https://my.oschina.net/zhangxufeng/blog/3164974","id":3164974,"original":true,"pubDate":"2020-02-11 08:24:35","recommend":true,"title":"nginx http模块数据存储结构","type":3,"viewCount":53},{"author":"ltysvx","body":"0x01简介     w3af是一个基于python开发的Web应用程序攻击和审计框架...","commentCount":0,"href":"https://my.oschina.net/u/3697324/blog/3164899","id":3164899,"original":true,"pubDate":"2020-02-10 19:38:52","recommend":true,"title":"在kali2019.4版本上安装w3af的那些事","type":3,"viewCount":117},{"author":"聚则","body":"本文作者：AntV 架构师-萧庆 简介 G6 是一个图关系可视化引擎，起始于我...","commentCount":0,"href":"https://my.oschina.net/u/4309229/blog/3164865","id":3164865,"original":true,"pubDate":"2020-02-10 17:42:22","recommend":true,"title":"AntV 架构演进-G6 篇","type":3,"viewCount":681},{"author":"腾讯云Serverless","body":"最近的一些疫情信息很让人揪心，为了方便大家掌握疫情信息，在空闲之余做...","commentCount":0,"href":"https://my.oschina.net/serverlesscloud/blog/3164755","id":3164755,"original":true,"pubDate":"2020-02-10 13:08:43","recommend":true,"title":"基于 Serverless +企业微信打造 nCoV 疫情监控小助手","type":3,"viewCount":188},{"author":"梁桂钊","body":"原文地址：梁桂钊的博客 博客地址：http://blog.720ui.com 欢迎关注公众...","commentCount":1,"href":"https://my.oschina.net/u/3789577/blog/3164648","id":3164648,"original":true,"pubDate":"2020-02-09 22:28:50","recommend":true,"title":"病毒与故障：漫谈计算机软件的故障应对","type":3,"viewCount":63},{"author":"腾讯云Serverless","body":"本文重点探讨下开发者使用 Serverless 时经常遇到的一些问题，以及如何解...","commentCount":0,"href":"https://my.oschina.net/serverlesscloud/blog/3164611","id":3164611,"original":true,"pubDate":"2020-02-09 20:10:48","recommend":true,"title":"Serverless 的运行原理与组件架构","type":3,"viewCount":117},{"author":"oj8kay","body":"文章里面的东西虽然涉及了人工智能，但是还是选择投在了前端的版块，一来...","commentCount":0,"href":"https://my.oschina.net/codingDog/blog/3164587","id":3164587,"original":true,"pubDate":"2020-02-09 18:35:34","recommend":true,"title":"如何获取一张普通图片的深度贴图（Depth Map）","type":3,"viewCount":107},{"author":"刘涛华","body":"上一章聊到在车联网或物联网中对数据库的需求，以及 IoTDB 的整体架构，...","commentCount":0,"href":"https://my.oschina.net/u/3374539/blog/3164528","id":3164528,"original":true,"pubDate":"2020-02-09 16:17:18","recommend":true,"title":"时序数据库 Apache-IoTDB 源码解析之文件格式简介（三）","type":3,"viewCount":116},{"author":"oj8kay","body":"海外党玩F***book的时候可能有接触过这个酷炫的3d图片效果： 只要通过客...","commentCount":2,"href":"https://my.oschina.net/codingDog/blog/3164412","id":3164412,"original":true,"pubDate":"2020-02-08 21:55:36","recommend":true,"title":"原生js+WebGL实现3D图片效果","type":3,"viewCount":377},{"author":"素小暖OSC","body":"一、前言 Orm框架的本质是简化编程中操作数据库的编码，发展到现在，基本...","commentCount":5,"href":"https://my.oschina.net/u/4006148/blog/3164407","id":3164407,"original":true,"pubDate":"2020-02-08 21:44:36","recommend":true,"title":"Spring Boot（四）：如何优雅的使用 Mybatis","type":3,"viewCount":655},{"author":"程序猿DD","body":"通过上一节的学习，我们已经学会如何应用Spring中的JdbcTemplate来完成对...","commentCount":0,"href":"https://my.oschina.net/didispace/blog/3164404","id":3164404,"original":true,"pubDate":"2020-02-08 21:28:09","recommend":true,"title":"Spring Boot 2.x基础教程：默认数据源Hikari的配置详解","type":3,"viewCount":132},{"author":"张凯强-zkqiang","body":"这是前一阵子群友发在群里的一道面试题，利用 Python 字典的特性，可以巧...","commentCount":0,"href":"https://my.oschina.net/u/4234347/blog/3164258","id":3164258,"original":true,"pubDate":"2020-02-08 12:39:26","recommend":true,"title":"一道快速考察 Python 基础的面试题","type":3,"viewCount":312},{"author":"刘涛华","body":"上一章聊到时序数据是什么样，物联网行业中的时序数据的特点：存量数据大...","commentCount":0,"href":"https://my.oschina.net/u/3374539/blog/3164203","id":3164203,"original":true,"pubDate":"2020-02-08 01:36:53","recommend":true,"title":"时序数据库 Apache-IoTDB 源码解析之系统架构（二）","type":3,"viewCount":1039},{"author":"腾讯云Serverless","body":"从行业趋势看，Serverless 是云计算必经的一场革命 2019 年，Serverles...","commentCount":0,"href":"https://my.oschina.net/serverlesscloud/blog/3164138","id":3164138,"original":true,"pubDate":"2020-02-07 21:00:32","recommend":true,"title":"Serverless 基本概念入门","type":3,"viewCount":124},{"author":"素小暖OSC","body":"在计算机技术日新月异的今天， Docker在国内发展的如火如荼，特别是在一...","commentCount":4,"href":"https://my.oschina.net/u/4006148/blog/3164071","id":3164071,"original":true,"pubDate":"2020-02-07 18:19:56","recommend":true,"title":"看完这篇，Docker你就入门了","type":3,"viewCount":3878},{"author":"腾讯云Serverless","body":"▎本文系译文：关于将设计思维与敏捷开发相结合的尝试 \u2014\u2014 成功与失败剖...","commentCount":0,"href":"https://my.oschina.net/serverlesscloud/blog/3164025","id":3164025,"original":true,"pubDate":"2020-02-07 16:15:52","recommend":true,"title":"如何将设计思维应用到精益初创公司的软件开发","type":3,"viewCount":48},{"author":"RancherLabs","body":"2019年，Kubernetes软件包管理器\u2014\u2014Helm发布了最新版本Helm 3，并且该版...","commentCount":0,"href":"https://my.oschina.net/u/3330830/blog/3163890","id":3163890,"original":true,"pubDate":"2020-02-07 11:03:00","recommend":true,"title":"一文教你一次性完成Helm 3迁移","type":3,"viewCount":139},{"author":"素小暖OSC","body":"IO的方式通常分为几种，同步阻塞的BIO、同步非阻塞的NIO、异步非阻塞的A...","commentCount":1,"href":"https://my.oschina.net/u/4006148/blog/3163873","id":3163873,"original":true,"pubDate":"2020-02-07 10:28:11","recommend":true,"title":"BIO、NIO、AIO 介绍和适用场景分析","type":3,"viewCount":1565},{"author":"知了一笑","body":"本文源码：GitHub·点这里 || GitEE·点这里 一、文档类型简介 1、Excel...","commentCount":0,"href":"https://my.oschina.net/cicadasmile/blog/3163864","id":3163864,"original":true,"pubDate":"2020-02-07 09:52:19","recommend":true,"title":"文件系统(01)：基于SpringBoot框架，管理Excel和PDF文件类型","type":3,"viewCount":420},{"author":"NebulaGraph","body":"天津某百货大楼内部相继出现 5 例新冠肺炎确诊病例，从起初的 3 个病例来...","commentCount":0,"href":"https://my.oschina.net/u/4169309/blog/3163862","id":3163862,"original":true,"pubDate":"2020-02-07 09:43:17","recommend":true,"title":"从天津百货大楼 5 病例\u201c迷局\u201d见新冠病毒传播路径","type":3,"viewCount":410}]
         * nextPageToken : DBA816934CD0AA59
         * prevPageToken : 0997C855C600E421
         * requestCount : 20
         * responseCount : 20
         * totalResults : 1000
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
             * author : 爱宝贝丶
             * body :         从本节开始，我们将进入http模块实现原理的讲解，关于h...
             * commentCount : 0
             * href : https://my.oschina.net/zhangxufeng/blog/3164974
             * id : 3164974
             * original : true
             * pubDate : 2020-02-11 08:24:35
             * recommend : true
             * title : nginx http模块数据存储结构
             * type : 3
             * viewCount : 53
             */

            private String author;
            private String body;
            private int commentCount;
            private String href;
            private int id;
            private boolean original;
            private String pubDate;
            private boolean recommend;
            private String title;
            private int type;
            private int viewCount;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
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

            public boolean isOriginal() {
                return original;
            }

            public void setOriginal(boolean original) {
                this.original = original;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public boolean isRecommend() {
                return recommend;
            }

            public void setRecommend(boolean recommend) {
                this.recommend = recommend;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }
        }
    }
}
