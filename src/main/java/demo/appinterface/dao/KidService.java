package demo.appinterface.dao;

import java.util.ArrayList;
import java.util.List;

import demo.appinterface.model.Kid;
import demo.appinterface.model.Lollipop;

public class KidService {
	/**
	 * 模拟返回一个对象
	 * @return
	 */
	public Kid getKidBySome(String name, int age, boolean married) {
		System.out.println("服务类收到的数据：" + name + "-" + age + "-" + married);

		Kid kid = null;
		// 模拟逻辑得到对象
		if ("柯宝宝".indexOf(name) != -1) {
			kid = new Kid();
			kid.setUserName("柯宝宝");
			kid.setAge(24);
			kid.setMarried(false);

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
			list.add(lollipop1);
			list.add(lollipop2);
			list.add(lollipop3);
			list.add(lollipop4);
			list.add(lollipop5);
			kid.setLollipops(list);
		}

		return kid;
	}
}
