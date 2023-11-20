package com.wx.framework.core.wx4j.response;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
public class WechatResponse
{
  private String ToUserName;
  private String FromUserName;
  private String CreateTime;
  private String MsgType;
  private String Content;
  private String ArticleCount;
  private ImageResponse Image;
  private VoiceResponse Voice;
  private VideoResponse Video;
  private MusicResponse Music;
  private List<ArticleResponse> article;
  private TransInfoResponse TransInfo;
  public static String[] CDATA_TAG = { "ToUserName", "FromUserName", "MsgType", "Event", "MsgId", "Content", "MediaId", "Title", "Description", "MusicUrl", "HQMusicUrl", "ThumbMediaId", "PicUrl", "Url" };

  @XmlElement(name="ToUserName")
  public String getToUserName()
  {
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

  @XmlElement(name="Content")
  public String getContent() {
    return this.Content; }

  public void setContent(String content) {
    this.Content = content; }

  @XmlElement(name="ArticleCount")
  public String getArticleCount() {
    return this.ArticleCount; }

  public void setArticleCount(String articleCount) {
    this.ArticleCount = articleCount;
  }

  @XmlElement(name="Image")
  public ImageResponse getImage() {
    return this.Image; }

  public void setImage(ImageResponse image) {
    this.Image = image; }

  @XmlElement(name="Voice")
  public VoiceResponse getVoice() {
    return this.Voice; }

  public void setVoice(VoiceResponse voice) {
    this.Voice = voice; }

  @XmlElement(name="Video")
  public VideoResponse getVideo() {
    return this.Video; }

  public void setVideo(VideoResponse video) {
    this.Video = video; }

  @XmlElement(name="Music")
  public MusicResponse getMusic() {
    return this.Music; }

  public void setMusic(MusicResponse music) {
    this.Music = music; }

  @XmlElementWrapper(name="Articles")
  @XmlElement(name="item")
  public List<ArticleResponse> getArticle() {
    return this.article; }

  public void setArticle(List<ArticleResponse> article) {
    this.article = article; }

  @XmlElement(name="TransInfo")
  public TransInfoResponse getTransInfo() {
    return this.TransInfo; }

  public void setTransInfo(TransInfoResponse transInfo) {
    this.TransInfo = transInfo;
  }
}