package org.roof.monitor.history.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.roof.monitor.history.dao.api.IHistroyDao;
import org.roof.monitor.history.service.api.IHistoryService;
import org.roof.monitor.host.dao.api.IHostDao;
import org.roof.monitor.item.dao.api.IItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabbix4j.history.HistoryGetRequest;
import com.zabbix4j.history.HistoryGetRequest.Params;
import com.zabbix4j.history.HistoryObject;

/**
 * 
 * <p>Description: </p>
 * <p>Title: HistoryService.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月2日 下午3:18:21</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Service
public class HistoryService implements IHistoryService {
	@Resource(name="hostDao")
	private IHostDao hostDao;
	@Autowired
	private IItemDao itemDao;
	@Autowired
	private IHistroyDao historyDao;

	public List<HistoryObject> get(String hostName,String key_,int resultType){		
		/*获取主机id*/
		int hostId = hostDao.getHostId(hostName);
		if(hostId == -1){
			try {
				throw new Exception("获取hostName为"+hostName+"的主机id失败!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		/*获取监控项id*/
		int itemId = itemDao.getItemId(hostId, key_);
		if(itemId == -1){
			try {
				throw new Exception("获取key为"+key_+"的监控项id失败!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		/*设置参数*/
		HistoryGetRequest request = new HistoryGetRequest();
		
		Params param = request.getParams();
		param.setOutput("extend");
		param.setHistory(resultType);//0:浮点 1:字符串 2:日志 3:整数(默认) 4:文本
		param.addItemId(itemId);
		param.setSortField("clock");
		param.setSortOrder("DESC");//需要大写
		param.setLimit(60);
		
		return historyDao.get(request);
	}
	
	@Deprecated
	public List<HistoryObject> getMuti(String hostName,String key_,int resultType){		
		/*获取主机id*/
		int hostId = hostDao.getHostId(hostName);
		if(hostId == -1){
			try {
				throw new Exception("获取hostName为"+hostName+"的主机id失败!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		/*获取监控项id*/
		String[] keys = key_.split(";");
		List<Integer>  itemIds = itemDao.getItemIds(hostId, keys);

		/*设置参数*/
		HistoryGetRequest request = new HistoryGetRequest();
		
		Params param = request.getParams();
		param.setOutput("extend");
		param.setHistory(resultType);//0:浮点 1:字符串 2:日志 3:整数(默认) 4:文本
		param.setItemids(itemIds);
		param.setSortField("clock");
		param.setSortOrder("DESC");//需要大写
		param.setLimit(60);
		
		return historyDao.get(request);
	}
}
