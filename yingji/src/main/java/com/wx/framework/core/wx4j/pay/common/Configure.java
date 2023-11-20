package com.wx.framework.core.wx4j.pay.common;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.codec.digest.DigestUtils;

public class Configure
{
  public static String key = "";
  public static String appID = "";
  public static String appSecret = "";
  public static String mchID = "";
  private static String subMchID = "";
  private static String certLocalPath = "";
  private static String certPassword = "";
  private static boolean useThreadToDoReport = true;
  private static String ip = "127.0.0.1";
  public static String UNIFIED_ORDER_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";
  public static String PAY_API = "https://api.mch.weixin.qq.com/pay/micropay";
  public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";
  public static String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";
  public static String REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";
  public static String REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";
  public static String DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";
  public static String REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";
  public static String JS_API_CALL_URL = "http://www.domain.com/wxpay/js_api_call.html";
  public static String SSLCERT_PATH = Configure.class.getClassLoader().getResource("apiclient_cert.pem").getPath();
  public static String SSLKEY_PATH = Configure.class.getClassLoader().getResource("apiclient_key.pem").getPath();
  public static String SSLCERT12_PATH = Configure.class.getClassLoader().getResource("apiclient_cert.p12").getPath();
  public static String NOTIFY_URL = "http://www.domain.com/wxpay/notify_url.html";
  public static String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
  public static String SHORT_URL = "https://api.mch.weixin.qq.com/tools/shorturl";
  public static String HttpsRequestClassName = "com.tencent.common.HttpsRequest";

  public static String getCurrTime()
  {
    Date now = new Date();
    SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    String s = outFormat.format(now);
    return s;
  }

  public static String getCurrTestOrderNo()
  {
    String currTime = getCurrTime();

    String strTime = currTime.substring(8, currTime.length());

    String strRandom = buildRandom(4) + "";

    String strReq = strTime + strRandom;
    return strReq;
  }

  public static int buildRandom(int length)
  {
    int num = 1;
    double random = Math.random();
    if (random < 0.10000000000000001D)
      random += 0.10000000000000001D;

    for (int i = 0; i < length; ++i)
      num *= 10;

    return (int)(random * num);
  }

  public static String getNonceStr()
  {
    Random random = new Random();
    return MD5.MD5Encode(String.valueOf(random.nextInt(10000)));
  }

  public static String getTimeStamp()
  {
    return String.valueOf(System.currentTimeMillis() / 1000L);
  }

  public static String sortParams(SortedMap<String, String> signParams)
  {
    StringBuffer sb = new StringBuffer();
    Set set = signParams.entrySet();
    Iterator it = set.iterator();
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry)it.next();
      String k = (String)entry.getKey();
      String v = (String)entry.getValue();
      sb.append(k + "=" + v + "&");
    }

    String params = sb.substring(0, sb.length() - 1);
    return params;
  }

  public static String createMD5Sign(SortedMap<String, String> signParams)
    throws Exception
  {
    StringBuffer sb = new StringBuffer(sortParams(signParams));
    String params = sb.append("&key=").append(key).toString();
    System.out.println(params);
    String sign = DigestUtils.md5Hex(getContentBytes(params, "UTF-8")).toUpperCase();
    return sign;
  }

  private static byte[] getContentBytes(String content, String charset)
  {
    if ((charset == null) || ("".equals(charset)))
      return content.getBytes();
    try
    {
      return content.getBytes(charset);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset); }
  }

  public static boolean isUseThreadToDoReport() {
    return useThreadToDoReport;
  }

  public static void setUseThreadToDoReport(boolean useThreadToDoReport) {
    useThreadToDoReport = useThreadToDoReport;
  }

  public static void setKey(String key)
  {
    key = key;
  }

  public static void setAppID(String appID) {
    appID = appID;
  }

  public static void setAppSecret(String appSecret) {
    appSecret = appSecret;
  }

  public static void setMchID(String mchID) {
    mchID = mchID;
  }

  public static void setSubMchID(String subMchID) {
    subMchID = subMchID;
  }

  public static void setCertLocalPath(String certLocalPath) {
    certLocalPath = certLocalPath;
  }

  public static void setCertPassword(String certPassword) {
    certPassword = certPassword;
  }

  public static void setIp(String ip) {
    ip = ip;
  }

  public static String getKey() {
    return key;
  }

  public static String getAppid() {
    return appID;
  }

  public static String getAppSecret() {
    return appSecret;
  }

  public static String getMchid() {
    return mchID;
  }

  public static String getSubMchid() {
    return subMchID;
  }

  public static String getCertLocalPath() {
    return certLocalPath;
  }

  public static String getCertPassword() {
    return certPassword;
  }

  public static String getIP() {
    return ip;
  }

  public static void setHttpsRequestClassName(String name) {
    HttpsRequestClassName = name;
  }
}