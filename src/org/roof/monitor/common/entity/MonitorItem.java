package org.roof.monitor.common.entity;

import java.io.Serializable;

/** 
 * <p>Description: 监控项</p>
 * <p>Title: MonitorType.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月16日 下午3:05:12</p> 
 * @author wangjb 
 * @version 1.0 
 * 
 */
public class MonitorItem implements Serializable{
	
	/** 
	* serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 3235201282080004032L;
	private Long id;
	private Long typeId;
	private String itemName;//监控项中文名称
	private String itemKey;//监控项key
	private int resultType;//监控项返回值类型(//0:浮点 1:字符串 2:日志 3:整数(默认) 4:文本)
	private int isShow;//是否显示(1:显示 0:不显示) 预留字段
	private int isHot;//是否热门(1:是 0:否) 预留字段 标记热门监控项:一个类型最多配置一个热门的
	
	public enum ResultType {
		FLOAT(0,"浮点"), STRING(1,"字符串"), LOG(2,"日志"),
		INT(3,"整数"), TEXT(4,"文本");
		
		private int id;
		private String value;
		
		ResultType(int id, String value){
			this.id = id;
			this.value = value;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	public int getResultType() {
		return resultType;
	}
	public void setResultType(int resultType) {
		this.resultType = resultType;
	}
	public int getIsHot() {
		return isHot;
	}
	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemKey() {
		return itemKey;
	}
	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}
}
