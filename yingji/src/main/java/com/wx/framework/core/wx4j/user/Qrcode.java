package com.wx.framework.core.wx4j.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;

public class Qrcode
{
  private static final String SHOWQRCODE_POST_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
  private String ticket;
  private Integer expireSeconds;
  private String url;

  public String getTicket()
  {
    return this.ticket; }

  public void setTicket(String ticket) {
    this.ticket = ticket; }

  @JSONField(name="expire_seconds")
  public Integer getExpireSeconds() {
    return this.expireSeconds; }

  @JSONField(name="expire_seconds")
  public void setExpireSeconds(Integer expireSeconds) {
    this.expireSeconds = expireSeconds; }

  public String getUrl() {
    return this.url; }

  public void setUrl(String url) {
    this.url = url;
  }

  public void getQrcode(String qrcodeFile)
  {
    byte[] b;
    try
    {
      b = HttpUtils.getFile("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + URLEncoder.encode(this.ticket, "UTF-8"));
      File file = new File(qrcodeFile);
      FileOutputStream fStream = new FileOutputStream(file);
      fStream.write(b);
      fStream.flush();
      fStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getQrcodeUrl()
  {
    return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + this.ticket;
  }
}