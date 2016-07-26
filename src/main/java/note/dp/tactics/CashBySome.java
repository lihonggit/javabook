package note.dp.tactics;

/**
 * 整体商品折扣方式 不计算不打折商品
 *
 */
public class CashBySome extends CashSuper {
	private double rate; // 折扣率0-1

	CashBySome(CashedModel model, double rate) {
		super(model);
		if (rate < 0 || rate > 1) {
			throw new RuntimeException("参数不合法：" + this.getClass());
		}
		this.rate = rate;
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

			// 判断是否可以折扣
			if (good.isCanDiscount()) {
				subtotal = price * rate; // 当前物品小计
				percent = String.valueOf(rate * 100); // 当前物品所打折扣
			}

			// 统计
			totalMoney += price;
			savingMoney += subtotal;
			resultMoney += price - subtotal;

			// 写回对象
			good.set_percent(percent);
			good.set_subtotal(subtotal);
		}
		// 写入结算对象
		super.model.setResultMoney(resultMoney);
		super.model.setSavingMoney(savingMoney);
		super.model.setTotalMoney(totalMoney);

		return super.model;
	}

}
