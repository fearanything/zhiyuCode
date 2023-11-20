package com.wx.framework.core.wx4j.data;

import com.wx.framework.core.wx4j.exception.WeChatException;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.token.TokenProxy;
import com.wx.framework.core.wx4j.util.DateTimeUtil;
import com.wx.framework.core.wx4j.util.WeChatUtil;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

public class DataCount
{
  private static Logger logger = Logger.getLogger(DataCount.class);
  private static String getusersummary_url = "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";
  private static String getusercumulate_url = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";

  public static int getusersummary()
  {
    Map params = new HashMap();
    params.put("begin_date", DateTimeUtil.getDateTime("2014-10-15", "yyyy-MM-dd"));
    params.put("end_date", DateTimeUtil.getDateTime("2014-10-19", "yyyy-MM-dd"));
    String token = TokenProxy.accessToken();
    String url = getusersummary_url.replace("ACCESS_TOKEN", token);
    net.sf.json.JSONObject json = HttpUtils.httpsRequest(url, "POST", com.alibaba.fastjson.JSONObject.toJSONString(params));
    String resultStr = json.toString();
    System.out.println(resultStr);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
      return 0;
    }
    System.out.println(json.get("new_user"));
    return 1;
  }
}