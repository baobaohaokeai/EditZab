package org.roof.monitor.history.dao.api;

import java.util.List;

import com.zabbix4j.history.HistoryGetRequest;
import com.zabbix4j.history.HistoryObject;

/**
 * 
 * <p>Description: </p>
 * <p>Title: IHistroyDao.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月2日 下午3:51:06</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public interface IHistroyDao {
	public List<HistoryObject> get(HistoryGetRequest request);
}
