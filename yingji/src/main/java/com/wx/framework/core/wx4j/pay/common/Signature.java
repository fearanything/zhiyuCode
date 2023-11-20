package com.wx.framework.core.wx4j.pay.common;

import com.wx.framework.core.wx4j.common.Wx4javaConfig;
import com.wx.framework.core.wx4j.pay.notify.PayNotifyData;
import com.wx.framework.core.wx4j.pay.utils.XmlConverUtil;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

public class Signature
{
  private static Log logger = LogFactory.getLog(HttpService.class);

  public static String getSign(Object o)
    throws IllegalAccessException
  {
    String key = Wx4javaConfig.instance().getPaySignKey();
    ArrayList list = new ArrayList();
    Class cls = o.getClass();
    Field[] fields = cls.getDeclaredFields();
    Field[] arr$ = fields; int len$ = arr$.length; for (int i$ = 0; i$ < len$; ++i$) { Field f = arr$[i$];
      f.setAccessible(true);
      if ((f.get(o) != null) && (f.get(o) != ""))
        list.add(new StringBuilder().append(f.getName()).append("=").append(f.get(o)).append("&").toString());
    }

    int size = list.size();
    String[] arrayToSort = (String[])list.toArray(new String[size]);
    Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; ++i)
      sb.append(arrayToSort[i]);

    String result = sb.toString();
    result = new StringBuilder().append(result).append("key=").append(key).toString();
    logger.debug(new StringBuilder().append("Sign Before MD5:").append(result).toString());
    result = MD5.MD5Encode(result).toUpperCase();
    logger.debug(new StringBuilder().append("Sign Result:").append(result).toString());
    return result;
  }

  public static String getSign(Map<String, Object> map) {
    String key = Wx4javaConfig.instance().getPaySignKey();
    ArrayList list = new ArrayList();
    for (Iterator i$ = map.entrySet().iterator(); i$.hasNext(); ) { Map.Entry entry = (Map.Entry)i$.next();
      if (entry.getValue() != "")
        list.add(new StringBuilder().append((String)entry.getKey()).append("=").append(entry.getValue()).append("&").toString());
    }

    int size = list.size();
    String[] arrayToSort = (String[])list.toArray(new String[size]);
    Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; ++i)
      sb.append(arrayToSort[i]);

    String result = sb.toString();
    result = new StringBuilder().append(result).append("key=").append(key).toString();

    result = MD5.MD5Encode(result).toUpperCase();

    return result;
  }

  public static String getSignFromResponseString(String responseString)
    throws IOException, SAXException, ParserConfigurationException
  {
    Map map = XmlConverUtil.xmltoMap(responseString);

    map.put("sign", "");
    System.out.println(new StringBuilder().append("getSignFromResponseString:").append(map.toString()).toString());

    return RandomStringGenerator.getSign(map);
  }

  public static boolean checkIsSignValidFromResponseString(String responseString)
  {
    Map map;
    try
    {
      map = XmlConverUtil.xmltoMap(responseString);
      logger.info(map.toString());
      String signFromAPIResponse = map.get("sign").toString();
      if ((signFromAPIResponse == "") || (signFromAPIResponse == null)) {
        logger.info("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
        return false;
      }
      logger.info(new StringBuilder().append("服务器回包里面的签名是:").append(signFromAPIResponse).toString());

      map.put("sign", "");
      logger.info(map.toString());

      String signForAPIResponse = RandomStringGenerator.getSign(map);
      logger.info(new StringBuilder().append("按照返回数据重新生成签名：").append(signForAPIResponse).toString());
      if (!(signForAPIResponse.equals(signFromAPIResponse)))
      {
        logger.info("API返回的数据签名验证不通过，有可能被第三方篡改!!!");
        return false;
      }
      logger.info("恭喜，API返回的数据签名验证通过!!!");
      return true; } catch (Exception e) {
    }
    return false;
  }

  public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
  {
    String notifyXml = "<xml><appid><![CDATA[wx538b5ed034982cbf]]></appid><attach><![CDATA[门诊预约费用]]></attach><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><device_info><![CDATA[WEB]]></device_info><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1308803801]]></mch_id><nonce_str><![CDATA[qd3hgwdmp17pbgs3uj2n2t5iznn66z4r]]></nonce_str><openid><![CDATA[otTUvwSkWg1nRzuj5ppuJNvroGWw]]></openid><out_trade_no><![CDATA[82]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[91B8E83E2FB95BD9ED4AE5344695C8EC]]></sign><time_end><![CDATA[20160511111541]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4000582001201605115728565596]]></transaction_id></xml>";
    PayNotifyData payNotifyData = (PayNotifyData)XMLParser.getObjectFromXML(notifyXml, PayNotifyData.class);
    String xml = XMLParser.toXML(payNotifyData);
    System.out.println(xml);
    Map map = XMLParser.getMapFromXML(xml);
    System.out.println(map);
    getSignFromResponseString(notifyXml);
  }
}