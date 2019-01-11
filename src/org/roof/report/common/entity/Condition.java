package org.roof.report.common.entity;

import java.io.Serializable;

/**
 * 
 * <p>Description: 筛选条件</p>
 * <p>Title: Condition.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月18日 上午9:32:31</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public class Condition implements Serializable{

	/** 
	* serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -3145548314006414650L;
	
//	统计区间
//	统计时间
//	时间类型
	private String startTime; //	开始时间
	private String endTime; //	结束时间
//	地市公司
//	区县公司
//	支局/部门
//	受理部门
//	客户统计属性
//	客户等级
//	营销服务属性
//	停机类型
//	业务类型	
//	最小统计单位
//	营业部门
//	营业员工号
//	营销工号
//	导购工号
//	补录工号
//	查询类别
//	虚拟网群号
//	号码类型
//	客户经理登录名
//	客户姓名
//	转出客户姓名 
//	转入客户姓名 
//	客户行业
//	客户城乡属性
//	客户电话
//	贵宾卡号
//	统计对象
//	行项目状态
//	产品类型
//	产品名称
//	操作类型
//	预登记状态
//	指标类型
//	优惠类型
//	优惠名称
//	质检组
//	订单编号
//	账期 
//	卡状态
//	派送方式 
//	兑换类型
//	套餐类型 
//	代理商
//	电话号码
//	协议类型  29
//	优惠操作类型  31
	/*报表代号32 特有 下同*/
//	空间租用类型 32
//	租用空间个数 32
//	入网用途 32
//	端口接入方式 32
//	端口宽带速率 32
//	代理商负责人ID 39
//	所有者工号 55
//	质检日期 56
//	过户状态 59
//	实物名称 62
//	百事通卡号 65
//	代理营业厅 70
//	管理部门  70
//	激活时间  71
//	代理商编码  73
//	打印代理商部门 74
//	兑换代理商部门 74
//	补贴券业务发生点  75
//	补贴券处理点类型 75
//	是否包含自动订单（10000号专用） 83
	//more props to add
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
