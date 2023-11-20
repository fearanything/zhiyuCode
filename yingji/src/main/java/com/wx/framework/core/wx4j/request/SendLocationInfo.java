package com.wx.framework.core.wx4j.request;

import javax.xml.bind.annotation.XmlElement;

public class SendLocationInfo
{
  private String Location_X;
  private String Location_Y;
  private String Scale;
  private String Label;
  private String Poiname;

  @XmlElement(name="Location_X")
  public String getLocation_X()
  {
    return this.Location_X; }

  public void setLocation_X(String location_X) {
    this.Location_X = location_X; }

  @XmlElement(name="Location_Y")
  public String getLocation_Y() {
    return this.Location_Y; }

  public void setLocation_Y(String location_Y) {
    this.Location_Y = location_Y; }

  @XmlElement(name="Scale")
  public String getScale() {
    return this.Scale; }

  public void setScale(String scale) {
    this.Scale = scale; }

  @XmlElement(name="Label")
  public String getLabel() {
    return this.Label; }

  public void setLabel(String label) {
    this.Label = label; }

  @XmlElement(name="Poiname")
  public String getPoiname() {
    return this.Poiname; }

  public void setPoiname(String poiname) {
    this.Poiname = poiname;
  }
}