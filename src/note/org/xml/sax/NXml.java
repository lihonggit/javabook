package note.org.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 用Sax方式解析xml (解析方式：从上到下一行一行的读) (对比Dom：较Dom方式更节省内存，适合解析大型xml文件)
 */
public class NXml {
	private static SAXParserFactory factory = SAXParserFactory.newInstance();
	private static SAXParser parser = null;

	public static void readXml() {
		try {
			parser = factory.newSAXParser();
			parser.parse("file/demo.xml", new NSaxParseHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readXml();
	}
}
