package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：监控点管理 实体类
 * 创建人：FH Q313596790
 * 创建时间：2022-10-28
 */
public class Monitor{ 
	private String MONITOR_ID;			//监控点ID
	private String MONITORTYPE_ID;			//监控点分类ID
	private String MONITOR_NAME;			//监控点名称
	private String MONITOR_CODE;            //设备编号
	private String MONITOR_URL;			//监控点URL
	private String MONITOR_IP;			//监控点IP
	private String IS_DEFAULT;			//监控点默认
	private int SORT;				//排序
	private int ISDEL;				//删除标志
	private String CREATER;			//创建人
	private String CREATE_DATE;			//创建时间
	private String MODIFYER;			//修改人
	private String MODIFY_DATE;			//修改时间
	public String getMONITOR_ID() {
		return MONITOR_ID;
	}
	public void setMONITOR_ID(String MONITOR_ID) {
		this.MONITOR_ID = MONITOR_ID;
	}
	public String getMONITORTYPE_ID() {
		return MONITORTYPE_ID;
	}
	public void setMONITORTYPE_ID(String MONITORTYPE_ID) {
		this.MONITORTYPE_ID = MONITORTYPE_ID;
	}
	public String getMONITOR_NAME() {
		return MONITOR_NAME;
	}
	public void setMONITOR_NAME(String MONITOR_NAME) {
		this.MONITOR_NAME = MONITOR_NAME;
	}
	public String getMONITOR_URL() {
		return MONITOR_URL;
	}
	public void setMONITOR_URL(String MONITOR_URL) {
		this.MONITOR_URL = MONITOR_URL;
	}
	public String getMONITOR_IP() {
		return MONITOR_IP;
	}
	public void setMONITOR_IP(String MONITOR_IP) {
		this.MONITOR_IP = MONITOR_IP;
	}
	
	public String getIS_DEFAULT() {
		return IS_DEFAULT;
	}
	public void setIS_DEFAULT(String iS_DEFAULT) {
		IS_DEFAULT = iS_DEFAULT;
	}
	public int getSORT() {
		return SORT;
	}
	public void setSORT(int SORT) {
		this.SORT = SORT;
	}
	public int getISDEL() {
		return ISDEL;
	}
	public void setISDEL(int ISDEL) {
		this.ISDEL = ISDEL;
	}
	public String getCREATER() {
		return CREATER;
	}
	public void setCREATER(String CREATER) {
		this.CREATER = CREATER;
	}
	public String getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(String CREATE_DATE) {
		this.CREATE_DATE = CREATE_DATE;
	}
	public String getMODIFYER() {
		return MODIFYER;
	}
	public void setMODIFYER(String MODIFYER) {
		this.MODIFYER = MODIFYER;
	}
	public String getMODIFY_DATE() {
		return MODIFY_DATE;
	}
	public void setMODIFY_DATE(String MODIFY_DATE) {
		this.MODIFY_DATE = MODIFY_DATE;
	}
	public String getMONITOR_CODE() {
		return MONITOR_CODE;
	}
	public void setMONITOR_CODE(String mONITOR_CODE) {
		MONITOR_CODE = mONITOR_CODE;
	}

}
