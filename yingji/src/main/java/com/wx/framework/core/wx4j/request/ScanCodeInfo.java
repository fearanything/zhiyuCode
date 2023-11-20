package com.wx.framework.core.wx4j.request;

import javax.xml.bind.annotation.XmlElement;

public class ScanCodeInfo
{
  private String ScanType;
  private String ScanResult;

  @XmlElement(name="ScanType")
  public String getScanType()
  {
    return this.ScanType; }

  public void setScanType(String scanType) {
    this.ScanType = scanType; }

  @XmlElement(name="ScanResult")
  public String getScanResult() {
    return this.ScanResult; }

  public void setScanResult(String scanResult) {
    this.ScanResult = scanResult;
  }
}