package com.wx.framework.core.wx4j.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Wx4javaConfig
{
  private static Logger logger = Logger.getLogger(Wx4javaConfig.class);
  private static final String configFile = "/wechat.properties";
  private String url;
  private String token;
  private String encodingAESKey;
  private String appid;
  private String appSecret;
  private String accessTokenServer;
  private String jsApiTicketServer;
  private String redirect_uri;
  private String redirect_defulat_uri;
  private String wx_jssdk_url;
  private String partnerKey;
  private String partnerId;
  private String notify_url;
  private String paySignKey;
  private String scope;
  private static Wx4javaConfig config = new Wx4javaConfig();

  private Wx4javaConfig()
  {
    Properties p = new Properties();
    InputStream inStream = super.getClass().getResourceAsStream("/wechat.properties");
    if (inStream == null) {
      logger.error("根目录下找不到wechat.properties文件");
      return;
    }
    try {
      p.load(inStream);
      this.url = p.getProperty("wechat.url").trim();
      this.encodingAESKey = p.getProperty("wechat.encodingaeskey").trim();
      this.token = p.getProperty("wechat.token").trim();
      this.appid = p.getProperty("wechat.appid").trim();
      this.appSecret = p.getProperty("wechat.appsecret").trim();
      this.accessTokenServer = p.getProperty("wechat.accessToken.server.class").trim();
      this.jsApiTicketServer = p.getProperty("wechat.ticket.jsapi.server.class").trim();
      this.redirect_uri = p.getProperty("redirect_uri").trim();

      this.partnerKey = p.getProperty("partnerKey").trim();
      this.partnerId = p.getProperty("partnerId").trim();
      this.notify_url = p.getProperty("notify_url").trim();
      this.paySignKey = p.getProperty("paySignKey").trim();
      this.redirect_defulat_uri = p.getProperty("redirect_defulat_uri").trim();
      this.scope = p.getProperty("scope").trim();

      this.wx_jssdk_url = p.getProperty("wx_jssdk_url").trim();
      inStream.close();
    } catch (IOException e) {
      logger.error("load wechat.properties error,class根目录下找不到wechat.properties文件");
      e.printStackTrace();
    }
    logger.info("load wechat4j.properties success");
  }

  public static Wx4javaConfig instance() {
    return config; }

  public String getToken() {
    return this.token; }

  public String getAppid() {
    return this.appid; }

  public String getAppSecret() {
    return this.appSecret;
  }

  public String getUrl() {
    return this.url;
  }

  public String getEncodingAESKey() {
    return this.encodingAESKey;
  }

  public String getAccessTokenServer() {
    return this.accessTokenServer;
  }

  public String getJsApiTicketServer() {
    return this.jsApiTicketServer;
  }

  public String getRedirect_uri() {
    return this.redirect_uri;
  }

  public String getPartnerKey() {
    return this.partnerKey;
  }

  public String getPartnerId() {
    return this.partnerId;
  }

  public String getNotify_url() {
    return this.notify_url;
  }

  public String getPaySignKey() {
    return this.paySignKey;
  }

  public String getRedirect_defulat_uri() {
    return this.redirect_defulat_uri;
  }

  public String getScope() {
    return this.scope;
  }

  public String getWx_jssdk_url() {
    return this.wx_jssdk_url;
  }
}