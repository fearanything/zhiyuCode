package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：水库水情 实体类
 * 创建人：FH Q313596790
 * 创建时间：2022-10-08
 */
public class Water{ 
	private String WATER_ID;			//水情ID
	private String TYPHOON_ID;			//台风ID
	private String RESERVOIR_ID;			//水库ID
	private String WATER_DATETIME;			//水情日期
	private Double WATER_DATA;			//水位(米)
	private int SORT;				//排序
	private int ISDEL;				//删除标志
	private String CREATER;			//创建人
	private String CREATE_DATE;			//创建时间
	private String MODIFYER;			//修改人
	private String MODIFY_DATE;			//修改时间
	public String getWATER_ID() {
		return WATER_ID;
	}
	public void setWATER_ID(String WATER_ID) {
		this.WATER_ID = WATER_ID;
	}
	public String getTYPHOON_ID() {
		return TYPHOON_ID;
	}
	public void setTYPHOON_ID(String TYPHOON_ID) {
		this.TYPHOON_ID = TYPHOON_ID;
	}
	public String getRESERVOIR_ID() {
		return RESERVOIR_ID;
	}
	public void setRESERVOIR_ID(String RESERVOIR_ID) {
		this.RESERVOIR_ID = RESERVOIR_ID;
	}
	public String getWATER_DATETIME() {
		return WATER_DATETIME;
	}
	public void setWATER_DATETIME(String WATER_DATETIME) {
		this.WATER_DATETIME = WATER_DATETIME;
	}
	public Double getWATER_DATA() {
		return WATER_DATA;
	}
	public void setWATER_DATA(Double WATER_DATA) {
		this.WATER_DATA = WATER_DATA;
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
