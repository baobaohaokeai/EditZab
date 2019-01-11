package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * <p>Description: </p>
 * <p>Title: TestSync.java</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2017年2月4日 上午9:34:29</p> 
 * @author Administrator 
 * @version 1.0 
 * 
 */
public class TestSync {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static byte[] lock = new byte[0];
	
	public String createTimeStr(){
        String timeStr;
        synchronized (lock) {
        	timeStr = sdf.format(new Date());
        	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        return timeStr;
	}
}
