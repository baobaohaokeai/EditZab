package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * <p>Description: </p>
 * <p>Title: WriteLog.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月27日 上午10:01:05</p> 
 * @author wangjb 
 * @version 1.0 
 * 
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD,ElementType.FIELD,ElementType.TYPE })
public @interface WriteLog {
	String value() default "";
	
	String optType() default "";
	
	int number() default 0;
	
}
