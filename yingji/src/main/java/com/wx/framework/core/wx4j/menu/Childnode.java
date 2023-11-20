package com.wx.framework.core.wx4j.menu;

public class Childnode
{
  private int id;
  private int parentid;
  private String name;
  private String url;
  private String type;
  private String key;

  public int getId()
  {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getParentid() {
    return this.parentid;
  }

  public void setParentid(int parentid) {
    this.parentid = parentid;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}