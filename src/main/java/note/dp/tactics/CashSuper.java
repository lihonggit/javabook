package note.dp.tactics;

/**
 * 结算类
 *
 */
public abstract class CashSuper {
	CashedModel model; // 结算封装对象

	protected CashSuper(CashedModel model) {
		this.model = model;;
	}

	/**
	 * 执行结算
	 */
	abstract CashedModel doCash();

}