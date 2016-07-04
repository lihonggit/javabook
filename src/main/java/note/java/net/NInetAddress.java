package note.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * IP地址相关信息的查看
 */
public class NInetAddress {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();

			// 获取本机的实例
			address = InetAddress.getLocalHost();
			System.out.println("计算机名：" + address.getHostName());
			System.out.println("计算机IP：" + address.getHostAddress());
			byte[] bytes = address.getAddress();// 获取字节数组形式的IP地址
			System.out.println("字节数组形式的IP：" + Arrays.toString(bytes));
			System.out.println("直接输出他：" + address);

			System.out.println("-------------------------------------");

			InetAddress other = null;
			// other = InetAddress.getByName("Y34S9WFJ4L5ACIY"); //可通过机器名获取
			other = InetAddress.getByName("192.168.0.166"); // 也可以通过IP地址获取
			System.out.println("他人的计算机名：" + other.getHostName());
			System.out.println("他人的计算机IP：" + other.getHostAddress());
			System.out.println("他人的直接输出他：" + other);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
