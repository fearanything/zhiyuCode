package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：气象信息 实体类
 * 创建人：FH Q313596790
 * 创建时间：2022-12-07
 */
public class Weather{ 
	private String WEATHER_ID;			//气象信息ID
	private String WEATHER_DATE;			//气象日期
	private String WEATHER_INFO;			//气象信息
	private String WEATHER_REMARK;			//气象备注
	private int SORT;				//排序
	private int ISDEL;				//删除标志
	private String CREATER;			//创建人
	private String CREATE_DATE;			//创建时间
	private String MODIFYER;			//修改人
	private String MODIFY_DATE;			//修改时间
	public String getWEATHER_ID() {
		return WEATHER_ID;
	}
	public void setWEATHER_ID(String WEATHER_ID) {
		this.WEATHER_ID = WEATHER_ID;
	}
	public String getWEATHER_DATE() {
		return WEATHER_DATE;
	}
	public void setWEATHER_DATE(String WEATHER_DATE) {
		this.WEATHER_DATE = WEATHER_DATE;
	}
	public String getWEATHER_INFO() {
		return WEATHER_INFO;
	}
	public void setWEATHER_INFO(String WEATHER_INFO) {
		this.WEATHER_INFO = WEATHER_INFO;
	}
	public String getWEATHER_REMARK() {
		return WEATHER_REMARK;
	}
	public void setWEATHER_REMARK(String WEATHER_REMARK) {
		this.WEATHER_REMARK = WEATHER_REMARK;
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
