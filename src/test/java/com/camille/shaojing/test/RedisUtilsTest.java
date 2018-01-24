package com.camille.shaojing.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import com.camille.shaojing.log4jinit.JUnit4ClassRunner;
import com.camille.shaojing.util.RedisUtils;

import redis.clients.jedis.Jedis;
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/spring/spring-redis.xml"})
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring-context.xml"})
@Transactional
public class RedisUtilsTest extends AbstractJUnit4SpringContextTests {
	private static Log LOG = LogFactory.getLog(RedisUtilsTest.class);
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
		LOG.info("boyName:"+boyName);
		LOG.info("girlName:"+girlName);
		jedis.close(); // 释放连接资源
	}
	@Test
	public void jedisUtilsTest() {
		LOG.info("husband:"+redisUtils.get("husband"));
		LOG.info("wife:"+redisUtils.get("wife"));
	}
}
