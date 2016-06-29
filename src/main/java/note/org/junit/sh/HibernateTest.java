package note.org.junit.sh;

import org.hibernate.Session;
import org.junit.Test;

/**
 * 整合Hibernate+JUnit
 *
 */
public class HibernateTest {

	@Test
	public void testHibernate() {
		Session session = HibernateSessionFactory.getSession();
		System.out.println(session);
	}

}
