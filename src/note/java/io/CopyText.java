package note.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 拷贝文本文件Demo
 *
 */
public class CopyText {
	public static void main(String[] args) {

		File fIn, fOut = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			fIn = new File("d:/demotest/javatest.txt");
			fOut = new File("d:/demotest/javatest_副本.txt");
			reader = new BufferedReader(new FileReader(fIn));
			writer = new BufferedWriter(new FileWriter(fOut));
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
				System.out.println(line);
			}
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
			}
		}
	}
}
