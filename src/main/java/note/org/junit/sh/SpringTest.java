package note.org.junit.sh;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 整合Spring+JUnit
 * 
 */
public class SpringTest {
	private static ApplicationContext applicationContext = null;

	// 加载Spring
	@BeforeClass
	public static void setUpBeforeClass() {
		applicationContext = new ClassPathXmlApplicationContext("note/org/junit/sh/config/applicationContext-mvc.xml"); // 可以
//		applicationContext = new ClassPathXmlApplicationContext("classpath:note/org/junit/sh/config/applicationContext-mvc.xml"); // 可以
//		applicationContext = new FileSystemXmlApplicationContext("classpath:note/org/junit/sh/config/applicationContext-mvc.xml"); // 可以
//		applicationContext = new FileSystemXmlApplicationContext("classpath:config/applicationContext-mvc.xml"); // 不行
//		applicationContext = new FileSystemXmlApplicationContext("note/org/junit/sh/config/applicationContext-mvc.xml"); // 不行
//		applicationContext = new FileSystemXmlApplicationContext("config/applicationContext-mvc.xml"); // 不行
//		applicationContext = new FileSystemXmlApplicationContext("applicationContext-mvc.xml"); // 不行
//		applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext-mvc.xml"); // 不行
//		applicationContext = new ClassPathXmlApplicationContext("classpath:config/applicationContext-mvc.xml"); // 不行
//		applicationContext = new ClassPathXmlApplicationContext("config/applicationContext-mvc.xml"); // 不行
//		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-mvc.xml"); // 不行
	}

	@Test
	public void testSpring() {
		Date date = (Date) applicationContext.getBean("date");
		System.out.println(date.toString());
	}
}
