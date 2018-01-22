package com.camille.shaojing.util;

public class BaseUtils {
	/**
	 * 判空
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj) {
		boolean rtnFlag=false;
		if(obj!=null&&!"".equals(obj)) {
			rtnFlag=true;
		}
		return rtnFlag;
	}
}
