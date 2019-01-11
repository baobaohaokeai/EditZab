package org.roof.monitor.history.service.api;

import java.util.List;

import com.zabbix4j.history.HistoryObject;

/**
 * 
 * <p>Description: </p>
 * <p>Title: HistoryService.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月2日 下午3:16:54</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public interface IHistoryService {
	
	public  List<HistoryObject> get(String hostName,String key_,int resultType);
	
	@Deprecated
	public  List<HistoryObject> getMuti(String hostName,String key_,int resultType);
}
