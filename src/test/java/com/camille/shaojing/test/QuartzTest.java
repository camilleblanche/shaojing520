package com.camille.shaojing.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import com.camille.shaojing.constant.QuartzConstants;
import com.camille.shaojing.log4jinit.JUnit4ClassRunner;
import com.camille.shaojing.quartz.SmsJob;
import com.camille.shaojing.service.IQuartzService;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring-context.xml"})
@Transactional  
public class QuartzTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private IQuartzService IQuartzService;
	@Test
	public void quartzAddJobTest() {
		IQuartzService.addJob("shaojing", QuartzConstants.JOB_GROUP_NAME, 
				"camille", QuartzConstants.TRIGGER_GROUP_NAME, SmsJob.class, "0 43 10 24 01 ?");
	}
	@Test
	public void quartzDelJobTest() {
		IQuartzService.removeJob("shaojing", QuartzConstants.JOB_GROUP_NAME,
				"camille", QuartzConstants.TRIGGER_GROUP_NAME);
	}
}
