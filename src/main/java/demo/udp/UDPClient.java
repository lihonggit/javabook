package demo.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP客户端
 */
public class UDPClient {
	public static void main(String[] args) {
		try {
			// 定义服务器地址、端口号和要发送的数据
			InetAddress address = InetAddress.getByName("localhost");
			int port = 3456;
			byte[] data = "叽叽叽，骚猪在叫了！嘻嘻~".getBytes();
			// 创建要发送的数据报包
			DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
			// 创建UDPSocket
			DatagramSocket socket = new DatagramSocket();
			// 执行发送数据
			socket.send(packet);
			// 关闭
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
