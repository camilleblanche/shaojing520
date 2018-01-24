package com.camille.shaojing.quartz;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.camille.shaojing.util.DateUtils;

public class SmsJob implements Job{
	private static Log log = LogFactory.getLog(SmsJob.class);
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.info(DateUtils.getStrByDate(new Date(), "yyyy-MM-dd HH:mm:ss")+" Send message begin.");
		log.info(DateUtils.getStrByDate(new Date(), "yyyy-MM-dd HH:mm:ss")+" Send message end.");
	}

}
