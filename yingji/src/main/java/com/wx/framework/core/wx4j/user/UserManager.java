package com.wx.framework.core.wx4j.user;

import com.alibaba.fastjson.JSON;
import com.wx.framework.core.wx4j.exception.WeChatException;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.token.TokenProxy;
import com.wx.framework.core.wx4j.util.WeChatUtil;
import java.io.PrintStream;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class UserManager
{
  Logger logger = Logger.getLogger(UserManager.class);
  private String accessToken;
  private static final String USRE_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=";
  private static final String USER_UPDATE_REMARK_POST_URL = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=";
  private static final String USER_INFO_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=";
  private static final String GROUP_CREATE_POST_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=";
  private static final String GROUP_GET_POST_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=";
  private static final String GROUP_GETID_POST_URL = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=";
  private static final String GROUP_UPDATE_POST_URL = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=";
  private static final String GROUP_MEMBERS_UPDATE_POST_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=";
  private static final String GROUP_MEMBERS_DATCHUPDATE_POST_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=";
  private static final String GROUP_DELETE_POST_URL = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=";

  public UserManager()
  {
    this.accessToken = TokenProxy.accessToken();
  }

  public List<String> allSubscriber()
  {
    Follwers follwers = subscriberList();
    String nextOpenId = follwers.getNextOpenid();
    while (StringUtils.isNotBlank(nextOpenId)) {
      Follwers f = subscriberList(nextOpenId);
      nextOpenId = f.getNextOpenid();
      if (f.getData() != null)
        follwers.getData().getOpenid().addAll(f.getData().getOpenid());
    }

    return follwers.getData().getOpenid();
  }

  public Follwers subscriberList()
  {
    return subscriberList(null);
  }

  public Follwers subscriberList(String nextOpenId)
  {
    String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + this.accessToken;
    if (StringUtils.isNotBlank(nextOpenId))
      url = url + "&next_openid=" + nextOpenId;

    String resultStr = HttpUtils.get(url);
    this.logger.info("return data " + resultStr);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      this.logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    return ((Follwers)com.alibaba.fastjson.JSONObject.parseObject(resultStr, Follwers.class));
  }

  public void updateRemark(String openId, String remark)
    throws WeChatException
  {
    com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
    jsonObject.put("openid", openId);
    jsonObject.put("remark", remark);
    String requestData = jsonObject.toString();
    this.logger.info("request data " + requestData);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=" + this.accessToken, requestData);
    this.logger.info("return data " + resultStr);
    WeChatUtil.isSuccess(resultStr);
  }

  public User getUserInfo(String openId)
  {
    return getUserInfo(openId, null);
  }

  public User getUserInfo(String openId, LanguageType lang)
  {
    String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + this.accessToken + "&openid=" + openId;
    if (lang != null)
      url = url + "&lang=" + lang.name();

    net.sf.json.JSONObject json = HttpUtils.httpsRequest(url, "GET", null);
    String resultStr = json.toString();
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      this.logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    User user = (User)com.alibaba.fastjson.JSONObject.parseObject(resultStr, User.class);
    return user;
  }

  public Group createGroup(String name)
    throws WeChatException
  {
    com.alibaba.fastjson.JSONObject nameJson = new com.alibaba.fastjson.JSONObject();
    com.alibaba.fastjson.JSONObject groupJson = new com.alibaba.fastjson.JSONObject();
    nameJson.put("name", name);
    groupJson.put("group", nameJson);
    String requestData = groupJson.toString();
    this.logger.info("request data " + requestData);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/groups/create?access_token=" + this.accessToken, requestData);
    this.logger.info("return data " + resultStr);
    WeChatUtil.isSuccess(resultStr);
    return ((Group)com.alibaba.fastjson.JSONObject.parseObject(resultStr).getObject("group", Group.class));
  }

  public List<Group> getGroup()
  {
    String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=" + this.accessToken;
    net.sf.json.JSONObject resultStr = HttpUtils.httpsRequest(requestUrl, "POST", null);
    this.logger.info("return data " + resultStr);
    List groups = JSON.parseArray(resultStr.getString("groups"), Group.class);
    return groups;
  }

  public Integer getIdGroup(String openId)
  {
    com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
    jsonObject.put("openid", openId);

    String requestData = jsonObject.toString();
    this.logger.info("request data " + requestData);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=" + this.accessToken, requestData);
    this.logger.info("return data " + resultStr);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      this.logger.error(e.getMessage());
      e.printStackTrace();
      return null;
    }
    com.alibaba.fastjson.JSONObject resultJson = com.alibaba.fastjson.JSONObject.parseObject(resultStr);
    int groupId = resultJson.getIntValue("groupid");
    return Integer.valueOf(groupId);
  }

  public void updateGroup(int groupId, String name)
    throws WeChatException
  {
    com.alibaba.fastjson.JSONObject nameJson = new com.alibaba.fastjson.JSONObject();
    com.alibaba.fastjson.JSONObject groupJson = new com.alibaba.fastjson.JSONObject();
    nameJson.put("id", Integer.valueOf(groupId));
    nameJson.put("name", name);
    groupJson.put("group", nameJson);
    String requestData = groupJson.toString();
    this.logger.info("request data " + requestData);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/groups/update?access_token=" + this.accessToken, requestData);
    this.logger.info("return data " + resultStr);
    WeChatUtil.isSuccess(resultStr);
  }

  public void membersUpdateGroup(String openId, int groupId)
    throws WeChatException
  {
    com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
    jsonObject.put("openid", openId);
    jsonObject.put("to_groupid", Integer.valueOf(groupId));
    String requestData = jsonObject.toString();
    this.logger.info("request data " + requestData);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=" + this.accessToken, requestData);
    this.logger.info("return data " + resultStr);
    WeChatUtil.isSuccess(resultStr);
  }

  public void membersDatchUpdateGroup(String[] openIds, int groupId)
    throws WeChatException
  {
    com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
    jsonObject.put("openid_list", openIds);
    jsonObject.put("to_groupid", Integer.valueOf(groupId));
    String requestData = jsonObject.toString();
    this.logger.info("request data " + requestData);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=" + this.accessToken, requestData);
    this.logger.info("return data " + resultStr);
    WeChatUtil.isSuccess(resultStr);
  }

  public void deleteGroup(int groupId)
    throws WeChatException
  {
    com.alibaba.fastjson.JSONObject idJson = new com.alibaba.fastjson.JSONObject();
    idJson.put("id", Integer.valueOf(groupId));
    com.alibaba.fastjson.JSONObject groupJson = new com.alibaba.fastjson.JSONObject();
    groupJson.put("group", idJson);
    String requestData = groupJson.toJSONString();
    this.logger.info("request data " + requestData);
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=" + this.accessToken, requestData);
    this.logger.info("return data " + resultStr);
    WeChatUtil.isSuccess(resultStr); }

  public static void main(String[] args) {
    UserManager mg = new UserManager();
    User u = mg.getUserInfo("oq2l3uO1xtFBgx3VsWB6wrrbTf3w", LanguageType.zh_CN);
    System.out.println(u.getNickName());
    System.out.println(u.getProvince());
  }
}