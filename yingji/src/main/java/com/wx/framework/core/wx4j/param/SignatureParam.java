package com.wx.framework.core.wx4j.param;

import javax.servlet.http.HttpServletRequest;

public class SignatureParam
{
  private String signature;
  private String timestamp;
  private String nonce;
  private String echostr;

  public SignatureParam(HttpServletRequest request)
  {
    this.signature = request.getParameter("signature");
    this.timestamp = request.getParameter("timestamp");
    this.nonce = request.getParameter("nonce");
    this.echostr = request.getParameter("echostr");
  }

  public String getSignature() {
    return this.signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public String getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getNonce() {
    return this.nonce;
  }

  public void setNonce(String nonce) {
    this.nonce = nonce;
  }

  public String getEchostr() {
    return this.echostr;
  }

  public void setEchostr(String echostr) {
    this.echostr = echostr;
  }
}