package com.wx.framework.core.wx4j.semantic;

import com.wx.framework.core.wx4j.exception.WeChatException;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.token.TokenProxy;
import com.wx.framework.core.wx4j.util.WeChatUtil;
import java.io.PrintStream;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class SemanticUnderstanding
{
  private static Logger logger = Logger.getLogger(SemanticUnderstanding.class);
  private static String semanticUnderstanding_url = "https://api.weixin.qq.com/semantic/semproxy/search?access_token=ACCESS_TOKEN";

  public static String undelstand(Undelstand queryvo)
  {
    String accessToken = TokenProxy.accessToken();
    String url = semanticUnderstanding_url.replace("ACCESS_TOKEN", accessToken);
    logger.info(url);
    JSONObject json = HttpUtils.httpsRequest(url, "POST", JSONObject.fromObject(queryvo).toString());
    String resultStr = json.toString();
    System.out.println(resultStr);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
    }

    return resultStr;
  }
}