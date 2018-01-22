package com.camille.shaojing.util;

import java.util.Date;

public class RandomUtils {
	/**
	 * 获取随机数
	 * @param num
	 * @return
	 */
	public static long getRandomNumber(int num){
		//String str= DateUtils.getStrByDate(new Date(),"yyyyMMddHHmmss");
		String str= DateUtils.getStrByDate(new Date(),"yyyyMMddHHmm");
		for(int i=0;i<num;i++){//随机得到num个0到10的数字
			str=str+(int)(Math.random()*10);
		}
		return Long.valueOf(str);
	}
}
