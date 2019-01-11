package org.roof.monitor.common.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.roof.monitor.common.dao.api.IMonitorCommonDao;
import org.roof.monitor.common.entity.MonitorItem;
import org.roof.monitor.common.entity.MonitorType;
import org.roof.roof.dataaccess.api.IDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>Description: </p>
 * <p>Title: MonitorCommonDao.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月16日 下午2:50:08</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Component
public class MonitorCommonDao implements IMonitorCommonDao {
	
	@Autowired
	@Qualifier("roofDaoSupport")
	private IDaoSupport daoSupport;

	@SuppressWarnings("unchecked")
	@Override
	public List<MonitorType> loadType() {
		List<MonitorType> list = (List<MonitorType>) daoSupport.selectForList("org.roof.monitor.common.dao.loadType");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MonitorItem> loadItemByType(String type) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("value", type);
		List<MonitorItem> list = (List<MonitorItem>) daoSupport.selectForList("org.roof.monitor.common.dao.loadItemByType",param);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MonitorItem> loadHotItem() {
		List<MonitorItem> list = (List<MonitorItem>) daoSupport.selectForList("org.roof.monitor.common.dao.loadHotItem");
		return list;
	}
}
