package note.org.xml;

import org.junit.Test;

public class XmlTest {
	@Test
	public void testPerformance() {

		long startTime = System.currentTimeMillis();
		note.org.dom4j.NXml.readXml();
		System.err.println("DOM4J耗时：\t" + (System.currentTimeMillis() - startTime));

		startTime = System.currentTimeMillis();
		note.org.jdom2.NXml.readXml();
		System.err.println("JDOM2耗时：\t" + (System.currentTimeMillis() - startTime));

		startTime = System.currentTimeMillis();
		note.org.xml.sax.NXml.readXml();
		System.err.println("SAX耗时：\t" + (System.currentTimeMillis() - startTime));

		startTime = System.currentTimeMillis();
		note.org.w3c.dom.NXml.readXml();
		System.err.println("DOM耗时：\t" + (System.currentTimeMillis() - startTime));
	}
}
