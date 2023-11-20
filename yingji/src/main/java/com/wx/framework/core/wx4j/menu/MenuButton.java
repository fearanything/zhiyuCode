package com.wx.framework.core.wx4j.menu;

import com.alibaba.fastjson.annotation.JSONField;
import com.wx.framework.core.wx4j.event.EventType;
import java.util.ArrayList;
import java.util.List;

public class MenuButton
{
  private EventType type;
  private String name;
  private String key;
  private String url;
  private String mediaId;
  private List<MenuButton> subButton;

  public MenuButton()
  {
    this.subButton = new ArrayList(); }

  public EventType getType() {
    return this.type; }

  public void setType(EventType type) {
    this.type = type; }

  public String getName() {
    return this.name; }

  public void setName(String name) {
    this.name = name; }

  public String getKey() {
    return this.key; }

  public void setKey(String key) {
    this.key = key; }

  public String getUrl() {
    return this.url; }

  public void setUrl(String url) {
    this.url = url; }

  @JSONField(name="media_id")
  public String getMediaId() {
    return this.mediaId; }

  @JSONField(name="media_id")
  public void setMediaId(String mediaId) {
    this.mediaId = mediaId; }

  @JSONField(name="sub_button")
  public List<MenuButton> getSubButton() {
    return this.subButton; }

  @JSONField(name="sub_button")
  public void setSubButton(List<MenuButton> subButton) {
    this.subButton = subButton;
  }
}