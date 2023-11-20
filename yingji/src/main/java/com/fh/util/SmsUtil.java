package com.fh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONObject;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/** 
 * 说明：短信接口类
 * 创建人：FH Q313596790
 * 修改时间：2013年2月22日
 * @version
 */
public class SmsUtil {
	
	private static Logger logger = Logger.getLogger(SmsUtil.class);
	
	public static void main(String [] args) {
		
		sendSms2("13511111111","您的验证码是：1111。请不要把验证码泄露给其他人。");
		//sendSmsAll(List<PageData> list)
		
		//sendSms1();
	}

	 //短信商 一  http://www.dxton.com/ =====================================================================================
	/**
	 * 给一个人发送单条短信
	 * @param mobile 手机号
	 * @param code  短信内容
	 */
 	public static void sendSms1(String mobile,String code){
	    String account = "", password = "";
	    String strSMS1 = Tools.readTxtFile(Const.SMS1);			//读取短信1配置
		if(null != strSMS1 && !"".equals(strSMS1)){
			String strS1[] = strSMS1.split(",fh,");
			if(strS1.length == 2){
				account = strS1[0];
				password = strS1[1];
			}
		}
 		String PostData = "";
		try {
			PostData = "account="+account+"&password="+password+"&mobile="+mobile+"&content="+URLEncoder.encode(code,"utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("短信提交失败");
		}
		 //System.out.println(PostData);
 	     String ret = SMS(PostData, "http://sms.106jiekou.com/utf8/sms.aspx");
 	     System.out.println(ret);
 	   /*  
 	   100			发送成功
 	   101			验证失败
 	   102			手机号码格式不正确
 	   103			会员级别不够
 	   104			内容未审核
 	   105			内容过多
 	   106			账户余额不足
 	   107			Ip受限
 	   108			手机号码发送太频繁，请换号或隔天再发
 	   109			帐号被锁定
 	   110			发送通道不正确
 	   111			当前时间段禁止短信发送
 	   120			系统升级
		*/
 	     
	}
	
	 public static String SMS(String postData, String postUrl) {
	        try {
	            //发送POST请求
	            URL url = new URL(postUrl);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            conn.setRequestProperty("Connection", "Keep-Alive");
	            conn.setUseCaches(false);
	            conn.setDoOutput(true);
	            conn.setRequestProperty("Content-Length", "" + postData.length());
	            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
	            out.write(postData);
	            out.flush();
	            out.close();
	            //获取响应状态
	            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
	                System.out.println("connect failed!");
	                return "";
	            }
	            //获取响应内容体
	            String line, result = "";
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	            while ((line = in.readLine()) != null) {
	                result += line + "\n";
	            }
	            in.close();
	            return result;
	        } catch (IOException e) {
	            e.printStackTrace(System.out);
	        }
	        return "";
	    }
	 //===================================================================================================================
	 
	 
	/**
	 * 
	 * 短信商 二  http://www.ihuyi.com/ =====================================================================================
	 * 
	 */
	private static String Url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";
	
	
	
	/**
	 * 给一个人发送单条短信
	 * @param mobile 手机号
	 * @param code  短信内容
	 */
	public static void sendSms2(String mobile,String code){
		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url); 
			
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");

	    String content = new String(code);  
	    
	    String account = "", password = "";
	    String strSMS2 = Tools.readTxtFile(Const.SMS2);			//读取短信2配置
		if(null != strSMS2 && !"".equals(strSMS2)){
			String strS2[] = strSMS2.split(",fh,");
			if(strS2.length == 2){
				account = strS2[0];
				password = strS2[1];
			}
		}
	    
		NameValuePair[] data = {//提交短信
		    new NameValuePair("account", account), 
		    new NameValuePair("password", password), 			//密码可以使用明文密码或使用32位MD5加密
		    new NameValuePair("mobile", mobile), 
		    new NameValuePair("content", content),
		};
		
		method.setRequestBody(data);
		
		try {
			client.executeMethod(method);
			
			String SubmitResult =method.getResponseBodyAsString();
					
			Document doc = DocumentHelper.parseText(SubmitResult); 
			Element root = doc.getRootElement();


			code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");
			
			
			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);
			
			if(code == "2"){
				System.out.println("短信提交成功");
			}
			
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}	
		
	}
	
	/**
	 * 给多个人发送单条短信
	 * @param list 手机号验证码
	 */
	public static void sendSmsAll(List<PageData> list){
		String code;
		String mobile;
		for(int i=0;i<list.size();i++){
			code=list.get(i).get("code").toString();
			mobile=list.get(i).get("mobile").toString();
			sendSms2(mobile,code);
		}
	}
	// =================================================================================================
	
/*	*//**
	 * 短信商3--阿里大于
	 *//*
	public static boolean sendSmsAliHttx(String json, String phone) {
		logger.info("开始发短信,json:" + json + ",phone:" + phone);
		String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "24552613";
		String secret = "1430e107db4cab4ebf8798e898ec9cb3";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("智宇科技");
		req.setSmsParamString(json);
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_78290032");
		try {
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
			// 解析返回的json字符串
			JSONObject jObject = new JSONObject(rsp.getBody());
			logger.info("发送短信返回码：" + rsp.getBody());
			String str1 = jObject.getString("alibaba_aliqin_fc_sms_num_send_response");
			if (StringUtils.isNotEmpty(str1)) {
				JSONObject jObj1 = new JSONObject(str1);
				String str2 = jObj1.getString("result");
				if (StringUtils.isNotEmpty(str2)) {
					JSONObject jObj2 = new JSONObject(str2);
					boolean flag = jObj2.getBoolean("success");
					if (flag) {
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	*//**
	 * 短信商3--阿里大于,催款提醒测试模板
	 *//*
	public static boolean sendSmsAliCuiKuan(String json, String phone) {
		logger.info("开始发短信,json:" + json + ",phone:" + phone);
		String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "24634838";
		String secret = "fdd168afdd4400b0baf548c90b378013";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("智宇科技");
		req.setSmsParamString(json);
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_99065034");
		try {
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
			// 解析返回的json字符串
			JSONObject jObject = new JSONObject(rsp.getBody());
			logger.info("发送短信返回码：" + rsp.getBody());
			String str1 = jObject.getString("alibaba_aliqin_fc_sms_num_send_response");
			if (StringUtils.isNotEmpty(str1)) {
				JSONObject jObj1 = new JSONObject(str1);
				String str2 = jObj1.getString("result");
				if (StringUtils.isNotEmpty(str2)) {
					JSONObject jObj2 = new JSONObject(str2);
					boolean flag = jObj2.getBoolean("success");
					if (flag) {
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	*/
	
	/**
	 * 短信商3--阿里大于,随手拍审核提醒
	 */
	public static boolean sendSmsAliSsp(String json, String phone) {
		logger.info("开始发短信,json:" + json + ",phone:" + phone);
		String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "24655211";
		String secret = "d1878bc8689bc54c858bea07f526fc0f";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("智宇科技");
		req.setSmsParamString(json);
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_103825022");
		try {
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
			// 解析返回的json字符串
			JSONObject jObject = new JSONObject(rsp.getBody());
			logger.info("发送短信返回码：" + rsp.getBody());
			String str1 = jObject.getString("alibaba_aliqin_fc_sms_num_send_response");
			if (StringUtils.isNotEmpty(str1)) {
				JSONObject jObj1 = new JSONObject(str1);
				String str2 = jObj1.getString("result");
				if (StringUtils.isNotEmpty(str2)) {
					JSONObject jObj2 = new JSONObject(str2);
					boolean flag = jObj2.getBoolean("success");
					if (flag) {
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 短信商3--阿里大于,实名注册验证码
	 */
	public static boolean sendSmsAliRealNameRegis(String json, String phone) {
		logger.info("开始发短信,json:" + json + ",phone:" + phone);
		String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "24797075";
		String secret = "c97a0bc1041f020800f3789f7c04a22a";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("智宇科技");
		req.setSmsParamString(json);
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_124335064");
		try {
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
			// 解析返回的json字符串
			JSONObject jObject = new JSONObject(rsp.getBody());
			logger.info("发送短信返回码：" + rsp.getBody());
			String str1 = jObject.getString("alibaba_aliqin_fc_sms_num_send_response");
			if (StringUtils.isNotEmpty(str1)) {
				JSONObject jObj1 = new JSONObject(str1);
				String str2 = jObj1.getString("result");
				if (StringUtils.isNotEmpty(str2)) {
					JSONObject jObj2 = new JSONObject(str2);
					boolean flag = jObj2.getBoolean("success");
					if (flag) {
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

