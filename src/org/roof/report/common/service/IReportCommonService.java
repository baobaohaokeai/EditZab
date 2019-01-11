package org.roof.report.common.service;

import java.util.List;

import org.roof.report.common.entity.Option;

/**
 * 
 * <p>Description: </p>
 * <p>Title: IReportCommonService.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月12日 下午4:36:25</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public interface IReportCommonService {
	/**
	 * 
	 * <p>Description: 加载地市公司</p>
	 * <p>Title: loadAreaCompany</p>
	 * @return
	 */
	public  List<Option> loadAreaCompany();
	
	/**
	 * 
	 * <p>Description: 加载区县公司</p>
	 * <p>Title: loadCountyCompany</p>
	 * @param type
	 * @return
	 */
	public  List<Option> loadCountyCompany();
	
	/**
	 * 
	 * <p>Description: 加载支局</p>
	 * <p>Title: loadSubOffice</p>
	 * @return
	 */
	public  List<Option> loadSubOffice();
	
	/**
	 * 
	 * <p>Description: 加载客户统计属性</p>
	 * <p>Title: loadCustomerProp</p>
	 * @return
	 */
	public  List<Option> loadCustomerProp();
	
	/**
	 * 
	 * <p>Description: 加载客户等级</p>
	 * <p>Title: loadCustomerLevel</p>
	 * @return
	 */
	public  List<Option> loadCustomerLevel();
	
	/**
	 * 
	 * <p>Description: 加载营销服务类型</p>
	 * <p>Title: loadMarketServiceType</p>
	 * @return
	 */
	public  List<Option> loadMarketServiceType();
	
	/**
	 * 
	 * <p>Description: 加载停机类型</p>
	 * <p>Title: loadHaltType</p>
	 * @return
	 */
	public  List<Option> loadHaltType();
	
	/**
	 * 
	 * <p>Description: 加载部门</p>
	 * <p>Title: loadDept</p>
	 * @return
	 */
	public  List<Option> loadDept();
}
