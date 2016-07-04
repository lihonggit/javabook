package note.java.lang.thread;

/**
 * 线程
 */
public class NThreadAV {
	public static void main(String[] args) throws InterruptedException {
		Thread actor = new Actor();
		actor.setPriority(1);
		actor.setName("东尼大木");
		actor.start();
		Thread actress = new Thread(new Actress(), "松岛枫");
		actress.setPriority(10);
		actress.start();
	}
}

/**
 * 男演员，继承Thread
 */
class Actor extends Thread {

	@Override
	public void run() {
		System.out.println("男演员：" + getName() + "出（shang）场(chuang)了！");
		boolean keep = true;
		int count = 0;
		while (keep) {
			System.out.println(getName() + "展开了第" + ++count + "轮攻势！");
			if (20 == count)
				keep = false;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName() + "进攻结束了！");
	}

}

/**
 * 女演员，实现Runnable接口
 */
class Actress implements Runnable {

	@Override
	public void run() {
		System.out.println("女演员：" + Thread.currentThread().getName() + "出（shang）场(chuang)了！");
		boolean keep = true;
		int count = 0;
		while (keep) {
			System.out.println(Thread.currentThread().getName() + "进行了第" + ++count + "轮防守！");
			if (20 == count)
				keep = false;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "防守结束了！");
	}

}