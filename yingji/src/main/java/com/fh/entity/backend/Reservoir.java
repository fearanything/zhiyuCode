package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：水库基本信息 实体类
 * 创建人：FH Q313596790
 * 创建时间：2022-10-08
 */
public class Reservoir{ 
	private String RESERVOIR_ID;			//水库ID
	private String RESERVOIR_NAME;			//水库名称
	private String RESERVOIR_ADDRESS;			//水库位置
	private Double WATER_LEVEL;			//警戒水位(米)
	private String RESERVOIR_INFO;			//水库介绍
	private int SORT;				//排序
	private int ISDEL;				//删除标志
	private String CREATER;			//创建人
	private String CREATE_DATE;			//创建时间
	private String MODIFYER;			//修改人
	private String MODIFY_DATE;			//修改时间
	public String getRESERVOIR_ID() {
		return RESERVOIR_ID;
	}
	public void setRESERVOIR_ID(String RESERVOIR_ID) {
		this.RESERVOIR_ID = RESERVOIR_ID;
	}
	public String getRESERVOIR_NAME() {
		return RESERVOIR_NAME;
	}
	public void setRESERVOIR_NAME(String RESERVOIR_NAME) {
		this.RESERVOIR_NAME = RESERVOIR_NAME;
	}
	public String getRESERVOIR_ADDRESS() {
		return RESERVOIR_ADDRESS;
	}
	public void setRESERVOIR_ADDRESS(String RESERVOIR_ADDRESS) {
		this.RESERVOIR_ADDRESS = RESERVOIR_ADDRESS;
	}
	public Double getWATER_LEVEL() {
		return WATER_LEVEL;
	}
	public void setWATER_LEVEL(Double WATER_LEVEL) {
		this.WATER_LEVEL = WATER_LEVEL;
	}
	public String getRESERVOIR_INFO() {
		return RESERVOIR_INFO;
	}
	public void setRESERVOIR_INFO(String RESERVOIR_INFO) {
		this.RESERVOIR_INFO = RESERVOIR_INFO;
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
