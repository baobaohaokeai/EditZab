package org.roof.monitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.apiInfo.ApiInfoGetRequest;

/** 
 * <p>Description: </p>
 * <p>Title: MonitorUtils.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年5月23日 上午9:20:16</p> 
 * @author wangjb 
 * @version 1.0 
 * 
 */
public class MonitorUtils {
	/**
	 * <p>Description: </p>
	 * <p>Title: toJsonList</p>
	 * @param list:beanList
	 * @param pattern:SimpleDateFormat日期格式
	 * @return
	 */
	public static <T> List<JSONObject> toJsonList(List<T> list, String pattern){
		List<JSONObject> result = new ArrayList<JSONObject>();
		JSONObject json = null;
		long timestamp = 0;
		for(T t : list){
			json = JSONObject.parseObject(JSONObject.toJSONString(t));
			if(json.containsKey("clock")){//由于返回的是纯数字,需增加显示时间.
				timestamp = json.getLongValue("clock");//单位为s
				if(! StringUtils.hasText(pattern)){
					pattern = "MM-dd HH:mm" ;
				}
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				json.put("time_show", sdf.format(new Date(timestamp * 1000)));//这里需要ms
			} 
			result.add(json);
		}
		return result;
	}
	
	/**
	 * 
	 * <p>Description: </p>
	 * <p>Title: toJsonList</p>
	 * @param list:beanList
	 * @return
	 */
	public static <T> List<JSONObject> toJsonList(List<T> list){
		return toJsonList(list,null);
	}
	
	/**
	 * 
	 * <p>Description: </p>
	 * <p>Title: getVersion</p>
	 * @return
	 */
	public static JSONObject getVersion(){
		String resultStr = "";
		try {
			resultStr = ZabbixLogin.getZabbixApi().apiInfo().get(new ApiInfoGetRequest()).getResult();
		} catch (ZabbixApiException e) {
			e.printStackTrace();
		}
		JSONObject result = new JSONObject();
		result.put("result", resultStr);
		return result;
	}
}
