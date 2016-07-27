package demo.gson.appservice;

import java.util.HashMap;
import java.util.Map;

import demo.gson.dao.KidService;
import demo.gson.model.Kid;
import demo.gson.util.AppServerUtil;

/**
 * Kid app业务类 
 *
 */
public class AppServiceKid {

	/**
	 * 得到kid业务
	 * @return
	 */
	public Map<String, Object> getKid() {
		// ==============得到一个默认==============
		Map<String, Object> businessMap = AppServerUtil.getInitMap();

		// ==============调用servcice方法处理逻辑==============
		Kid kid = KidService.getKid();

		// ==============初始化返回对象==============
		businessMap.put("userName", kid.getUserName());
		businessMap.put("age", kid.getAge());
		businessMap.put("sex", kid.getSex());
		businessMap.put("lollipops", kid.getLollipops());

		return businessMap;
	}
}
