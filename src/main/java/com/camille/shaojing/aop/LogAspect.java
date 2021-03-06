package com.camille.shaojing.aop;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

import com.camille.shaojing.util.DateUtils;
import com.camille.shaojing.util.JsonUtils;

public class LogAspect {
	private static Log LOG = LogFactory.getLog(LogAspect.class);

	public void before(JoinPoint joinPoint) {
		String name = joinPoint.getTarget().getClass().getName();
		String method = joinPoint.getSignature().getName();
		String timestamp = DateUtils.getStrByDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		LOG.info(timestamp + "：" + name + "." + method + "(..)");
	}

	public void after(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		LOG.info("params："+JsonUtils.toJSONString(args));
	}

	public void afterReturn(JoinPoint joinPoint, Object value) {
		LOG.info("rtnValue：" + value);
	}
}
