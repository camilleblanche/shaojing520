package com.camille.shaojing.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.camille.shaojing.util.SmsUtils;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring-context.xml"})
public class SmsUtilsTest extends AbstractJUnit4SpringContextTests {
	@Test
	public void smsUtilsTest() {
		try {
			String result = SmsUtils.doPost("17683755019,15657127019", "【Forever Love】To my loving girlfriend:Happy birthday.");
			System.out.println("result:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
