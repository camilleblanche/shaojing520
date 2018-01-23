package com.camille.shaojing.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.camille.shaojing.util.RedisUtils;

import redis.clients.jedis.Jedis;
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/spring/spring-redis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring-context.xml"})
public class RedisTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private RedisUtils redisUtils;
	@Before
	public void before() {
		/*@SuppressWarnings("resource")
		ApplicationContext context=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/config/spring/spring-redis.xml");  
		redisUtils=context.getBean("redisUtil",RedisUtils.class);  */
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
		System.out.println(redisUtils.get("wife"));
	}
}
