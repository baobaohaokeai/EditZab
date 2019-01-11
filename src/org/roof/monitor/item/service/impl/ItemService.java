package org.roof.monitor.item.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.roof.monitor.item.dao.api.IItemDao;
import org.roof.monitor.item.service.api.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabbix4j.GetRequestCommonParams.Search;
import com.zabbix4j.item.ItemGetRequest;
import com.zabbix4j.item.ItemGetRequest.Params;
import com.zabbix4j.item.ItemGetResponse.Result;

/**
 * 
 * <p>Description: </p>
 * <p>Title: ItemService.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月3日 下午4:08:32</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Service
public class ItemService implements IItemService {
	@Autowired
	private IItemDao itemDao;

	@Override
	public List<Result> get() {
		ItemGetRequest request = new ItemGetRequest();
		Params param = request.getParams();
		param.setOutput("extend");
		List<Integer> Hostids = new ArrayList<Integer>();
		Hostids.add(10105);//agent
		param.setHostids(Hostids);
//		param.setApplication("cpu");
		
		Search search = param.getSearch();
		search.setKey_("system.cpu.util[,system]");
		param.setSearch(search);

		param.setSortField("name");

		return itemDao.get(request);
	}
}
