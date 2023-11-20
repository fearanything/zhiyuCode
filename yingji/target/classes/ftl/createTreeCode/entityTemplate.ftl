package com.fh.entity.${packageName};

import java.util.List;

/** 
 * 说明：${TITLE} 实体类
 * 创建人：FH Q313596790
 * 创建时间：${nowDate?string("yyyy-MM-dd")}
 */
public class ${objectName}{ 
	
	<#list fieldList as var>
		<#if var[1] == 'Integer'>
	private int ${var[0]};				//${var[2]}
		<#elseif var[1] == 'Double'>
	private Double ${var[0]};			//${var[2]}
		<#else>
	private String ${var[0]};			//${var[2]}
		</#if>
	</#list>
	private String target;
	private boolean has${objectName}= false;
	private String treeurl;
	private String icon;
	private List<${objectName}> sub${objectName}; //子集合
	
   <#list fieldList as var>
		<#if var[1] == 'Integer'>
	public int get${var[0]}() {
		return ${var[0]};
	}
	public void set${var[0]}(int ${var[0]}) {
		this.${var[0]} = ${var[0]};
	}
		<#elseif var[1] == 'Double'>
	public Double get${var[0]}() {
		return ${var[0]};
	}
	public void set${var[0]}(Double ${var[0]}) {
		this.${var[0]} = ${var[0]};
	}
		<#else>
	public String get${var[0]}() {
		return ${var[0]};
	}
	public void set${var[0]}(String ${var[0]}) {
		this.${var[0]} = ${var[0]};
	}
		</#if>
	</#list>
	
	public List<${objectName}> getSub${objectName}() {
		return sub${objectName};
	}
	public void setSub${objectName}(List<${objectName}> sub${objectName}) {
		this.sub${objectName} = sub${objectName};
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public boolean isHas${objectName}() {
		return has${objectName};
	}
	public void setHas${objectName}(boolean has${objectName}) {
		this.has${objectName} = has${objectName};
	}
	public String getTreeurl() {
		return treeurl;
	}
	public void setTreeurl(String treeurl) {
		this.treeurl = treeurl;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
