package com.example.xlhhlocation;


import android.text.TextUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	private static final String TAG = "DateUtil";


	/**
	 * long的时间转换成string
	 *
	 * @param milliseconds
	 * @param pattern
	 * @return
	 */
	public static String longToDateString(long milliseconds, String pattern) {
		Date date = new Date(milliseconds * 1000);
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}


	private static SimpleDateFormat sdf = null;

	/**
	 *
	 *
	 * @param time
	 * @param strPattern
	 * @return
	 */
	public  static String formatUTC(long time, String strPattern) {
		if (TextUtils.isEmpty(strPattern)) {
			strPattern = "yyyy-MM-dd HH:mm:ss";
		}
		if (sdf == null) {
			try {
				sdf = new SimpleDateFormat(strPattern, Locale.CHINA);
			} catch (Throwable e) {
			}
		} else {
			sdf.applyPattern(strPattern);
		}
		return sdf == null ? "NULL" : sdf.format(time);
	}

	/**
	 * 计算时间差
	 *
	 * @param diff
	 * @param type 0 天数； 1 小时； 2 分钟； 3 秒数
	 * @return
	 */
	public static long getDiffTime(long diff, int type){
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		switch (type){
			case 0:
				day = diff / nd;// 计算差多少天
				return day;
			case 1:
				hour = diff % nd / nh + day * 24;// 计算差多少小时
				return hour;
			case 2:
				min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
				return min;
			case 3:
				sec = diff % nd % nh % nm / ns;// 计算差多少秒   
				return sec;

		}
		return 0;
	}
}
