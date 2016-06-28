package note.org.dom4j;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用dom4j方式操作xml 
 *
 */
public class NXml {
	private static SAXReader reader = new SAXReader();

	/**
	 * 读取xml
	 */
	public static void readXml() {
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
	
	public static void main(String[] args) {
		readXml();
	}
}
