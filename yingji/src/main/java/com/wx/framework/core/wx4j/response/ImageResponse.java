package com.wx.framework.core.wx4j.response;

import javax.xml.bind.annotation.XmlElement;

public class ImageResponse
{
  private String MediaId;

  @XmlElement(name="MediaId")
  public String getMediaId()
  {
    return this.MediaId;
  }

  public void setMediaId(String mediaId) {
    this.MediaId = mediaId;
  }
}