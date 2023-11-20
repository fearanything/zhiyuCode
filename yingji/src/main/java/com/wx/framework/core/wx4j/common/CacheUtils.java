package com.wx.framework.core.wx4j.common;

import com.wx.framework.core.ehcache.EHCacheUtil;
import java.io.PrintStream;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class CacheUtils
{
  private static final Logger log = Logger.getLogger(CacheUtils.class);
  public static EHCacheUtil cache_util = new EHCacheUtil();

  public static String getAccessToken(String appid, String appsecret)
    throws Exception
  {
    String accessToken = (String)cache_util.getCacheElement("accessToken");
    if ((StringUtils.isBlank(accessToken)) || (StringUtils.isEmpty(accessToken))) {
      log.info("accessToken为空，没有进行缓存.................");
      accessToken = CustomCacheTokenTitckUtil.getAccess_token(appid, appsecret);
      cache_util.addToCache("accessToken", accessToken);
      log.info("accessToken完成缓存");
    } else {
      log.info("accessToken从缓存总获取缓存" + accessToken);
    }
    return accessToken;
  }

  public static String getJsApiTicket(String accessToken)
    throws Exception
  {
    String jsticket = (String)cache_util.getCacheElement("jsticket");
    if ((StringUtils.isBlank(jsticket)) || (StringUtils.isEmpty(jsticket))) {
      log.info("jsticket为空，没有进行缓存.................");
      jsticket = CustomCacheTokenTitckUtil.getJsApiTicket(accessToken);
      cache_util.addToCache("jsticket", jsticket);
      log.info("jsticket完成缓存");
    } else {
      log.info("jsticket从缓存总获取缓存" + jsticket);
    }
    return jsticket;
  }

  public static void main(String[] args) throws Exception {
    String token = getAccessToken("wxd762b2b6e1eee1d6", "7ce9622115fba5f4cfcc87824d29061e");
    System.out.println(token);
  }
}