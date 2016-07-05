package note.java.lang.thread;

/**
 * stop：此方法源于jdk1.0,由于容易使业务不可控，已经被弃用。让线程暴力停止
 */
public class NThreadStop {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println("今天，我要打十个！");
		for (int i = 1; i <= 10; i++) {
			// 打之前先休息调整一下
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 开始打
			System.out.println("我打的人数：" + i);
			// 然而打到第三个的时候我不想打了
			if (i == 3) {
				System.out.println("不想打了。。。");
				Thread.currentThread().stop();
			}
		}
		System.out.println("十个打完了！");
	}
}
