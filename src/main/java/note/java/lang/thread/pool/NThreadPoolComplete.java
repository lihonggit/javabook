package note.java.lang.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 判断线程池所有任务是否执行完毕
 *
 */
public class NThreadPoolComplete {

	public static void main(String args[]) throws InterruptedException {
		// 创建拥有一个线程的线程池，依次执行任务，当然这里也可使用其他线程池实现
		ExecutorService exe = Executors.newSingleThreadExecutor();
		for (int i = 1; i <= 5; i++) {
			exe.execute(new SubThread2(i));
		}
		exe.shutdown();
		while (true) {
			// 判断是否结束
			if (exe.isTerminated()) {
				System.out.println("结束了！");
				break;
			}
			// 延迟检查，减少系统开销
			Thread.sleep(200);
		}
		System.out.println("主线程完毕！");
	}
	
}

/**
 * 执行用的子线程
 */
class SubThread implements Runnable {
	private int i;

	public SubThread(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		try {
			// 延迟执行
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(i);
	}

}
