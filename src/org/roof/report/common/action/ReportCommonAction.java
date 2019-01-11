package org.roof.report.common.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.roof.report.common.entity.Option;
import org.roof.report.common.service.IReportCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <p>Description: </p>
 * <p>Title: ReportCommonAction.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月12日 下午4:35:57</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Controller
@RequestMapping("reportCommon")
public class ReportCommonAction {
	@Autowired
	HttpServletRequest request;
	@Autowired
	private IReportCommonService service;
	
	@RequestMapping("/loadAreaCompany")
	public @ResponseBody List<Option> loadAreaCompany(){
		return service.loadAreaCompany();
	}
	
	@RequestMapping("/loadCountyCompany")
	public @ResponseBody List<Option> loadCountyCompany(){
		return service.loadCountyCompany();
	}
	
	@RequestMapping("/loadSubOffice")
	public @ResponseBody List<Option> loadSubOffice(){
		return service.loadSubOffice();
	}
	
	@RequestMapping("/loadCustomerProp")
	public List<Option> loadCustomerProp() {
		return service.loadCustomerProp();
	}

	@RequestMapping("/loadCustomerLevel")
	public List<Option> loadCustomerLevel() {
		return service.loadCustomerLevel();
	}

	@RequestMapping("/loadMarketServiceType")
	public List<Option> loadMarketServiceType() {
		return service.loadMarketServiceType();
	}

	@RequestMapping("/loadHaltType")
	public List<Option> loadHaltType() {
		return service.loadHaltType();
	}

	@RequestMapping("/loadDept")
	public List<Option> loadDept() {
		return service.loadDept();
	}
}