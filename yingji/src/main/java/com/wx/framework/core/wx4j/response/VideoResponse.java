package com.wx.framework.core.wx4j.response;

import javax.xml.bind.annotation.XmlElement;

public class VideoResponse
{
  private String MediaId;
  private String Title;
  private String Description;
  private String ThumbMediaId;

  @XmlElement(name="MediaId")
  public String getMediaId()
  {
    return this.MediaId; }

  public void setMediaId(String mediaId) {
    this.MediaId = mediaId; }

  @XmlElement(name="Title")
  public String getTitle() {
    return this.Title; }

  public void setTitle(String title) {
    this.Title = title; }

  @XmlElement(name="Description")
  public String getDescription() {
    return this.Description; }

  public void setDescription(String description) {
    this.Description = description; }

  @XmlElement(name="ThumbMediaId")
  public String getThumbMediaId() {
    return this.ThumbMediaId; }

  public void setThumbMediaId(String thumbMediaId) {
    this.ThumbMediaId = thumbMediaId;
  }
}