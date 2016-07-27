package note.dp.tactics;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略模式 (计算策略)
 */
public class _Main {
	private static List<Good> goods = new ArrayList<>();

	public static void main(String[] args) {
		ContextCash cash = new ContextCash(new CashedModel(goods, CashWays.SAVE));
		cash.getResult().showBill();
	}

	/*
	 * init test
	 */
	static {
		Good g1 = new Good("酱猪蹄", 10, true);
		Good g2 = new Good("鱼香肉丝", 8, true);
		Good g3 = new Good("宫保鸡丁", 6, true);
		Good g4 = new Good("夫妻肺片", 3, true);
		Good g5 = new Good("麻婆豆腐", 15, true);
		Good g6 = new Good("回锅肉", 18, false);
		Good g7 = new Good("东坡肘子", 20, false);
		Good g8 = new Good("干烧岩鲤", 22, false);
		Good g9 = new Good("干烧桂鱼", 10, false);
		Good g10 = new Good("怪味鸡", 14, false);
		goods.add(g1);
		goods.add(g2);
		goods.add(g3);
		goods.add(g4);
		goods.add(g5);
		goods.add(g6);
		goods.add(g7);
		goods.add(g8);
		goods.add(g9);
		goods.add(g10);
	}
}
