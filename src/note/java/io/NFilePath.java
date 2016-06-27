package note.java.io;

import java.io.File;

public class NFilePath {
	public static void main(String[] args) {
		
		System.out.println(NFilePath.class.getResource(""));
		File file = new File(".");
		System.out.println(file.getAbsolutePath());
	}
}
