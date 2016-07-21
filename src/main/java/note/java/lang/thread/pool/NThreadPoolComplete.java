package note.java.lang.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 判断线程池所有任务是否执行完毕
 *
 */
public class NThreadPoolComplete {
	
	public static String status = "NULL";

	public static void main(String args[]) throws InterruptedException {
		
		
		// 创建拥有一个线程的线程池，依次执行任务，当然这里也可使用其他线程池实现
		ExecutorService exe = Executors.newSingleThreadExecutor();
		// 任务执行10秒
		for (int i = 1; i <= 10; i++) {
			exe.execute(new SubThread(i));
		}
		exe.shutdown();
		// 启动检查线程
		new CheckThread(exe).start();
		
		
		while (!"执行完毕".equals(status)) {
			// 2秒检查一次
			Thread.sleep(2000);
			if ("执行完毕".equals(status)) {
				System.out.println(status);
			}
		}
		System.out.println("主线程完毕！");
	}
	
}

/**
 * 检查状态的线程，
 *
 */
class CheckThread extends Thread {
	private ExecutorService exe;
	public CheckThread(ExecutorService exe){
		this.exe = exe;
	}
	@Override
	public void run() {
		while (true) {
			// 判断是否结束
			if (exe.isTerminated()) {
				NThreadPoolComplete.status = "执行完毕";
				break;
			}
			// 延迟检查，减少系统开销
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
			NThreadPoolComplete.status = "执行中...";
			// 延迟执行
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			NThreadPoolComplete.status = "执行出错";
			e.printStackTrace();
		}
		System.out.println(i);
	}

}
