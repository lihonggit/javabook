package com.diushabao;

import java.util.Map;

import com.diushabao.biz.PostData;
import com.diushabao.util.FormatUtil;
import com.diushabao.util.HttpUtil;

public class DsbInterfaceTest {
	public static final String URL_HEADER = "http://182.131.21.111:2080/app/service";

//	 public static final String URL_HEADER = "http://192.168.0.166:8080/dsb/app/service";

	public static void main(String[] args) throws Exception {
		// FormatUtil.printJson(doPost(new PostData().do11()));
		// FormatUtil.printJson(doPost(new PostData().do103()));
		// FormatUtil.printJson(doPost(new PostData().do107()));
		// FormatUtil.printJson(doPost(new PostData().do202()));
		// FormatUtil.printJson(doPost(new PostData().do001()));
//		 FormatUtil.printJson(doPost(new PostData().do107()));
//		 FormatUtil.printJson(doPost(new PostData().do507()));
		 FormatUtil.printJson(doPost(new PostData().do508()));
//		FormatUtil.printJson(doPost(new PostData().do527()));
		// FormatUtil.printJson(doPost(new PostData().do530()));
		// FormatUtil.printJson(doPost(new PostData().do531()));
		// FormatUtil.printJson(doPost(new PostData().do401_online("1")));
		// FormatUtil.printJson(doPost(new PostData().do401_online("2")));
	}

	public static String doPost(Map<String, Object> allParam) throws Exception {
		return HttpUtil.doPost(URL_HEADER, allParam);
	};

}
