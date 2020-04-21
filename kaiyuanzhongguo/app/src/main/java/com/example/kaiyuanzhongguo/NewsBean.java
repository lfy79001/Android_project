package com.example.kaiyuanzhongguo;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

public class NewsBean extends BasePageBean<NewsBean.ResultBean.ItemsBean> {

    /**
     * code : 1
     * message : success
     * notice : {"like":0,"review":0,"letter":0,"mention":0,"fans":0}
     * result : {"items":[{"author":"码云Gitee","body":"上周一，很多公司开始了远程办公，一周过去了，疫情控制虽有所起色，但去公司集体撸代码的日子依然遥远，远程办公将成为更多企业的选择。 想必已经...","commentCount":0,"href":"https://www.oschina.net/news/113284/remote-working-weekly-review","id":113284,"pubDate":"2020-02-10 14:06:12","recommend":true,"title":"远程办公一周复盘","type":6,"viewCount":7},{"author":"kissonchan","body":"作为武汉人，看到家乡遭此疫情，深感痛心，亲人们都在武汉居家隔离中。恳请大家不要用有色眼光对待武汉人、湖北人，武汉加油！中国加油！ > Qigsaw...","commentCount":0,"href":"https://www.oschina.net/news/113283/qigsaw-1-3-0-released","id":113283,"pubDate":"2020-02-10 11:53:03","recommend":true,"title":"[家乡加油！] 基于 App Bundle 的动态化框架 Qigsaw 1.3.0 重磅推出","type":6,"viewCount":81},{"author":"最后_","body":"今日更新日志: 1. 唯一Id生成器换成 hutool 的 IdUtil 2. 关联字段数据注入工具（zuihou-injection-starter） 增加guava本地缓存，加快注入速度， ...","commentCount":0,"href":"https://www.oschina.net/news/113282/zuihou-admin-cloud-1-6-released","id":113282,"pubDate":"2020-02-10 09:36:29","recommend":true,"title":"zuihou-admin-cloud 1.6 发布，支持自动生成前端页面","type":6,"viewCount":121},{"author":"xplanet","body":"对于那些使用 GNU Make 作为其构建系统的用户，从 Linux 5.6 开始，并行构建时间将快得多。 Linus Torvalds 本人围绕内核的管道代码进行了更改，以...","commentCount":10,"href":"https://www.oschina.net/news/113281/linux-pipe-parallel-job-opt","id":113281,"pubDate":"2020-02-10 09:04:25","recommend":true,"title":"Linus Torvalds 优化内核管道代码，大型 CPU 系统受益","type":6,"viewCount":2200},{"author":"oschina","body":"我们知道，苹果最新的Mac Pro可以配备最多1.5TB的超大容量内存，那这么多内存能用来干啥？如何能够将它们吃光？推特网友Jonathan Morrison就做了一...","commentCount":8,"href":"https://www.oschina.net/news/113280/1tb-memory-macpro-max-chrome-tab","id":113280,"pubDate":"2020-02-10 08:57:37","recommend":true,"title":"当 Chrome 同时打开 6000 多个标签页，顶配版 Mac Pro：我真的一滴都没有了","type":6,"viewCount":2264},{"author":"Javen-IJPay","body":"TNWX: TypeScript + Node.js + WeiXin 微信系开发脚手架，支持微信公众号、微信支付、微信小游戏、微信小程序、企业号/企业微信。最最最重要的是能...","commentCount":0,"href":"https://www.oschina.net/news/113279/tnwx-2-2-0-released","id":113279,"pubDate":"2020-02-10 08:49:41","recommend":false,"title":"TNWX 2.2.0 版本发布，微信系开发脚手架","type":6,"viewCount":71},{"author":"xplanet","body":"微软 Powertoys 团队宣布推出一款新的实用程序，名为 \u201dKeyboard Shortcut Manager\u201c（键盘快捷键管理器）。该键盘管理器使用户能够自定义其键盘，...","commentCount":1,"href":"https://www.oschina.net/news/113278/powertoys-keyboardmanager","id":113278,"pubDate":"2020-02-10 08:46:21","recommend":false,"title":"微软 Powertoys 推出新的实用程序，自定义键盘快捷管理","type":6,"viewCount":379},{"author":"oschina","body":"采用主从结构，以类人机器人 xshadower 为示例的通用开源机器人系统，非 ROS，操控真实机器人，无仿真环境。 本系统采用 makefile 整合 platformIO...","commentCount":0,"href":"https://gitee.com/xshadower/openrobot","id":113277,"pubDate":"2020-02-10 08:35:38","recommend":false,"title":"码云推荐 | 通用开源机器人系统 openrobot","type":0,"viewCount":1},{"author":"oschina","body":"vue-ele-form-generator 是专为 vue-ele-form 开发的可视化表单设计工具, 让表单开发的效率更上一层楼！","commentCount":0,"href":"https://www.oschina.net/p/vue-ele-form-generator","id":50327,"pubDate":"2020-02-10 08:31:30","recommend":false,"title":"vue-ele-form-generator \u2014\u2014 可视化表单设计工具","type":1,"viewCount":1148},{"author":"oschina","body":"IO 的方式通常分为几种，同步阻塞的 BIO、同步非阻塞的 NIO 以及异步非阻塞的 AIO。","commentCount":1,"href":"https://my.oschina.net/u/4006148/blog/3163873","id":3163873,"pubDate":"2020-02-10 08:30:45","recommend":false,"title":"每日一博 | BIO、NIO、AIO 介绍和适用场景分析","type":3,"viewCount":920},{"author":"局长","body":"elementary OS 5.1.2 已发布，这是 5.1 \"Hera\" 系列的一个新的次要版本，此版本通过升级内核引入了较新的硬件支持，并包含针对严重 sudo 错误的修...","commentCount":1,"href":"https://www.oschina.net/news/113274/elementary-os-5-1-2-hera","id":113274,"pubDate":"2020-02-10 08:20:00","recommend":false,"title":"elementary OS 5.1.2 发布，升级内核以及修复严重的 sudo 错误","type":6,"viewCount":439},{"author":"xplanet","body":"Hugo 0.64.1 发布了，这是一个 bug 修复版本，其中包含几个重要的修复程序： hugofs：修复 mount b78576fd #6854 修复捆绑资源排序的回归 18888...","commentCount":1,"href":"https://www.oschina.net/news/113273/hugo-0-64-1-released","id":113273,"pubDate":"2020-02-10 08:11:53","recommend":false,"title":"Hugo 0.64.1 发布，Go 编写的静态网站生成器","type":6,"viewCount":138},{"author":"xplanet","body":"TypeScript 3.8 的候选版本发布了。TypeScript 3.8 带来了许多新特性，包括新的 ECMAScript 标准功能，仅用于导入/导出类型的新语法等等。 仅类型导...","commentCount":2,"href":"https://www.oschina.net/news/113272/typescript-3-8-rc-released","id":113272,"pubDate":"2020-02-10 08:02:24","recommend":false,"title":"TypeScript 3.8 RC 发布","type":6,"viewCount":696},{"author":"xplanet","body":"Ant Design 4.0.0-rc.4 发布了。Ant Design 是阿里开源的一套企业级的 UI 设计语言和 React 实现，使用 TypeScript 构建，提供完整的类型定义文件，...","commentCount":1,"href":"https://www.oschina.net/news/113271/ant-design-4-0-0-rc4-released","id":113271,"pubDate":"2020-02-10 08:01:44","recommend":false,"title":"Ant Design 4.0.0-rc.4 发布，企业级 UI 设计语言","type":6,"viewCount":513},{"author":"xplanet","body":"Apache Commons Compress 1.20 发布了，Commons Compress 用以实现将文件压缩或解压成 tar、zip、bzip2 等格式。  Bug 修复： SevenZFile 可能会为...","commentCount":0,"href":"https://www.oschina.net/news/113270/apache-commons-compress-1-20-released","id":113270,"pubDate":"2020-02-10 08:01:06","recommend":false,"title":"Apache Commons Compress 1.20 发布","type":6,"viewCount":74},{"author":"xplanet","body":"Apache Commons CSV 1.8 （要求 Java 8+） 发布了，Commons CSV 是一个用来读写各种 Comma Separated Value (CSV) 格式文件的 Java 库。  更新内...","commentCount":0,"href":"https://www.oschina.net/news/113269/commons-csv-1-8-released","id":113269,"pubDate":"2020-02-10 08:00:24","recommend":false,"title":"Apache Commons CSV 1.8 发布，CSV 文件读写库","type":6,"viewCount":83},{"author":"局长","body":"Debian 10（代号\"buster\"）的第三次更新和 Debian 9（代号\"stretch\"）的第十二次更新已发布，两个版本主要都是对安全性问题进行了更正，并针对严重...","commentCount":2,"href":"https://www.oschina.net/news/113268/debian-10-3-n-9-1-2-released","id":113268,"pubDate":"2020-02-10 07:57:15","recommend":false,"title":"Debian GNU/Linux 10.3 和 9.12 发布","type":6,"viewCount":674},{"author":"xuri","body":"Excelize 是 Go 语言编写的用于操作 Office Excel 文档类库，基于 ECMA-376 Office OpenXML 标准。可以使用它来读取、写入由 Microsoft Excel™ ...","commentCount":0,"href":"https://www.oschina.net/news/113267/excelize-2-1-0-released","id":113267,"pubDate":"2020-02-10 00:13:04","recommend":false,"title":"Excelize 发布 2.1.0 版本，Go 语言 Excel 文档基础库","type":6,"viewCount":82},{"author":"ShopXO开源商城","body":"ShopXO 国内领先企业级B2C免费开源电商系统！ 求实进取、创新专注、自主研发、国内领先企业级B2C电商系统解决方案。 遵循Apache2开源协议发布，无需...","commentCount":0,"href":"https://www.oschina.net/news/113266/shopxo-1-8-0-released","id":113266,"pubDate":"2020-02-09 22:50:46","recommend":false,"title":"ShopXO v1.8.0 发布，企业级 B2C 免费开源商城系统","type":6,"viewCount":86},{"author":"东方玄","body":"软件官方网址：http://www.novalide.com NovalIDE 1.2.1 新年隆重发布，新版本添加了以下重磅功能！ 发布gittool插件,支持clone,commit,checkout项...","commentCount":6,"href":"https://www.oschina.net/news/113265/novalide-1-1-2-released","id":113265,"pubDate":"2020-02-09 20:41:02","recommend":false,"title":"NovalIDE 1.1.2 版本新年重磅发布啦！","type":6,"viewCount":1037}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":104100}
     * time : 2020-02-10 14:19:50
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
         * items : [{"author":"码云Gitee","body":"上周一，很多公司开始了远程办公，一周过去了，疫情控制虽有所起色，但去公司集体撸代码的日子依然遥远，远程办公将成为更多企业的选择。 想必已经...","commentCount":0,"href":"https://www.oschina.net/news/113284/remote-working-weekly-review","id":113284,"pubDate":"2020-02-10 14:06:12","recommend":true,"title":"远程办公一周复盘","type":6,"viewCount":7},{"author":"kissonchan","body":"作为武汉人，看到家乡遭此疫情，深感痛心，亲人们都在武汉居家隔离中。恳请大家不要用有色眼光对待武汉人、湖北人，武汉加油！中国加油！ > Qigsaw...","commentCount":0,"href":"https://www.oschina.net/news/113283/qigsaw-1-3-0-released","id":113283,"pubDate":"2020-02-10 11:53:03","recommend":true,"title":"[家乡加油！] 基于 App Bundle 的动态化框架 Qigsaw 1.3.0 重磅推出","type":6,"viewCount":81},{"author":"最后_","body":"今日更新日志: 1. 唯一Id生成器换成 hutool 的 IdUtil 2. 关联字段数据注入工具（zuihou-injection-starter） 增加guava本地缓存，加快注入速度， ...","commentCount":0,"href":"https://www.oschina.net/news/113282/zuihou-admin-cloud-1-6-released","id":113282,"pubDate":"2020-02-10 09:36:29","recommend":true,"title":"zuihou-admin-cloud 1.6 发布，支持自动生成前端页面","type":6,"viewCount":121},{"author":"xplanet","body":"对于那些使用 GNU Make 作为其构建系统的用户，从 Linux 5.6 开始，并行构建时间将快得多。 Linus Torvalds 本人围绕内核的管道代码进行了更改，以...","commentCount":10,"href":"https://www.oschina.net/news/113281/linux-pipe-parallel-job-opt","id":113281,"pubDate":"2020-02-10 09:04:25","recommend":true,"title":"Linus Torvalds 优化内核管道代码，大型 CPU 系统受益","type":6,"viewCount":2200},{"author":"oschina","body":"我们知道，苹果最新的Mac Pro可以配备最多1.5TB的超大容量内存，那这么多内存能用来干啥？如何能够将它们吃光？推特网友Jonathan Morrison就做了一...","commentCount":8,"href":"https://www.oschina.net/news/113280/1tb-memory-macpro-max-chrome-tab","id":113280,"pubDate":"2020-02-10 08:57:37","recommend":true,"title":"当 Chrome 同时打开 6000 多个标签页，顶配版 Mac Pro：我真的一滴都没有了","type":6,"viewCount":2264},{"author":"Javen-IJPay","body":"TNWX: TypeScript + Node.js + WeiXin 微信系开发脚手架，支持微信公众号、微信支付、微信小游戏、微信小程序、企业号/企业微信。最最最重要的是能...","commentCount":0,"href":"https://www.oschina.net/news/113279/tnwx-2-2-0-released","id":113279,"pubDate":"2020-02-10 08:49:41","recommend":false,"title":"TNWX 2.2.0 版本发布，微信系开发脚手架","type":6,"viewCount":71},{"author":"xplanet","body":"微软 Powertoys 团队宣布推出一款新的实用程序，名为 \u201dKeyboard Shortcut Manager\u201c（键盘快捷键管理器）。该键盘管理器使用户能够自定义其键盘，...","commentCount":1,"href":"https://www.oschina.net/news/113278/powertoys-keyboardmanager","id":113278,"pubDate":"2020-02-10 08:46:21","recommend":false,"title":"微软 Powertoys 推出新的实用程序，自定义键盘快捷管理","type":6,"viewCount":379},{"author":"oschina","body":"采用主从结构，以类人机器人 xshadower 为示例的通用开源机器人系统，非 ROS，操控真实机器人，无仿真环境。 本系统采用 makefile 整合 platformIO...","commentCount":0,"href":"https://gitee.com/xshadower/openrobot","id":113277,"pubDate":"2020-02-10 08:35:38","recommend":false,"title":"码云推荐 | 通用开源机器人系统 openrobot","type":0,"viewCount":1},{"author":"oschina","body":"vue-ele-form-generator 是专为 vue-ele-form 开发的可视化表单设计工具, 让表单开发的效率更上一层楼！","commentCount":0,"href":"https://www.oschina.net/p/vue-ele-form-generator","id":50327,"pubDate":"2020-02-10 08:31:30","recommend":false,"title":"vue-ele-form-generator \u2014\u2014 可视化表单设计工具","type":1,"viewCount":1148},{"author":"oschina","body":"IO 的方式通常分为几种，同步阻塞的 BIO、同步非阻塞的 NIO 以及异步非阻塞的 AIO。","commentCount":1,"href":"https://my.oschina.net/u/4006148/blog/3163873","id":3163873,"pubDate":"2020-02-10 08:30:45","recommend":false,"title":"每日一博 | BIO、NIO、AIO 介绍和适用场景分析","type":3,"viewCount":920},{"author":"局长","body":"elementary OS 5.1.2 已发布，这是 5.1 \"Hera\" 系列的一个新的次要版本，此版本通过升级内核引入了较新的硬件支持，并包含针对严重 sudo 错误的修...","commentCount":1,"href":"https://www.oschina.net/news/113274/elementary-os-5-1-2-hera","id":113274,"pubDate":"2020-02-10 08:20:00","recommend":false,"title":"elementary OS 5.1.2 发布，升级内核以及修复严重的 sudo 错误","type":6,"viewCount":439},{"author":"xplanet","body":"Hugo 0.64.1 发布了，这是一个 bug 修复版本，其中包含几个重要的修复程序： hugofs：修复 mount b78576fd #6854 修复捆绑资源排序的回归 18888...","commentCount":1,"href":"https://www.oschina.net/news/113273/hugo-0-64-1-released","id":113273,"pubDate":"2020-02-10 08:11:53","recommend":false,"title":"Hugo 0.64.1 发布，Go 编写的静态网站生成器","type":6,"viewCount":138},{"author":"xplanet","body":"TypeScript 3.8 的候选版本发布了。TypeScript 3.8 带来了许多新特性，包括新的 ECMAScript 标准功能，仅用于导入/导出类型的新语法等等。 仅类型导...","commentCount":2,"href":"https://www.oschina.net/news/113272/typescript-3-8-rc-released","id":113272,"pubDate":"2020-02-10 08:02:24","recommend":false,"title":"TypeScript 3.8 RC 发布","type":6,"viewCount":696},{"author":"xplanet","body":"Ant Design 4.0.0-rc.4 发布了。Ant Design 是阿里开源的一套企业级的 UI 设计语言和 React 实现，使用 TypeScript 构建，提供完整的类型定义文件，...","commentCount":1,"href":"https://www.oschina.net/news/113271/ant-design-4-0-0-rc4-released","id":113271,"pubDate":"2020-02-10 08:01:44","recommend":false,"title":"Ant Design 4.0.0-rc.4 发布，企业级 UI 设计语言","type":6,"viewCount":513},{"author":"xplanet","body":"Apache Commons Compress 1.20 发布了，Commons Compress 用以实现将文件压缩或解压成 tar、zip、bzip2 等格式。  Bug 修复： SevenZFile 可能会为...","commentCount":0,"href":"https://www.oschina.net/news/113270/apache-commons-compress-1-20-released","id":113270,"pubDate":"2020-02-10 08:01:06","recommend":false,"title":"Apache Commons Compress 1.20 发布","type":6,"viewCount":74},{"author":"xplanet","body":"Apache Commons CSV 1.8 （要求 Java 8+） 发布了，Commons CSV 是一个用来读写各种 Comma Separated Value (CSV) 格式文件的 Java 库。  更新内...","commentCount":0,"href":"https://www.oschina.net/news/113269/commons-csv-1-8-released","id":113269,"pubDate":"2020-02-10 08:00:24","recommend":false,"title":"Apache Commons CSV 1.8 发布，CSV 文件读写库","type":6,"viewCount":83},{"author":"局长","body":"Debian 10（代号\"buster\"）的第三次更新和 Debian 9（代号\"stretch\"）的第十二次更新已发布，两个版本主要都是对安全性问题进行了更正，并针对严重...","commentCount":2,"href":"https://www.oschina.net/news/113268/debian-10-3-n-9-1-2-released","id":113268,"pubDate":"2020-02-10 07:57:15","recommend":false,"title":"Debian GNU/Linux 10.3 和 9.12 发布","type":6,"viewCount":674},{"author":"xuri","body":"Excelize 是 Go 语言编写的用于操作 Office Excel 文档类库，基于 ECMA-376 Office OpenXML 标准。可以使用它来读取、写入由 Microsoft Excel™ ...","commentCount":0,"href":"https://www.oschina.net/news/113267/excelize-2-1-0-released","id":113267,"pubDate":"2020-02-10 00:13:04","recommend":false,"title":"Excelize 发布 2.1.0 版本，Go 语言 Excel 文档基础库","type":6,"viewCount":82},{"author":"ShopXO开源商城","body":"ShopXO 国内领先企业级B2C免费开源电商系统！ 求实进取、创新专注、自主研发、国内领先企业级B2C电商系统解决方案。 遵循Apache2开源协议发布，无需...","commentCount":0,"href":"https://www.oschina.net/news/113266/shopxo-1-8-0-released","id":113266,"pubDate":"2020-02-09 22:50:46","recommend":false,"title":"ShopXO v1.8.0 发布，企业级 B2C 免费开源商城系统","type":6,"viewCount":86},{"author":"东方玄","body":"软件官方网址：http://www.novalide.com NovalIDE 1.2.1 新年隆重发布，新版本添加了以下重磅功能！ 发布gittool插件,支持clone,commit,checkout项...","commentCount":6,"href":"https://www.oschina.net/news/113265/novalide-1-1-2-released","id":113265,"pubDate":"2020-02-09 20:41:02","recommend":false,"title":"NovalIDE 1.1.2 版本新年重磅发布啦！","type":6,"viewCount":1037}]
         * nextPageToken : DBA816934CD0AA59
         * prevPageToken : 0997C855C600E421
         * requestCount : 20
         * responseCount : 20
         * totalResults : 104100
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
             * author : 码云Gitee
             * body : 上周一，很多公司开始了远程办公，一周过去了，疫情控制虽有所起色，但去公司集体撸代码的日子依然遥远，远程办公将成为更多企业的选择。 想必已经...
             * commentCount : 0
             * href : https://www.oschina.net/news/113284/remote-working-weekly-review
             * id : 113284
             * pubDate : 2020-02-10 14:06:12
             * recommend : true
             * title : 远程办公一周复盘
             * type : 6
             * viewCount : 7
             */

            private String author;
            private String body;
            private int commentCount;
            private String href;
            private int id;
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
