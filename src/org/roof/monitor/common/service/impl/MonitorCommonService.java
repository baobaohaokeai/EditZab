package org.roof.monitor.common.service.impl;

import java.util.List;

import org.roof.monitor.common.dao.api.IMonitorCommonDao;
import org.roof.monitor.common.entity.MonitorItem;
import org.roof.monitor.common.entity.MonitorType;
import org.roof.monitor.common.service.api.IMonitorCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * <p>Description: </p>
 * <p>Title: MonitorCommonService.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月16日 下午2:51:02</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Service
public class MonitorCommonService implements IMonitorCommonService {
	@Autowired
	private IMonitorCommonDao dao;

	@Override
	public List<MonitorType> loadType() {
		return dao.loadType();
	}

	@Override
	public List<MonitorItem> loadItemByType(String type) {
		return dao.loadItemByType(type);
	}
	
	@Override
	public List<MonitorItem> loadHotItem() {
		return dao.loadHotItem();
	}

}
