package com.wx.framework.core.wx4j.pay.common;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser
{
  public static <T> T getObjectFromXML(String xml, Class<T> tClass)
  {
    XStream xStreamForResponseData = new XStream();
    xStreamForResponseData.alias("xml", tClass);
    xStreamForResponseData.ignoreUnknownElements();
    return (T) xStreamForResponseData.fromXML(xml);
  }

  public static InputStream getStringStream(String sInputString) throws UnsupportedEncodingException {
    ByteArrayInputStream tInputStringStream = null;
    if ((sInputString != null) && (!(sInputString.trim().equals(""))))
      tInputStringStream = new ByteArrayInputStream(sInputString.getBytes("UTF-8"));

    return tInputStringStream;
  }

  public static Map<String, Object> getMapFromXML(String xmlString)
    throws ParserConfigurationException, IOException, SAXException
  {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    InputStream is = getStringStream(xmlString);
    Document document = builder.parse(is);

    NodeList allNodes = document.getFirstChild().getChildNodes();

    Map map = new HashMap();
    int i = 0;
    while (i < allNodes.getLength()) {
      Node node = allNodes.item(i);
      if (node instanceof Element)
        map.put(node.getNodeName(), node.getNodeValue());

      ++i;
    }
    return map;
  }

  public static String toXML(Object o)
  {
    XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
    xStream.autodetectAnnotations(true);
    return xStream.toXML(o);
  }
}