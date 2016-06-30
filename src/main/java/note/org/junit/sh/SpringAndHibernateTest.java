package note.org.junit.sh;

import org.hibernate.internal.SessionFactoryImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAndHibernateTest {
	private static ApplicationContext applicationContext = null;

	// 加载Spring
	@BeforeClass
	public static void setUpBeforeClass() {
		applicationContext = new ClassPathXmlApplicationContext("note/org/junit/sh/config/applicationContext-mvc.xml");
	}

	@Test
	public void testSpringAndHibernate() {
		SessionFactoryImpl impl = (SessionFactoryImpl) applicationContext.getBean("sessionFactory");
		System.out.println(impl);
	}

}
