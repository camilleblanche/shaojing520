package com.camille.shaojing.model;

import java.util.HashMap;
import java.util.Map;
/**
 * 返回数据
 */
public class R extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;
	
	public R() {

	}
	
	public R(int code) {
		put("code", code);
	}
	
	public R(int code, String msg) {
		put("code", code);
		put("msg", msg);
	}
	
	public static R error() {
		return new R(500, "未知异常，请联系管理员");
	}
	
	public static R error(String msg) {
		return new R(500, msg);
	}
	
	public static R error(int code, String msg) {
		return new R(code, msg);
	}

	public static R ok() {
		return new R(0);
	}
	public static R ok(String msg) {
		return new R(0, msg);
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R(0);
		r.putAll(map);
		return r;
	}
	public static R put(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
