package demo.gson.dao;

import java.util.ArrayList;
import java.util.List;

import demo.gson.model.Kid;
import demo.gson.model.Lollipop;

public class KidService {
	/**
	 * 模拟返回一个对象
	 * @return
	 */
	public static Kid getKid() {
		Kid kid = new Kid();
		kid.setUserName("柯昌全小宝宝");
		kid.setAge("25");
		kid.setSex("男");

		List<Lollipop> list = new ArrayList<>();
		Lollipop lollipop1 = new Lollipop();
		lollipop1.setName("凝胶型糖果");
		lollipop1.setSize("10*10");
		lollipop1.setWeight("100g");
		Lollipop lollipop2 = new Lollipop();
		lollipop2.setName("硬糖");
		lollipop2.setSize("20*10");
		lollipop2.setWeight("120g");
		Lollipop lollipop3 = new Lollipop();
		lollipop3.setName("牛奶");
		lollipop3.setSize("30*10");
		lollipop3.setWeight("60g");
		Lollipop lollipop4 = new Lollipop();
		lollipop4.setName("巧克力");
		lollipop4.setSize("10*20");
		lollipop4.setWeight("80g");
		Lollipop lollipop5 = new Lollipop();
		lollipop5.setName("牛奶加水果");
		lollipop5.setSize("10*15");
		lollipop5.setWeight("130g");
		kid.setLollipops(list);

		return kid;
	}
}
