package org.roof.monitor.host.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.roof.monitor.ZabbixLogin;
import org.roof.monitor.host.dao.api.IHostDao;
import org.springframework.stereotype.Component;

import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.host.Host;
import com.zabbix4j.host.HostCreateRequest;
import com.zabbix4j.host.HostDeleteRequest;
import com.zabbix4j.host.HostGetRequest;
import com.zabbix4j.host.HostGetRequest.Filter;
import com.zabbix4j.host.HostGetResponse.Result;
import com.zabbix4j.host.HostUpdateRequest;

/**
 * 
 * <p>Description: </p>
 * <p>Title: HostDao.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月3日 下午3:08:09</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Component
public class HostDao implements IHostDao{
	private Host host = ZabbixLogin.getZabbixApi().host();
	
	public List<Integer> create(HostCreateRequest request){
		List<Integer> list = new ArrayList<Integer>();
		try {
			list = host.create(request).getResult().getHostids();
		} catch (ZabbixApiException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<Integer> delete(HostDeleteRequest request){
		List<Integer> list = new ArrayList<Integer>();
		try {
			list = host.delete(request).getResult().getHostids();
		} catch (ZabbixApiException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Integer> update(HostUpdateRequest request){
		List<Integer> list = new ArrayList<Integer>();
		try {
			list = host.update(request).getResult().getHostids();
		} catch (ZabbixApiException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Result> get(HostGetRequest request){
		List<Result> list = new ArrayList<Result>();
		try {
			list = host.get(request).getResult();
		} catch (ZabbixApiException e) {
			e.printStackTrace();
		}
		return list; //--10105 (agent)  10084(server)
		
	}
	
	public int getHostId(String hostName){
		HostGetRequest request = new HostGetRequest();
		HostGetRequest.Params param = request.getParams();
		param.setOutput("hostid");
		
		Filter filter = param.getFilter();
		filter.setHost(hostName);
		param.setFilter(filter);

		List<Result> list = new ArrayList<Result>();
		try {
			list = host.get(request).getResult();
		} catch (ZabbixApiException e) {
			e.printStackTrace();
		}
		return list.size() > 0 ? list.get(0).getHostid() : -1; //--10105 (agent)  10084(server)
		
	}
}
