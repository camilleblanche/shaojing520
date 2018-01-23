package com.camille.shaojing.task;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.camille.shaojing.util.DateUtils;
import com.camille.shaojing.util.SmsUtils;


public class TimedTask {
	private static Log log = LogFactory.getLog(TimedTask.class);
	public void loveHint() {
		log.info(DateUtils.getStrByDate(new Date(), "yyyy-MM-dd HH:mm:ss")+" Send message begin.");
		try {
			String result = SmsUtils.doPost("17683755019,15657127019", "【Forever Love】To my loving girlfriend:Happy birthday.");
			log.info("result:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info(DateUtils.getStrByDate(new Date(), "yyyy-MM-dd HH:mm:ss")+" Send message end.");
	}
}
