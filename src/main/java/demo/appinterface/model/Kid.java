package demo.appinterface.model;

import java.util.List;

/**
 * 测试用用户类
 *
 */
public class Kid {
	private String userName; // 用户名
	private int age; // 年龄
	private boolean married; // 是否已婚
	private List<Lollipop> lollipops; // 棒棒糖集合

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean getMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public List<Lollipop> getLollipops() {
		return lollipops;
	}

	public void setLollipops(List<Lollipop> lollipops) {
		this.lollipops = lollipops;
	}

}
