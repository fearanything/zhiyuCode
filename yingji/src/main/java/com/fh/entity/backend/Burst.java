package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：突发情况记录表 实体类
 * 创建人：FH Q313596790
 * 创建时间：2022-10-08
 */
public class Burst{ 
	private String BURST_ID;			//突发情况ID
	private String TYPHOON_ID;			//台风ID
	private String BURST_DATETIME;			//突发时间
	private String BURST_COMPANY;			//突发单位
	private String BURST_INFO;			//突发情况
	private int SORT;				//排序
	private int ISDEL;				//删除标志
	private String CREATER;			//创建人
	private String CREATE_DATE;			//创建时间
	private String MODIFYER;			//修改人
	private String MODIFY_DATE;			//修改时间
	public String getBURST_ID() {
		return BURST_ID;
	}
	public void setBURST_ID(String BURST_ID) {
		this.BURST_ID = BURST_ID;
	}
	public String getTYPHOON_ID() {
		return TYPHOON_ID;
	}
	public void setTYPHOON_ID(String TYPHOON_ID) {
		this.TYPHOON_ID = TYPHOON_ID;
	}
	public String getBURST_DATETIME() {
		return BURST_DATETIME;
	}
	public void setBURST_DATETIME(String BURST_DATETIME) {
		this.BURST_DATETIME = BURST_DATETIME;
	}
	public String getBURST_COMPANY() {
		return BURST_COMPANY;
	}
	public void setBURST_COMPANY(String BURST_COMPANY) {
		this.BURST_COMPANY = BURST_COMPANY;
	}
	public String getBURST_INFO() {
		return BURST_INFO;
	}
	public void setBURST_INFO(String BURST_INFO) {
		this.BURST_INFO = BURST_INFO;
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

}
