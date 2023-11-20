package com.wx.framework.core.wx4j.menu;

import java.util.ArrayList;
import java.util.List;

public class TreeNode
{
  private int id;
  private int parentid;
  private String name;
  private String url;
  private String type;
  private String key;
  private List<Childnode> childnodes;

  public TreeNode()
  {
    this.childnodes = new ArrayList(); }

  public List<Childnode> getChildnodes() {
    return this.childnodes;
  }

  public void setChildnodes(List<Childnode> childnodes) {
    this.childnodes = childnodes;
  }

  public int getId() {
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