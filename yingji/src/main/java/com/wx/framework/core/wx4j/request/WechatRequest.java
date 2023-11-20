package com.wx.framework.core.wx4j.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class WechatRequest
{
  private String ToUserName;
  private String FromUserName;
  private String CreateTime;
  private String MsgType;
  private String Event;
  private String EventKey;
  private String MsgId;
  private String Content;
  private String Location_X;
  private String Location_Y;
  private String Scale;
  private String Label;
  private String Title;
  private String Description;
  private String Url;
  private String PicUrl;
  private String MediaId;
  private String Format;
  private String Status;
  private String Latitude;
  private String Longitude;
  private String Precision;
  private String Ticket;
  private String ThumbMediaId;
  private ScanCodeInfo ScanCodeInfo;
  private SendPicsInfo SendPicsInfo;
  private SendLocationInfo SendLocationInfo;

  @XmlElement(name="Format")
  public String getFormat()
  {
    return this.Format; }

  public void setFormat(String format) {
    this.Format = format; }

  @XmlElement(name="PicUrl")
  public String getPicUrl() {
    return this.PicUrl; }

  public void setPicUrl(String picUrl) {
    this.PicUrl = picUrl; }

  @XmlElement(name="MediaId")
  public String getMediaId() {
    return this.MediaId; }

  public void setMediaId(String mediaId) {
    this.MediaId = mediaId; }

  @XmlElement(name="Title")
  public String getTitle() {
    return this.Title; }

  public void setTitle(String title) {
    this.Title = title; }

  @XmlElement(name="Description")
  public String getDescription() {
    return this.Description; }

  public void setDescription(String description) {
    this.Description = description; }

  @XmlElement(name="Url")
  public String getUrl() {
    return this.Url; }

  public void setUrl(String url) {
    this.Url = url; }

  @XmlElement(name="Location_X")
  public String getLocation_X() {
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

  @XmlElement(name="MsgId")
  public String getMsgId() {
    return this.MsgId; }

  public void setMsgId(String msgId) {
    this.MsgId = msgId; }

  @XmlElement(name="ToUserName")
  public String getToUserName() {
    return this.ToUserName; }

  public void setToUserName(String toUserName) {
    this.ToUserName = toUserName; }

  @XmlElement(name="FromUserName")
  public String getFromUserName() {
    return this.FromUserName; }

  public void setFromUserName(String fromUserName) {
    this.FromUserName = fromUserName; }

  @XmlElement(name="CreateTime")
  public String getCreateTime() {
    return this.CreateTime; }

  public void setCreateTime(String createTime) {
    this.CreateTime = createTime; }

  @XmlElement(name="MsgType")
  public String getMsgType() {
    return this.MsgType; }

  public void setMsgType(String msgType) {
    this.MsgType = msgType; }

  @XmlElement(name="Event")
  public String getEvent() {
    return this.Event; }

  public void setEvent(String event) {
    this.Event = event; }

  @XmlElement(name="EventKey")
  public String getEventKey() {
    return this.EventKey; }

  public void setEventKey(String eventKey) {
    this.EventKey = eventKey; }

  @XmlElement(name="Content")
  public String getContent() {
    return this.Content; }

  public void setContent(String content) {
    this.Content = content; }

  @XmlElement(name="Status")
  public String getStatus() {
    return this.Status; }

  public void setStatus(String status) {
    this.Status = status; }

  @XmlElement(name="Latitude")
  public String getLatitude() {
    return this.Latitude; }

  public void setLatitude(String latitude) {
    this.Latitude = latitude; }

  @XmlElement(name="Longitude")
  public String getLongitude() {
    return this.Longitude; }

  public void setLongitude(String longitude) {
    this.Longitude = longitude; }

  @XmlElement(name="Precision")
  public String getPrecision() {
    return this.Precision; }

  public void setPrecision(String precision) {
    this.Precision = precision; }

  @XmlElement(name="Ticket")
  public String getTicket() {
    return this.Ticket; }

  public void setTicket(String ticket) {
    this.Ticket = ticket; }

  @XmlElement(name="ThumbMediaId")
  public String getThumbMediaId() {
    return this.ThumbMediaId; }

  public void setThumbMediaId(String thumbMediaId) {
    this.ThumbMediaId = thumbMediaId; }

  @XmlElement(name="ScanCodeInfo")
  public ScanCodeInfo getScanCodeInfo() {
    return this.ScanCodeInfo; }

  public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
    this.ScanCodeInfo = scanCodeInfo; }

  @XmlElement(name="SendPicsInfo")
  public SendPicsInfo getSendPicsInfo() {
    return this.SendPicsInfo; }

  public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
    this.SendPicsInfo = sendPicsInfo; }

  @XmlElement(name="SendLocationInfo")
  public SendLocationInfo getSendLocationInfo() {
    return this.SendLocationInfo; }

  public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
    this.SendLocationInfo = sendLocationInfo;
  }
}