package org.roof.monitor.common.service.api;

import java.util.List;

import org.roof.monitor.common.entity.MonitorItem;
import org.roof.monitor.common.entity.MonitorType;

/**
 * 
 * <p>Description: </p>
 * <p>Title: IMonitorCommonService.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月16日 下午2:54:55</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public interface IMonitorCommonService {
	public  List<MonitorType> loadType();
	
	public  List<MonitorItem> loadItemByType(String type);
	
	public  List<MonitorItem> loadHotItem();
}
