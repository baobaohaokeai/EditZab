package org.roof.report.report01.action;

import java.util.List;

import org.roof.report.common.entity.Condition;
import org.roof.report.report01.entity.Report01;
import org.roof.report.report01.service.IReport01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <p>Description:停机订单竣工清单 </p>
 * <p>Title: Report01Action.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月4日 上午11:31:55</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Controller
@RequestMapping("report01Action")
public class Report01Action {
	@Autowired
	private IReport01Service service;
	
	@RequestMapping("/load")
	public String load(){
		return "/roof-web/report/report01/report.jsp";
	}
	
	@RequestMapping("/get")
	public @ResponseBody List<Report01> get(Condition condition){
		return service.get(condition);
	}
	
}
