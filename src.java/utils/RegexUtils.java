package utils;

import java.util.regex.Pattern;

/**
 * 正则表达式帮助类
 *
 */
public class RegexUtils {

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
