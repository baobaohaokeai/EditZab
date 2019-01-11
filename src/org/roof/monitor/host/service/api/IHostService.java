package org.roof.monitor.host.service.api;

import java.util.List;

import com.zabbix4j.host.HostGetResponse.Result;

/**
 * 
 * <p>Description: </p>
 * <p>Title: IHostService.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月3日 下午3:56:54</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public interface IHostService {
	
	public List<Integer> create();
	
	public List<Integer> delete(List<Integer> hostIds);
	
	public List<Integer> update();
	
	public List<Result> get();
}
