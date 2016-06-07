package note.java.io;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件Demo
 *
 */
public class CreateFileDemo {

	/**
	 * 创建一个文件，如果文件夹不存在执行创建文件夹后再创建文件
	 * 
	 * @param filePath
	 *            文件路径
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static boolean createNewFile(String filePath, String fileName) {
		// 文件夹对象
		File dir = new File(filePath);
		// 如果文件夹对象不存在，执行创建
		if (!dir.exists()) {
			// 用mkdirs创建文件路径中所有不存在的文件夹
			dir.mkdirs();
		}

		// 文件对象
		File file = new File(filePath + File.separator + fileName);
		if (!file.exists()) {
			try {
				if (file.createNewFile()) {
					return true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			return true;
		}

		// 默认创建失败
		return false;
	}

	public static void main(String[] args) {
		boolean b = createNewFile("D:/demotest", "The测试.txt");
		if (b) {
			System.out.println("成功！");
		} else {
			System.out.println("失败！");
		}
	}
}
