package com.wx.framework.core.wx4j.ai;

import com.wx.framework.core.wx4j.WechatSupport;
import com.wx.framework.core.wx4j.request.Item;
import com.wx.framework.core.wx4j.request.ScanCodeInfo;
import com.wx.framework.core.wx4j.request.SendLocationInfo;
import com.wx.framework.core.wx4j.request.SendPicsInfo;
import com.wx.framework.core.wx4j.request.WechatRequest;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class MyWechat extends WechatSupport
{
  private static Logger logger = Logger.getLogger(MyWechat.class);

  public MyWechat(HttpServletRequest request)
  {
    super(request);
  }

  protected void onText()
  {
    String content = this.wechatRequest.getContent().trim();

    if (content.equals("1")) {
      responseText("你好，hello world!<a href=\"http://www.baidu.com\">这是链接</a>");
    }
    else if (content.equals("2")) {
      responseNew("图文消息", "测试图文消息", "http://upload.qqfuzhi.com/portal/showimg.php?img=e2dnYyk8PHEhIys9Y3t8Z3w9YGd8YXY9YmI9cHx%2BPHtnZ2NMen50f3xydz1wdHosPGFmYX8nTHEuJ3Z2IXFyJnUiICAqcnAnInYhcHJ2InAnKndycidwKyAgdnIqdiN1KitxdyojIysjcSAiJipyK3YqIXd1JCt1JyBxKnIkcCt1JyYkKysicCAjIiokKyogcHd1ICAhcXArciUjI3EhdyYjKiIncSclIiUqJyAkInEgKiV2IiEiJnEgKyp2cXV3cCEmJ3EjcHYqJHIrdytwIyYgIHIicHAgcXFwIiIldyIhNXIuISMrNXEuISMr", "http://www.chengn.com");
    }
    else
    {
      responseText("你好，你的输入为: " + content + "\n" + "请按照如下操作输入:\n" + "1 文本\n" + "2 图文\n");
    }
  }

  protected void onImage()
  {
    String picUrl = this.wechatRequest.getPicUrl();
    String MediaId = this.wechatRequest.getMediaId();
    String MsgId = this.wechatRequest.getMsgId();

    String result = "图片消息picUrl:" + picUrl + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
    logger.info(result);
    responseText(result);
  }

  protected void onVoice()
  {
    String Format = this.wechatRequest.getFormat();
    String MediaId = this.wechatRequest.getMediaId();
    String MsgId = this.wechatRequest.getMsgId();

    String result = "语音消息Format:" + Format + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
    logger.info(result);
    responseText(result);
  }

  protected void onVideo()
  {
    String ThumbMediaId = this.wechatRequest.getThumbMediaId();
    String MediaId = this.wechatRequest.getMediaId();
    String MsgId = this.wechatRequest.getMsgId();

    String result = "视频消息ThumbMediaId:" + ThumbMediaId + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
    logger.info(result);
    responseText(result);
  }

  protected void onLocation()
  {
    String Location_X = this.wechatRequest.getLocation_X();
    String Location_Y = this.wechatRequest.getLocation_Y();
    String Scale = this.wechatRequest.getScale();
    String Label = this.wechatRequest.getLabel();
    String MsgId = this.wechatRequest.getMsgId();

    String result = "地理位置消息Location_X:" + Location_X + ", Location_Y:" + Location_Y + ", Scale:" + Scale + ", Label:" + Label + ", MsgId:" + MsgId;

    logger.info(result);
    responseText(result);
  }

  protected void onLink()
  {
    String Title = this.wechatRequest.getTitle();
    String Description = this.wechatRequest.getDescription();
    String Url = this.wechatRequest.getUrl();
    String MsgId = this.wechatRequest.getMsgId();

    String result = "链接消息Title:" + Title + ", Description:" + Description + ", Url:" + Url + ", MsgId:" + MsgId;

    logger.info(result);
    responseText(result);
  }

  protected void onUnknown()
  {
    String msgType = this.wechatRequest.getMsgType();

    String result = "未知消息msgType:" + msgType;
    logger.info(result);
    responseText(result);
  }

  protected void scan()
  {
    String FromUserName = this.wechatRequest.getFromUserName();
    String Ticket = this.wechatRequest.getTicket();

    String result = "扫描二维码事件FromUserName:" + FromUserName + ", Ticket:" + Ticket;
    logger.info(result);
    responseText(result);
  }

  protected void subscribe()
  {
    String FromUserName = this.wechatRequest.getFromUserName();

    String Ticket = this.wechatRequest.getTicket();

    String result = "谢谢关注";
    if (StringUtils.isNotBlank(Ticket))
      result = "扫描带场景值二维码事件FromUserName:" + FromUserName + ", Ticket:" + Ticket;

    logger.info(result);
    responseText(result);
  }

  protected void unSubscribe()
  {
    String FromUserName = this.wechatRequest.getFromUserName();
    String result = "取消订阅事件FromUserName:" + FromUserName;
    logger.info(result);
    responseText(result);
  }

  protected void view()
  {
    String link = this.wechatRequest.getEventKey();
    logger.info("点击菜单跳转链接时的事件推送link:" + link);
    responseText("点击菜单跳转链接时的事件推送link:" + link);
  }

  protected void click()
  {
    String key = this.wechatRequest.getEventKey();
    logger.info("自定义菜单事件eventKey:" + key);
    responseText("自定义菜单事件eventKey:" + key);
  }

  protected void location()
  {
    String Latitude = this.wechatRequest.getLatitude();
    String Longitude = this.wechatRequest.getLongitude();
    String Precision = this.wechatRequest.getPrecision();
    String result = "上报地理位置事件Latitude:" + Latitude + ", Longitude:" + Longitude + ", Precision:" + Precision;
    logger.info(result);
    responseText(result);
  }

  protected void templateMsgCallback()
  {
    String MsgID = this.wechatRequest.getMsgId();
    String Status = this.wechatRequest.getStatus();
    String result = "模板消息发送成功推送事件MsgID:" + MsgID + ", Status:" + Status;
    logger.info(result);
  }

  protected void locationSelect()
  {
    String Location_X = this.wechatRequest.getSendLocationInfo().getLocation_X();
    String Location_Y = this.wechatRequest.getSendLocationInfo().getLocation_Y();
    String Scale = this.wechatRequest.getSendLocationInfo().getScale();
    String Label = this.wechatRequest.getSendLocationInfo().getLabel();
    String Poiname = this.wechatRequest.getSendLocationInfo().getPoiname();
    String result = "弹出地理位置选择器的事件Location_X:" + Location_X + ", Location_Y:" + Location_Y + ", Scale:" + Scale + ", Label:" + Label + ", Poiname:" + Poiname;

    logger.info(result);
    responseText(result);
  }

  protected void picPhotoOrAlbum()
  {
    String Count = this.wechatRequest.getSendPicsInfo().getCount();
    String PicMd5Sum = "";
    if ((StringUtils.isNotBlank(Count)) && (!(Count.equals("0"))))
      PicMd5Sum = ((Item)this.wechatRequest.getSendPicsInfo().getItem().get(0)).getPicMd5Sum();

    String result = "弹出系统拍照发图的事件Count:" + Count + ", PicMd5Sum:" + PicMd5Sum;
    logger.info(result);
    responseText(result);
  }

  protected void picSysPhoto()
  {
    String Count = this.wechatRequest.getSendPicsInfo().getCount();
    String result = "弹出系统拍照发图的事件Count:" + Count;
    logger.info(result);
    responseText(result);
  }

  protected void picWeixin()
  {
    String Count = this.wechatRequest.getSendPicsInfo().getCount();
    String result = "弹出系统拍照发图的事件Count:" + Count;
    logger.info(result);
    responseText(result);
  }

  protected void scanCodePush()
  {
    String ScanType = this.wechatRequest.getScanCodeInfo().getScanType();
    String ScanResult = this.wechatRequest.getScanCodeInfo().getScanResult();
    String result = "扫码推事件ScanType:" + ScanType + ", ScanResult:" + ScanResult;
    logger.info(result);
    responseText(result);
  }

  protected void scanCodeWaitMsg()
  {
    String ScanType = this.wechatRequest.getScanCodeInfo().getScanType();
    String ScanResult = this.wechatRequest.getScanCodeInfo().getScanResult();
    String result = "扫码推事件ScanType:" + ScanType + ", ScanResult:" + ScanResult;
    logger.info(result);
    responseText(result);
  }

  protected void onShortVideo()
  {
    String ThumbMediaId = this.wechatRequest.getThumbMediaId();
    String MediaId = this.wechatRequest.getMediaId();
    String MsgId = this.wechatRequest.getMsgId();

    String result = "小视频消息ThumbMediaId:" + ThumbMediaId + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
    logger.info(result);
    responseText(result);
  }

  protected void kfCreateSession()
  {
  }

  protected void kfCloseSession()
  {
  }

  protected void kfSwitchSession()
  {
  }
}