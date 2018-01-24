package com.camille.shaojing.quartz;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.camille.shaojing.util.DateUtils;
import com.camille.shaojing.util.SmsUtils;

public class SmsJob implements Job{
	private static Log LOG = LogFactory.getLog(SmsJob.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LOG.info(DateUtils.getStrByDate(new Date(), "yyyy-MM-dd HH:mm:ss")+" Send message begin.");
		try {
			String result = SmsUtils.doPost("17683755019,15657127019", "【Forever Love】To my loving girlfriend:Happy birthday.");
			LOG.info("result:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info(DateUtils.getStrByDate(new Date(), "yyyy-MM-dd HH:mm:ss")+" Send message end.");
	}

}
