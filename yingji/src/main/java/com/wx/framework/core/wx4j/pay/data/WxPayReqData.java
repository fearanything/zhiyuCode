package com.wx.framework.core.wx4j.pay.data;

import com.wx.framework.core.wx4j.pay.common.RandomStringGenerator;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class WxPayReqData
{
  private String appid = "";
  private String mch_id = "";
  private String device_info = "WEB";
  private String nonce_str = "";
  private String sign = "";
  private String body = "";
  private String attach = "";
  private String out_trade_no = "";
  private int total_fee = 0;
  private String spbill_create_ip = "";
  private String time_start = "";
  private String time_expire = "";
  private String goods_tag = "";
  private String auth_code = "";
  private String notify_url = "";
  private String trade_type = "JSAPI";
  private String product_id = "";
  private String openid = "";

  public WxPayReqData(String appid, String mchId, String openId, String authCode, String body, String attach, String outTradeNo, int totalFee, String deviceInfo, String spBillCreateIP, String timeStart, String timeExpire, String goodsTag, String tradeType, String notify_url, String nonce_str)
  {
    setAppid(appid);

    setMch_id(mchId);

    setOpenid(openId);

    setAuth_code(authCode);

    setBody(body);

    setAttach(attach);

    setOut_trade_no(outTradeNo);

    setTotal_fee(totalFee);

    setDevice_info(deviceInfo);

    setSpbill_create_ip(spBillCreateIP);

    setTime_start(timeStart);

    setTime_expire(timeExpire);

    setGoods_tag(goodsTag);

    setTrade_type(tradeType);

    setNotify_url(notify_url);

    setNonce_str(nonce_str);

    System.out.println("统一支付订单：" + toMap());
    String sign = RandomStringGenerator.getSign(toMap());
    System.out.println("统一支付订单签名：" + sign);

    setSign(sign);
  }

  public String getAppid()
  {
    return this.appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getMch_id() {
    return this.mch_id;
  }

  public void setMch_id(String mch_id) {
    this.mch_id = mch_id;
  }

  public String getDevice_info() {
    return this.device_info;
  }

  public void setDevice_info(String device_info) {
    this.device_info = device_info;
  }

  public String getNonce_str() {
    return this.nonce_str;
  }

  public void setNonce_str(String nonce_str) {
    this.nonce_str = nonce_str;
  }

  public String getSign() {
    return this.sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getAttach() {
    return this.attach;
  }

  public void setAttach(String attach) {
    this.attach = attach;
  }

  public String getOut_trade_no() {
    return this.out_trade_no;
  }

  public void setOut_trade_no(String out_trade_no) {
    this.out_trade_no = out_trade_no;
  }

  public int getTotal_fee() {
    return this.total_fee;
  }

  public void setTotal_fee(int total_fee) {
    this.total_fee = total_fee;
  }

  public String getSpbill_create_ip() {
    return this.spbill_create_ip;
  }

  public void setSpbill_create_ip(String spbill_create_ip) {
    this.spbill_create_ip = spbill_create_ip;
  }

  public String getTime_start() {
    return this.time_start;
  }

  public void setTime_start(String time_start) {
    this.time_start = time_start;
  }

  public String getTime_expire() {
    return this.time_expire;
  }

  public void setTime_expire(String time_expire) {
    this.time_expire = time_expire;
  }

  public String getGoods_tag() {
    return this.goods_tag;
  }

  public void setGoods_tag(String goods_tag) {
    this.goods_tag = goods_tag;
  }

  public String getAuth_code() {
    return this.auth_code;
  }

  public void setAuth_code(String auth_code) {
    this.auth_code = auth_code;
  }

  public String getNotify_url() {
    return this.notify_url;
  }

  public void setNotify_url(String notify_url) {
    this.notify_url = notify_url;
  }

  public String getTrade_type() {
    return this.trade_type;
  }

  public void setTrade_type(String trade_type) {
    this.trade_type = trade_type;
  }

  public String getProduct_id() {
    return this.product_id;
  }

  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }

  public String getOpenid() {
    return this.openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public Map<String, Object> toMap() {
    Map map = new HashMap();
    Field[] fields = super.getClass().getDeclaredFields();
    Field[] arr$ = fields; int len$ = arr$.length; for (int i$ = 0; i$ < len$; ) { Field field = arr$[i$];
      try
      {
        Object obj = field.get(this);
        if (obj != null)
          map.put(field.getName(), obj);
      }
      catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
      ++i$;
    }

    return map;
  }
}