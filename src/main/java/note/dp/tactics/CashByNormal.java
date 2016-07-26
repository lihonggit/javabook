package note.dp.tactics;

/**
 * 默认模式，不进行任何打折操作
 *
 */
public class CashByNormal extends CashSuper {

	protected CashByNormal(CashedModel model) {
		super(model);
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
		// 没有任何折扣
		resultMoney = totalMoney;
		
		// 写入结算对象
		model.setResultMoney(resultMoney);
		model.setSavingMoney(savingMoney);
		model.setTotalMoney(totalMoney);

		return model;
	}

}
