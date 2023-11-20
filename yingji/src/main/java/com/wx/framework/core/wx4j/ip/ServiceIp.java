package com.wx.framework.core.wx4j.ip;

import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.common.CacheUtils;
import com.wx.framework.core.wx4j.common.Wx4javaConfig;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import java.io.PrintStream;

public class ServiceIp
{
  private static String ipurl = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";

  public static String getServiceIp()
    throws Exception
  {
    String appid = Wx4javaConfig.instance().getAppid();
    String appsecret = Wx4javaConfig.instance().getAppSecret();
    String ACCESS_TOKEN = CacheUtils.getAccessToken(appid, appsecret);
    String requestUrl = ipurl.replace("ACCESS_TOKEN", ACCESS_TOKEN);

    String request_str = HttpUtils.get(requestUrl);
    JSONObject jsonObject = JSONObject.parseObject(request_str);
    System.out.println(jsonObject.toJSONString());
    return null;
  }
}