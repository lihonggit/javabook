package note.java.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConllectionsDemo {
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
				// %1标识输出位置,$5表示占5个字符位,\n表示换行
				System.out.printf("%1$5s%2$5s%3$5s\n", i1, i2, cp);
				return cp;
			}
		});

		for (Object[] objects : list1) {
			System.out.printf("%1$s\t%2$10s\n", objects[0], objects[1]);
		}
	}
}
