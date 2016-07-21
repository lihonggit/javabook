package note.java.lang.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 子线程异常的捕获
 * 但是这样有个弊端：get()是一个阻塞方法，会导致主线程阻塞
 *
 */
public class NThreadException {
	public static void main(String[] args) {
		// errorDemo();
		successDemo1();
		// 还有通过设置HandlerThreadFactory就不介绍了
	}

	// 成功示例：先声明一个线程池，在线程池中运行一个包含异常的线程，通过线程池抛出
	public static void successDemo1() {
		boolean isCatch = false;
		try {
			ExecutorService service = Executors.newCachedThreadPool();
			Future<?> future = service.submit(new SonThreadExceptionDemo());
			service.shutdown();
			// 这句最关键，它将抛出所执行线程中所抛出的所有异常
			future.get();
		} catch (Exception e) {
			// 结果
			isCatch = true;
		}
		if (isCatch) {
			System.out.println("我捕获到了子线程异常！");
		} else {
			System.out.println("并没有捕获到子线程异常！");
		}
	}

	// 错误示例：运行一个包含异常的线程，并尝试捕获它
	public static void errorDemo() {
		boolean isCatch = false;
		try {
			new Thread(new SonThreadExceptionDemo()).start();
		} catch (Exception e) {
			// 结果
			isCatch = true;
		}
		if (isCatch) {
			System.out.println("我捕获到了子线程异常！");
		} else {
			System.out.println("并没有捕获到子线程异常！");
		}
	}
}

class SonThreadExceptionDemo implements Runnable {
	@Override
	public void run() {
		throw new RuntimeException();
	}
}
