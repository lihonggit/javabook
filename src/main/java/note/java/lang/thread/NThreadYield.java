package note.java.lang.thread;

/**
 * yield：暂时交出该线程的CPU资源 （方法注释里面说:它是很少适合使用此方法。
 * 它可能是用于调试和测试的目的，它可能有助于重现由于竞争条件的错误非常有用。
 * 设计并发控制结构，如在java.util.concurrent.locks中包的那些，当它也可能是有用的。）
 */
public class NThreadYield {
	public static void main(String[] args) {
		Thread.yield();
	}
}
