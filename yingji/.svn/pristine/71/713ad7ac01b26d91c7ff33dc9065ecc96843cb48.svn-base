package com.wx.framework.core.wx4j.message;

import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.message.template.TemplateMsgBody;
import com.wx.framework.core.wx4j.message.template.TemplateMsgData;
import com.wx.framework.core.wx4j.token.TokenProxy;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

public class TemplateMsg
{
  private static Logger logger = Logger.getLogger(TemplateMsg.class);
  public static final String SET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
  public static final String GET_TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";
  public static final String SEND_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
  private String accessToken;

  public TemplateMsg()
  {
    this.accessToken = TokenProxy.accessToken();
  }

  public void setIndustry(String[] industrys)
  {
    String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=" + this.accessToken;
    JSONObject json = new JSONObject();
    for (int i = 0; i < industrys.length; ++i)
      json.put("industry_id" + i, industrys[i]);

    String data = json.toJSONString();
    HttpUtils.post(url, data);
  }

  public String getTemplateId(String templateIdShort)
  {
    logger.info("get template id,short template id is:" + templateIdShort);

    String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=" + this.accessToken;
    JSONObject json = new JSONObject();
    json.put("template_id_short", templateIdShort);
    String data = json.toJSONString();
    System.out.println(data);
    String result = HttpUtils.post(url, data);
    logger.info("post result:" + result);

    JSONObject resultJson = JSONObject.parseObject(result);
    if (resultJson.getString("errcode").equals("0"))
      return resultJson.getString("template_id");
    logger.error("get template id error:" + resultJson.getString("errmsg"));
    return null;
  }

  public String send(TemplateMsgBody postData)
  {
    logger.info("send template message");

    String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + this.accessToken;
    JSONObject json = new JSONObject();
    json.put("touser", postData.getTouser());
    json.put("template_id", postData.getTemplateId());
    json.put("url", postData.getUrl());
    json.put("topcolor", postData.getTopcolor());
    JSONObject jsonData = new JSONObject();
    for (Iterator i$ = postData.getData().iterator(); i$.hasNext(); ) { TemplateMsgData data = (TemplateMsgData)i$.next();
      JSONObject keynote = new JSONObject();
      keynote.put("value", data.getValue());
      keynote.put("color", data.getColor());
      jsonData.put(data.getName(), keynote);
    }
    json.put("data", jsonData);

    String data = json.toJSONString();
    String result = HttpUtils.post(url, data);
    logger.info("post result:" + result);

    JSONObject resultJson = JSONObject.parseObject(result);
    if (resultJson.getString("errcode").equals("0"))
      return resultJson.getString("msgid");

    logger.error("send template message error:" + resultJson.getString("errmsg"));
    return null;
  }

  public static void main(String[] args) {
    TemplateMsg msg = new TemplateMsg();
    TemplateMsgBody body = new TemplateMsgBody();
    body.setTemplateId("5Edz9rY2NtMIHYKWg49q4kch7rwlCeiwmq8N2JbDdq0");
    body.setTouser("otTUvwSkWg1nRzuj5ppuJNvroGWw");
    body.setTopcolor("red");
    List list = new ArrayList();
    TemplateMsgData data1 = new TemplateMsgData();
    data1.setColor("red");
    data1.setName("first");
    data1.setValue("微信预约通知");

    TemplateMsgData data2 = new TemplateMsgData();
    data2.setColor("#173177");
    data2.setName("keyword1");
    data2.setValue("方坚");

    TemplateMsgData data3 = new TemplateMsgData();
    data3.setColor("#173177");
    data3.setName("keyword2");
    data3.setValue("13825160872");

    TemplateMsgData data4 = new TemplateMsgData();
    data4.setColor("#173177");
    data4.setName("keyword3");
    data4.setValue("隐形矫正");

    TemplateMsgData data5 = new TemplateMsgData();
    data5.setColor("#173177");
    data5.setName("keyword4");
    data5.setValue("2016-05-18 14:00-15:00");

    TemplateMsgData data6 = new TemplateMsgData();
    data6.setColor("#173177");
    data6.setName("remark");
    data6.setValue("请准时就诊，谢谢合作。");

    list.add(data1);
    list.add(data2);
    list.add(data3);
    list.add(data4);
    list.add(data5);
    list.add(data6);
    body.setData(list);
    msg.send(body);
  }
}