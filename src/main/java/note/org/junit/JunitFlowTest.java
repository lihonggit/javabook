package note.org.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitFlowTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is afterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("this is before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("this is after");
	}

	@Test
	public void test1() {
		System.out.println("this is test1....");
	}

	@Test
	public void test2() {
		System.out.println("this is test2....");
	}

	@Test(timeout=2000)
	public void testWirte() {
		try {
			Thread.sleep(2016);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
