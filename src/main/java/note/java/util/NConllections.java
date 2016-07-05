package note.java.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NConllections {
	public static void main(String[] args) {
		List<Object[]> list1 = new ArrayList<>();
		list1.add(new Object[] { "张三", 16 });
		list1.add(new Object[] { "何明", null });
		list1.add(new Object[] { "林倩", 18 });

		List<Object[]> list2 = new ArrayList<>();
		list1.add(new Object[] { "逗比张", 16 });
		list1.add(new Object[] { "哈儿王", 15 });
		list1.add(new Object[] { "脑残李", 28 });

		list1.addAll(list2);

		Collections.sort(list1, new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				Integer i1 = 0;
				Integer i2 = 0;
				try {
					i1 = Integer.parseInt(String.valueOf(o1[1]));
				} catch (Exception e) {
				}
				try {
					i2 = Integer.parseInt(String.valueOf(o2[1]));
				} catch (Exception e) {
				}
				// 目测返回-1,0,1
				int cp = i2.compareTo(i1);
				// %nd：占位，n表示占多少位
				System.out.printf("%5d%5d%5d\n", i1, i2, cp);
				return cp;
			}
		});

		System.out.println("按照数字大小排序：");
		for (Object[] objects : list1) {
			System.out.printf("%s\t\t%d\n", objects[0], objects[1]);
		}
	}
}
