package com.camille.shaojing.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import com.camille.shaojing.log4jinit.JUnit4ClassRunner;

import com.camille.shaojing.util.SmsUtils;
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring-context.xml"})
@Transactional
public class SmsUtilsTest extends AbstractJUnit4SpringContextTests {
	private static Log LOG = LogFactory.getLog(RedisUtilsTest.class);
	@Test
	public void smsUtilsTest() {
		try {
			String result = SmsUtils.doPost("17683755019,15657127019", "【Forever Love】To my loving girlfriend:Happy birthday.");
			LOG.info("result:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
