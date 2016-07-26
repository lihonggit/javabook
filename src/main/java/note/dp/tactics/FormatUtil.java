package note.dp.tactics;

import java.text.DecimalFormat;

public class FormatUtil {
	private static DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * 保留2位小数
	 * 
	 * @return
	 */
	public static double format2Decimal(double value) {
		return Double.valueOf(df.format(value));
	}
}
