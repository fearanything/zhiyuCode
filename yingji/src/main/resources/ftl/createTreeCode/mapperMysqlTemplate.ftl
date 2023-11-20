<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${objectName}Mapper">
	
	<resultMap type="${objectName}" id="${objectNameLower}ResultMap">
	   <#list fieldList as var>	
		<result column="${var[0]}" property="${var[0]}"/>
	   </#list>
	</resultMap>
	
	<!--表名 -->
	<sql id="tableName">
		${tabletop}${objectNameUpper}
	</sql>
	
	<!-- 字段 -->
	<sql id="Field">
	<#list fieldList as var>
       <#if !var_has_next>
         ${var[0]}
       <#else>
         ${var[0]},
       </#if>
	</#list>
	</sql>
	
	<!-- 字段值 -->
	<sql id="FieldValue">
	<#list fieldList as var>
	   <#if !var_has_next>
         ${r"#{"}${var[0]}${r"}"}
       <#else>
         ${r"#{"}${var[0]}${r"}"},
       </#if>	
	</#list>
	</sql>
	
	<!-- 新增-->
	<insert id="save" parameterType="pd">
		insert into 
	<include refid="tableName"></include>
		(
	<include refid="Field"></include>
		) values (
	<include refid="FieldValue"></include>
		)
	</insert>
	
	<!-- 删除-->
	<delete id="delete" parameterType="pd">
		update
		<include refid="tableName"></include>
		set 
		 ISDEL = 1,
		 MODIFYER = ${r"#{"}MODIFYER${r"}"},
		 MODIFY_DATE = ${r"#{"}MODIFY_DATE${r"}"}
		where 
			${objectNameUpper}_ID = ${r"#{"}${objectNameUpper}_ID${r"}"}
	</delete>
	
	<!-- 修改 -->
	<update id="edit" parameterType="pd">
		update
		<include refid="tableName"></include>
		set 
	<#list fieldList as var>
	  <#if var[3] == "是">
         ${var[0]} = ${r"#{"}${var[0]}${r"}"},
      </#if>
	</#list>
	     MODIFYER = ${r"#{"}MODIFYER${r"}"},
		 MODIFY_DATE = ${r"#{"}MODIFY_DATE${r"}"}
	        where 
				${objectNameUpper}_ID = ${r"#{"}${objectNameUpper}_ID${r"}"}
	</update>
	
	<!-- 通过ID获取数据 -->
	<select id="findById" parameterType="pd" resultType="pd">
		select 
		<include refid="Field"></include>
		from 
		<include refid="tableName"></include>
		where ISDEL =0 and
			${objectNameUpper}_ID = ${r"#{"}${objectNameUpper}_ID${r"}"}
	</select>
	
	<!-- 列表 -->
	<select id="datalistPage" parameterType="page" resultType="pd">
		select
		<include refid="Field"></include>
		from 
		<include refid="tableName"></include>
		where ISDEL =0 and 1=1
		<if test="pd.${objectNameUpper}_ID!= null and pd.${objectNameUpper}_ID != ''"><!-- 检索 -->
		and PARENT_ID = ${r"#{"}pd.${objectNameUpper}_ID${r"}"}
		</if>
		<if test="pd.keywords!= null and pd.keywords != ''"><!-- 关键词检索 -->
			and
				(
				<!--	根据需求自己加检索条件-->
					字段1 LIKE CONCAT(CONCAT('%', ${r"#{pd.keywords})"},'%')
					 or 
					字段2 LIKE CONCAT(CONCAT('%', ${r"#{pd.keywords})"},'%') 
				
				)
		</if>
	</select>
	
	<!-- 通过ID获取其子级列表 -->
	<select id="listByParentId" parameterType="String" resultMap="${objectNameLower}ResultMap">
		select 
		<include refid="Field"></include>
		from 
		<include refid="tableName"></include>
		where ISDEL =0 and
			PARENT_ID = ${r"#{parentId}"} order by NAME 
	</select>
	
	<!-- 列表(全部) -->
	<select id="listAll" parameterType="pd" resultType="pd">
		select
		<include refid="Field"></include>
		from 
		<include refid="tableName"></include>
		where ISDEL =0
	</select>
	
</mapper>