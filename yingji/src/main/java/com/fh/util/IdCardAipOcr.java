package com.fh.util;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

/**
 * 身份证信息识别
 */
public class IdCardAipOcr {
	// 设置APPID/AK/SK
	public static final String APP_ID = "10806829";
	public static final String API_KEY = "qCMZCTHToQEnZOAmNh26Z2hL";
	public static final String SECRET_KEY = "n3nA3o3TgLVjBrDRQvrcxrEY15PaHOba";

	/**
	 * @param logoface 身份证正反面标识
	 * @param filePath 本地图片路径
	 * 身份证正反面识别
	 */
	public static String recognizeIdCrad(Integer logoFace, String filePath) {
		// 初始化一个AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// 可选：设置网络连接参数
		// client.setConnectionTimeoutInMillis(2000);
		// client.setSocketTimeoutInMillis(60000);

		// 可选：设置代理服务器地址, http和socket二选一，或者均不设置
		// client.setHttpProxy("proxy_host", proxy_port); // 设置http代理
		// client.setSocketProxy("proxy_host", proxy_port); // 设置socket代理

		// 可选：设置log4j日志输出格式，若不设置，则使用默认配置
		// 也可以直接通过jvm启动参数设置此环境变量
		// System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("detect_direction", "false");
		options.put("detect_risk", "false");
		
		String idCardSide = "";
		if (CarUserConstants.FRONT == logoFace) {
			idCardSide = "front";
		}
//		String idCardSide = "front";//正面
//		String idCardSide = "back";//反面

		// 参数为本地图片路径
		String image = filePath;
		JSONObject res = client.idcard(image, idCardSide, options);
		System.out.println(res.toString());
		return res.toString();

		// 参数为本地图片二进制数组
//		byte[] file = readImageFile(image);
//		res = client.idcard(file, idCardSide, options);
//		System.out.println(res.toString(2));

	}
	
}
