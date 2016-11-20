package com.lb.parrot.support.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;

public class XmlUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(XmlUtil.class);
	
	public static Element parseElement(String xmlStr) {
		Element element = null;
		try {
			element = parseDocument(xmlStr).getDocumentElement();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (SAXException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (ParserConfigurationException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return element;
	}
	
	public static Element parseElement(InputStream in) throws IOException, SAXException, ParserConfigurationException{
		return parseDocument(in).getDocumentElement();
	}
	
	public static Document newDocument() throws ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		return db.newDocument();
	}

	public static Document parseDocument(String xmlStr) throws IOException, SAXException, ParserConfigurationException {
		return parseDocument(xmlStr, "utf-8");
	}

	public static Document parseDocument(InputStream in) throws IOException, SAXException, ParserConfigurationException {
		return parseDocument(in, "utf-8");
	}

	public static Document parseDocument(String xmlStr, String charset) throws IOException, SAXException, ParserConfigurationException {
		InputStream in = new ByteArrayInputStream(xmlStr.getBytes(charset));
		return parseDocument(in, charset);
	}

	public static Document parseDocument(InputStream in, String charset) throws IOException, SAXException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is = new InputSource(in);
		is.setEncoding(charset);
		return db.parse(in);
	}

	public static String toXml(Object obj) {
		XStream xstream = new XStream();
		xstream.processAnnotations(obj.getClass());
		return xstream.toXML(obj);
	}

	@SuppressWarnings("unchecked")
	public static <T> T toBean(String xmlStr, Class<T> cls) {
		//XStream xstream = new XStream(new DomDriver());
		XStream xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations(cls);
		return (T) xstream.fromXML(xmlStr);
	}

}
