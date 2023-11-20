package com.fh.entity.backend;

import java.util.List;

//监控点实体类
public class Projects {
	private String PROJECTTYPE_NAME;			//项目分类名称
	private String PROJECTTYPE_NUM;			//项目数量
	private List<Project> PROJECT_LIST;			//项目
	public String getPROJECTTYPE_NAME() {
		return PROJECTTYPE_NAME;
	}
	public void setPROJECTTYPE_NAME(String pROJECTTYPE_NAME) {
		PROJECTTYPE_NAME = pROJECTTYPE_NAME;
	}
	
	public String getPROJECTTYPE_NUM() {
		return PROJECTTYPE_NUM;
	}
	public void setPROJECTTYPE_NUM(String pROJECTTYPE_NUM) {
		PROJECTTYPE_NUM = pROJECTTYPE_NUM;
	}
	public List<Project> getPROJECT_LIST() {
		return PROJECT_LIST;
	}
	public void setPROJECT_LIST(List<Project> pROJECT_LIST) {
		PROJECT_LIST = pROJECT_LIST;
	}
	
}
