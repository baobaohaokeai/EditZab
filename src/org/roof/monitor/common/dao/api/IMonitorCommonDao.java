package org.roof.monitor.common.dao.api;

import java.util.List;

import org.roof.monitor.common.entity.MonitorItem;
import org.roof.monitor.common.entity.MonitorType;

/**
 * 
 * <p>Description: </p>
 * <p>Title: IMonitorCommonDao.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月16日 下午2:49:17</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public interface IMonitorCommonDao {
	/**
	 * 
	 * <p>Description: 加载监控类型</p>
	 * <p>Title: loadType</p>
	 * @return
	 */
	public  List<MonitorType> loadType();
	
	/**
	 * 
	 * <p>Description: 加载已知监控类型对应的监控项</p>
	 * <p>Title: loadItemByType</p>
	 * @param type
	 * @return
	 */
	public  List<MonitorItem> loadItemByType(String type);
	
	/**
	 * 
	 * <p>Description: 加载热门监控项</p>
	 * <p>Title: loadHotItem</p>
	 * @return
	 */
	public  List<MonitorItem> loadHotItem();
}
