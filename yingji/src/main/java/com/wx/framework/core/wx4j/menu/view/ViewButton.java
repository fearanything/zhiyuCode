package com.wx.framework.core.wx4j.menu.view;

import com.wx.framework.core.wx4j.menu.Button;

public class ViewButton extends Button
{
  private String type;
  private String url;
  private String name;

  public String getName()
  {
    return this.name; }

  public void setName(String name) {
    this.name = name; }

  public String getType() {
    return this.type; }

  public void setType(String type) {
    this.type = type; }

  public String getUrl() {
    return this.url; }

  public void setUrl(String url) {
    this.url = url; }

  public ViewButton(String type, String url, String name) {
    this.type = type;
    this.url = url;
    this.name = name;
  }

  public ViewButton()
  {
  }
}