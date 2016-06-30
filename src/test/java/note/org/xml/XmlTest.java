package note.org.xml;

import org.junit.Test;

public class XmlTest {
	@Test
	public void testPerformance() {

		long startTime = System.currentTimeMillis();
		new note.org.dom4j.NXml().xmlParse();
		System.err.println("DOM4J耗时：\t" + (System.currentTimeMillis() - startTime));

		startTime = System.currentTimeMillis();
		new note.org.jdom2.NXml().readXml();
		System.err.println("JDOM2耗时：\t" + (System.currentTimeMillis() - startTime));

		startTime = System.currentTimeMillis();
		new note.org.xml.sax.NXml().parseXml();
		System.err.println("SAX耗时：\t" + (System.currentTimeMillis() - startTime));

		startTime = System.currentTimeMillis();
		new note.org.w3c.dom.NXml().xmlParse();
		System.err.println("DOM耗时：\t" + (System.currentTimeMillis() - startTime));
	}
}
