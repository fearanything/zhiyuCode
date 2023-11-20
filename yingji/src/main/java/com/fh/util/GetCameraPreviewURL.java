package com.fh.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class GetCameraPreviewURL {

	public static String GetCameraURL() {

		/**
		 * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
		 */
	
		ArtemisConfig.host = "153.0.150.42:4430"; // 平台的ip端口
		ArtemisConfig.appKey = "28247187"; // 密钥appkey
		ArtemisConfig.appSecret = "HQF64zbP6IEBTOVd1MP2";// 密钥appSecret

		/**
		 * STEP2：设置OpenAPI接口的上下文
		 */
		final String ARTEMIS_PATH = "/artemis";
		final String cameraIndexCode = "54c14b3c7f7542d68d4752acb8e966b1";

		/**
		 * STEP3：设置接口的URI地址/api/video/v2/cameras/previewURLs
		 */
		final String previewURLsApi = ARTEMIS_PATH + "/api/video/v2/cameras/previewURLs";
		Map<String, String> path = new HashMap<String, String>(2) {
			{
				put("https//", previewURLsApi);// 根据现场环境部署确认是http还是https
			}
		};

		/**
		 * STEP4：设置参数提交方式
		 */
		String contentType = "application/json";

		/**
		 * STEP5：组装请求参数
		 */
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("cameraIndexCode", cameraIndexCode);
		jsonBody.put("streamType", 0);
		jsonBody.put("protocol", "rtsp");
		//jsonBody.put("transmode", 1);
		//jsonBody.put("expand", "transcode=0");
		//jsonBody.put("streamform", "ps");
		String body = jsonBody.toJSONString();
		/**
		 * STEP6：调用接口
		 */
		//String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType, null);// post请求application/json类型参数
		//return result;
		
		//定义发送数据
		JSONObject param = new JSONObject();
		param.put("cameraIndexCode", "54c14b3c7f7542d68d4752acb8e966b1");
		//param.put("streamType", 0);
		//param.put("protocol", "rtsp");
		//定义接收数据
		JSONObject result = new JSONObject();
		 
		String url = "https://153.0.150.42:4430/artemis/api/video/v2/cameras/previewURLs";
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient client = HttpClients.createDefault();
		//请求参数转JOSN字符串
		StringEntity entity = new StringEntity(param.toString(), "UTF-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		try {
			//添加请求头参数
			httpPost.addHeader("Content-Type", "application/json");
			httpPost.addHeader("access_token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJzY29wZSJdLCJleHAiOjE2Njk4MTQwMjgsImp0aSI6InJlN2dTcGNlVVA5OS1JOVhRUGpZR1ctSFVIcyIsImNsaWVudF9pZCI6IjI4MjQ3MTg3In0.nYe5WH8hvyQSjgRHzjCqLHujdMa5fOr7_K7fISZozf0");
			HttpResponse response = client.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				result = JSON.parseObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
			result.put("error", "连接错误！");
		}
		String relStr=result.toJSONString();
		return relStr;
	}
	
//	public static String GetCameraList() {
//
//		/**
//		 * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
//		 */
//		ArtemisConfig.host = "153.0.150.42:4430"; // 平台的ip端口
//		ArtemisConfig.appKey = "28247187"; // 密钥appkey
//		ArtemisConfig.appSecret = "HQF64zbP6IEBTOVd1MP2";// 密钥appSecret
//
//		/**
//		 * STEP2：设置OpenAPI接口的上下文
//		 */
//		final String ARTEMIS_PATH = "/artemis";
//		final String cameraIndexCode = "13322053920";
//
//		/**
//		 * STEP3：设置接口的URI地址
//		 */
//		final String previewURLsApi = ARTEMIS_PATH + "/api/resource/v2/encodeDevice/search";
//		Map<String, String> path = new HashMap<String, String>(2) {
//			{
//				put("https//", previewURLsApi);// 根据现场环境部署确认是http还是https
//			}
//		};
//
//		/**
//		 * STEP4：设置参数提交方式
//		 */
//		String contentType = "application/json";
//
//		/**
//		 * STEP5：组装请求参数
//		 */
//		JSONObject jsonBody = new JSONObject();
//		jsonBody.put("pageNo", 1);
//		jsonBody.put("pageSize", 5);
//		jsonBody.put("streamType", 0);
//		jsonBody.put("protocol", "rtsp");
//		jsonBody.put("transmode", 1);
//		jsonBody.put("expand", "streamform=ps");
//		String body = jsonBody.toJSONString();
//		/**
//		 * STEP6：调用接口
//		 */
//		String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType, null);// post请求application/json类型参数
//		return result;
//	}

	public static void main(String[] args) {
		String result = GetCameraURL();
		System.out.println("result结果示例: " + result);
	}
}
