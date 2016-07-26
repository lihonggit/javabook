package note.dp.factory;

import java.util.Arrays;

public class Factory {
	public static void main(String[] args) {
		RainbowSuper rainbowSuper1 = RainbowSuper.getInstance("三色");
		rainbowSuper1.show();
		RainbowSuper rainbowSuper2 = RainbowSuper.getInstance("五色");
		rainbowSuper2.show();
		RainbowSuper rainbowSuper3 = RainbowSuper.getInstance("七色");
		rainbowSuper3.show();
	}
}

// ========父类=========
class RainbowSuper {
	protected String name;
	protected String[] color;

	protected void show(){
		System.out.println("我是" + name + " -> " + Arrays.toString(color));
	};

	public static RainbowSuper getInstance(String name) {
		RainbowSuper rainbowSuper = null;
		switch (name) {
		case "三色":
			rainbowSuper = new Rainbow1();
			break;
		case "五色":
			rainbowSuper = new Rainbow2();
			break;
		case "七色":
			rainbowSuper = new Rainbow3();
			break;
		default:
			rainbowSuper = new Rainbow2();
			break;
		}
		return rainbowSuper;
	};
}

//========子类们=========
class Rainbow1 extends RainbowSuper {
	public Rainbow1() {
		// 这里不能通过coloer = {"紫","蓝","绿"};这样赋值，因为语法上有问题
		String[] thisColor = { "紫", "蓝", "绿" };
		this.name = "三彩小清新";
		this.color = thisColor;
	}
}

class Rainbow2 extends RainbowSuper {
	public Rainbow2() {
		String[] thisColor = { "红", "紫", "蓝", "黄", "绿" };
		this.name = "五彩小淑女";
		this.color = thisColor;
	}
}

class Rainbow3 extends RainbowSuper {
	public Rainbow3() {
		String[] thisColor = { "红", "紫", "靛", "蓝", "黄", "橙", "绿" };
		this.name = "七彩大骚猪";
		this.color = thisColor;
	}
}