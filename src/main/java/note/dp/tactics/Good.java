package note.dp.tactics;

/**
 * 商品类
 *
 */
public class Good {
	private String name; // 名称
	private double price; // 价格
	private boolean canDiscount; // 是否可以折扣
	// --------临时字段：用于业务显示--------
	private String _percent; // 所打折扣
	private double _subtotal; // 小计

	protected Good() {
	}

	public Good(String name, double price, boolean canDiscount) {
		this.name = name;
		this.price = price;
		this.canDiscount = canDiscount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isCanDiscount() {
		return canDiscount;
	}

	public void setCanDiscount(boolean canDiscount) {
		this.canDiscount = canDiscount;
	}

	public String get_percent() {
		return _percent;
	}

	public void set_percent(String _percent) {
		this._percent = _percent;
	}

	public double get_subtotal() {
		return _subtotal;
	}

	public void set_subtotal(double _subtotal) {
		this._subtotal = FormatUtil.format2Decimal(_subtotal);
	}

	@Override
	public String toString() {
		return "[" + name + ", " + price + ", " + _percent + ", " + _subtotal + "]";
	}
	

}
