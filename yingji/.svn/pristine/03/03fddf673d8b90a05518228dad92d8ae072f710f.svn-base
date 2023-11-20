package com.wx.framework.core.wx4j.csc;

import java.util.HashMap;
import java.util.Map;

public class RecordOperCode
{
  private static final Map<Integer, String> operCodeMap = new HashMap();

  public static String getSessionState(int opercode)
  {
    if (operCodeMap.containsKey(Integer.valueOf(opercode)))
      return ((String)operCodeMap.get(Integer.valueOf(opercode)));

    return "";
  }

  static
  {
    operCodeMap.put(Integer.valueOf(1000), "创建未接入会话");
    operCodeMap.put(Integer.valueOf(1001), "接入会话");
    operCodeMap.put(Integer.valueOf(1002), "主动发起会话");
    operCodeMap.put(Integer.valueOf(1004), "关闭会话");
    operCodeMap.put(Integer.valueOf(1005), "抢接会话");
    operCodeMap.put(Integer.valueOf(2001), "公众号收到消息");
    operCodeMap.put(Integer.valueOf(2002), "客服发送消息");
    operCodeMap.put(Integer.valueOf(2003), "客服收到消息");
  }
}