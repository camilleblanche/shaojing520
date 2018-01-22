package com.camille.shaojing.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class CryptographyUtils {
	private static final String SALT="ShaoJing";//加密盐值
	/**
	 * base64加密
	 * @param str
	 * @return
	 */
	public static String encBase64(String str){
		return Base64.encodeToString(str.getBytes());
	}
	/**
	 * base64解密
	 * @param str
	 * @return
	 */
	public static String decBase64(String str){
		return Base64.decodeToString(str);
	}
	/**
	 * shiroMd5加密
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String shiroMd5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}
	/**
	 * shiroMd5加密
	 * @param str
	 * @return
	 */
	public static String shiroMd5(String str){
		return new Md5Hash(str,SALT).toString();
	}
	/**
	 * springMd5加密
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String springMd5Encode(String str,String salt){
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		//md5.setEncodeHashAsBase64(true);//默认false
		return md5.encodePassword(str, salt);
	}
	/**
	 * springMd5加密
	 * @param str
	 * @return
	 */
	public static String springMd5Encode(String str){
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		//md5.setEncodeHashAsBase64(true);//默认false
		return md5.encodePassword(str, SALT);
	}
	/**
	 * springMd5加密校验
	 * @param encPass
	 * @param rawPass
	 * @param salt
	 * @return
	 */
	public static boolean springMd5Check(String encPass, String rawPass, String salt){
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		return md5.isPasswordValid(encPass, rawPass, salt);
	}
	/**
	 * springMd5加密校验
	 * @param encPass
	 * @param rawPass
	 * @return
	 */
	public static boolean springMd5Check(String encPass, String rawPass){
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		return md5.isPasswordValid(encPass, rawPass, SALT);
	}
}
