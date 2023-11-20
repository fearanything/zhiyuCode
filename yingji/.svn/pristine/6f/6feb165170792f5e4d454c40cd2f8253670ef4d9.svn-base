package com.wx.framework.core.wx4j.util;

import java.util.Calendar;
import java.util.Date;

public class DateTime extends Date
{
  public static final DateTime MAX_DATE_TIME = new DateTime(9999, 12, 31, 23, 59, 59);
  public static final DateTime MIN_DATE_TIME = new DateTime(1, 1, 1, 0, 0, 0);
  private static final long serialVersionUID = 1L;
  private Date date;
  private Calendar calendar;

  public DateTime(long ticks)
  {
    this.date = new Date(ticks);
  }

  public DateTime(int year, int month, int day)
  {
    this.calendar.set(year, month, day);
    this.date = this.calendar.getTime();
  }

  public DateTime(int year, int month, int day, int hour, int minute, int second)
  {
    this.calendar.set(year, month, day, hour, minute, second);
    this.date = this.calendar.getTime();
  }

  public DateTime(String dateString)
  {
    this.date = DateTimeUtil.getDate(dateString);
  }

  public String toString()
  {
    return DateTimeUtil.toDateTimeStr(this.date);
  }

  public String toString(String format)
  {
    return DateTimeUtil.toDateString(this.date, format);
  }

  public Date toDate()
  {
    return this.date;
  }
}