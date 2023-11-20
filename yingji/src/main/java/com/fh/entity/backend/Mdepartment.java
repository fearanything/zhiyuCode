package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：部门 实体类
 * 创建人：FH Q313596790
 * 创建时间：2022-03-25
 */
public class Mdepartment{ 
	private String DEPARTMENT_ID;			//ID
	private int SORT;				//顺序
	private int ISDEL;				//删除标志
	private String CREATER;			//创建人
	private String CREATE_DATE;			//创建时间
	private String MODIFYER;			//修改人
	private String MODIFY_DATE;			//修改时间
	private String DEPARTMENT_NAME;			//部门名称
	public String getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(String DEPARTMENT_ID) {
		this.DEPARTMENT_ID = DEPARTMENT_ID;
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
	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}
	public void setDEPARTMENT_NAME(String DEPARTMENT_NAME) {
		this.DEPARTMENT_NAME = DEPARTMENT_NAME;
	}

}
