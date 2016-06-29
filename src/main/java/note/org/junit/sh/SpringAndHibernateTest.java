package note.org.junit.sh;

import org.hibernate.internal.SessionFactoryImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringAndHibernateTest {
	private static ApplicationContext applicationContext = null;

	// 加载Spring
	@BeforeClass
	public static void setUpBeforeClass() {
		applicationContext = new FileSystemXmlApplicationContext("config/applicationContext-mvc.xml");
	}

	// 这里有毒！！！
	@Test
	public void testSpringAndHibernate() {
		SessionFactoryImpl impl = (SessionFactoryImpl) applicationContext.getBean("sessionFactory");
		System.out.println(impl);
	}
}
