package com.camille.shaojing.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;

public class JsonUtils {
	/**
	 * 将参数转化为JSON字符串
	 * @param param 要转化的参数
	 * @return
	 */
	public static String toJSONString(Object param) {
		return JSON.toJSONString(param);
	}
	/**
	 * 将JSON字符串转为Map
	 * @param jsonStr JSON字符串
	 * @return
	 */
	public static Map<?,?> parseMap(String jsonStr){
		return JSON.parseObject(jsonStr,Map.class);
	}
	/**
	 * 将JSON字符串转为clazz对象
	 * @param jsonStr JSON字符串
	 * @param clzz clazz类
	 * @return
	 */
	public static <T> T parseObject(String jsonStr,Class<T> clazz){
		return JSON.parseObject(jsonStr, clazz);
	}
	
}
