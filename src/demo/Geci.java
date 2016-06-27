package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.RegexUtils;

/**
 * 读取lrc类型文件并按时规定间显示歌词
 */
public class Geci {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");

	public static void main(String[] args) {
		List<Gc> lrcDataList = new ArrayList<Gc>();
		Gc lrcData = new Gc();
		Date tempDate = null;
		String content = null;
		content = getFileContent("file/安河桥.lrc");
		content = content.replaceAll("\\]", "");

		boolean b = true;

		String[] contents = content.split("\\[");

		for (int i = 0; i < contents.length; i++) {
			String thisLine = contents[i];
			String thisTime = null;
			String thisValue = null;
			// 分两种方式取值，通过判断每行前两个字符串就行了
			if (thisLine.length() > 2 && RegexUtils.isInteger(thisLine.substring(0, 2))) {
				// 歌词
				thisTime = thisLine.length() > 8 ? thisLine.substring(0, 9) : null;
				thisValue = thisLine.length() > 8 ? thisLine.substring(8, thisLine.length()) : "";
			} else {
				// 介绍
				thisValue = thisLine;
				// 去掉关键词A
				thisValue = thisValue.replace("ti:", "");
				thisValue = thisValue.replace("ar:", "");
				thisValue = thisValue.replace("al:", "");
				thisValue = thisValue.replace("by:", "");
				thisValue = thisValue.replace("t_time:", "");
			}

			int time = 0;
			Date thisDate = null;
			try {
				if (thisTime != null) {
					thisDate = dateFormat.parse(thisTime);
				}
			} catch (Exception e) {
			}
			if (thisDate != null) {
				if (tempDate != null) {
					time = (int) (thisDate.getTime() - tempDate.getTime());
				}
				tempDate = thisDate;
			}

			lrcData = new Gc();
			lrcData.setTime(time);
			// 前进或后退歌词
			if (b && time > 0) {
				lrcData.setTime(time - 1000);
				b = false;
			}
			lrcData.setValue(thisValue);

			lrcDataList.add(lrcData);
		}

		// ////////////数据已得到，来显示吧///////////////
		for (Gc gc : lrcDataList) {
			try {
				if (gc.getTime() == 0 && "".equals(gc.getValue())) {
					continue;
				}
				Thread.sleep(gc.getTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(gc.getValue());
		}
	}

	public static String getFileContent(String fileName) {
		StringBuffer returnStr = new StringBuffer("");
		try {
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String tempString = "";
			while ((tempString = reader.readLine()) != null) {
				returnStr.append(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnStr.toString();
	}

}

class Gc {
	private Integer time = 0;
	private String value = "";

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		if (time < 0) {
			time = 0;
		}
		this.time = time;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}