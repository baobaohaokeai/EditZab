package test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * <p>Description: </p>
 * <p>Title: WriteLogUtil.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月27日 上午10:52:40</p> 
 * @author wangjb 
 * @version 1.0 
 * 
 */
public class WriteLogUtil {
	public static void WriteLogUtil(){
		System.out.println("-----------------");
	}
	
	@WriteLog(value = "testests",optType="新增",number=01)
	public static void test(){
		System.out.println("-------------test--------------");
	}
	
	public static void main(String[] args) {
		test();
		writeLog(WriteLogUtil.class);
		WriteLogUtil();
	}
	
	public static void writeLog(Class<?> clazz){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss:SSS");
		Method[] ms = clazz.getDeclaredMethods();
		for(Method f :ms){
			if(f.isAnnotationPresent(WriteLog.class)){
				WriteLog log = f.getAnnotation(WriteLog.class);
				System.out.println("用户(XXX)在"+sdf.format(new Date())+"访问了("+f.getName()+")方法"
					+";optType="+log.optType());
			}
		}
	}
}
