package org.roof.monitor.common.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.roof.monitor.common.entity.MonitorItem;
import org.roof.monitor.common.entity.MonitorType;
import org.roof.monitor.common.service.api.IMonitorCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <p>Description: </p>
 * <p>Title: MonitorCommonAction.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月16日 下午2:30:09</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Controller
@RequestMapping("monitorCommon")
public class MonitorCommonAction {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private IMonitorCommonService service;
	
	@RequestMapping("/loadType")
	public @ResponseBody List<MonitorType> loadType(){
		return service.loadType();
	}
	
	@RequestMapping("/loadItemByType")
	public @ResponseBody List<MonitorItem> loadItemByType(){
		String type = request.getParameter("type");
		return service.loadItemByType(type);
	}
	
	@RequestMapping("/loadHotItem")
	public @ResponseBody List<MonitorItem> loadHotItem(){
		return service.loadHotItem();
	}
	
}
