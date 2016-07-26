package note.dp.factory;

public class Rainbow1 extends RainbowSuper {
	public Rainbow1() {
		// 这里不能通过coloer = {"紫","蓝","绿"};这样赋值，因为语法上有问题
		String[] thisColor = { "紫", "蓝", "绿" };
		this.name = "三彩小清新";
		this.color = thisColor;
	}
}