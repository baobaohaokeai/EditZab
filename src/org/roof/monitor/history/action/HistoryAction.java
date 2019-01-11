package org.roof.monitor.history.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.roof.monitor.ToExport;
import org.roof.monitor.MonitorUtils;
import org.roof.monitor.history.service.api.IHistoryService;
import org.roof.web.resource.entity.ResourceVo;
import org.roof.web.resource.service.api.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * <p>Description: </p>
 * <p>Title: HistoryAction.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月3日 下午5:13:07</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Controller
@RequestMapping("monitorHistoryAction")
public class HistoryAction {
	
	@Autowired
	private IHistoryService service;
	@Autowired
	private IResourceService resourceService;
	
	private List<JSONObject> result = null;
	
	@RequestMapping("/get")
	public @ResponseBody List<JSONObject> get(String hostName,String key_,int resultType){
		this.result = null;
		
		List<JSONObject> result = MonitorUtils.toJsonList(service.get(hostName, key_, resultType));
		this.result = result;
		
		return result;
	}
	
	@Deprecated
	@RequestMapping("/getVersion")
	public @ResponseBody JSONObject getVersion(){
		return MonitorUtils.getVersion();
	}
	
	@RequestMapping("/read")
	public @ResponseBody List<ResourceVo> read(Long id, Long roleId, HttpServletRequest request) {
		String basePath = request.getContextPath();
//		if (roleId == null || roleId.longValue() == 0) {
			//将resource表中的id为75(监控管理首页)的节点作为当前树的顶节点
			return resourceService.read(id, basePath, 75L);
//		} else {
//			return resourceService.readByRole(id, roleId, basePath);
//		}
	}
	
	@RequestMapping("/index")
	public String index(){
		return "/roof-web/monitor/index/index.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(){
		return "/roof-web/monitor/detail/detail.jsp";
	}
	
	@RequestMapping("/toExcel")
	public void toExcel(HttpServletRequest request, HttpServletResponse response){
		new ToExport().export(request, response, this.result);
	}
	
}
