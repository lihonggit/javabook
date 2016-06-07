package note.java.util.regex;

import java.util.regex.Pattern;

public class _RegexUtils {

	/**
	 * 数字是否为判断
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
}
