package com.fh.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarUserConstants {
	
	//上传图片文件夹
	public static final String IMG_FILE = "uploadFiles/carUserImgs/";
	
	// 身份证正反面标记start...
	/**正面*/
	public static final Integer FRONT = 1;
	/**反面*/
	public static final Integer BACK = 2;
	// 身份证正反面标记end
	
	// 删除标记start...
	/**未删除*/
	public static final Integer NOT_DEL = 0;
	/**已删除*/
	public static final Integer IS_DEL = 1;
	// 删除标记end...
	
	// 用户状态start...
	/**未禁止*/
	public static final Integer NOT_FORBID = 0;
	/**已禁止*/
	public static final Integer IS_FORBID = 1;
	// 用户状态end...
	
	// 审核状态start...
	/**未审核*/
	public static final Integer NOT_AUDIT = 0;
	/**未通过*/
	public static final Integer AUDIT_PASS = 1;
	/**已通过*/
	public static final Integer AUDIT_REJECT = 2;
	// 审核状态end...
	
	//service状态start...
	/**修改成功*/
	public static final Integer UPDATE_SUCCESS = 1;
	//service状态end...
	
	// 获取用户状态
	public static Map<Integer, String> getUserStatus() {
		Map<Integer, String> result = new HashMap<Integer, String>();
		result.put(IS_FORBID, "已禁止");
		result.put(NOT_FORBID, "未禁止");
		return result;
	}
	
	// 获取审核状态
	public static Map<String, String> getAuditStatus() {
		Map<String, String> result = new LinkedHashMap<String, String>();
		result.put(AUDIT_PASS + "", "未通过");
		result.put(AUDIT_REJECT + "", "已通过");
		result.put(NOT_AUDIT + "", "未审核");
		return result;
	}
}
