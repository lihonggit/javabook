package note.java.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 统一支援定位符的使用
 */
public class NURL {
	public static void main(String[] args) {
		try {
//				URL url = new URL("http://localhost:7070/MetaFscm/login/monitor/push/status");
//				URL url = new URL("http://localhost:7070/MetaFscm/login/monitor/push/status");
				URL url = new URL("http://test.sfdhb.com/");

//				 URL url = new URL("http://localhost:7070/MetaFscm/login/monitor/push");
				InputStream inputStream = url.openStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				String tempString = "";
				while ((tempString = bufferedReader.readLine()) != null) {
					System.out.println(tempString);
				}
				bufferedReader.close();
				// System.out.println(FileUtils.getFileContent(url.openStream(), true));
//				Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
