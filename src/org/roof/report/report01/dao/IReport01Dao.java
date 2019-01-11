package org.roof.report.report01.dao;

import java.util.List;

import org.roof.report.common.entity.Condition;
import org.roof.report.report01.entity.Report01;

/**
 * 
 * <p>Description: </p>
 * <p>Title: IReport01Dao.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月4日 下午2:01:52</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public interface IReport01Dao {

	public  List<Report01> get(Condition condition);
	
}
