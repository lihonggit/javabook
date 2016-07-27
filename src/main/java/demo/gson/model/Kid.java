package demo.gson.model;

import java.util.List;

/**
 * 测试用用户类
 *
 */
public class Kid {
	private String userName; // 用户名
	private String age; // 年龄
	private String sex; // 性别
	private List<Lollipop> lollipops; // 棒棒糖集合

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Lollipop> getLollipops() {
		return lollipops;
	}

	public void setLollipops(List<Lollipop> lollipops) {
		this.lollipops = lollipops;
	}

}
