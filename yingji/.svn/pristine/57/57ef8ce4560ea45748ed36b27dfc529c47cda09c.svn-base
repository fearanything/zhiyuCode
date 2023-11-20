package com.wx.framework.core.wx4j;

import com.wx.framework.core.wx4j.event.EventType;
import com.wx.framework.core.wx4j.event.MsgType;
import com.wx.framework.core.wx4j.lang.JaxbParser;
import com.wx.framework.core.wx4j.lang.StreamUtils;
import com.wx.framework.core.wx4j.request.WechatRequest;
import com.wx.framework.core.wx4j.response.ArticleResponse;
import com.wx.framework.core.wx4j.response.ImageResponse;
import com.wx.framework.core.wx4j.response.MusicResponse;
import com.wx.framework.core.wx4j.response.TransInfoResponse;
import com.wx.framework.core.wx4j.response.VideoResponse;
import com.wx.framework.core.wx4j.response.VoiceResponse;
import com.wx.framework.core.wx4j.response.WechatResponse;
import com.wx.framework.core.wx4j.util.XmlHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public abstract class WechatSupport
{
  Logger logger = Logger.getLogger(WechatSupport.class);
  private HttpServletRequest request;
  protected WechatRequest wechatRequest;
  protected WechatResponse wechatResponse;

  public WechatSupport(HttpServletRequest request)
  {
    this.logger.info("WechatSupport reading......");
    this.request = request;
    this.wechatRequest = new WechatRequest();
    this.wechatResponse = new WechatResponse();
  }

  public String execute()
  {
    this.logger.info("WechatSupport execute.....");

    String result = dispatch();
    this.logger.info("WechatSupport execute return msg:" + result);
    return result;
  }

  private String dispatch()
  {
    String postDataStr = null;
    try {
      postDataStr = StreamUtils.streamToString(this.request.getInputStream());
    } catch (IOException e) {
      this.logger.error("post data deal failed!");
      e.printStackTrace();
    }

    setPostData(postDataStr);

    dispatchMessage();

    String result = response();

    return result;
  }

  private void setPostData(String xmlStr)
  {
    JaxbParser jaxbParser;
    try
    {
      jaxbParser = new JaxbParser(WechatRequest.class);
      this.wechatRequest = ((WechatRequest)jaxbParser.toObj(xmlStr));
    } catch (Exception e) {
      this.logger.error("post data parse error");
      e.printStackTrace();
    }
  }

  private void dispatchMessage()
  {
    this.logger.info("distributeMessage start");
    if (StringUtils.isBlank(this.wechatRequest.getMsgType()))
      this.logger.info("msgType is null");

    MsgType msgType = MsgType.valueOf(this.wechatRequest.getMsgType());
    this.logger.info("msgType is " + msgType.name());
    switch (msgType.ordinal())
    {
    case 1:
      dispatchEvent();
      break;
    case 2:
      onText();
      break;
    case 3:
      onImage();
      break;
    case 4:
      onVoice();
      break;
    case 5:
      onVideo();
      break;
    case 6:
      onShortVideo();
      break;
    case 7:
      onLocation();
      break;
    case 8:
      onLink();
      break;
    default:
      onUnknown();
    }
  }

  private void dispatchEvent()
  {
    EventType event = EventType.valueOf(this.wechatRequest.getEvent());
    this.logger.info("dispatch event,event is " + event.name());
    switch (event.ordinal())
    {
    case 1:
      click();
      break;
    case 2:
      subscribe();
      break;
    case 3:
      unSubscribe();
      break;
    case 4:
      scan();
      break;
    case 5:
      location();
      break;
    case 6:
      view();
      break;
    case 7:
      templateMsgCallback();
      break;
    case 8:
      scanCodePush();
      break;
    case 9:
      scanCodeWaitMsg();
      break;
    case 10:
      picSysPhoto();
      break;
    case 11:
      picPhotoOrAlbum();
      break;
    case 12:
      picWeixin();
      break;
    case 13:
      locationSelect();
      break;
    case 14:
      kfCreateSession();
      break;
    case 15:
      kfCloseSession();
      break;
    case 16:
      kfSwitchSession();
    }
  }

  private String response()
  {
    String result = null;
    try
    {
      result = XmlHelper.objectToXML(WechatResponse.class, this.wechatResponse);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  private void responseBase()
  {
    this.wechatResponse.setToUserName(this.wechatRequest.getFromUserName());
    this.wechatResponse.setFromUserName(this.wechatRequest.getToUserName());
    this.wechatResponse.setCreateTime(this.wechatRequest.getCreateTime());
  }

  public void responseText(String content)
  {
    responseBase();
    this.wechatResponse.setMsgType(MsgType.text.name());
    this.wechatResponse.setContent(content);
  }

  public void responseImage(String mediaId)
  {
    responseBase();
    this.wechatResponse.setMsgType(MsgType.image.name());
    ImageResponse image = new ImageResponse();
    image.setMediaId(mediaId);
    this.wechatResponse.setImage(image);
  }

  public void responseVoice(String mediaId)
  {
    responseBase();
    this.wechatResponse.setMsgType(MsgType.voice.name());
    VoiceResponse voice = new VoiceResponse();
    voice.setMediaId(mediaId);
    this.wechatResponse.setVoice(voice);
  }

  public void responseVideo(String mediaId, String title, String description)
  {
    VideoResponse video = new VideoResponse();
    video.setMediaId(mediaId);
    video.setTitle(title);
    video.setDescription(description);
    responseVideo(video);
  }

  public void responseVideo(VideoResponse video)
  {
    responseBase();
    this.wechatResponse.setMsgType(MsgType.video.name());
    this.wechatResponse.setVideo(video);
  }

  public void responseMusic(String title, String description, String musicURL, String hQMusicUrl, String thumbMediaId)
  {
    MusicResponse music = new MusicResponse();
    music.setTitle(title);
    music.setDescription(description);
    music.setMusicURL(musicURL);
    music.setHQMusicUrl(hQMusicUrl);
    music.setThumbMediaId(thumbMediaId);
    responseMusic(music);
  }

  public void responseMusic(MusicResponse music)
  {
    responseBase();
    this.wechatResponse.setMsgType(MsgType.music.name());
    this.wechatResponse.setMusic(music);
  }

  public void responseNew(String title, String description, String picUrl, String url)
  {
    ArticleResponse item = new ArticleResponse();
    item.setTitle(title);
    item.setDescription(description);
    item.setPicUrl(picUrl);
    item.setUrl(url);
    responseNews(item);
  }

  public void responseNews(ArticleResponse item)
  {
    List items = new ArrayList();
    items.add(item);
    responseNews(items);
  }

  public void responseNews(List<ArticleResponse> items)
  {
    responseBase();
    this.wechatResponse.setMsgType(MsgType.news.name());
    this.wechatResponse.setArticleCount(String.valueOf(items.size()));
    this.wechatResponse.setArticle(items);
  }

  public void responseCustomerService()
  {
    responseBase();
    this.wechatResponse.setMsgType(MsgType.transfer_customer_service.name());
  }

  public void responseCustomerService(String kfAccount)
  {
    responseBase();
    this.wechatResponse.setMsgType(MsgType.transfer_customer_service.name());
    this.wechatResponse.setTransInfo(new TransInfoResponse(kfAccount));
  }

  public void responseCustomerService(TransInfoResponse transInfo)
  {
    responseBase();
    this.wechatResponse.setMsgType(MsgType.transfer_customer_service.name());
    this.wechatResponse.setTransInfo(transInfo);
  }

  protected abstract void onText();

  protected abstract void onImage();

  protected abstract void onVoice();

  protected abstract void onVideo();

  protected abstract void onShortVideo();

  protected abstract void onLocation();

  protected abstract void onLink();

  protected abstract void onUnknown();

  protected abstract void click();

  protected abstract void subscribe();

  protected abstract void unSubscribe();

  protected abstract void scan();

  protected abstract void location();

  protected abstract void view();

  protected abstract void templateMsgCallback();

  protected abstract void scanCodePush();

  protected abstract void scanCodeWaitMsg();

  protected abstract void picSysPhoto();

  protected abstract void picPhotoOrAlbum();

  protected abstract void picWeixin();

  protected abstract void locationSelect();

  protected abstract void kfCreateSession();

  protected abstract void kfCloseSession();

  protected abstract void kfSwitchSession();
}