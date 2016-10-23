package com.wftong.biz;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class PostData {
	// 包装
	private Map<String, Object> bz = null;
	private Gson gson = new Gson();

	public PostData() {
		bz = new HashMap<String, Object>();
	}
	
	public Map<String, Object> do001() {
		Map<String, Object> dataBody = new HashMap<>();
		dataBody.put("userName", "yongxin@qq.com");
		dataBody.put("passWord", "111111");
		dataBody.put("longitudes", "");
		dataBody.put("phoneNo", "");
		
		dataBody.put("source", "001");
		dataBody.put("token", "ff808081558204d2015596879afe0f5e_2016-07-19");
		bz.put("reqBody", gson.toJson(dataBody));
		return bz;
	}
	
	
	

//	public Map<String, Object> do11() throws JSONException {
//		bz.put("source", "11");
//
//		return bz;
//	}
//
//	public Map<String, Object> do103() throws JSONException {
//		bz.put("source", "103");
//		// bz.put("movementId", "fc909f174b5ca63d014b72339d4a06b0");
//		// server
//		bz.put("movementId", "000000004a574940014a627af02c080d");
//
//		return bz;
//	}
//
//	public Map<String, Object> do107() throws JSONException {
//		bz.put("source", "107");
//		// bz.put("activityId", "000000004a574940014a6b4fabda0fd4");
//		// server
//		bz.put("activityId", "000000004a574940014a6b4fabda0fd4");
//		bz.put("pageNo", "1");
//
//		return bz;
//	}
//
//	public Map<String, Object> do202() throws JSONException {
//		bz.put("source", "202");
//		bz.put("dynamicId", "0000000049f031750149f43e9881065b");
//		// server
//		// bz.put("dynamicId", "ff808081549ea05f01554ff0356a1ea1");
//
//		return bz;
//	}
//
//	public Map<String, Object> do001() throws JSONException {
//		bz.put("source", "001");
//		bz.put("tel", "13860472997");
//		bz.put("type", "0");
//		bz.put("source", "001");
//		bz.put("password", "123456");
//
//		return bz;
//	}
//
//	public Map<String, Object> do507() throws JSONException {
//		bz.put("source", "507");
//		bz.put("status", "0");
//
//		return bz;
//	}
//
//	public Map<String, Object> do508() throws JSONException {
//		bz.put("source", "508");
//		bz.put("orderId", "201606300000006");
//
//		return bz;
//	}
//
//	public Map<String, Object> do527() throws JSONException {
//		bz.put("source", "527");
//
//		return bz;
//	}
//
//	public Map<String, Object> do530() throws JSONException {
//		bz.put("source", "530");
//		bz.put("productId", "00005543");
////		bz.put("storeId", "fc909f174b395ddf014b39642530000c");
//		bz.put("communityId", "000000004a4cf484014a571685d40318");
//		// server
//		bz.put("storeId", "fc909f174b395ddf014b39642530000c");
//		// bz.put("communityId", "000000004a4cf484014a571685d40318");
//		bz.put("storeType", "1");
//
//		return bz;
//	}
//
//	public Map<String, Object> do531() throws JSONException {
//		bz.put("storeType", "1");
//		bz.put("source", "531");
//		bz.put("productId", "00002569");
//		bz.put("communityId", "fc909f1d4cb16218014d325eabf30c74");
//
//		return bz;
//	}
//
//	/**
//	 * http://182.131.21.111:99/app/service?AllParam={"position":"1","source":"401","token":"ff808081558204d2015596879afe0f5e_2016-06-30","channel":"首页"}
//	 * http://192.168.0.166:8080/dsb/app/service?AllParam={"position":"1","source":"401","token":"0000000049e644b50149e64ce277007e_2014-12-02","channel":"首页"}
//	 * @param position
//	 * @return
//	 * @throws JSONException
//	 */
//	public Map<String, Object> do401_online(String position) throws JSONException {
//		bz.put("source", "401");
//		bz.put("channel", "首页");
//		bz.put("position", position);
//
//		return bz;
//	}

}