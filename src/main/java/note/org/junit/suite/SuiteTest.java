package note.org.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite测试套件,用于测试一组类
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ Suite1.class, Suite2.class, Suite3.class })
public class SuiteTest {
	// 这里面什么也不用写，也不能写
}
