package note.org.xml.sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.AttributesImpl;

import note.org.xml.sax.NSaxParseHandler.Book;

/**
 * 使用SAX方式操作xml (解析方式：从上到下一行一行的读) (对比Dom：较Dom方式更节省内存，适合解析大型xml文件)
 */
public class NXml {
	private static SAXParserFactory factory = SAXParserFactory.newInstance();
	private static SAXParser parser = null;

	/**
	 * 解析xml
	 */
	public List<Book> parseXml() {
		List<Book> bookList = null;
		try {
			NSaxParseHandler handler = new NSaxParseHandler();
			parser = factory.newSAXParser();
			parser.parse(new InputSource(new InputStreamReader(new FileInputStream("file/demo.xml"), "utf-8")),
					handler);
			bookList = handler.getBookList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(bookList);
		return bookList;
	}

	/**
	 * 创建xml
	 */
	public void createXml() {
		// 解析得到数据
		List<Book> bookList = parseXml();

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

			// 把List里的内容设置进来
			int bookIndex = 1;
			for (Book book : bookList) {
				// 创建book
				// 创建前清空属性重新设置
				atts.clear();
				atts.addAttribute("", "", "id", "", String.valueOf(bookIndex));
				handler.startElement("", "", "book", atts);

				atts.clear();
				handler.startElement("", "", "title", atts);
				handler.characters(book.getTitle().toCharArray(), 0, book.getTitle().length());
				handler.endElement("", "", "title");

				atts.clear();
				handler.startElement("", "", "author", atts);
				handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
				handler.endElement("", "", "author");

				atts.clear();
				handler.startElement("", "", "price", atts);
				handler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
				handler.endElement("", "", "price");

				// 结束book
				handler.endElement("", "", "book");
				bookIndex++;
			}

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
