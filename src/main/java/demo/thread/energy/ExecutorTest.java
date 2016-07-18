package demo.thread.energy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**  
* 线程池newFixedThreadPool的使用。  
*  
*/
public class ExecutorTest {
	public static void main(String args[]) {
		System.out.println(new ExecutorTest().haha());
	}

	// 0 停止 1 执行中
	private static int status = 0;

	static StringBuffer haha = new StringBuffer();
	static int ii = 0;
	static int jj = 0;

	public String haha() {
		if (status != 1) {
			// 建立一个容量为5的固定尺寸的线程池
			ExecutorService cachedThreadPool = Executors.newSingleThreadExecutor();
			status = 1;
			// 判断可是线程池可以结束
			for (int i = 0; i < 100; i++) {

				cachedThreadPool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.print("哈哈i:" + ++jj + '\n');
					}
				});
			}
			for (int j = 0; j < 100; j++) {

				cachedThreadPool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.print("哈哈j:" + ++ii + '\n');
					}
				});
			}
			try {
				cachedThreadPool.shutdown();
				cachedThreadPool.awaitTermination(0, TimeUnit.MILLISECONDS);
				System.out.print("over" + '\n');
			} catch (InterruptedException ignored) {
			}
		}
		return haha.toString() + "aa";
	}
}
