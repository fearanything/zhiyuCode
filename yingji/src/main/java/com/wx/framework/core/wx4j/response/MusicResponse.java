package com.wx.framework.core.wx4j.response;

import javax.xml.bind.annotation.XmlElement;

public class MusicResponse
{
  private String Title;
  private String Description;
  private String MusicURL;
  private String HQMusicUrl;
  private String ThumbMediaId;

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

  @XmlElement(name="MusicURL")
  public String getMusicURL() {
    return this.MusicURL; }

  public void setMusicURL(String musicURL) {
    this.MusicURL = musicURL; }

  @XmlElement(name="HQMusicUrl")
  public String getHQMusicUrl() {
    return this.HQMusicUrl; }

  public void setHQMusicUrl(String hQMusicUrl) {
    this.HQMusicUrl = hQMusicUrl; }

  @XmlElement(name="ThumbMediaId")
  public String getThumbMediaId() {
    return this.ThumbMediaId; }

  public void setThumbMediaId(String thumbMediaId) {
    this.ThumbMediaId = thumbMediaId;
  }
}