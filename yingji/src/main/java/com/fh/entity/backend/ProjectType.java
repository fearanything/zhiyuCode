package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：工程项目 实体类
 * 创建人：FH Q313596790
 * 创建时间：2022-10-08
 */
public class ProjectType{ 
	private String PROJECTTYPE_ID;			//项目ID
	private String PROJECTTYPE_NAME;			//项目名称（分类）
	private int PROJECTTYPE_NUM;				//项目数量
	private String PROJECTTYPE_COLOR;			//颜色值
	private int SORT;				//排序
	private int ISDEL;				//删除标志
	private String CREATER;			//创建人
	private String CREATE_DATE;			//创建时间
	private String MODIFYER;			//修改人
	private String MODIFY_DATE;			//修改时间
	
	
	public String getPROJECTTYPE_ID() {
		return PROJECTTYPE_ID;
	}
	public void setPROJECTTYPE_ID(String pROJECTTYPE_ID) {
		PROJECTTYPE_ID = pROJECTTYPE_ID;
	}
	public String getPROJECTTYPE_NAME() {
		return PROJECTTYPE_NAME;
	}
	public void setPROJECTTYPE_NAME(String pROJECTTYPE_NAME) {
		PROJECTTYPE_NAME = pROJECTTYPE_NAME;
	}
	public int getPROJECTTYPE_NUM() {
		return PROJECTTYPE_NUM;
	}
	public void setPROJECTTYPE_NUM(int pROJECTTYPE_NUM) {
		PROJECTTYPE_NUM = pROJECTTYPE_NUM;
	}
	public String getPROJECTTYPE_COLOR() {
		return PROJECTTYPE_COLOR;
	}
	public void setPROJECTTYPE_COLOR(String pROJECTTYPE_COLOR) {
		PROJECTTYPE_COLOR = pROJECTTYPE_COLOR;
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
