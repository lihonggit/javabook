package note.dp.tactics;

import java.util.List;

/**
 * 结算封装对象 作为结算对象，也作为结算返回对象
 *
 */
public class CashedModel {

	private List<Good> cashGoods; // 结算的商品
	private CashWays cashWays; // 结算方式
	private double totalMoney; // 总价
	private double resultMoney; // 应收
	private double savingMoney; // 优惠

	protected CashedModel(List<Good> cashGoods, CashWays cashWays) {
		this.cashGoods = cashGoods;
		this.cashWays = cashWays;
	}

	public CashWays getCashWays() {
		return cashWays;
	}

	public void setCashWays(CashWays cashWays) {
		this.cashWays = cashWays;
	}

	public List<Good> getCashGoods() {
		return cashGoods;
	}

	public void setCashGoods(List<Good> cashGoods) {
		this.cashGoods = cashGoods;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = FormatUtil.format2Decimal(totalMoney);
	}

	public double getResultMoney() {
		return resultMoney;
	}

	public void setResultMoney(double resultMoney) {
		this.resultMoney = FormatUtil.format2Decimal(resultMoney);
	}

	public double getSavingMoney() {
		return savingMoney;
	}

	public void setSavingMoney(double savingMoney) {
		this.savingMoney = FormatUtil.format2Decimal(savingMoney);
	}

	/**
	 * 展示结算账单
	 */
	public void showBill() {
		System.out.println(" -------- 结账单 -------- ");
		for (Good good : cashGoods) {
			System.out.println(good);
		}
		System.out.println("总价：" + totalMoney);
		System.out.println("应收：" + resultMoney);
		System.out.println("折扣：" + savingMoney);
		System.out.println("优惠方式（" + cashWays + "）");
		System.out.println("-------- 谢谢惠顾 --------");
		System.out.println("----------- -----------\n");
	}
}
