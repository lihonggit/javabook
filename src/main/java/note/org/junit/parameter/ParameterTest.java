package note.org.junit.parameter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 测试多组数据
 *
 */
@RunWith(Parameterized.class)
public class ParameterTest {
	private int m = 0; // 预期值
	private int a = 0; // 参数1
	private int b = 0; // 参数2

	// 参数列表
	@Parameters
	public static Collection<Object[]> param() {
		return Arrays.asList(new Object[][] { { 1, 1, 0 }, { 2, 2, 0 } });
	}

	// 必要的构造函数，junit会通过反射来自动设值进来
	public ParameterTest(int m, int a, int b) {
		this.m = m;
		this.a = a;
		this.b = b;
	}

	// 测试主体方法
	@Test
	public void testAdd() {
		assertEquals(m, new Calc().add(a, b));
	}
}
