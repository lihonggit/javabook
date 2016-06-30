package note.org.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NSaxParseHandler extends DefaultHandler {
	// 接收数据的实体集合
	private List<Book> bookList = null;
	// 当前文档遍历的book节点
	private Book currBook = null;
	// 当前文档缓存的节点值
	String currValue = null;

	/**
	 * 开始解析节点
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		// 根据需求操作节点
		// 当当前节点名为book,遍历节点属性值
		if (qName.equals("book")) {
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println(attributes.getQName(i) + ":" + attributes.getValue(i));
			}
			// 判断到book节点的时候创建当前book对象
			currBook = new Book();
		} else if (!qName.equals("bookstore")) {
			System.out.print(qName + ":");
		}
	}

	/**
	 * 结束解析节点
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName.equals("book")) {
			System.out.println();
			// 添加到集合
			bookList.add(currBook);
		}
		// 将当前值设置到对象
		if (qName.equals("title")) {
			currBook.setTitle(currValue);
		}
		if (qName.equals("author")) {
			currBook.setAuthor(currValue);
		}
		if (qName.equals("price")) {
			currBook.setPrice(currValue);
		}
	}

	/**
	 * 开始解析文档
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("开始");
		// 初始化接收数据的实体集合
		bookList = new ArrayList<>();
	}

	/**
	 * 结束解析文档
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("结束");
	}

	/**
	 * 遍历到节点值时
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		currValue = new String(ch, start, length);
		if (!"".equals(currValue.trim())) {
			System.out.println(currValue);
		}
	}

	public List<Book> getBookList() {
		return bookList;
	}

	/**
	 * 用于接收解析数据的实体
	 */
	class Book {
		private String title;
		private String author;
		private String price;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "\t\nBook [title=" + title + ", author=" + author + ", price=" + price + "]";
		}

	}
}
