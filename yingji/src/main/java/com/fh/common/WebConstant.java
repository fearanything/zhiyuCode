package com.fh.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 常量类
 * @author Bill
 *
 */
public class WebConstant {
	
	// 启用
	public static final String IS_USE = "1";
	// 禁用
	public static final String NOT_USE = "0";
	/**
	 * 获取启用map
	 * @return
	 */
	public static Map<String, String> getUseMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put(IS_USE, "启用");
		map.put(NOT_USE, "禁用");
		return map;
	}
	// 当前
	public static final String IS_NOW = "1";
	// 旧的
	public static final String IS_OLD = "0";
	/**
	 * 获取启用map
	 * @return
	 */
	public static Map<String, String> getStaticMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put(IS_NOW, "是");
		map.put(IS_OLD, "否");
		return map;
	}
	public static String getStaticValue(String status) {
		Map<String, String> map = getStaticMap();
		return map.get(status);
	}
	public static String getStaticCode(String statusValue) {
		Map<String, String> map = getStaticMap();
		String keyValue="";
		for (String key : map.keySet()) { 
			if(statusValue.equals(map.get(key))) {
				keyValue=key;
			}
		}  
		return keyValue;
	}
	// 默认
	public static final String IS_YES = "1";
	// 不默认
	public static final String IS_NO = "0";
		/**
		 * 获取启用map
		 * @return
		 */
		public static Map<String, String> getDefaultMap() {
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put(IS_YES, "是");
			map.put(IS_NO, "否");
			return map;
		}
		public static Map<String, String> getNoYesMap() {
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put(IS_NO, "否");
			map.put(IS_YES, "是");
			return map;
		}
		public static String getDefaultValue(String status) {
			Map<String, String> map = getStaticMap();
			return map.get(status);
		}
		public static String getDefaultCode(String statusValue) {
			Map<String, String> map = getStaticMap();
			String keyValue="";
			for (String key : map.keySet()) { 
				if(statusValue.equals(map.get(key))) {
					keyValue=key;
				}
			}  
			return keyValue;
		}
	// 应急响应级别 - 1级
	public static final String ANSWER_LEVEL_1 = "Ⅰ";
	// 应急响应级别 - 2级
	public static final String ANSWER_LEVEL_2 = "Ⅱ";
	// 应急响应级别 - 3级
	public static final String ANSWER_LEVEL_3 = "Ⅲ";
	// 应急响应级别 - 4级
	public static final String ANSWER_LEVEL_4 = "Ⅳ";

	
	public static Map<String, String> getAnswerLevelMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put(ANSWER_LEVEL_1, "Ⅰ级");
		map.put(ANSWER_LEVEL_2, "Ⅱ级");
		map.put(ANSWER_LEVEL_3, "Ⅲ级");
		map.put(ANSWER_LEVEL_4, "Ⅳ级");
		return map;
	}
	public static String getAnswerLeveValue(String status) {
		Map<String, String> map = getAnswerLevelMap();
		return map.get(status);
	}
	public static String getAnswerLevelCode(String statusValue) {
		Map<String, String> map = getAnswerLevelMap();
		String keyValue="";
		for (String key : map.keySet()) { 
			if(statusValue.equals(map.get(key))) {
				keyValue=key;
			}
		}  
		return keyValue;
	}
	
    // 颜色值 - 红色
	public static final String COLOR_RED = "#FF551D";
	// 颜色值 - 黄色
	public static final String COLOR_YELLOW = "#FFBE03";
	// 颜色值 - 蓝色
	public static final String COLOR_BLUE = "#2CADFF";
	// 颜色值 - 绿色
	public static final String COLOR_GREEN = "#86D72E";
	// 颜色值 - 灰色
	public static final String COLOR_GREY = "#CCCCCC";
	// 颜色值 - 粉红
	public static final String COLOR_PINK = "#FFC0CB";
	
	public static Map<String, String> getColorMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put(COLOR_RED, "红色");
		map.put(COLOR_YELLOW, "黄色");
		map.put(COLOR_BLUE, "蓝色");
		map.put(COLOR_GREEN, "绿色");
		map.put(COLOR_GREY, "灰色");
		map.put(COLOR_PINK, "粉红");
		return map;
	}
	public static String getColorValue(String status) {
		Map<String, String> map = getColorMap();
		return map.get(status);
	}
	public static String getColorCode(String statusValue) {
		Map<String, String> map = getColorMap();
		String keyValue="";
		for (String key : map.keySet()) { 
			if(statusValue.equals(map.get(key))) {
				keyValue=key;
			}
		}  
		return keyValue;
	}
	// 能源系统
	public static final String SYS_1001 = "1001";
	// 置业系统
	public static final String SYS_1002 = "1002";
	// 水电系统
	public static final String SYS_1003 = "1003";
	/**
	 * 获取启用map
	 * @return
	 */
	public static Map<String, String> getSysMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put(SYS_1001, "能源系统");
		map.put(SYS_1002, "置业系统");
		map.put(SYS_1003, "水电系统");
		return map;
	}
	public static String getSysValue(String status) {
		Map<String, String> map = getSysMap();
		return map.get(status);
	}
	public static String getSysCode(String statusValue) {
		Map<String, String> map = getSysMap();
		String keyValue="";
		for (String key : map.keySet()) { 
			if(statusValue.equals(map.get(key))) {
				keyValue=key;
			}
		}  
		return keyValue;
	}

	// 隐患类别
	public static final String HIDDEN_DANGER_CLASSIFY = "hidden_danger_classify";
	// 隐患级别
	public static final String HIDDEN_DANGER_LEVEL = "hidden_danger_level";
	// 隐患因素
	public static final String HIDDEN_DANGER_FACTOR = "hidden_danger_factor";
	// 事故类型
	public static final String ACCIDENT_TYPE = "accident_type";
	// 风险等级
	public static final String RISK_LEVEL = "risk_level";

	public static void main(String[] args) {
//		int total = 10;
//		int now = 1;
//		int n = 3;
//		int fp = 1,bp = total;
//		if (total > n * 2 + 1) {
//			fp = now - n;
//			bp = now + n;
//			if (fp < 1) {
//				bp += 1 - fp;
//				fp = 1;
//			}
//			if (bp > total) {
//				fp -= bp - total;
//				bp = total;
//			}
//		}
//		System.out.println("前：" + fp + "  后：" + bp + "  后减前：" + (bp - fp));
		  
	}
}
