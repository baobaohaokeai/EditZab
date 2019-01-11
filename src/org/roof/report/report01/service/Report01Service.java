package org.roof.report.report01.service;

import java.util.List;

import org.roof.report.common.entity.Condition;
import org.roof.report.report01.dao.IReport01Dao;
import org.roof.report.report01.entity.Report01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * <p>Description: </p>
 * <p>Title: Report01Service.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月4日 下午2:01:52</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Service
public class Report01Service implements IReport01Service{
	@Autowired
	private IReport01Dao dao;
	
	public  List<Report01> get(Condition condition){
		return dao.get(condition);	
	}
	
}
