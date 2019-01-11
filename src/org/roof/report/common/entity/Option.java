package org.roof.report.common.entity;

import java.io.Serializable;

/**
 * 
 * <p>Description: 下拉框</p>
 * <p>Title: Option.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月12日 下午3:53:58</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public class Option implements Serializable{

	/** 
	* serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -5442603789181579961L;
	
	private String name;//显示名称
	private String value;//值
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
