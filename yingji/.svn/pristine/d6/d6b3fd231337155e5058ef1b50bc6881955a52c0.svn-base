package com.wx.framework.core.wx4j.csc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.exception.WeChatException;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.token.TokenProxy;
import com.wx.framework.core.wx4j.util.WeChatUtil;
import java.io.File;
import java.util.List;
import org.apache.log4j.Logger;

public class CustomerServicesManager
{
  private static Logger logger = Logger.getLogger(CustomerServicesManager.class);
  private static final String CUSTOMSERVICE_KFSESSION_CREATE_POST_URL = "https://api.weixin.qq.com/customservice/kfsession/create?access_token=";
  private static final String CUSTOMSERVICE_KFSESSION_CLOSE_POST_URL = "https://api.weixin.qq.com/customservice/kfsession/close?access_token=";
  private static final String CUSTOMSERVICE_KFSESSION_GETSESSION_GET_URL = "https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=";
  private static final String CUSTOMSERVICE_KFSESSION_GETSESSIONLIST_GET_URL = "https://api.weixin.qq.com/customservice/kfsession/getsessionlist?access_token=";
  private static final String CUSTOMSERVICE_KFSESSION_GETWAITCASE_GET_URL = "https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token=";
  private static final String CUSTOMSERVICE_GETKFLIST_GET_URL = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=";
  private static final String CUSTOMSERVICE_GETONLIEKFLIST_GET_URL = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=";
  private static final String CUSTOMSERVICE_KFACCOUNT_ADD_POST_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=";
  private static final String CUSTOMSERVICE_KFACCOUNT_UPDATE_POST_URL = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=";
  private static final String CUSTOMSERVICE_KFACCOUNT_UPLOADHEADIMG_POST_URL = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=";
  private static final String CUSTOMSERVICE_KFACCOUNT_DEL_POST_URL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=";
  private static final String CUSTOMSERVICE_MSGRECORD_GETRECORD_POST_URL = "https://api.weixin.qq.com/customservice/msgrecord/getrecord?access_token=";
  private static final String PARAM_FILE = "media";
  private String accessToken;

  public CustomerServicesManager()
  {
    this.accessToken = TokenProxy.accessToken();
  }

  public void kfSessionCreate(String openId, String kfAccount)
    throws WeChatException
  {
    kfSessionCreate(openId, kfAccount, null);
  }

  public void kfSessionCreate(String openId, String kfAccount, String text)
    throws WeChatException
  {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("openid", openId);
    jsonObject.put("kf_account", kfAccount);
    if (text != null)
      jsonObject.put("text", text);

    String resultStr = HttpUtils.post("https://api.weixin.qq.com/customservice/kfsession/create?access_token=" + this.accessToken, jsonObject.toJSONString());
    WeChatUtil.isSuccess(resultStr);
  }

  public void kfSessionClose(String openId, String kfAccount)
    throws WeChatException
  {
    kfSessionClose(openId, kfAccount, null);
  }

  public void kfSessionClose(String openId, String kfAccount, String text)
    throws WeChatException
  {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("openid", openId);
    jsonObject.put("kf_account", kfAccount);
    if (text != null)
      jsonObject.put("text", text);

    String resultStr = HttpUtils.post("https://api.weixin.qq.com/customservice/kfsession/close?access_token=" + this.accessToken, jsonObject.toJSONString());
    WeChatUtil.isSuccess(resultStr);
  }

  public CustomerServicesSession getSession(String openId)
  {
    String resultStr = HttpUtils.get("https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=" + this.accessToken + "&openid=" + openId);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    CustomerServicesSession customerServicesSession = (CustomerServicesSession)JSON.parseObject(resultStr, CustomerServicesSession.class);
    return customerServicesSession;
  }

  public List<CustomerServicesSession> getSessionList(String kfAccount)
  {
    String resultStr = HttpUtils.get("https://api.weixin.qq.com/customservice/kfsession/getsessionlist?access_token=" + this.accessToken + "&kf_account=" + kfAccount);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    String sessionlist = JSON.parseObject(resultStr).getString("sessionlist");
    List customerServicesSessions = JSON.parseArray(sessionlist, CustomerServicesSession.class);
    return customerServicesSessions;
  }

  public List<CustomerServicesSession> getWaitCaseList()
  {
    String resultStr = HttpUtils.get("https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token=" + this.accessToken);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    String waitcaselist = JSON.parseObject(resultStr).getString("waitcaselist");
    List customerServicesSessions = JSON.parseArray(waitcaselist, CustomerServicesSession.class);
    return customerServicesSessions;
  }

  public List<CustomerServices> getKfList()
  {
    String resultStr = HttpUtils.get("https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=" + this.accessToken);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    String kf_list = JSONObject.parseObject(resultStr).getString("kf_list");
    List list = JSON.parseArray(kf_list, CustomerServices.class);
    return list;
  }

  public List<CustomerServices> getOnlieKfList()
  {
    String resultStr = HttpUtils.get("https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=" + this.accessToken);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    JSONObject jsonObject = JSONObject.parseObject(resultStr);
    List list = JSON.parseArray(jsonObject.getString("kf_online_list"), CustomerServices.class);
    return list;
  }

  public void kfAddAccount(String kfAccount, String nickName, String password)
    throws WeChatException
  {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("kf_account", kfAccount);
    jsonObject.put("nickname", nickName);
    jsonObject.put("password", password);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/customservice/kfaccount/add?access_token=" + this.accessToken, jsonObject.toJSONString());
    WeChatUtil.isSuccess(resultStr);
  }

  public void kfUpdateAccount(String kfAccount, String nickName, String password)
    throws WeChatException
  {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("kf_account", kfAccount);
    jsonObject.put("nickname", nickName);
    jsonObject.put("password", password);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/customservice/kfaccount/update?access_token=" + this.accessToken, jsonObject.toJSONString());
    WeChatUtil.isSuccess(resultStr);
  }

  public void kfUploadHeadImg(String kfAccount, File file)
    throws WeChatException
  {
    String resultStr = HttpUtils.postFile("http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=" + this.accessToken + "&kf_account=" + kfAccount, "media", file);
    WeChatUtil.isSuccess(resultStr);
  }

  public void kfDelAccount(String kfAccount)
    throws WeChatException
  {
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/customservice/kfaccount/del?access_token=" + this.accessToken + "&kf_account=" + kfAccount);
    WeChatUtil.isSuccess(resultStr);
  }

  public List<Record> getRecord(long starttime, long endtime, int pageindex, int pagesize)
  {
    JSONObject data = new JSONObject();
    data.put("endtime", Long.valueOf(endtime));
    data.put("pageindex", Integer.valueOf(pageindex));
    data.put("pagesize", Integer.valueOf(pagesize));
    data.put("starttime", Long.valueOf(starttime));
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/customservice/msgrecord/getrecord?access_token=" + this.accessToken, data.toJSONString());
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    String recordlist = JSON.parseObject(resultStr).getString("recordlist");
    List records = JSON.parseArray(recordlist, Record.class);
    return records;
  }
}