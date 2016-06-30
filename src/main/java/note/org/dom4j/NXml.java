package note.org.dom4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 使用dom4j方式操作xml
 *
 */
public class NXml {
	private SAXReader reader = new SAXReader();

	/**
	 * 解析Xml
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void xmlParse() {
		try {
			Document document = reader.read(new InputStreamReader(new FileInputStream("file/demo.xml"), "UTF-8"));

			// 根
			Element rootElement = document.getRootElement();
			// 子
			Iterator childElements = rootElement.elementIterator();
			while (childElements.hasNext()) {
				Element child = (Element) childElements.next();

				// 子的属性
				List<Attribute> childAttributes = child.attributes();
				System.out.print("[");
				for (Attribute attribute : childAttributes) {
					System.out.print(attribute.getName() + ":" + attribute.getValue() + " ");
				}
				System.out.println("]");

				// 孙
				Iterator sunElements = child.elementIterator();
				while (sunElements.hasNext()) {
					Element sun = (Element) sunElements.next();
					System.out.println(sun.getName() + ":" + sun.getText());
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建Xml
	 */
	public void createXml() {
		// 创建Document对象
		Document document = DocumentHelper.createDocument();
		// 创建节点
		Element rss = document.addElement("rss");
		rss.addAttribute("version", "2.0");
		// 创建节点
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("<H工口>小学生又在搞事了!</H工口>");
		// 格式化
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("myDom4jRSS.xml")), format);
			// 默认转义保留字符，比如大于小于符号，这里设置成不转义
			writer.setEscapeText(false);
			writer.write(document);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		NXml xml = new NXml();
		// xml.xmlParse();
		xml.createXml();
	}
}
