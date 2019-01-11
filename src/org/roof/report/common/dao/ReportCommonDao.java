package org.roof.report.common.dao;

import java.util.List;

import org.roof.report.common.entity.Option;
import org.roof.roof.dataaccess.api.IDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * 
 * <p>Description: </p>
 * <p>Title: ReportCommonDao.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月12日 下午4:36:12</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class ReportCommonDao implements IReportCommonDao {
	
	@Autowired
	@Qualifier("roofDaoSupport")
	private IDaoSupport daoSupport;

	@Override
	public List<Option> loadAreaCompany() {
//		List<Option> list = (List<Option>) daoSupport.selectForList("org.roof.report.common.dao.loadAreaCompany");
		return null;
	}

	@Override
	public List<Option> loadCountyCompany() {
//		List<Option> list = (List<Option>) daoSupport.selectForList("org.roof.report.common.dao.loadCountyCompany");
		return null;
	}

	@Override
	public List<Option> loadSubOffice() {
//		List<Option> list = (List<Option>) daoSupport.selectForList("org.roof.report.common.dao.loadSubOffice");
		return null;
	}

	@Override
	public List<Option> loadCustomerProp() {
//		List<Option> list = (List<Option>) daoSupport.selectForList("org.roof.report.common.dao.loadCustomerProp");
		return null;
	}

	@Override
	public List<Option> loadCustomerLevel() {
//		List<Option> list = (List<Option>) daoSupport.selectForList("org.roof.report.common.dao.loadCustomerLevel");
		return null;
	}

	@Override
	public List<Option> loadMarketServiceType() {
//		List<Option> list = (List<Option>) daoSupport.selectForList("org.roof.report.common.dao.loadMarketServiceType");
		return null;
	}

	@Override
	public List<Option> loadHaltType() {
//		List<Option> list = (List<Option>) daoSupport.selectForList("org.roof.report.common.dao.loadHaltType");
		return null;
	}

	@Override
	public List<Option> loadDept() {
//		List<Option> list = (List<Option>) daoSupport.selectForList("org.roof.report.common.dao.loadDept");
		return null;
	}
}
