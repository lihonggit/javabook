package note.org.w3c.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 使用DOM方式操作xml
 *
 */
public class NXml {
	private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private static DocumentBuilder builder = null;

	/**
	 * 读取
	 */
	public static void readXml() {
		try {
			builder = factory.newDocumentBuilder();

			File file = new File("file/demo.xml");
			Document document = builder.parse(file);
			// 得到根元素
			Element rootElement = document.getDocumentElement();

			NodeList nodeList = rootElement.getElementsByTagName("book");
			for (int i = 0; i < nodeList.getLength(); i++) {
				// 获取元素属性
				System.out.println("获取元素属性");
				Node nodeBook = nodeList.item(i);
				NamedNodeMap map = nodeBook.getAttributes();
				for (int j = 0; j < map.getLength(); j++) {
					System.out.print("[" + map.item(j).getNodeName() + ":" + map.item(j).getNodeValue() + "]\t");
				}
				System.out.println("");

				// 获取元素下面的值
				System.out.println("获取元素下面的值");
				Element element = (Element) nodeList.item(i);
				NodeList lastNodeList = element.getChildNodes();
				for (int j = 0; j < lastNodeList.getLength(); j++) {
					Node node = lastNodeList.item(j);
					// 如果不判断，dom会把标签之间的空白也算进去
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						System.out.print(node.getNodeName() + ":\t");
						// 这里也可用getTextContent()，但不能直接getNodeValue()，会返回null，因为dom会把这个节点下的内容看成一个元素
						System.out.println(node.getFirstChild().getNodeValue());
					}
				}
				System.out.println("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写入
	 * @param document
	 * @param filename
	 */
	public static void writeXML(Document document, String filename) {
		try {
			builder = factory.newDocumentBuilder();
			document.normalize();

			/** 将document中的内容写入文件中 */
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// 编码
			DOMSource source = new DOMSource(document);
			PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateXML() {
		try {
			builder = factory.newDocumentBuilder();

			FileInputStream fi = new FileInputStream("file/demo.xml");
			Document document = builder.parse(fi);

			// 得到某个元素(第一个元素节点的第一个节点)
			Element element = (Element) document.getElementsByTagName("book").item(0);
			Node node = element.getElementsByTagName("title").item(0);

			node.setTextContent(node.getTextContent() + "- -");

			writeXML(document, "file/demo.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readXml();
		// updateXML();
	}
}
