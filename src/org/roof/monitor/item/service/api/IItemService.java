package org.roof.monitor.item.service.api;

import java.util.List;

import com.zabbix4j.item.ItemGetResponse.Result;

/**
 * 
 * <p>Description: </p>
 * <p>Title: IItemService.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月3日 下午4:06:23</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public interface IItemService {
	
	public List<Result> get();
}
