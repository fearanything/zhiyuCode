package com.wx.framework.core.wx4j.pay.common;

import com.wx.framework.core.wx4j.common.Wx4javaConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class RandomStringGenerator
{
  public static String getRandomStringByLength(int length)
  {
    String base = "abcdefghijklmnopqrstuvwxyz0123456789";
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < length; ++i) {
      int number = random.nextInt(base.length());
      sb.append(base.charAt(number));
    }
    return sb.toString();
  }

  public static String getSign(Map<String, Object> map)
  {
    String key = Wx4javaConfig.instance().getPaySignKey();
    ArrayList list = new ArrayList();
    for (Iterator i$ = map.entrySet().iterator(); i$.hasNext(); ) { Map.Entry entry = (Map.Entry)i$.next();
      if (entry.getValue() != "")
        list.add(new StringBuilder().append((String)entry.getKey()).append("=").append(entry.getValue()).append("&").toString());
    }

    int size = list.size();
    String[] arrayToSort = (String[])list.toArray(new String[size]);
    Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; ++i)
      sb.append(arrayToSort[i]);

    String result = sb.toString();
    result = new StringBuilder().append(result).append("key=").append(key).toString();

    result = MD5.MD5Encode(result).toUpperCase();

    return result;
  }
}