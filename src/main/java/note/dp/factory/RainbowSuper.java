package note.dp.factory;

import java.util.Arrays;

public class RainbowSuper {
	protected String name;
	protected String[] color;

	protected void show() {
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
