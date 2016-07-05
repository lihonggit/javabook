package note.java.lang.thread;

/**
 * interrupt:中断线程,不要用来停止线程操作！
 * （JavaDoc:如果当线程如果调用了某些方法，比如说调用了sleep()后而进入了一种阻塞的状态之时，此时如果这个线程再被调用了interrupt()
 * ， 它会产生两个结果：
 * 1.他的中断状态被清除cleared，而不是被设置，那么线程的isInterrupted()方法就不能返回一个表示是否被中断的正确状态，
 * 导致while循环不能正确的退出。 2.sleep()方法会收到一个InterruptedException。 ...还是使用退出旗标吧）
 */
public class NThreadInterrupt {
	public static void main(String[] args) {
		System.out.println("主线程开始...");
		ChildThread childThread = new ChildThread();
		childThread.start();

		// 主线程执行3秒后，调用interrupt方法，中断子线程
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		childThread.interrupt();

		System.out.println("主线程结束...");

		Thread.currentThread().interrupt();
	}
}

class ChildThread extends Thread {
	@Override
	public void run() {
		System.out.println("子线程开始...");
		// 如果线程没中断
		while (!this.isInterrupted()) {
			try {
				// 就是这里，如果设置成1000，很可能程序会正常停止，但是如果设置成2000，就会出错！
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("子线程还在跑。");
		}
	}
}
