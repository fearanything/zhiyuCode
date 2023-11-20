package com.wx.framework.core.wx4j.response;

import javax.xml.bind.annotation.XmlElement;

public class ArticleResponse
{
  private String Title;
  private String Description;
  private String PicUrl;
  private String Url;

  @XmlElement(name="Title")
  public String getTitle()
  {
    return this.Title; }

  public void setTitle(String title) {
    this.Title = title; }

  @XmlElement(name="Description")
  public String getDescription() {
    return this.Description; }

  public void setDescription(String description) {
    this.Description = description; }

  @XmlElement(name="PicUrl")
  public String getPicUrl() {
    return this.PicUrl; }

  public void setPicUrl(String picUrl) {
    this.PicUrl = picUrl; }

  @XmlElement(name="Url")
  public String getUrl() {
    return this.Url; }

  public void setUrl(String url) {
    this.Url = url;
  }
}