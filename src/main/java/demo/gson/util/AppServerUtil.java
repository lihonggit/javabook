package demo.gson.util;

import java.util.HashMap;
import java.util.Map;

import demo.gson.config.AppServerInterface;

public class AppServerUtil {
	/**
	 * 获取一个默认的map
	 * @return
	 */
	public static Map<String, Object> getInitMap() {
		Map<String, Object> defMap = new HashMap<String, Object>();
		defMap.put(AppServerInterface.RESULT_STATUS, false);
		defMap.put(AppServerInterface.RESULT_MSG, "未知错误");
		return defMap;
	}
}
