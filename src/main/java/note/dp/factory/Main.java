package note.dp.factory;

public class Main {
	public static void main(String[] args) {
		RainbowSuper rainbowSuper1 = RainbowSuper.getInstance("三色");
		rainbowSuper1.show();
		RainbowSuper rainbowSuper2 = RainbowSuper.getInstance("五色");
		rainbowSuper2.show();
		RainbowSuper rainbowSuper3 = RainbowSuper.getInstance("七色");
		rainbowSuper3.show();
	}
}


