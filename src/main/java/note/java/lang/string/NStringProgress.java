package note.java.lang.string;

/**
 * 命令行不换行效果
 * (请在cmd控制台执行)
 */
public class NStringProgress {
	private final static String BACKSPACES = getBackspaces(62);
	private static int i = 0;
	private static int range = 300;

	public static void main(String[] args) {
		while (true) {
			int completeNum = getXmas();
			if (completeNum > 60) {
				System.out.print("\ncompleted!");
				System.exit(0);
			}
			System.out.print(BACKSPACES); // 输出很多个退格符
			try {
				System.out.printf("[%s]", getFormatStr(completeNum));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static String getFormatStr(int completeNum) {
		if (completeNum > 60) {
			completeNum = 60;
		} else if (completeNum < 0) {
			completeNum = 0;
		}
		char char1 = '=';
		char char2 = '>';
		int noCompleteNum = 60 - completeNum;
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

	public static int getXmas() {
		range = range - 5;

		int slp = (int) (Math.random() * range--);
		try {
			Thread.sleep(slp);
		} catch (Exception e) {

		}
		return i++;
	}
}