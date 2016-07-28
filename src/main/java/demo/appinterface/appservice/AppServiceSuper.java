package demo.appinterface.appservice;

import java.util.HashMap;
import java.util.Map;

import demo.appinterface.config.AppServerConfig;

/**
 * 应用服务父类
 *
 */
public class AppServiceSuper implements AppServerConfig {
	Map<String, Object> paramMap = null; // 请求数据
	Map<String, Object> businessMap = null; // 返回数据

	public AppServiceSuper(Map<String, Object> paramMap) {
		if (paramMap == null || paramMap.keySet().size() == 0) {
			throw new RuntimeException("请求参数为空");
		}
		// 初始化交互数据
		this.paramMap = paramMap;
		this.businessMap = this.getInitRspMap();
	}

	/**
	 * 获取一个默认的map
	 * @return
	 */
	private Map<String, Object> getInitRspMap() {
		Map<String, Object> defMap = new HashMap<String, Object>();
		defMap.put(RESULT_STATUS, false);
		defMap.put(RESULT_ISNULL, false);
		defMap.put(RESULT_MSG, "");
		return defMap;
	}

}
