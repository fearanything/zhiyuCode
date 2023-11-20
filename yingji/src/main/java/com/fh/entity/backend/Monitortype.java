package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：监控点分类 实体类
 * 创建人：FH Q313596790
 * 创建时间：2022-10-28
 */
public class Monitortype{ 
	private String MONITORTYPE_ID;			//监控点分类ID
	private String MONITORTYPE_NAME;			//监控点分类名称
	private String MONITORTYPE_CODE;	    //监控点分类编码
	private String PARENT_ID;			//监控点分类父ID
	private int SORT;				//排序
	private int ISDEL;				//删除标志
	private String CREATER;			//创建人
	private String CREATE_DATE;			//创建时间
	private String MODIFYER;			//修改人
	private String MODIFY_DATE;			//修改时间
	public String getMONITORTYPE_ID() {
		return MONITORTYPE_ID;
	}
	public void setMONITORTYPE_ID(String MONITORTYPE_ID) {
		this.MONITORTYPE_ID = MONITORTYPE_ID;
	}
	public String getMONITORTYPE_NAME() {
		return MONITORTYPE_NAME;
	}
	public void setMONITORTYPE_NAME(String MONITORTYPE_NAME) {
		this.MONITORTYPE_NAME = MONITORTYPE_NAME;
	}
	public String getPARENT_ID() {
		return PARENT_ID;
	}
	public void setPARENT_ID(String PARENT_ID) {
		this.PARENT_ID = PARENT_ID;
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
	public String getMONITORTYPE_CODE() {
		return MONITORTYPE_CODE;
	}
	public void setMONITORTYPE_CODE(String mONITORTYPE_CODE) {
		MONITORTYPE_CODE = mONITORTYPE_CODE;
	}

}
