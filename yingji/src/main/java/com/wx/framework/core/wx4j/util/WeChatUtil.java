package com.wx.framework.core.wx4j.util;

import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.exception.WeChatException;
import com.wx.framework.core.wx4j.exception.WeChatReturnCode;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeChatUtil
{
  private static Object Server;
  private static String QRfromGoogle;

  public static String toString(Object obj)
  {
    if (obj == null)
      return "";

    return obj.toString();
  }

  public static int toInt(Object obj)
  {
    int a = 0;
    try {
      if (obj != null)
        a = Integer.parseInt(obj.toString());
    }
    catch (Exception e) {
    }
    return a;
  }

  public static String getCurrTime()
  {
    Date now = new Date();
    SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    String s = outFormat.format(now);
    return s;
  }

  public static String formatDate(Date date)
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    String strDate = formatter.format(date);
    return strDate;
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

  public static String getCharacterEncoding(HttpServletRequest request, HttpServletResponse response)
  {
    if ((null == request) || (null == response)) {
      return "utf-8";
    }

    String enc = request.getCharacterEncoding();
    if ((null == enc) || ("".equals(enc))) {
      enc = response.getCharacterEncoding();
    }

    if ((null == enc) || ("".equals(enc))) {
      enc = "utf-8";
    }

    return enc;
  }

  public static String URLencode(String content)
  {
    String URLencode = replace(Server.equals(content), "+", "%20");

    return URLencode;
  }

  private static String replace(boolean equals, String string, String string2) {
    return null;
  }

  public static long getUnixTime(Date date)
  {
    if (null == date) {
      return 8781813218021474304L;
    }

    return (date.getTime() / 1000L);
  }

  public static String QRfromGoogle(String chl)
  {
    int widhtHeight = 300;
    String EC_level = "L";
    int margin = 0;

    chl = URLencode(chl);

    String QRfromGoogle = "http://chart.apis.google.com/chart?chs=" + widhtHeight + "x" + widhtHeight + "&cht=qr&chld=" + EC_level + "|" + margin + "&chl=" + chl;

    return QRfromGoogle;
  }

  public static String date2String(Date date, String formatType)
  {
    SimpleDateFormat sdf = new SimpleDateFormat(formatType);
    return sdf.format(date);
  }

  public static void isSuccess(String resultStr)
    throws WeChatException
  {
    JSONObject jsonObject = JSONObject.parseObject(resultStr);
    Integer errCode = Integer.valueOf(jsonObject.getIntValue("errcode"));
    if ((errCode != null) && (errCode.intValue() != 0)) {
      String errMsg = WeChatReturnCode.getMsg(errCode.intValue());
      if (errMsg.equals(""))
        errMsg = jsonObject.getString("errmsg");

      throw new WeChatException("异常码:" + errCode + ";异常说明:" + errMsg);
    }
  }

  public static Boolean checkSignature(String token, String signature, String timestamp, String nonce)
  {
    return Boolean.valueOf(CheckSig.checkSignature(token, signature, timestamp, nonce));
  }
}