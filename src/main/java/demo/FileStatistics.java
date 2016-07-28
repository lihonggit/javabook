package demo;

import java.io.File;

import utils.FileUtils;

/**
 * 文件统计
 *
 */
public class FileStatistics {

	public static void main(String[] args) throws Exception {
		String path = "D:/workspaceJ2EE/javabook";
		File root = new File(path);
		FileStatistics statistics = new FileStatistics();
		statistics.doCalc(root, 0);
		statistics.printResult();
	}

	private int fileCount = 0;
	private int direCount = 0;
	private int charCount = 0;

	/**
	 * 递归方法，记录并打印文件信息
	 * @param dir
	 * @param thisLayer
	 * @throws Exception
	 */
	public final void doCalc(File dir, final int thisLayer) throws Exception {
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			File thisFile = fs[i];
			if (thisFile.isDirectory()) {
				direCount++;
				System.out.println(getSp(thisLayer) + "+" + thisFile.getName());
				if (!thisFile.getName().equals(".git") && !thisFile.getName().equals(".settings") && !thisFile.getName().equals("target")) {
					doCalc(thisFile, thisLayer + 1);
				}
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
	private String getSp(int sp) {
		String tab = "	";
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < sp; i++) {
			buffer.append(tab);
		}
		return buffer.toString();
	}

	public void printResult() {
		System.out.println("文件数：\t" + fileCount);
		System.out.println("文件夹数：\t" + direCount);
		System.out.println("字数：\t" + charCount);
	}

	// get & set
	public int getFileCount() {
		return fileCount;
	}

	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	public int getDireCount() {
		return direCount;
	}

	public void setDireCount(int direCount) {
		this.direCount = direCount;
	}

	public int getCharCount() {
		return charCount;
	}

	public void setCharCount(int charCount) {
		this.charCount = charCount;
	}

}
