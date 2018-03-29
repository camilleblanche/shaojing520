package com.camille.shaojing.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class BaseUtils {
	/**
	 * 判空
	 * @param obj
	 * @return
	 */
	public static boolean isBlank(Object obj) {
		boolean rtnFlag=false;
		if(obj==null||"".equals(obj)) {
			rtnFlag=true;
		}
		return rtnFlag;
	}
	
	/**
	 * 获取随机数
	 * @param num
	 * @return
	 */
	public static long getRandomNumber(int num){
		//String str= DateUtils.getStrByDate(new Date(),"yyyyMMddHHmmss");
		String str= DateUtils.getStrByDate(new Date(),"yyyyMMddHHmm");
		for(int i=0;i<num;i++){//随机得到num个0到10的数字
			str=str+(int)(Math.random()*10);
		}
		return Long.valueOf(str);
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 深度克隆
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static <T> T clone(T obj) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
        ByteArrayInputStream bin = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T)ois.readObject();
    }
}
