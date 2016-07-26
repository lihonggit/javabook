package note.dp.tactics;

/**
 * 满减方式
 *
 */
public class CashByFullCut extends CashSuper {
	private double fullMoney;
	private double cutMoney;

	CashByFullCut(CashedModel model, double fullMoney, double cutMoney) {
		super(model);
		// 满多少减多少
		if (cutMoney > fullMoney) {
			throw new RuntimeException("484傻？想不想做生意？");
		}
		this.fullMoney = fullMoney;
		this.cutMoney = cutMoney;
	}

	@Override
	CashedModel doCash() {
		double totalMoney = 0; // 总价
		double resultMoney = 0; // 应收
		double savingMoney = 0; // 优惠
		// 结算商品对象
		for (Good good : super.model.getCashGoods()) {
			double price = good.getPrice(); // 当前物品价格
			double subtotal = price; // 当前物品小计
			String percent = "100"; // 当前物品所打折扣

			// 统计
			totalMoney += price;

			// 写回对象
			good.set_percent(percent);
			good.set_subtotal(subtotal);
		}

		// 判断满减
		if (totalMoney >= fullMoney) {
			savingMoney = cutMoney;
		}
		// 应收 = 总价 - 优惠
		resultMoney = totalMoney - savingMoney;

		// 写入结算对象
		super.model.setResultMoney(resultMoney);
		super.model.setSavingMoney(savingMoney);
		super.model.setTotalMoney(totalMoney);

		return super.model;
	}

}
