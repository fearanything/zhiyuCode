package com.wx.framework.core.wx4j.token;

import com.wx.framework.core.wx4j.common.CacheUtils;
import com.wx.framework.core.wx4j.common.Wx4javaConfig;

public class TokenProxy
{
  public static String accessToken()
  {
    String appid = Wx4javaConfig.instance().getAppid();
    String appsecret = Wx4javaConfig.instance().getAppSecret();
    String token = "";
    try {
      token = CacheUtils.getAccessToken(appid, appsecret);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return token;
  }

  public static String jsApiTicket()
  {
    String appid = Wx4javaConfig.instance().getAppid();
    String appsecret = Wx4javaConfig.instance().getAppSecret();
    String ticket = "";
    String token = "";
    try {
      token = CacheUtils.getAccessToken(appid, appsecret);
      ticket = CacheUtils.getJsApiTicket(token);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ticket;
  }
}