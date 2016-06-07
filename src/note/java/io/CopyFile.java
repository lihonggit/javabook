package note.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 拷贝文件Demo
 *
 */
public class CopyFile {

	/**
	 * 普通字节流方式
	 * @param srcPath 源路径
	 * @param targetPath 目标路径
	 * @return
	 */
	public static boolean copyFile(String srcPath, String targetPath) {
		boolean success = false;
		File fIn, fOut = null;
		InputStream i = null;
		OutputStream o = null;
		int length = 0;

		try {
			fIn = new File(srcPath);
			fOut = new File(targetPath);
			i = new FileInputStream(fIn);
			o = new FileOutputStream(fOut);
			byte[] read = new byte[1024 * 10];
			while ((length = i.read(read)) != -1) {
				o.write(read, 0, length);
			}
			o.flush();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (i != null) {
				try {
					i.close();
				} catch (IOException e) {
				}
			}
			if (o != null) {
				try {
					o.close();
				} catch (IOException e) {
				}
			}
		}
		return success;
	}

	/**
	 * 缓冲字节流方式
	 * @param srcPath 源路径
	 * @param targetPath 目标路径
	 * @return
	 */
	public static boolean copyFileBuffer(String srcPath, String targetPath) {
		boolean success = false;
		File fIn, fOut = null;
		InputStream i = null;
		OutputStream o = null;
		BufferedInputStream bi = null;
		BufferedOutputStream bo = null;
		int length = 0;

		try {
			fIn = new File(srcPath);
			fOut = new File(targetPath);
			i = new FileInputStream(fIn);
			o = new FileOutputStream(fOut);
			bi = new BufferedInputStream(i);
			bo = new BufferedOutputStream(o);

			byte[] read = new byte[1024 * 10];
			while ((length = bi.read(read)) != -1) {
				bo.write(read, 0, length);
			}
			bo.flush();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bi != null) {
				try {
					bi.close();
				} catch (IOException e) {
				}
			}
			if (bo != null) {
				try {
					bo.close();
				} catch (IOException e) {
				}
			}
		}

		return success;
	}

	public static void main(String[] args) {
		String srcPath = "F:\\MySql.zip";
		String targetPath = "F:\\MySql_Copy.zip";

		// 普通方式
		boolean b = CopyFile.copyFile(srcPath, targetPath);

		// 缓冲方式
		// boolean b = CopyFile.copyFileBuffer(srcPath, targetPath);

		if (b) {
			System.out.println("copy成功！");
		} else {
			System.out.println("copy失败！");
		}

	}
}
