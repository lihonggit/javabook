package note.dp.tactics;


/**
 * 策略模式
 * (计算策略)
 */
public class Tactics {

}

class CashContext{
	
}

class CashSuper{
	protected String totalMoney;
}

enum PayWays{
	/*
	 * 整单折扣
	 * 整体商品折扣（不计算不打折商品）
	 * 满减
	 * 
	 */
	A("整体折扣"),
	B("类型折扣");
	
	private final String name;
	private PayWays(String name) {
		this.name = name;
	}
}
// 全部打折
// 部分类型商品打折
// 

class Cash{
	
}
