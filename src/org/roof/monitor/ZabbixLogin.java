package org.roof.monitor;

import java.io.IOException;
import java.util.Properties;

import com.zabbix4j.ZabbixApi;
import com.zabbix4j.ZabbixApiException;

/**
 * 
 * <p>Description: </p>
 * <p>Title: ZabbixLogin.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年5月12日 下午2:15:13</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public class ZabbixLogin {
	private static String user;
	private static String password;
	private static String server_url;
	
	static {
		Properties pro = new Properties();
		try {
			pro.load(ZabbixLogin.class.getResourceAsStream("/zabbix.properties"));
			user = pro.getProperty("zabbixUser");
			password = pro.getProperty("zabbixPassword");
			server_url = pro.getProperty("zabbixServerUrl");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ZabbixApi getZabbixApi(){
//		ZabbixApi zabbixApi = new ZabbixApi(server_url);
//		try {
//			zabbixApi.login(user, password);
//		} catch (ZabbixApiException e) {
//			e.printStackTrace();
//		}
//		return zabbixApi;
		return null;
	}
	
	public static void main(String[] args) {
		try {
			String path = ZabbixLogin.class.getResource("/zabbix.properties").getPath();
			System.out.println(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
