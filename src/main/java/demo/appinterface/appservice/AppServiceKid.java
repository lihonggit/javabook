package demo.appinterface.appservice;

import java.util.Map;

import demo.appinterface.dao.KidService;
import demo.appinterface.model.Kid;

/**
 * Kid app业务类 
 *
 */
public class AppServiceKid extends AppServiceSuper {

	public AppServiceKid(Map<String, Object> paramMap) {
		super(paramMap);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 得到kid业务
	 * @return
	 */
	public Map<String, Object> getKid() {
		try {
			// ==============得到业务参数==============
			String name = (String) paramMap.get("name");
			int age = (int) paramMap.get("age");
			boolean married = (boolean) paramMap.get("married");

			// ==============检查参数==============
			if (name == null) {
				businessMap.put(RESULT_MSG, "参数粗我");
				return businessMap;
			}

			// ==============调用servcice方法处理逻辑==============
			KidService service = new KidService();
			Kid kid = service.getKidBySome(name, age, married);

			// ==============业务数据==============
			if (kid != null) {
				businessMap.put(RESULT_ISNULL, true);
				
				// put业务数据
				businessMap.put("userName", kid.getUserName());
				businessMap.put("age", kid.getAge());
				businessMap.put("married", kid.getMarried());
				businessMap.put("lollipops", kid.getLollipops());
			}
			// put状态数据
			businessMap.put(RESULT_STATUS, true);
		} catch (Exception e) {
			businessMap.put(RESULT_MSG, e.getMessage());
		}

		return businessMap;
	}
}
