package note.java.lang.thread;

/**
 * join方法：让其他线程停止，等待当前线程执行完毕
 */
public class NThreadJoin {
	private static boolean childIsOk = false;

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		mainThread.setName("老师");
		System.out.println(mainThread.getName() + "要关上厕所门,准备下班了！");
		System.out.println("...");

		System.out.println("但是,半路杀出一个爱拉屎的熊孩子");
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("熊孩子拉屎了~ ");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("熊孩子终于拉完了！");
				childIsOk = true;
			}
		}, "我是熊孩子");
		thread.start();
		// Tip:分别解开/注释下面几句代码，然后运行对比结果
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("...");
		System.out.println(mainThread.getName() + "关上了厕所门！\n");

		if (childIsOk) {
			System.out.println("老师等待熊孩子出来后，关上了门，是个好老师！");
		} else {
			System.out.println("尼玛，熊孩子被关厕所了，老师背锅了！");
		}
	}
}
