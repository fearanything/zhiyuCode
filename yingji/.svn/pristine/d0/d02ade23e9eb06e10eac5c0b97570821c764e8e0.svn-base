package com.wx.framework.core.wx4j.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtils
{
  public static String streamToString(InputStream is)
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    int i = -1;
    try
    {
      while ((i = is.read()) != -1)
        baos.write(i);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return baos.toString();
  }

  public static InputStream strToStream(String str)
  {
    InputStream is = new ByteArrayInputStream(str.getBytes());
    return is;
  }
}