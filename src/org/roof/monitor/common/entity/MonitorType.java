package org.roof.monitor.common.entity;

import java.io.Serializable;

/** 
 * <p>Description: 监控类型</p>
 * <p>Title: MonitorType.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月16日 下午3:05:12</p> 
 * @author wangjb 
 * @version 1.0 
 * 
 */
public class MonitorType implements Serializable{

	/** 
	* serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -682044422957797403L;
	
	private Long id;
	private String typeName;//中文名(显示名)
	private String typeValue;//英文名
	private int isShow;//是否显示(1:显示 0:不显示) 预留字段
	
	public enum Type{
		CPU(1L,"CPU","cpu"),MEMORY(2L,"内存","memory"),
		DISK(3L,"硬盘","disk"),IF(4L,"网卡","if"),
		PROCESS(5L,"进程","process"),SWAP(6L,"交换分区","swap");
		
		private Long id;
		private String name;
		private String value;
		
		Type(Long id, String name, String value){
			this.id = id;
			this.name = name;
			this.value = value;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeValue() {
		return typeValue;
	}
	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}	
}