package note.org.xml.sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 使用SAX方式操作xml (解析方式：从上到下一行一行的读) (对比Dom：较Dom方式更节省内存，适合解析大型xml文件)
 */
public class NXml {
	private static SAXParserFactory factory = SAXParserFactory.newInstance();
	private static SAXParser parser = null;

	/**
	 * 解析xml
	 */
	public void parseXml() {
		try {
			NSaxParseHandler handler = new NSaxParseHandler();
			parser = factory.newSAXParser();
			parser.parse(new InputSource(new InputStreamReader(new FileInputStream("file/demo.xml"), "utf-8")), handler);

			System.out.println("?" + handler.getBookList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建xml
	 */
	public void createXml() {
		// 创建一个SAXTransformerFactory
		SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		try {
			// 创建一个TransformerHandler对象
			TransformerHandler handler = factory.newTransformerHandler();
			// 创建一个Transformer对象
			Transformer transformer = handler.getTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); // 设置字符集
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // 设置换行
			// 创建一个Result对象
			Result result = new StreamResult(new File("mySaxXml.xml"));
			handler.setResult(result);
			// 用handel对象进行内容编写
			// 打开document
			handler.startDocument();
			AttributesImpl atts = new AttributesImpl();

			/**
			 * startElement()：第一个、第二个参数为命名空间；第三个为标签名称；第四个为参数为标签属性
			 * addAttribute()：第一个、第二个参数为命名空间；第三个为属性名称；第四个为参数为属性类型；第五个参数为属性值
			 */
			// 创建bookStore
			handler.startElement("", "", "bookStore", atts);
			// 创建book
			// 创建前清空属性重新设置
			atts.clear();
			atts.addAttribute("", "", "id", "", "1");
			handler.startElement("", "", "book", atts);
			// 结束book
			handler.endElement("", "", "book");
			// 结束booStore标签
			handler.endElement("", "", "bookStore");
			// 关闭document
			handler.endDocument();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		NXml xml = new NXml();
		// xml.parseXml();
		xml.createXml();
	}
}
