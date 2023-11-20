package com.wx.framework.core.wx4j.pay;

import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.common.Wx4javaConfig;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

public class Pay
{
  private static final String DELIVERNOTIFY_URL = "https://api.weixin.qq.com/pay/delivernotify?access_token=";

  public static String getPackage(Map<String, String> params)
    throws UnsupportedEncodingException
  {
    String partnerKey = Wx4javaConfig.instance().getPartnerKey();
    String partnerId = Wx4javaConfig.instance().getPartnerId();
    String notifyUrl = Wx4javaConfig.instance().getNotify_url();

    params.put("partner", partnerId);
    params.put("notify_url", notifyUrl);

    return packageSign(params, partnerKey);
  }

  public static String createSign(Map<String, String> params, boolean encode)
    throws UnsupportedEncodingException
  {
    Set keysSet = params.keySet();
    Object[] keys = keysSet.toArray();
    Arrays.sort(keys);
    StringBuffer temp = new StringBuffer();
    boolean first = true;
    Object[] arr$ = keys; int len$ = arr$.length; for (int i$ = 0; i$ < len$; ++i$) { Object key = arr$[i$];
      if (first)
        first = false;
      else
        temp.append("&");

      temp.append(key).append("=");
      Object value = params.get(key);
      String valueString = "";
      if (null != value)
        valueString = value.toString();

      if (encode)
        temp.append(URLEncoder.encode(valueString, "UTF-8"));
      else
        temp.append(valueString);
    }

    return temp.toString();
  }

  private static String packageSign(Map<String, String> params, String paternerKey)
    throws UnsupportedEncodingException
  {
    String string1 = createSign(params, false);
    String stringSignTemp = string1 + "&key=" + paternerKey;
    String signValue = DigestUtils.md5Hex(stringSignTemp).toUpperCase();
    String string2 = createSign(params, true);
    return string2 + "&sign=" + signValue;
  }

  public static String paySign(String timestamp, String noncestr, String packages)
    throws UnsupportedEncodingException
  {
    Map paras = new HashMap();
    paras.put("appid", Wx4javaConfig.instance().getAppid());
    paras.put("timestamp", timestamp);
    paras.put("noncestr", noncestr);
    paras.put("package", packages);
    paras.put("appkey", Wx4javaConfig.instance().getPaySignKey());

    String string1 = createSign(paras, false);
    String paySign = DigestUtils.shaHex(string1);
    return paySign;
  }

  public static boolean verifySign(long timestamp, String noncestr, String openid, int issubscribe, String appsignature)
    throws UnsupportedEncodingException
  {
    Map paras = new HashMap();
    paras.put("appid", Wx4javaConfig.instance().getAppid());
    paras.put("appkey", Wx4javaConfig.instance().getPaySignKey());
    paras.put("timestamp", String.valueOf(timestamp));
    paras.put("noncestr", noncestr);
    paras.put("openid", openid);
    paras.put("issubscribe", String.valueOf(issubscribe));

    String string1 = createSign(paras, false);
    String paySign = DigestUtils.shaHex(string1);
    return paySign.equalsIgnoreCase(appsignature);
  }

  private static String deliverSign(Map<String, String> paras)
    throws UnsupportedEncodingException
  {
    paras.put("appkey", Wx4javaConfig.instance().getPaySignKey());
    String string1 = createSign(paras, false);
    String paySign = DigestUtils.shaHex(string1);
    return paySign;
  }

  public static boolean delivernotify(String access_token, String openid, String transid, String out_trade_no)
    throws IOException, ExecutionException, InterruptedException
  {
    Map paras = new HashMap();
    paras.put("appid", Wx4javaConfig.instance().getAppid());
    paras.put("openid", openid);
    paras.put("transid", transid);
    paras.put("out_trade_no", out_trade_no);
    paras.put("deliver_timestamp", (System.currentTimeMillis() / 1000L) + "");
    paras.put("deliver_status", "1");
    paras.put("deliver_msg", "ok");

    String app_signature = deliverSign(paras);
    paras.put("app_signature", app_signature);
    paras.put("sign_method", "sha1");
    String json = HttpUtils.post("https://api.weixin.qq.com/pay/delivernotify?access_token=".concat(access_token), JSONObject.toJSONString(paras));
    if (StringUtils.isNotBlank(json)) {
      JSONObject object = JSONObject.parseObject(json);
      if (object.containsKey("errcode")) {
        int errcode = object.getIntValue("errcode");
        return (errcode == 0);
      }
    }
    return false;
  }
}