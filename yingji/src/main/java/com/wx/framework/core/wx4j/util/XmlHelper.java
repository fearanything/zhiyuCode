package com.wx.framework.core.wx4j.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlHelper
{
  public static String objectToXML(Class clazz, Object object)
    throws JAXBException
  {
    String xml = null;
    JAXBContext context = JAXBContext.newInstance(new Class[] { clazz });
    Marshaller m = context.createMarshaller();
    m.setProperty("jaxb.formatted.output", Boolean.TRUE);
    m.setProperty("jaxb.encoding", "UTF-8");
    m.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
    m.setProperty("jaxb.fragment", Boolean.valueOf(true));
    Writer w = new StringWriter();
    m.marshal(object, w);
    xml = w.toString();
    return xml;
  }

  public static Object xmlToObject(Class clazz, String xml)
    throws JAXBException
  {
    JAXBContext context = JAXBContext.newInstance(new Class[] { clazz });
    Unmarshaller um = context.createUnmarshaller();
    return um.unmarshal(new StringReader(xml));
  }
}