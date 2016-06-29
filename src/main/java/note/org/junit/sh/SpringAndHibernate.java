package note.org.junit.sh;

import org.hibernate.internal.SessionFactoryImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringAndHibernate {

	private static ApplicationContext context;


	// 加载Spring
	@BeforeClass
	public static void setUpBeforeClass() {
		context = new FileSystemXmlApplicationContext("config/applicationContext-mvc.xml");
	}

	@Test
	public void test() {
		SessionFactoryImpl bean = (SessionFactoryImpl) context.getBean("sessionFactory");
		System.out.println(bean);
	}

}
