package com.wx.framework.core.wx4j.pay.utils;

import com.wx.framework.core.wx4j.common.Wx4javaConfig;
import com.wx.framework.core.wx4j.pay.utils.http.HttpClientConnectionManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class GetWxOrderno
{
  public static DefaultHttpClient httpclient = new DefaultHttpClient();

  public static String getWxPayNo(String url, String xmlParam)
    throws Exception
  {
    KeyStore keyStore = KeyStore.getInstance("PKCS12");

    FileInputStream instream = new FileInputStream(new File(GetWxOrderno.class.getClassLoader().getResource("apiclient_cert.p12").getFile()));
    try
    {
      keyStore.load(instream, Wx4javaConfig.instance().getPartnerId().toCharArray());
    } finally {
      instream.close();
    }
    SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, Wx4javaConfig.instance().getPartnerId().toCharArray()).build();

    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

    CloseableHttpClient http_client = HttpClients.custom().setSSLSocketFactory(sslsf).build();

    HttpPost httpost = HttpClientConnectionManager.getPostMethod(url);
    String prepay_id = "";
    try {
      httpost.setEntity(new StringEntity(xmlParam, "UTF-8"));
      HttpResponse response = http_client.execute(httpost);
      String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
      Map dataMap = new HashMap();
      System.out.println("微信返回json:" + jsonStr);
      Map map = doXMLParse(jsonStr);
      String return_code = (String)map.get("return_code");
      prepay_id = jsonStr;
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return prepay_id;
  }

  public static String getPayNo(String url, String xmlParam)
  {
    DefaultHttpClient client = new DefaultHttpClient();
    client.getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
    HttpPost httpost = HttpClientConnectionManager.getPostMethod(url);
    String prepay_id = "";
    try {
      httpost.setEntity(new StringEntity(xmlParam, "UTF-8"));
      HttpResponse response = httpclient.execute(httpost);
      String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
      Map dataMap = new HashMap();
      System.out.println("微信返回json:" + jsonStr);

      if (jsonStr.indexOf("FAIL") != -1)
        return prepay_id;

      Map map = doXMLParse(jsonStr);
      String return_code = (String)map.get("return_code");
      prepay_id = (String)map.get("prepay_id");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return prepay_id;
  }

  public static Map getRefund(String url, String xmlParam)
  {
    Map map = new HashMap();

    DefaultHttpClient client = new DefaultHttpClient();
    client.getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
    HttpPost httpost = HttpClientConnectionManager.getPostMethod(url);
    try {
      httpost.setEntity(new StringEntity(xmlParam, "UTF-8"));
      HttpResponse response = httpclient.execute(httpost);
      String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
      Map dataMap = new HashMap();
      System.out.println("微信返回json:" + jsonStr);
      map = doXMLParse(jsonStr);
      String return_code = (String)map.get("return_code");
      System.out.println("微信返回return_code:" + return_code);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return map;
  }

  public static Map doXMLParse(String strxml)
    throws Exception
  {
    if ((null == strxml) || ("".equals(strxml))) {
      return null;
    }

    Map m = new HashMap();
    InputStream in = String2Inputstream(strxml);
    SAXBuilder builder = new SAXBuilder();
    Document doc = builder.build(in);
    Element root = doc.getRootElement();
    List list = root.getChildren();
    Iterator it = list.iterator();
    while (it.hasNext()) {
      Element e = (Element)it.next();
      String k = e.getName();
      String v = "";
      List children = e.getChildren();
      if (children.isEmpty())
        v = e.getTextNormalize();
      else {
        v = getChildrenText(children);
      }

      m.put(k, v);
    }

    in.close();

    return m;
  }

  public static String getChildrenText(List children)
  {
    StringBuffer sb = new StringBuffer();
    if (!(children.isEmpty())) {
      Iterator it = children.iterator();
      while (it.hasNext()) {
        Element e = (Element)it.next();
        String name = e.getName();
        String value = e.getTextNormalize();
        List list = e.getChildren();
        sb.append("<" + name + ">");
        if (!(list.isEmpty()))
          sb.append(getChildrenText(list));

        sb.append(value);
        sb.append("</" + name + ">");
      }
    }

    return sb.toString(); }

  public static InputStream String2Inputstream(String str) {
    return new ByteArrayInputStream(str.getBytes());
  }

  static
  {
    httpclient = (DefaultHttpClient)HttpClientConnectionManager.getSSLInstance(httpclient);
  }
}