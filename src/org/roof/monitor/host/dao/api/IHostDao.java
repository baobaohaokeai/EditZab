package org.roof.monitor.host.dao.api;

import java.util.List;

import com.zabbix4j.host.HostCreateRequest;
import com.zabbix4j.host.HostDeleteRequest;
import com.zabbix4j.host.HostGetRequest;
import com.zabbix4j.host.HostGetResponse.Result;
import com.zabbix4j.host.HostUpdateRequest;

/**
 * 
 * <p>Description: </p>
 * <p>Title: IHostDao.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月3日 下午3:09:27</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public interface IHostDao {
	
	public List<Integer> create(HostCreateRequest request);
	
	public List<Integer> delete(HostDeleteRequest request);
	
	public List<Integer> update(HostUpdateRequest request);
	
	public List<Result> get(HostGetRequest request);
	
	public int getHostId(String hostName);
}
