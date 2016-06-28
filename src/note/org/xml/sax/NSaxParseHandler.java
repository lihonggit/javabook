package note.org.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NSaxParseHandler extends DefaultHandler {

	/**
	 * 开始解析节点
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		// 根据需求操作节点
		// 当当前节点名为book,遍历节点属性值
		if (qName.equals("book")) {
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println(attributes.getQName(i) + ":" + attributes.getValue(i));
			}
		} else if (!qName.equals("bookstore")) {
			System.out.print(qName + ":");
		}
	}

	/**
	 * 遍历到节点值时
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String value = new String(ch, start, length);
		if (!"".equals(value.trim())) {
			System.out.println(value);
		}
	}

	/**
	 * 结束解析节点
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName.equals("book")) {
			System.out.println();
		}
	}

	/**
	 * 开始解析文档
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("开始");
	}

	/**
	 * 结束解析文档
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("结束");
	}
}
