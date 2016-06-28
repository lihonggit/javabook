package note.org.xml.sax;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

/**
 * 使用SAX方式操作xml (解析方式：从上到下一行一行的读) (对比Dom：较Dom方式更节省内存，适合解析大型xml文件)
 */
public class NXml {
	private static SAXParserFactory factory = SAXParserFactory.newInstance();
	private static SAXParser parser = null;

	public static void readXml() {
		try {
			parser = factory.newSAXParser();
			parser.parse(new InputSource(new InputStreamReader(new FileInputStream("file/demo.xml"),"utf-8")), new NSaxParseHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readXml();
	}
}
