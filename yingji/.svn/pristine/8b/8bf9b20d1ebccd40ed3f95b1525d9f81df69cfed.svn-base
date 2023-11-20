package com.wx.framework.core.wx4j.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.event.MsgType;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.response.ArticleResponse;
import com.wx.framework.core.wx4j.response.MusicResponse;
import com.wx.framework.core.wx4j.response.VideoResponse;
import com.wx.framework.core.wx4j.token.TokenProxy;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class CustomerMsg
{
  private static Logger logger = Logger.getLogger(CustomerMsg.class);
  private static final String MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
  private String toUserOpenId;
  private String msgType;
  private String msgBody;

  public CustomerMsg(String toUserOpenId)
  {
    this.toUserOpenId = toUserOpenId;
  }

  private void send()
  {
    String accessToken = TokenProxy.accessToken();

    if (StringUtils.isBlank(this.toUserOpenId))
      return;

    if (StringUtils.isBlank(accessToken)) {
      logger.error("发送失败，无法得到accessToken");
      return;
    }

    if (StringUtils.isNotBlank(accessToken)) {
      String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
      System.out.println("msgBody=" + this.msgBody);
      HttpUtils.post(url, this.msgBody);
    }
  }

  public void sendText(String content)
  {
    this.msgType = MsgType.text.name();

    JSONObject jsonMsg = new JSONObject();
    jsonMsg.put("content", content);
    JSONObject json = new JSONObject();
    json.put("touser", this.toUserOpenId);
    json.put("msgtype", this.msgType);
    json.put("text", jsonMsg);
    this.msgBody = json.toJSONString();
    send();
  }

  public void sendImage(String mediaId)
  {
    this.msgType = MsgType.image.name();

    JSONObject jsonMsg = new JSONObject();
    jsonMsg.put("media_id", mediaId);

    JSONObject json = new JSONObject();
    json.put("touser", this.toUserOpenId);
    json.put("msgtype", this.msgType);
    json.put("image", jsonMsg);

    this.msgBody = json.toJSONString();

    send();
  }

  public void sendVoice(String mediaId)
  {
    this.msgType = MsgType.voice.name();

    JSONObject jsonMsg = new JSONObject();
    jsonMsg.put("media_id", mediaId);

    JSONObject json = new JSONObject();
    json.put("touser", this.toUserOpenId);
    json.put("msgtype", this.msgType);
    json.put("voice", jsonMsg);

    this.msgBody = json.toJSONString();
    send();
  }

  public void sendVideo(String title, String description, String mediaId, String thumbMediaId)
  {
    VideoResponse video = new VideoResponse();
    video.setTitle(title);
    video.setDescription(description);
    video.setMediaId(thumbMediaId);
    video.setThumbMediaId(thumbMediaId);
    sendVideo(video);
  }

  public void sendVideo(VideoResponse video)
  {
    this.msgType = MsgType.video.name();

    JSONObject jsonMsg = new JSONObject();
    jsonMsg.put("media_id", video.getMediaId());
    jsonMsg.put("thumb_media_id", video.getThumbMediaId());
    jsonMsg.put("title", video.getTitle());
    jsonMsg.put("description", video.getDescription());

    JSONObject json = new JSONObject();
    json.put("touser", this.toUserOpenId);
    json.put("msgtype", this.msgType);
    json.put("video", jsonMsg);

    this.msgBody = json.toJSONString();
    send();
  }

  public void sendMusic(String title, String description, String musicURL, String hQMusicUrl, String thumbMediaId)
  {
    MusicResponse music = new MusicResponse();
    music.setTitle(title);
    music.setDescription(description);
    music.setMusicURL(musicURL);
    music.setHQMusicUrl(hQMusicUrl);
    music.setThumbMediaId(thumbMediaId);
    sendMusic(music);
  }

  public void sendMusic(MusicResponse music)
  {
    this.msgType = MsgType.music.name();

    JSONObject jsonMsg = new JSONObject();
    jsonMsg.put("title", music.getTitle());
    jsonMsg.put("description", music.getDescription());
    jsonMsg.put("musicurl", music.getMusicURL());
    jsonMsg.put("hqmusicurl", music.getHQMusicUrl());
    jsonMsg.put("thumb_media_id", music.getThumbMediaId());

    JSONObject json = new JSONObject();
    json.put("touser", this.toUserOpenId);
    json.put("msgtype", this.msgType);
    json.put("music", jsonMsg);

    this.msgBody = json.toJSONString();
    send();
  }

  public void sendNew(String title, String description, String picUrl, String url)
  {
    ArticleResponse item = new ArticleResponse();
    item.setTitle(title);
    item.setDescription(description);
    item.setPicUrl(picUrl);
    item.setUrl(url);
    sendNews(item);
  }

  public void sendNews(ArticleResponse item)
  {
    List items = new ArrayList();
    items.add(item);
    sendNews(items);
  }

  public void sendNews(List<ArticleResponse> items)
  {
    this.msgType = MsgType.news.name();
    JSONArray jsonArray = new JSONArray();
    for (Iterator i$ = items.iterator(); i$.hasNext(); ) { ArticleResponse item = (ArticleResponse)i$.next();
      JSONObject jsonItem = new JSONObject();
      jsonItem.put("title", item.getTitle());
      jsonItem.put("description", item.getDescription());
      jsonItem.put("url", item.getUrl());
      jsonItem.put("picurl", item.getPicUrl());

      jsonArray.add(jsonItem);
    }

    JSONObject jsonMsg = new JSONObject();
    jsonMsg.put("articles", jsonArray);

    JSONObject json = new JSONObject();
    json.put("touser", this.toUserOpenId);
    json.put("msgtype", this.msgType);
    json.put("news", jsonMsg);

    this.msgBody = json.toJSONString();
    send();
  }
}