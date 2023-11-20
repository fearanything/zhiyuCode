package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：通知公告 实体类
 * 创建人：FH Q313596790
 * 创建时间：2022-09-21
 */
public class Notice{ 
	private String NOTICE_ID;			//通知公告ID
	private String TYPHOON_ID;			//台风ID
	private String NOTICE_DATETIME;			//发布时间
	private String NOTICE_TITLE;			//通知公告标题
	private String NOTICE_CONTENT;			//通知公告内容
	private int SORT;				//排序
	private int ISDEL;				//删除标志
	private String CREATER;			//创建人
	private String CREATE_DATE;			//创建时间
	private String MODIFYER;			//修改人
	private String MODIFY_DATE;			//修改时间
	public String getNOTICE_ID() {
		return NOTICE_ID;
	}
	public void setNOTICE_ID(String NOTICE_ID) {
		this.NOTICE_ID = NOTICE_ID;
	}
	public String getTYPHOON_ID() {
		return TYPHOON_ID;
	}
	public void setTYPHOON_ID(String TYPHOON_ID) {
		this.TYPHOON_ID = TYPHOON_ID;
	}
	public String getNOTICE_DATETIME() {
		return NOTICE_DATETIME;
	}
	public void setNOTICE_DATETIME(String NOTICE_DATETIME) {
		this.NOTICE_DATETIME = NOTICE_DATETIME;
	}
	public String getNOTICE_TITLE() {
		return NOTICE_TITLE;
	}
	public void setNOTICE_TITLE(String NOTICE_TITLE) {
		this.NOTICE_TITLE = NOTICE_TITLE;
	}
	public String getNOTICE_CONTENT() {
		return NOTICE_CONTENT;
	}
	public void setNOTICE_CONTENT(String NOTICE_CONTENT) {
		this.NOTICE_CONTENT = NOTICE_CONTENT;
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
