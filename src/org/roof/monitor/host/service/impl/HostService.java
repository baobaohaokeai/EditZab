package org.roof.monitor.host.service.impl;

import java.util.Date;
import java.util.List;

import org.roof.monitor.host.dao.api.IHostDao;
import org.roof.monitor.host.service.api.IHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabbix4j.host.HostCreateRequest;
import com.zabbix4j.host.HostDeleteRequest;
import com.zabbix4j.host.HostGetRequest;
import com.zabbix4j.host.HostGetResponse.Result;
import com.zabbix4j.host.HostUpdateRequest;
import com.zabbix4j.hostinteface.HostInterfaceObject;

/**
 * 
 * <p>Description: </p>
 * <p>Title: HostService.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月3日 下午3:58:06</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
@Service
public class HostService implements IHostService {
	@Autowired
	private IHostDao hostDao;

	@Override
	public List<Integer> create() {
		HostCreateRequest request = new HostCreateRequest();
		HostCreateRequest.Params param = request.getParams();
		param.setHost("test host created1." + new Date().getTime());
		
		HostInterfaceObject hostInterface = new HostInterfaceObject();
		hostInterface.setType(1);
		hostInterface.setMain(1);
		hostInterface.setUseip(1);
		hostInterface.setIp("192.168.255.255");
		hostInterface.setDns("");
		hostInterface.setPort(10050);
		
		param.addHostInterfaceObject(hostInterface);
		param.addGroupId(50);
		param.addTemplateId(20045);
		return hostDao.create(request);
	}

	@Override
	public List<Integer> delete(List<Integer> hostIds) {
		HostDeleteRequest request = new HostDeleteRequest();
		for(int hostId : hostIds){
			request.addParams(hostId);			
		}
		return hostDao.delete(request);
	}

	@Override
	public List<Integer> update() {
		HostUpdateRequest request = new HostUpdateRequest();
		HostUpdateRequest.Params param = request.getParams();
		param.setHostid(10092);
		param.setStatus(0);
		return hostDao.update(request);
	}

	@Override
	public List<Result> get() {
		HostGetRequest request = new HostGetRequest();
		HostGetRequest.Params param = request.getParams();
		param.setOutput("extend");
		return hostDao.get(request);
	}
}
