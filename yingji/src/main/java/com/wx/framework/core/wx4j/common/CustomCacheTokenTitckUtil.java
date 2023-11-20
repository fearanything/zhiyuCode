package com.wx.framework.core.wx4j.common;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.exception.WeChatReturnCode;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;
import org.apache.log4j.Logger;

public class CustomCacheTokenTitckUtil
{
  private static final Logger log = Logger.getLogger(CustomCacheTokenTitckUtil.class);

  public static String getAccess_token(String appid, String appsecret)
    throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException, IOException, ExecutionException, InterruptedException
  {
    String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    String requestUrl = token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
    String access_token = "";

    String request_str = HttpUtils.get(requestUrl);
    JSONObject jsonObject = JSONObject.parseObject(request_str);
    if (null != jsonObject)
      try {
        access_token = jsonObject.getString("access_token");
      }
      catch (JSONException e) {
        log.error("获取token失败 errcode:{} errmsg:{}:" + jsonObject.getString("errcode") + "errmsg:" + WeChatReturnCode.getMsg(jsonObject.getIntValue("errcode")));
      }

    return access_token;
  }

  public static String getJsApiTicket(String access_token)
    throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException, IOException, ExecutionException, InterruptedException
  {
    String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    String requestUrl = url.replace("ACCESS_TOKEN", access_token);

    String ticket = "";
    String request_str = HttpUtils.get(requestUrl);
    JSONObject jsonObject = JSONObject.parseObject(request_str);
    if (null != jsonObject)
      try {
        ticket = jsonObject.getString("ticket");
      }
      catch (JSONException e) {
        log.error("获取JsApiTicket失败 errcode:{} errmsg:{}:" + jsonObject.getString("errcode") + "errmsg:" + WeChatReturnCode.getMsg(jsonObject.getIntValue("errcode")));
      }

    return ticket;
  }
}