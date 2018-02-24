package com.camille.shaojing.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.camille.shaojing.log4jinit.JUnit4ClassRunner;
import com.camille.shaojing.util.CryptographyUtils;
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring-context.xml"})
public class CryptographyTest extends AbstractJUnit4SpringContextTests{
	private static Log LOG = LogFactory.getLog(CryptographyTest.class);
	@Test
	public void shiroMd5Test() {
		LOG.info("passwordEn:"+CryptographyUtils.shiroMd5("Jing0109"));
	}
}
