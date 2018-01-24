package com.camille.shaojing.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import com.camille.shaojing.constant.QuartzConstants;
import com.camille.shaojing.log4jinit.JUnit4ClassRunner;
import com.camille.shaojing.quartz.DemoJob;
import com.camille.shaojing.service.IQuartzService;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring-context.xml"})
@Transactional  
public class QuartzTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private IQuartzService IQuartzService;
	@Test
	public void quartzAddJobTest() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("wife", "shaojing");
		map.put("age", 20L);
		IQuartzService.addJob("lichaozhong", QuartzConstants.JOB_GROUP_NAME, 
				"shaojing", QuartzConstants.TRIGGER_GROUP_NAME, DemoJob.class, "0 00 16 24 01 ?",
				map);
	}
	@Test
	public void quartzDelJobTest() {
		IQuartzService.removeJob("lichaozhong", QuartzConstants.JOB_GROUP_NAME,
				"shaojing", QuartzConstants.TRIGGER_GROUP_NAME);
	}
}
