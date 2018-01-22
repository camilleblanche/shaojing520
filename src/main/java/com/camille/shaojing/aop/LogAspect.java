package com.camille.shaojing.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;

import com.camille.shaojing.util.DateUtils;

public class LogAspect {
	public void before(JoinPoint joinPoint){
		String name=joinPoint.getTarget().getClass().getName();
		String method=joinPoint.getSignature().getName();
		String timestamp=DateUtils.getStrByDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		System.out.println(timestamp+"："+name+"."+method+"(..)");
	}
	
	public void after(JoinPoint joinPoint){
		Object[] args=joinPoint.getArgs();
		System.out.print("params：");
		for (Object arg : args) {
			System.out.print(arg+" ");
		}
		System.out.println();
	}
	
	public void afterReturn(JoinPoint joinPoint,Object value){
		System.out.println("rtnValue："+value);
	}
}
