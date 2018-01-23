package com.camille.shaojing.util ;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	/**	
	 * 字符串转换成日期
	 * @param datestr 要转换的字符串
	 * @param formatestr 转换格式 yyyy-MM-dd HH:mm:ss
	 * @return 返回转化后的日期对象，转化失败后返回null
	 */
	public static Date getDateByStr(String datestr,String formatestr){
		SimpleDateFormat dateFormat=new SimpleDateFormat(formatestr);
		java.util.Date date=null;
		try {
			date=dateFormat.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 日期转换成字符串
	 * @param date要转换成日期格式
	 * @param formatestr 要转换的格式 yyyy-MM-dd HH:mm:ss
	 * @return 返回转换后的字符串
	 */
	public static String getStrByDate(Date date, String formatestr){
		String datestr=null;
		SimpleDateFormat dateFormat=new SimpleDateFormat(formatestr);
			datestr=dateFormat.format(date);
			return datestr;
	}
}
