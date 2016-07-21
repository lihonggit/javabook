package note.java.lang.exception;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池异常的捕获
 * (通过重写ThreadPoolExecutor的afterExecute方法,并配合submit执行方法来实现；
 * 这里如果调用execute方法执行不将处理后的Runnable对象包装成Future<?>去执行，所以也不会去调用get()，自然就不能达到捕获异常的效果)
 */
public class NThreadPoolException {
	public static void main(String[] args) {
		ExecutorService service = null;
		// 这里的new直接复制源码里面Executros点系列方法的实现
		service = new MyThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		// 假如有100个任务
		for (int i = 1; i <= 100; i++) {
			Thread thread = new Thread(new ThreadExceptionDemo(i));
			service.execute(thread);
		}
		service.shutdown();

		// 再看看是否真的结束线程池了
		System.out.println("线程池运行状态：" + service.isTerminated());
		System.out.println("程序结束！");
	}
}

/**
 * 继承ThreadPoolExecutor，重写方法
 */
class MyThreadPoolExecutor extends ThreadPoolExecutor {
	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	/**
	 * 线程执行后会调用这个方法。重写这个方法，来记录异常
	 */
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		if (r instanceof Future<?>) {
			Future<?> future = (Future<?>) r;
			try {
				future.get();
			} catch (Exception e) {
				System.out.println("在这里记录异常");
			}
		}
	}

}

class ThreadExceptionDemo implements Runnable {
	private int num = 0;

	public ThreadExceptionDemo(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println(num);
		throw new RuntimeException(num + "");
	}
}