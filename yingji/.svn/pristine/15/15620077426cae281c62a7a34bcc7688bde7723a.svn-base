package com.wx.framework.core.wx4j.request;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class SendPicsInfo
{
  private String Count;
  private List<Item> item;

  @XmlElement(name="Count")
  public String getCount()
  {
    return this.Count; }

  public void setCount(String count) {
    this.Count = count; }

  @XmlElementWrapper(name="PicList")
  @XmlElement(name="item")
  public List<Item> getItem() {
    return this.item; }

  public void setItem(List<Item> item) {
    this.item = item;
  }
}