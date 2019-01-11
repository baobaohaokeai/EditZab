package org.roof.report.common.service;

import java.util.List;

import org.roof.report.common.dao.IReportCommonDao;
import org.roof.report.common.entity.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * <p>Description: </p>
 * <p>Title: ReportCommonService.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月12日 下午4:36:31</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Service
public class ReportCommonService implements IReportCommonService {
	@Autowired
	private IReportCommonDao dao;

	@Override
	public List<Option> loadAreaCompany() {
		return dao.loadAreaCompany();
	}

	@Override
	public List<Option> loadCountyCompany() {
		return dao.loadCountyCompany();
	}

	@Override
	public List<Option> loadSubOffice() {
		return dao.loadSubOffice();
	}

	@Override
	public List<Option> loadCustomerProp() {
		return dao.loadCustomerProp();
	}

	@Override
	public List<Option> loadCustomerLevel() {
		return dao.loadCustomerLevel();
	}

	@Override
	public List<Option> loadMarketServiceType() {
		return dao.loadMarketServiceType();
	}

	@Override
	public List<Option> loadHaltType() {
		return dao.loadHaltType();
	}

	@Override
	public List<Option> loadDept() {
		return dao.loadDept();
	}
}
