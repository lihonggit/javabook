package note.org.jdom2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * 使用JDOM操作xml
 *
 */
public class NXml {
	private SAXBuilder builder = new SAXBuilder();

	/**
	 * 读取
	 */
	public void readXml() {
		try {
			FileInputStream fi = new FileInputStream("file/demo.xml");
			InputStreamReader isr = new InputStreamReader(fi, "UTF-8");
			Document document = builder.build(isr);
			// 根
			Element rootElement = document.getRootElement();
			// 子
			List<Element> childElements = rootElement.getChildren();
			for (Element child : childElements) {
				// 子的属性
				List<Attribute> childAttributes = child.getAttributes();
				System.out.print("[");
				for (Attribute attribute : childAttributes) {
					System.out.print(attribute.getName() + ":" + attribute.getValue() + " ");
				}
				System.out.println("]");

				// 孙
				List<Element> sunElements = child.getChildren();
				for (Element sun : sunElements) {
					System.out.println(sun.getName() + ":" + sun.getText());
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建xml
	 */
	public void createXML() {
		// 创建节点
		Element rss = new Element("rss");
		rss.setAttribute("version", "2.0");

		Element channel = new Element("channel");
		rss.addContent(channel);

		Element title = new Element("title");
		channel.addContent(title);
		title.setText("H工口<>笑学生");

		// 生成document
		Document document = new Document(rss);
		XMLOutputter outputter = new XMLOutputter();
		// 格式化
		Format format = Format.getPrettyFormat();
		format.setEncoding("UTF-8");
		// 这里应该是设置格式方式
		format.setIndent("\t");
		try {
			outputter.setFormat(format);
			outputter.output(document, new FileOutputStream(new File("myJdomRSS.xml")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		NXml xml = new NXml();
		// xml.readXml();
		xml.createXML();
	}
}
