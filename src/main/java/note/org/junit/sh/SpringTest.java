package note.org.junit.sh;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 整合Spring框架
 * 
 */
public class SpringTest {
	private static ApplicationContext applicationContext = null;

	@BeforeClass
	public static void setUpBeforeClass() {
		applicationContext = new FileSystemXmlApplicationContext("config/applicationContext-mvc.xml");
	}

	@Test
	public void testSpring() {
		Date date = (Date) applicationContext.getBean("date");
		System.out.println(date.toString());
	}
}
