package com.fh.entity.backend;

import java.util.List;

/** 
 * 说明：项目和所属单位关联 实体类
 * 创建人：FH Q313596790
 * 创建时间：2023-11-15
 */
public class M_project_id{ 
	private String M_PROJECT_ORG;			//项目和所属单位关联
	private String PROJECT_ID;			//项目id，实际上也是org_id
	private String ORG_ID;			//orgid
	public String getM_PROJECT_ORG() {
		return M_PROJECT_ORG;
	}
	public void setM_PROJECT_ORG(String M_PROJECT_ORG) {
		this.M_PROJECT_ORG = M_PROJECT_ORG;
	}
	public String getPROJECT_ID() {
		return PROJECT_ID;
	}
	public void setPROJECT_ID(String PROJECT_ID) {
		this.PROJECT_ID = PROJECT_ID;
	}
	public String getORG_ID() {
		return ORG_ID;
	}
	public void setORG_ID(String ORG_ID) {
		this.ORG_ID = ORG_ID;
	}

}
