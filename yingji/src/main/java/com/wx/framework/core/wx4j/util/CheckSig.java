package com.wx.framework.core.wx4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.log4j.Logger;

public class CheckSig
{
  private final Logger LOGGER;

  public CheckSig()
  {
    this.LOGGER = Logger.getLogger(CheckSig.class);
  }

  public static final String inputStream2String(InputStream in)
    throws UnsupportedEncodingException, IOException
  {
    if (in == null)
      return "";

    StringBuffer out = new StringBuffer();
    byte[] b = new byte[4096];
    int n;
    while ((n = in.read(b)) != -1) {
     
      out.append(new String(b, 0, n, "UTF-8"));
    }
    return out.toString();
  }

  public static final boolean checkSignature2(String token, String signature, String timestamp, String nonce) {
    List params = new ArrayList();
    params.add(token);
    params.add(timestamp);
    params.add(nonce);
    Collections.sort(params, new Comparator()
    {
      public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
      }

    });
    String temp = new StringBuilder().append((String)params.get(0)).append((String)params.get(1)).append((String)params.get(2)).toString();
    return SHA1.encode(temp).equals(signature);
  }

  public static boolean checkSignature(String token, String signature, String timestamp, String nonce)
  {
    String[] arr = { token, timestamp, nonce };
    Arrays.sort(arr);
    StringBuilder content = new StringBuilder();
    for (int i = 0; i < arr.length; ++i)
      content.append(arr[i]);

    MessageDigest md = null;
    String tmpStr = null;
    try {
      md = MessageDigest.getInstance("SHA-1");
      byte[] digest = md.digest(content.toString().getBytes());
      tmpStr = byteToStr(digest);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    content = null;

    return ((tmpStr != null) ? tmpStr.equals(signature.toUpperCase()) : false);
  }

  private static String byteToStr(byte[] byteArray) {
    String strDigest = "";
    for (int i = 0; i < byteArray.length; ++i)
      strDigest = new StringBuilder().append(strDigest).append(byteToHexStr(byteArray[i])).toString();

    return strDigest;
  }

  private static String byteToHexStr(byte mByte)
  {
    char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    char[] tempArr = new char[2];
    tempArr[0] = Digit[(mByte >>> 4 & 0xF)];
    tempArr[1] = Digit[(mByte & 0xF)];
    String s = new String(tempArr);
    return s;
  }

  public static Map<String, String> sign(String jsapi_ticket, String url, String nonce_str, String timestamp)
  {
    Map ret = new HashMap();

    String signature = "";

    String string1 = new StringBuilder().append("jsapi_ticket=").append(jsapi_ticket).append("&noncestr=").append(nonce_str).append("&timestamp=").append(timestamp).append("&url=").append(url).toString();
    try
    {
      MessageDigest crypt = MessageDigest.getInstance("SHA-1");
      crypt.reset();
      crypt.update(string1.getBytes("UTF-8"));
      signature = byteToHex(crypt.digest());
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch (UnsupportedEncodingException e)
    {
      e.printStackTrace();
    }

    ret.put("url", url);
    ret.put("jsapi_ticket", jsapi_ticket);
    ret.put("nonceStr", nonce_str);
    ret.put("timestamp", timestamp);
    ret.put("signature", signature);

    return ret;
  }

  private static String byteToHex(byte[] hash) {
    Formatter formatter = new Formatter();
    byte[] arr$ = hash; int len$ = arr$.length; for (int i$ = 0; i$ < len$; ++i$) { byte b = arr$[i$];

      formatter.format("%02x", new Object[] { Byte.valueOf(b) });
    }
    String result = formatter.toString();
    formatter.close();
    return result;
  }

  public static String create_nonce_str() {
    return UUID.randomUUID().toString();
  }

  public static String create_timestamp() {
    return Long.toString(System.currentTimeMillis() / 1000L);
  }
}