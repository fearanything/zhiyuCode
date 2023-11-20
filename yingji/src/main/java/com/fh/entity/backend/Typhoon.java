package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：台风信息 实体类
 * 创建人：FH Q313596790
 * 创建时间：2022-09-19
 */
public class Typhoon{ 
	private String TYPHOON_ID;			//台风ID
	private String TYPHOON_YEAR;			//台风年份
	private String TYPHOON_NO;			//台风号
	private String TYPHOON_NAME;			//台风名称
	private String TYPHOON_REMARK;			//台风描述
	private int SORT;				//排序
	private int ISDEL;				//删除标志
	private String CREATER;			//创建人
	private String CREATE_DATE;			//创建时间
	private String MODIFYER;			//修改人
	private String MODIFY_DATE;			//修改时间
	private String IS_NOW;			//是否当前
	private String TYPHOON_DUTY;			//值班内容
	private String TYPHOON_TEL;			//值班公共电话
	public String getTYPHOON_ID() {
		return TYPHOON_ID;
	}
	public void setTYPHOON_ID(String TYPHOON_ID) {
		this.TYPHOON_ID = TYPHOON_ID;
	}
	public String getTYPHOON_YEAR() {
		return TYPHOON_YEAR;
	}
	public void setTYPHOON_YEAR(String TYPHOON_YEAR) {
		this.TYPHOON_YEAR = TYPHOON_YEAR;
	}
	public String getTYPHOON_NO() {
		return TYPHOON_NO;
	}
	public void setTYPHOON_NO(String TYPHOON_NO) {
		this.TYPHOON_NO = TYPHOON_NO;
	}
	public String getTYPHOON_NAME() {
		return TYPHOON_NAME;
	}
	public void setTYPHOON_NAME(String TYPHOON_NAME) {
		this.TYPHOON_NAME = TYPHOON_NAME;
	}
	public String getTYPHOON_REMARK() {
		return TYPHOON_REMARK;
	}
	public void setTYPHOON_REMARK(String TYPHOON_REMARK) {
		this.TYPHOON_REMARK = TYPHOON_REMARK;
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
	public String getIS_NOW() {
		return IS_NOW;
	}
	public void setIS_NOW(String iS_NOW) {
		IS_NOW = iS_NOW;
	}
	public String getTYPHOON_DUTY() {
		return TYPHOON_DUTY;
	}
	public void setTYPHOON_DUTY(String tYPHOON_DUTY) {
		TYPHOON_DUTY = tYPHOON_DUTY;
	}
	public String getTYPHOON_TEL() {
		return TYPHOON_TEL;
	}
	public void setTYPHOON_TEL(String tYPHOON_TEL) {
		TYPHOON_TEL = tYPHOON_TEL;
	}

}
