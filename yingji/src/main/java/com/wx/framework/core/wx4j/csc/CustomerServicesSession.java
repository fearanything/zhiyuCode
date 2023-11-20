package com.wx.framework.core.wx4j.csc;

import com.alibaba.fastjson.annotation.JSONField;

public class CustomerServicesSession
{
  private int createTime;
  private String kfAccount;
  private String openId;

  @JSONField(name="createtime")
  public int getCreateTime()
  {
    return this.createTime; }

  @JSONField(name="createtime")
  public void setCreateTime(int createTime) {
    this.createTime = createTime;
  }

  @JSONField(name="kf_account")
  public String getKfAccount()
  {
    return this.kfAccount; }

  @JSONField(name="kf_account")
  public void setKfAccount(String kfAccount) {
    this.kfAccount = kfAccount;
  }

  @JSONField(name="openid")
  public String getOpenId()
  {
    return this.openId; }

  @JSONField(name="openid")
  public void setOpenId(String openId) {
    this.openId = openId;
  }
}