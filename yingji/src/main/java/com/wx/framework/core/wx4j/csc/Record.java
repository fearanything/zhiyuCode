package com.wx.framework.core.wx4j.csc;

public class Record
{
  private String openid;
  private int opercode;
  private String text;
  private int time;
  private String worker;

  public Record()
  {
  }

  public Record(String openid, int opercode, String text, int time, String worker)
  {
    this.openid = openid;
    this.opercode = opercode;
    this.text = text;
    this.time = time;
    this.worker = worker;
  }

  public String getOpenid()
  {
    return this.openid; }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public int getOpercode()
  {
    return this.opercode; }

  public void setOpercode(int opercode) {
    this.opercode = opercode;
  }

  public String getText()
  {
    return this.text; }

  public void setText(String text) {
    this.text = text;
  }

  public int getTime()
  {
    return this.time; }

  public void setTime(int time) {
    this.time = time;
  }

  public String getWorker()
  {
    return this.worker; }

  public void setWorker(String worker) {
    this.worker = worker;
  }
}