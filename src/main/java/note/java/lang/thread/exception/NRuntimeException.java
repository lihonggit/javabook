package note.java.lang.thread.exception;

/**
 * 运行时异常:发生时向外抛出异常，并中断当前流程,并且一直往外面抛，直到有try catch捕获它
 *
 */
public class NRuntimeException {
	public static void main(String[] args) {
		InnerTest test = new InnerTest();
		try {
			test.throwARuntimeException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

@SuppressWarnings("unused")
class InnerTest {
	public void throwARuntimeException() {
		if (false) {
			throw new RuntimeException("1");
		}
		if (false) {
			throw new RuntimeException("2");
		}

		throwARuntimeException2();

		System.out.println("正常结束...1");
	}

	public void throwARuntimeException2() {
		if (false) {
			throw new RuntimeException("3");
		}
		if (true) {
			throw new RuntimeException("4");
		}
		System.out.println("正常结束...2");
	}
}
