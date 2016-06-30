package note.org.w3c.dom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
import org.xml.sax.InputSource;

/**
 * 使用DOM方式操作xml
 *
 */
public class NXml {
	/**
	 * 创建DocumentBuilder对象
	 * @return
	 */
	private DocumentBuilder getDocumentBuilder() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return builder;
	}

	/**
	 * 解析
	 */
	public void xmlParse() {
		try {
			Document document = getDocumentBuilder().parse(new InputSource(new InputStreamReader(new FileInputStream("file/demo.xml"), "utf-8")));
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
	 * 
	 * @param document
	 * @param filename
	 */
	public void writeXML(Document document, String filename) {
		try {
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

	public void updateXML() {
		try {
			FileInputStream fi = new FileInputStream("file/demo.xml");
			Document document = getDocumentBuilder().parse(fi);

			// 得到某个元素(第一个元素节点的第一个节点)
			Element element = (Element) document.getElementsByTagName("book").item(0);
			Node node = element.getElementsByTagName("title").item(0);

			node.setTextContent(node.getTextContent() + "- -");

			writeXML(document, "file/demo.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建一个Xml
	 */
	public void createXml() {
		// 创建文档
		Document document = getDocumentBuilder().newDocument();
		// 创建一个根节点
		Element rootElement = document.createElement("bookStore");
		// 创建一个子节点
		Element bookElement = document.createElement("book");
		// 向子节点中添加属性
		bookElement.setAttribute("id", "1");

		// 创建book属性并赋值
		Element elementTitle = document.createElement("title");
		elementTitle.setTextContent("隔壁的老李");
		Element elementAuthor = document.createElement("author");
		elementAuthor.setTextContent("老王");
		Element elementPrice = document.createElement("price");
		elementPrice.setTextContent("2.50");
		// 加入到book节点
		bookElement.appendChild(elementTitle);
		bookElement.appendChild(elementAuthor);
		bookElement.appendChild(elementPrice);

		// 将子节点添加到根节点中
		rootElement.appendChild(bookElement);
		// 将根节点添加到文档中
		document.appendChild(rootElement);

		// 生成
		writeXML(document, "myDomXml.xml");
	}

	public static void main(String[] args) {
		NXml xml = new NXml();
		// xml.xmlParse();
		// xml.updateXML();
		xml.createXml();
	}
}
