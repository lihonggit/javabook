package note.java.lang.thread.pool;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerTest {

	public static void main(String[] args) {
		ScheduledExecutorService s = new ScheduledThreadPoolExecutor(1);
		s.scheduleAtFixedRate(new InnerTimerTest(), 0, 1, TimeUnit.SECONDS);
	}

	private static class InnerTimerTest implements Runnable {

		private final static String BACKSPACES = getBackspaces(100);

		public void run() {
			System.out.print(BACKSPACES); // 输出很多个退格符
			int completeNum = Xmas.getXmas();
			// System.out.printf("正在复制%s", getFormatStr(completeNum));
			try {
				System.out.printf("%s", getFormatStr(completeNum));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private static String getFormatStr(int completeNum) {
			if (completeNum > 100) {
				completeNum = 100;
			} else if (completeNum < 0) {
				completeNum = 0;
			}
			char char1 = '=';
			char char2 = '>';
			int noCompleteNum = 100 - completeNum;
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < completeNum; i++) {
				buffer.append(char2);
			}
			for (int i = 0; i < noCompleteNum; i++) {
				buffer.append(char1);
			}
			return buffer.toString();
		}

		/**
		 * 生成多个退格符
		 * 
		 * @param count
		 * @return
		 */
		private static String getBackspaces(int count) {
			char[] chs = new char[count];
			for (int i = 0; i < count; i++) {
				chs[i] = '\b';
			}
			return new String(chs);
		}
	}
}

class Xmas {
	private static int i = 0;
	private static int range = 20;

	public static int getXmas() {
		int slp = (int) (Math.random() * range--);
		try {
			Thread.sleep(slp);
		} catch (Exception e) {

		}
		return i++;
	}
}