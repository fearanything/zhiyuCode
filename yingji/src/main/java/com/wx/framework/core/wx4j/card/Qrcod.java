package com.wx.framework.core.wx4j.card;

import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.token.TokenProxy;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.apache.commons.lang.StringUtils;

public class Qrcod
{
  private static final String QRCOD_CREATE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
  private static final String QRCOD_SHOW = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";

  public JSONObject createScene(String accessToken, int expireSeconds, int sceneId)
    throws InterruptedException, ExecutionException, IOException
  {
    Map params = new HashMap();
    Map actionInfo = new HashMap();
    Map scene = new HashMap();
    params.put("expire_seconds", Integer.valueOf(expireSeconds));
    params.put("action_name", "QR_SCENE");
    scene.put("scene_id", Integer.valueOf(sceneId));
    actionInfo.put("scene", scene);
    params.put("action_info", actionInfo);
    String post = JSONObject.toJSONString(params);
    String reslut = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=".concat(accessToken), post);
    if (StringUtils.isNotEmpty(reslut))
      return JSONObject.parseObject(reslut);

    return null;
  }

  public JSONObject createLimitScene(String accessToken, int sceneId)
    throws InterruptedException, ExecutionException, IOException
  {
    Map params = new HashMap();
    Map actionInfo = new HashMap();
    Map scene = new HashMap();
    params.put("action_name", "QR_LIMIT_SCENE");
    scene.put("scene_id", Integer.valueOf(sceneId));
    actionInfo.put("scene", scene);
    params.put("action_info", actionInfo);
    String post = JSONObject.toJSONString(params);
    String reslut = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=".concat(accessToken), post);
    if (StringUtils.isNotEmpty(reslut))
      return JSONObject.parseObject(reslut);

    return null;
  }

  public static String showqrcodeUrl(String ticket)
  {
    return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=".concat(ticket);
  }

  public static void main(String[] args) throws Exception
  {
    String token = TokenProxy.accessToken();
    Qrcod ticket = new Qrcod();
    JSONObject json = ticket.createScene(token, 2, 100);
    System.out.println(json);

    System.out.println(showqrcodeUrl(json.getString("ticket")));
  }
}