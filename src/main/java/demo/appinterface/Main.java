package demo.appinterface;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import demo.appinterface.appservice.AppServiceKid;
import demo.appinterface.util.FormatUtil;

public class Main {

	static Gson gson = new Gson();

	public static void main(String[] args) {
		// 得到登录对象
		Map<String, Object> reqMap = new HashMap<>();
		// 参数类型错误示例
		// reqMap.put("name", "lh");
		// reqMap.put("age", "2");
		// reqMap.put("married", "ii");

		// 结果为空示例
		// reqMap.put("name", "柯阿哥");
		// reqMap.put("age", 20);
		// reqMap.put("married", false);

		// 正确示例
		reqMap.put("name", "柯宝宝");
		reqMap.put("age", 20);
		reqMap.put("married", false);

		// 模拟调用服务
		AppServiceKid appServiceKid = new AppServiceKid(reqMap);
		// 调用服务方法
		Map<String, Object> rspMap = appServiceKid.getKid();

		// 打印返回json
		System.out.println(">>>>>>>>>>>>>>>>>>>");
		String json = gson.toJson(rspMap);
		System.out.println(FormatUtil.formatJson(json));
	}

}
