package note.org.jdom2;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * 使用JDOM操作xml
 *
 */
public class NXml {
	private static SAXBuilder builder = new SAXBuilder();

	/**
	 * 读取
	 */
	public static void readXml() {
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

	public static void main(String[] args) {
		readXml();
	}
}
