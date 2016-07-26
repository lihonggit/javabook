package note.dp.tactics;

/**
 * 结算策略执行类
 *
 */
public class ContextCash {
	private CashSuper cashSuper = null;

	public ContextCash(CashedModel model) {
		switch (model.getCashWays()) {
		case NOMAL:
			cashSuper = new CashByNormal(model);
			break;
		case SAVE:
			cashSuper = new CashBySome(model, 0.8);
			break;
		case SAVE_ALL:
			cashSuper = new CashByAll(model, 0.95);
			break;
		case FULL_CAT_100_30:
			cashSuper = new CashByFullCut(model, 100, 30);
			break;
		case FULL_CAT_200_80:
			cashSuper = new CashByFullCut(model, 200, 80);
			break;
		case FULL_CAT_300_150:
			cashSuper = new CashByFullCut(model, 300, 150);
			break;

		default:
			cashSuper = new CashByNormal(model);
			break;
		}
	}

	/**
	 * 获取结果
	 * 
	 * @return
	 */
	public CashedModel getResult() {
		return cashSuper.doCash();
	}
}
