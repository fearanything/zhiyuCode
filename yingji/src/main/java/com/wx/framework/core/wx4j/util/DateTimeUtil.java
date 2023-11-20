package com.wx.framework.core.wx4j.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil
{
  public static final String DEFAULT_FORMAT_DATE = "yyyy-MM-dd";
  public static final String DEFAULT_FORMAT_TIME = "HH:mm:ss";
  public static final String DEFAULT_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

  public static Date getDateTime(String dateString, String format)
  {
    SimpleDateFormat sf = new SimpleDateFormat(format);
    Date date = null;
    try
    {
      date = sf.parse(dateString);
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return date;
  }

  public static Date getDateTime(String dateTimeString)
  {
    return getDateTime(dateTimeString, "yyyy-MM-dd HH:mm:ss");
  }

  public static Date getDate(String date)
  {
    return getDateTime(date, "yyyy-MM-dd");
  }

  public static Date getTime(String time)
  {
    return getDateTime(time, "HH:mm:ss");
  }

  public static String toDateString(Date date, String format)
  {
    SimpleDateFormat sf = new SimpleDateFormat(format);
    return sf.format(date);
  }

  public static String toDateTimeStr(Date date)
  {
    return toDateString(date, "yyyy-MM-dd HH:mm:ss");
  }

  public static String toDateStr(Date date)
  {
    return toDateString(date, "yyyy-MM-dd");
  }

  public static String toTimeStr(Date date)
  {
    return toDateString(date, "HH:mm:ss");
  }

  public static String todayStr()
  {
    return currentDateStr();
  }

  public static Date today()
  {
    return current();
  }

  public static Date getToday(String time)
  {
    String today = todayStr();
    return getDateTime(today + " " + time, "yyyy-MM-dd HH:mm:ss");
  }

  public static Date now()
  {
    return current();
  }

  public static String nowStr()
  {
    return currentStr();
  }

  public static String currentTimeStr()
  {
    return toDateString(new Date(), "HH:mm:ss");
  }

  public static String currentDateStr()
  {
    return toDateString(new Date(), "yyyy-MM-dd");
  }

  public static String currentStr()
  {
    return toDateString(new Date(), "yyyy-MM-dd HH:mm:ss");
  }

  public static Date current()
  {
    return new Date();
  }

  public static String format(String text, Date date)
  {
    int start = text.indexOf("{");
    for (int end = text.indexOf("}"); (start > 0) && (end > 0); end = text.indexOf("}"))
    {
      String subStr = text.substring(start, end + 1);
      String format = text.substring(start + 1, end);
      String dateStr = toDateString(date, format);
      text = text.replace(subStr, dateStr);
      start = text.indexOf("{");
    }

    return text;
  }

  public static boolean isDate(String dateString)
  {
    return tryParse(dateString);
  }

  public static boolean tryParse(String dateString)
  {
    Date date = getDateTime(dateString);
    return (date != null);
  }
}