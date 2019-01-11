package org.roof.monitor.item.dao.api;

import java.util.List;

import com.zabbix4j.item.ItemGetRequest;
import com.zabbix4j.item.ItemGetResponse.Result;

/**
 * 
 * <p>Description: </p>
 * <p>Title: IItem.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月2日 下午3:11:15</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public interface IItemDao {
	public List<Result> get(ItemGetRequest request);
	
	public int getItemId(int hostId , String key_);
	
	public List<Integer> getItemIds (int hostId , String[] keys);
}
