package com.wx.framework.core.wx4j.user;

import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.exception.WeChatException;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.token.TokenProxy;
import com.wx.framework.core.wx4j.util.WeChatUtil;
import org.apache.log4j.Logger;

public class AccountManager
{
  Logger logger = Logger.getLogger(AccountManager.class);
  private static final String SHORTURL_POST_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=";
  private static final String QRCODE_POST_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
  private String accessToken;

  public AccountManager()
  {
    this.accessToken = TokenProxy.accessToken();
  }

  public String shortUrl(String longUrl)
  {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("action", "long2short");
    jsonObject.put("long_url", longUrl);
    String requestData = jsonObject.toString();
    this.logger.info("request data " + requestData);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + this.accessToken, requestData);
    this.logger.info("return data " + resultStr);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      this.logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    JSONObject resultJson = JSONObject.parseObject(resultStr);
    return resultJson.getString("short_url");
  }

  public Qrcode createQrcodePerpetual(long sceneId)
  {
    return createQrcodeTicket(QrcodeType.QR_LIMIT_SCENE, null, Long.valueOf(sceneId), null);
  }

  public Qrcode createQrcodePerpetualstr(String sceneStr)
  {
    return createQrcodeTicket(QrcodeType.QR_LIMIT_STR_SCENE, null, null, sceneStr);
  }

  public Qrcode createQrcodeTemporary(long sceneId, int expireSeconds)
  {
    return createQrcodeTicket(QrcodeType.QR_SCENE, Integer.valueOf(expireSeconds), Long.valueOf(sceneId), null);
  }

  private Qrcode createQrcodeTicket(QrcodeType qrcodeType, Integer expireSeconds, Long sceneId, String sceneStr) {
    JSONObject ticketJson = new JSONObject();
    ticketJson.put("action_name", qrcodeType);
    JSONObject sceneJson = new JSONObject();
    switch (qrcodeType.ordinal())
    {
    case 1:
      ticketJson.put("expire_seconds", expireSeconds);
      sceneJson.put("scene_id", sceneId);
      break;
    case 2:
      sceneJson.put("scene_id", sceneId);
      break;
    case 3:
      sceneJson.put("scene_str", sceneStr);
    }

    JSONObject actionInfoJson = new JSONObject();
    actionInfoJson.put("scene", sceneJson);
    ticketJson.put("action_info", actionInfoJson);
    String requestData = ticketJson.toString();
    this.logger.info("request data " + requestData);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + this.accessToken, requestData);
    this.logger.info("return data " + resultStr);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      this.logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    Qrcode qrcode = (Qrcode)JSONObject.parseObject(resultStr, Qrcode.class);
    return qrcode;
  }
}