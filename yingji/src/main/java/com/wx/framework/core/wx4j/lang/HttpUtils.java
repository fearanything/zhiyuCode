package com.wx.framework.core.wx4j.lang;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import net.sf.json.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpUtils
{
  private static Logger logger = Logger.getLogger(HttpUtils.class);
  public static final int timeout = 10;

  public static String post(String url)
  {
    return post(url, "");
  }

  public static String post(String url, String data)
  {
    return httpPost(url, data); }

  public static String post(String url, InputStream instream) {
    HttpEntity entity;
    try {
      entity = Request.Post(url).bodyStream(instream, ContentType.create("text/html", Consts.UTF_8)).execute().returnResponse().getEntity();
      return ((entity == null) ? null : EntityUtils.toString(entity));
    } catch (Exception e) {
      logger.error("post请求异常，" + e.getMessage() + "\n post url:" + url);
      e.printStackTrace();
    }

    return null;
  }

  public static String get(String url)
  {
    return httpGet(url);
  }

  private static String httpPost(String url, String data) {
    HttpEntity entity;
    try {
      entity = Request.Post(url).bodyString(data, ContentType.create("text/html", Consts.UTF_8)).execute().returnResponse().getEntity();
      return ((entity == null) ? null : EntityUtils.toString(entity));
    } catch (Exception e) {
      logger.error("post请求异常，" + e.getMessage() + "\n post url:" + url);
      e.printStackTrace();
    }
    return null;
  }

  public static String postFile(String url, File file)
  {
    return postFile(url, null, file);
  }

  public static String postFile(String url, String name, File file)
  {
    HttpEntity reqEntity = MultipartEntityBuilder.create().addBinaryBody(name, file).build();
    try {
      Request request = Request.Post(url);
      request.body(reqEntity);
      HttpEntity resEntity = request.execute().returnResponse().getEntity();
      return ((resEntity == null) ? null : EntityUtils.toString(resEntity));
    } catch (Exception e) {
      logger.error("postFile请求异常，" + e.getMessage() + "\n post url:" + url);
      e.printStackTrace();
    }
    return null;
  }

  public static byte[] getFile(String url)
  {
    Request request;
    try {
      request = Request.Get(url);
      HttpEntity resEntity = request.execute().returnResponse().getEntity();
      return EntityUtils.toByteArray(resEntity);
    } catch (Exception e) {
      logger.error("postFile请求异常，" + e.getMessage() + "\n post url:" + url);
      e.printStackTrace();
    }
    return null;
  }

  private static String httpGet(String url) {
    HttpEntity entity;
    try {
      entity = Request.Get(url).execute().returnResponse().getEntity();
      return ((entity == null) ? null : EntityUtils.toString(entity));
    } catch (Exception e) {
      logger.error("get请求异常，" + e.getMessage() + "\n get url:" + url);
      e.printStackTrace();
    }
    return null;
  }

  public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr)
  {
    JSONObject jsonObject = null;
    try
    {
      TrustManager[] tm = { new MyX509TrustManager() };
      SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
      sslContext.init(null, tm, new SecureRandom());

      SSLSocketFactory ssf = sslContext.getSocketFactory();
      URL url = new URL(requestUrl);
      HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
      conn.setSSLSocketFactory(ssf);
      conn.setDoOutput(true);
      conn.setDoInput(true);
      conn.setUseCaches(false);

      conn.setRequestMethod(requestMethod);

      if (null != outputStr) {
        OutputStream outputStream = conn.getOutputStream();

        outputStream.write(outputStr.getBytes("UTF-8"));
        outputStream.close();
      }

      InputStream inputStream = conn.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      String str = null;
      StringBuffer buffer = new StringBuffer();
      while ((str = bufferedReader.readLine()) != null) {
        buffer.append(str);
      }

      bufferedReader.close();
      inputStreamReader.close();
      inputStream.close();
      inputStream = null;
      conn.disconnect();
      jsonObject = JSONObject.fromObject(buffer.toString());
    } catch (ConnectException ce) {
      logger.error("连接超时：{}", ce);
    } catch (Exception e) {
      logger.error("https请求异常：{}", e);
    }
    return jsonObject;
  }

  public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr)
  {
    JSONObject jsonObject = null;
    StringBuffer buffer = new StringBuffer();
    try
    {
      TrustManager[] tm = { new MyX509TrustManager() };
      SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
      sslContext.init(null, tm, new SecureRandom());

      SSLSocketFactory ssf = sslContext.getSocketFactory();

      URL url = new URL(requestUrl);
      HttpsURLConnection httpUrlConn = (HttpsURLConnection)url.openConnection();
      httpUrlConn.setSSLSocketFactory(ssf);

      httpUrlConn.setDoOutput(true);
      httpUrlConn.setDoInput(true);
      httpUrlConn.setUseCaches(false);

      httpUrlConn.setRequestMethod(requestMethod);

      if ("GET".equalsIgnoreCase(requestMethod)) {
        httpUrlConn.connect();
      }

      if (null != outputStr) {
        OutputStream outputStream = httpUrlConn.getOutputStream();

        outputStream.write(outputStr.getBytes("UTF-8"));
        outputStream.close();
      }

      InputStream inputStream = httpUrlConn.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

      String str = null;
      while ((str = bufferedReader.readLine()) != null)
        buffer.append(str);

      bufferedReader.close();
      inputStreamReader.close();

      inputStream.close();
      inputStream = null;
      httpUrlConn.disconnect();
      jsonObject = JSONObject.fromObject(buffer.toString());
    } catch (ConnectException ce) {
      ce.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return jsonObject;
  }
}