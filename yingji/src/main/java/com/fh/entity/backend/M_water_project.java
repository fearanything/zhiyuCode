package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：水库和项目关联 实体类
 * 创建人：FH Q313596790
 * 创建时间：2023-10-27
 */
public class M_water_project{ 
	private String M_WATER_PROJECT_ID;			//关联水库和项目的id
	private String WATER_ID;			//水库id
	private String PROJECT_ID;			//项目id
	public String getM_WATER_PROJECT_ID() {
		return M_WATER_PROJECT_ID;
	}
	public void setM_WATER_PROJECT_ID(String M_WATER_PROJECT_ID) {
		this.M_WATER_PROJECT_ID = M_WATER_PROJECT_ID;
	}
	public String getWATER_ID() {
		return WATER_ID;
	}
	public void setWATER_ID(String WATER_ID) {
		this.WATER_ID = WATER_ID;
	}
	public String getPROJECT_ID() {
		return PROJECT_ID;
	}
	public void setPROJECT_ID(String PROJECT_ID) {
		this.PROJECT_ID = PROJECT_ID;
	}

}
