/**
 * @author dingdj
 * Date:2014-5-15下午6:23:50
 *
 */
package com.dj.lib.expandlist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * @author dingdj Date:2014-5-15下午6:23:50
 * 
 */
public class CommonData {

	public static int[][] colors = { { 130, 159, 217 }, { 185, 197, 219 },
			{ 168, 219, 96 }, { 106, 83, 155 }, { 220, 192, 129 },
			{ 60, 120, 206 }, };

	/**
	 * 本地缺省网址导航数据
	 */
	public static final String[] defaultNavCategory = { "资讯阅读", "生活购物", "社区交友",
			"影音娱乐", "综合资讯"};
	
	public static final String[] defaultNavCategoryDrawableName = { "ic_rc_yuedu", "ic_rc_gouwu", "ic_rc_shequ",
		"ic_rc_yingyin", "ic_rc_zonghe"};

	public static final String[][] defaultNavTitle = {
			{ "游戏社区", "糗事百科", "新浪娱乐", "安卓网", "快乐麻花", "木棉女生网", "豆瓣", "周公解梦",
					"天涯娱乐八卦", "瑞丽" },
			{ "网易新闻", "腾讯新闻", "环球网", "凤凰网", "CNTV", "路透中文网" },
			{ "熊猫看书网", "言情小说吧", "多酷书城", "红袖添香", "起点文学", "小说阅读网", "晋江文学",
					"纵横中文网", "塔读文学", "潇湘书院" },
			{ "大众点评", "58同城", "前程无忧", "搜房租房", "百姓网", "赶集网" },

			{ "百度贴吧", "掌上猫扑", "天涯", "有缘交友", "世纪佳缘", "百合网", "珍爱网", "开心网" },
			{ "美团网", "聚划算", "团800", "拉手网", "窝窝团", "百度团购" },
			{ "淘宝网", "天猫", "乐蜂网", "凡客", "亚马逊", "苏宁易购", "京东商城", "一号店", "当当网" },
			{ "携程网", "去哪儿", "穷游网", "酒店预定", "芒果网", "同程网" },

			{ "nba", "新浪体育", "cctv5", "虎扑体育", "搜狐体育", "网易体育", "直播吧" },
			{ "优酷", "爱奇艺", "PPTV", "土豆网", "第一视频", "搜狐视频" },
			{ "酷我好声音", "百度音乐", "虾米音乐", "QQ音乐", "一听音乐", "宜搜音乐" },
			{ "彩票购买", "话费充值", "快递查询", "在线翻译", "实时路况", "时光影讯" },

			{ "公交查询", "机票酒店", "列车时刻", "违章查询", "特价机票", "手机归属地", "常用号码" } };
	
	
	public static final String[][] defaultNavUrl = {
			// 综合
			{ "http://bbs.18183.com?source=91zm",
					"http://wap2.qiushibaike.com/", "http://ent.sina.cn//",
					"http://m.hiapk.com/theme/", "http://m.kl688.com/",
					"http://mm.91.com/sms/", "http://m.douban.com/login?",
					"http://3g.sina.com.cn/dpool/astro/jm/",
					"http://m.tianya.cn/bbs/list.jsp?item=funinfo",
					"http://wap.rayli.com.cn/" },
			// 新闻
			{ "http://3g.163.com/x/",
					"http://shipei.qq.com/index.htm?from=91zs",
					"http://www.huanqiu.com/", "http://i.ifeng.com/news/",
					"http://www.cntv.cn/", "http://cn.reuters.com/" },
			// 小说
			{ "http://ks.91.com/NewIndex.aspx?stat=9999",
					"http://wap.tadu.com/book/category/104/?cid=1745",
					"http://xs.duoku.com/?fr=xs_91zs",
					"http://wap.hongxiu.com/?siteid=18",
					"http://qidian.cn/linkIn.jsp?id=91xiong",
					"http://www.readnovel.com/", "http://m.jjwxc.com/",
					"http://www.zongheng.com/",
					"http://wap.tadu.com/book/topic/685/?cid=1745",
					"http://g.xxsy.net?czclac=e341301dafe57c680f5ca76f64fb1f49" },
			// 生活
			{ "http://m.dianping.com/tuan?utm_source=app_91zhuomian",
					"http://wap.58.com/", "http://3g.51job.com/?partner=91",
					"http://m.soufun.com/zf/?sf_source=mzu91&utm_source=91zm",
					"http://fuzhou.baixing.com/m/", "http://wap.ganji.cn/" },
			// 社交
			{ "http://wapp.baidu.com/?pd=41300", "http://wap.mop.com/",
					"http://wap.tianya.cn/ally?f=3157",
					"http://youyuan.com/?from=3471", "http://www.jiayuan.com/",
					"http://www.baihe.com/", "http://www.zhenai.com/",
					"http://www.kaixin001.com/" },
			// 团购
			{
					"http://r.union.meituan.com/url/visit/?a=1&key=17Jd8bLqWvgZjQTVyIc6nkExluSDhoGB&url=i.meituan.com",
					"http://r.m.taobao.com/m3?p=mm_32510800_3293005_10741847&c=1005",
					"http://m.tuan800.com/?union=91zm&utm_source=91zm&union_wi=91zm&custom_style=96&vt=8",
					"http://m.lashou.com/?union_pid=976399679&union_sign=55;3428",
					"http://www.55tuan.com", "http://tuan.baidu.com/" },
			// 购物
			{
					"http://m.taobao.com?ttid=12zsh031",
					"http://r.m.taobao.com/m3?p=mm_32510800_3412905_11019732&c=1001",
					"http://wap.lefeng.com/index.php/home/index/aid/27286/cid2/lyw",
					"http://m.vancl.com?source=zhuomian91",
					"http://m.amazon.cn/?_encoding=UTF8&camp=536&creative=3200&linkCode=ur2&tag=dianmeng03-23",
					"http://m.suning.com/emall/snmw_10052_10051_.html",
					"http://union.m.360buy.com/click/go.action?to=http://m.360buy.com&type=1&keyword=&unionId=35955&subunionId=0",
					"http://m.yihaodian.com?tracker_u=10652374",
					"http://www.dangdang.com/" },
			// 旅游
			{
					"http://m.ctrip.com/c/ydmw",
					"http://touch.qunar.com/flight.jsp?bd_source=91desktop",
					"http://www.qyer.com/",
					"http://m.kuxun.cn/hotel.html?fromid=Kzhuomian-S1567842-T1168071&utm_source=91zhuomian&utm_medium=cps&utm_campaign=91zhuomianhotel",
					"http://www.mangocity.com/", "http://wap.17u.cn/" },
			// 体育
			{ "http://china.nba.com/", "http://sports.sina.com.cn/",
					"http://sports.cntv.cn/live/cctv5/index.shtml",
					"http://m.hupu.com/", "http://sports.sohu.com/",
					"http://sports.163.com/", "http://www.zhibo8.cc/" },
			// 视频
			{ "http://m.youku.com/wap/", "http://m.iqiyi.com/?msrc=3_29_54",
					"http://wap.pptv.com/", "http://m.tudou.com/index.do",
					"http://3g.v1.cn/",
					"http://m.tv.sohu.com/?pvid=72c2467c2a2863c2" },
			// 音乐
			{ "http://h.kuwo.cn/hz/?from=91",
					"http://music.baidu.com?fr=91zhuomian",
					"http://www.xiami.com/web/spark?ref=aZm91",
					"http://wfmusic.3g.qq.com/", "http://www.1ting.com/",
					"http://ad2.easou.com:8080/j10ad/ea2.jsp?channel=6&cid=bccn3516_48588_D_1&key=" },
			// 便民
			{
					"http://caipiao.m.taobao.com/?ttid=52zsh003",
					"http://r.m.taobao.com/zc?p=mm_32510800_3412911_11019770",
					"http://wap.kuaidi100.com/",
					"http://translate.google.com/",
					"http://dp.sina.cn/dpool/tools/citytraffic/index.php?p=0&serial=223379234.163",
					"http://m.mtime.com/" },
			// 查询
			{
					"http://m.8684.cn/bus?91",
					"http://touch.qunar.com/hotel.jsp?bd_source=91desktop",
					"http://www.12306.cn/mormhweb",
					"http://www.ip138.com/weizhang.htm",
					"http://m.kuxun.cn/plane.html?fromid=Kzhuomian-S1567842-T1071231&utm_source=91zhuomian&utm_medium=cps&utm_campaign=91zhuomianplane",
					"http://wap.ip138.com/sim.html",
					"http://m.hao123.com/n/v/dianhua?z=100000" } };
	
	
	/**
	 * 在浏览器中打开指定地址
	 * @param ctx
	 * @param url 网页url
	 */
	public static void openPage(Context ctx, String url) {
		try {
			if(null != url && !(url.startsWith("http://") || url.startsWith("https://"))){
				url = "http://" + url;
			}
			Uri uri = Uri.parse(url);
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			ctx.startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */  
    public static int dip2px(Context context, float dpValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    public static int px2dip(Context context, float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }  

}
