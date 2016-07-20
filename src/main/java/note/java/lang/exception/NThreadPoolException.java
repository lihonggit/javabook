package note.java.lang.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池异常的捕获 功能：当任意一个线程池里的子线程发生异常，结束线程池其他所有任务
 */
public class NThreadPoolException {
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newCachedThreadPool();
			// 假如有100个任务
			for (int i = 1; i <= 100; i++) {
				Future<?> future = service.submit(new ThreadExceptionDemo(i));
				future.get();
			}

		} catch (Exception e) {
			System.out.println("发生异常!" + e.getMessage());
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
		// 再看看是否真的结束线程池了
		System.out.println("线程池运行状态：" + service.isTerminated());
		System.out.println("程序结束！");
	}
}

class ThreadExceptionDemo implements Runnable {
	private int num = 0;

	public ThreadExceptionDemo(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		throw new RuntimeException(num + "");
	}
}