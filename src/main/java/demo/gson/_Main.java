package demo.gson;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import demo.gson.appservice.AppServiceKid;

public class _Main {
	public static void main(String[] args) {
		// 得到登录对象
		Gson gson = new Gson();
		AppServiceKid appServiceKid = new AppServiceKid();
		appServiceKid.getKid();
		
	}
	
	/**
	 * 登录服务
	 * @return
	 */
	public Map<String, Object> appServerLogin() {
		Map<String, Object> userObj = new HashMap<String, Object>();
		return userObj;
	}
}
