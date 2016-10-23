package com.diushabao.biz;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.diushabao.DsbInterfaceTest;

public class PostData {
	// 包装
	private Map<String, Object> bz = null;

	public Map<String, Object> do11() throws JSONException {
		bz.put("userName", "11");
		bz.put("passWord", "11");
		bz.put("longitudes", "11");
		bz.put("phoneNo", "11");
		
		return bz;
	}
	
	public PostData() {
		bz = new HashMap<String, Object>();
		if (DsbInterfaceTest.URL_HEADER.indexOf("192.168") != -1 || DsbInterfaceTest.URL_HEADER.indexOf("localhost") != -1) {
			// 本地
			bz.put("token", "0000000049df63060149dfc001ca005b_1993-06-06");
		} else {
			// 外网
			bz.put("token", "ff808081558204d2015596879afe0f5e_2016-07-19");
		}
	}


	public Map<String, Object> do103() throws JSONException {
		bz.put("source", "103");
		// bz.put("movementId", "fc909f174b5ca63d014b72339d4a06b0");
		// server
		bz.put("movementId", "000000004a574940014a627af02c080d");

		return bz;
	}

	public Map<String, Object> do107() throws JSONException {
		bz.put("source", "107");
		// bz.put("activityId", "000000004a574940014a6b4fabda0fd4");
		// server
		bz.put("activityId", "000000004a574940014a6b4fabda0fd4");
		bz.put("pageNo", "1");

		return bz;
	}

	public Map<String, Object> do202() throws JSONException {
		bz.put("source", "202");
		bz.put("dynamicId", "0000000049f031750149f43e9881065b");
		// server
		// bz.put("dynamicId", "ff808081549ea05f01554ff0356a1ea1");

		return bz;
	}

	public Map<String, Object> do001() throws JSONException {
		bz.put("source", "001");
		bz.put("tel", "13860472997");
		bz.put("type", "0");
		bz.put("source", "001");
		bz.put("password", "123456");

		return bz;
	}

	public Map<String, Object> do507() throws JSONException {
		bz.put("source", "507");
		bz.put("status", "0");

		return bz;
	}

	public Map<String, Object> do508() throws JSONException {
		bz.put("source", "508");
		bz.put("orderId", "201606300000006");

		return bz;
	}

	public Map<String, Object> do527() throws JSONException {
		bz.put("source", "527");

		return bz;
	}

	public Map<String, Object> do530() throws JSONException {
		bz.put("source", "530");
		bz.put("productId", "00005543");
//		bz.put("storeId", "fc909f174b395ddf014b39642530000c");
		bz.put("communityId", "000000004a4cf484014a571685d40318");
		// server
		bz.put("storeId", "fc909f174b395ddf014b39642530000c");
		// bz.put("communityId", "000000004a4cf484014a571685d40318");
		bz.put("storeType", "1");

		return bz;
	}

	public Map<String, Object> do531() throws JSONException {
		bz.put("storeType", "1");
		bz.put("source", "531");
		bz.put("productId", "00002569");
		bz.put("communityId", "fc909f1d4cb16218014d325eabf30c74");

		return bz;
	}

	/**
	 * http://182.131.21.111:99/app/service?AllParam={"position":"1","source":"401","token":"ff808081558204d2015596879afe0f5e_2016-06-30","channel":"首页"}
	 * http://192.168.0.166:8080/dsb/app/service?AllParam={"position":"1","source":"401","token":"0000000049e644b50149e64ce277007e_2014-12-02","channel":"首页"}
	 * @param position
	 * @return
	 * @throws JSONException
	 */
	public Map<String, Object> do401_online(String position) throws JSONException {
		bz.put("source", "401");
		bz.put("channel", "首页");
		bz.put("position", position);

		return bz;
	}

}