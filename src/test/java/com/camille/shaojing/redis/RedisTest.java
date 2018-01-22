package com.camille.shaojing.redis;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.1.70", 6379); // 创建客户端 设置IP和端口
		jedis.auth("Camille2.7");
		jedis.set("boy","lichaozhong"); 
		jedis.set("girl","shaojing"); // 设置值
		String boyName=jedis.get("boy");
		String girlName=jedis.get("girl"); // 获取值
		System.out.println("boyName:"+boyName);
		System.out.println("girlName:"+girlName);
		jedis.close(); // 释放连接资源
	}
}
