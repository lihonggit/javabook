package utils.jdbc;

import java.util.List;
import java.util.Map;

public class TestMain {
	public static void main(String[] args) {
		String sql = "select nick_name from customer";
		List<Map<String, Object>> values = JdbcUtils.findModeResult(sql, null);
		for (Map<String, Object> map : values) {
			System.out.println(map.get("NICK_NAME"));
		}
		JdbcUtils.findMoreRefResult("", null, TestMain.class);
	}
}
