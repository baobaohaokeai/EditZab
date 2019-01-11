package org.roof.report.report01.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.roof.report.common.entity.Condition;
import org.roof.report.report01.entity.Report01;
import org.roof.roof.dataaccess.api.IDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 
 * <p>Description: </p>
 * <p>Title: Report01Dao.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月4日 下午2:01:52</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Repository
public class Report01Dao implements IReport01Dao{
	@Resource(name="roofDaoSupport")
	private IDaoSupport daoSupport;
	
	public  List<Report01> get(Condition con){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startTime", con.getStartTime());
		param.put("endTime", con.getEndTime());
		//more params to put
		//xxxxx
		
//		@SuppressWarnings("unchecked")
//		List<Map<String,Object>> report11 = (List<Map<String,Object>>) daoSupport
//				.selectForList("org.roof.report.report01.dao.get", param);
//		System.out.println(report11.get(0));
		@SuppressWarnings("unchecked")
		List<Report01> report = (List<Report01>) daoSupport
				.selectForList("org.roof.report.report01.dao.get", param);
		return report;
	}
	
}
