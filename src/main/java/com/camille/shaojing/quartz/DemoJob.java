package com.camille.shaojing.quartz;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import com.camille.shaojing.util.DateUtils;

public class DemoJob implements Job {
	private static Log LOG = LogFactory.getLog(DemoJob.class);
	
	//private String wife;
	
	//private Long age;//(1)使用JobFactory实现基本类型数据的自动"注入",推荐
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LOG.info(DateUtils.getStrByDate(new Date(), "yyyy-MM-dd HH:mm:ss")+" job begin.");
		try {
			JobKey key = context.getJobDetail().getKey();//jobGroupName.jobName
			//JobDataMap dataMap = context.getJobDetail().getJobDataMap();
			JobDataMap dataMap = context.getMergedJobDataMap();//quartz 1.5+ 最佳
			//(2)JobDataMap存取基本类型的数据
			String wife = dataMap.getString("wife");
			long age = dataMap.getLong("age");
			LOG.info(key+"-wife:"+wife+";age:"+age);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info(DateUtils.getStrByDate(new Date(), "yyyy-MM-dd HH:mm:ss")+" job end.");
	}
/*	public String getWife() {
		return wife;
	}
	public void setWife(String wife) {
		this.wife = wife;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}*/
}
