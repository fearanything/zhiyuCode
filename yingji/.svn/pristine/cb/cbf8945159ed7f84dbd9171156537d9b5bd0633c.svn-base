package com.wx.framework.core.wx4j.lang;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;

public class JaxbParser
{
  private static Logger logger = Logger.getLogger(JaxbParser.class);
  private Class clazz;
  private String[] cdataNode;

  public JaxbParser(Class clazz)
  {
    this.clazz = clazz;
  }

  public void setCdataNode(String[] cdataNode)
  {
    this.cdataNode = cdataNode;
  }

  public String toXML(Object obj)
  {
    String result = null;
    try
    {
      JAXBContext context = JAXBContext.newInstance(new Class[] { obj.getClass() });

      Marshaller m = context.createMarshaller();
      m.setProperty("jaxb.encoding", "UTF-8");
      m.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
      m.setProperty("jaxb.fragment", Boolean.valueOf(true));
      OutputStream os = new ByteOutputStream();
      StringWriter writer = new StringWriter();
      XMLSerializer serializer = getXMLSerializer(os);
      m.marshal(obj, serializer.asContentHandler());
      result = os.toString();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    logger.debug("response text:" + result);
    return result;
  }

  public Object toObj(InputStream is)
  {
    try
    {
      JAXBContext context = JAXBContext.newInstance(new Class[] { this.clazz });

      Unmarshaller um = context.createUnmarshaller();
      Object obj = um.unmarshal(is);
      return obj;
    } catch (Exception e) {
      logger.error("post data parse error");
      e.printStackTrace();
    }
    return null;
  }

  public Object toObj(String xmlStr)
  {
    InputStream is = new ByteArrayInputStream(xmlStr.getBytes());
    return toObj(is);
  }

  private XMLSerializer getXMLSerializer(OutputStream os)
  {
    OutputFormat of = new OutputFormat();
    formatCDataTag();
    of.setCDataElements(this.cdataNode);
    of.setPreserveSpace(true);
    of.setIndenting(true);
    of.setOmitXMLDeclaration(true);
    XMLSerializer serializer = new XMLSerializer(of);
    serializer.setOutputByteStream(os);
    return serializer;
  }

  private void formatCDataTag()
  {
    for (int i = 0; i < this.cdataNode.length; ++i)
      this.cdataNode[i] = "^" + this.cdataNode[i];
  }
}