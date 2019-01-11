package org.roof.monitor.item.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.roof.monitor.ZabbixLogin;
import org.roof.monitor.item.dao.api.IItemDao;
import org.springframework.stereotype.Component;

import com.zabbix4j.GetRequestCommonParams.Search;
import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.item.Item;
import com.zabbix4j.item.ItemGetRequest;
import com.zabbix4j.item.ItemGetRequest.Params;
import com.zabbix4j.item.ItemGetResponse.Result;

/**
 * 
 * <p>Description: </p>
 * <p>Title: ItemDao.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月2日 下午3:12:50</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Component
public class ItemDao implements IItemDao {
	private Item item = ZabbixLogin.getZabbixApi().item();
	
	@Override
	public List<Result> get(ItemGetRequest request){
		List<Result> list = new ArrayList<Result>();
		try {
			list = item.get(request).getResult();
		} catch (ZabbixApiException e) {
			e.printStackTrace();
		} 
		return list;	
	}
	
	@Override
	public int getItemId(int hostId , String key_){
		ItemGetRequest request = new ItemGetRequest();
		Params param = request.getParams();
		param.setOutput("itemId");
		param.addHostId(hostId);
		
		Search search = param.getSearch();
		search.setKey_(key_);
		param.setSearch(search);

		List<Result> list = new ArrayList<Result>();
		try {
			list = item.get(request).getResult();
		} catch (ZabbixApiException e) {
			e.printStackTrace();
		}
		return list.size() > 0 ? list.get(0).getItemid() : -1;
	}
	
	@Override
	public List<Integer> getItemIds(int hostId, String[] keys) {
		List<Integer> list = new ArrayList<Integer>();
		for(String key_ : keys){
			if(key_.length() > 0){
				list.add(getItemId(hostId ,key_));				
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		ItemDao item = new ItemDao();
		item.getItemId(10105, "system.cpu.util[,system]");
	}


}
