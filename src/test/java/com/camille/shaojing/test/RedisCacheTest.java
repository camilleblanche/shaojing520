package com.camille.shaojing.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import com.camille.shaojing.log4jinit.JUnit4ClassRunner;
import com.camille.shaojing.service.IUserService;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring-context.xml"})
@Transactional
public class RedisCacheTest extends AbstractJUnit4SpringContextTests {
	private static Log LOG = LogFactory.getLog(RedisCacheTest.class);
	@Autowired
	private IUserService iUserService;
	@Test
	public void redisCacheTest() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userId", 1);
		map.put("loginPassword", "Jing0109");
		iUserService.updateUser(map);
	}
}
