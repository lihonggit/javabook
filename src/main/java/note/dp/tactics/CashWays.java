package note.dp.tactics;

/**
 * 折扣方案枚举
 *
 */
public enum CashWays {
	NOMAL("无", ""), // 无折扣方式
	SAVE("折扣", "★★★"), // 折扣
	SAVE_ALL("整单折扣", "★★★★★"), // 整单折扣
	FULL_CAT_100_30("满100减30", "★★"), // 满减
	FULL_CAT_200_80("满200减80", "★★★"), // 满减
	FULL_CAT_300_150("满300减150", "★★★★"); // 满减

	private final String name;
	private final String star;

	private CashWays(String name, String star) {
		this.name = name;
		this.star = star;
	}

	@Override
	public String toString() {
		return name + " " + star;
	}
}