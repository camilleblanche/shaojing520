package com.camille.shaojing.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;

import com.camille.shaojing.util.RedisUtils;

import redis.clients.jedis.Jedis;
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/spring/spring-redis.xml"})
public class RedisTest {
	private RedisUtils redisUtils;
	@Before
	public void before() {
		@SuppressWarnings("resource")
		ApplicationContext context=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/config/spring/spring-redis.xml");  
		redisUtils=context.getBean("redisUtil",RedisUtils.class);  
	}
	@Test
	public void simpleJedisTest() {
		Jedis jedis = new Jedis("192.168.1.70", 6379); // 创建客户端 设置IP和端口
		jedis.auth("Camille2.7");
		jedis.set("boyName","lichaozhong"); 
		jedis.set("girlName","shaojing"); // 设置值
		String boyName=jedis.get("boyName");
		String girlName=jedis.get("girlName"); // 获取值
		System.out.println("boyName:"+boyName);
		System.out.println("girlName:"+girlName);
		jedis.close(); // 释放连接资源
	}
	@Test
	public void jedisUtilsTest() {
		redisUtils.get("wife");
	}
}
