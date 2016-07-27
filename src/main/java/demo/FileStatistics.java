package demo;

import java.io.File;

import utils.FileUtils;

/**
 * 文件统计
 *
 */
public class FileStatistics {

	public static void main(String[] args) throws Exception {
		String path = "D:/workspaceJ2EE/javabook/src/main/java/note/dp";
		File root = new File(path);
		showAllFiles(root, 0);
		System.out.println("文件数：\t" + fileCount);
		System.out.println("文件夹数：\t" + direCount);
		System.out.println("字数：\t" + charCount);
	}

	private static int fileCount = 0;
	private static int direCount = 0;
	private static int charCount = 0;

	private final static void showAllFiles(File dir, final int thisLayer) throws Exception {
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			File thisFile = fs[i];
			if (thisFile.isDirectory()) {
				direCount++;
				System.out.println(getSp(thisLayer) + "+" + thisFile.getName());
				showAllFiles(thisFile, thisLayer + 1);
			} else {
				fileCount++;
				System.out.println(getSp(thisLayer) + "-" + thisFile.getName());
				String content = FileUtils.getFileContent(thisFile.getAbsolutePath());
				charCount += content.length();
			}
		}
	}

	/**
	 * 拼装tab符
	 * @param sp
	 * @return
	 */
	static String getSp(int sp) {
		String tab = "	";
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < sp; i++) {
			buffer.append(tab);
		}
		return buffer.toString();
	}

}
