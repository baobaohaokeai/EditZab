package org.roof.monitor.history.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.roof.monitor.ZabbixLogin;
import org.roof.monitor.history.dao.api.IHistroyDao;
import org.springframework.stereotype.Component;

import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.history.History;
import com.zabbix4j.history.HistoryGetRequest;
import com.zabbix4j.history.HistoryObject;

/**
 * 
 * <p>Description: </p>
 * <p>Title: HistroyDao.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月2日 下午3:52:01</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Component
public class HistroyDao implements IHistroyDao{
	private History history = ZabbixLogin.getZabbixApi().history();
	
	public List<HistoryObject> get(HistoryGetRequest request){
		List<HistoryObject> list = new ArrayList<HistoryObject>();
		try {
			list = history.get(request).getResult();
		} catch (ZabbixApiException e) {
			e.printStackTrace();
		}
		return list;
	}
}
