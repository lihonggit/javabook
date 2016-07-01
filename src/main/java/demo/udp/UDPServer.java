package demo.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP服务器
 */
public class UDPServer {
	public static void main(String[] args) {
		try {
			// 创建一个UDPsocket
			DatagramSocket socket = new DatagramSocket(3456);
			// 创建一个规定大小的数据包，用于读取数据
			byte[] buf = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			// 阻塞读取客户端发来的消息
			socket.receive(packet);
			// 读取到的消息
			String clientMsg = new String(packet.getData(), 0, packet.getLength());
			System.out.println("UDP服务器收到消息：" + clientMsg);

			// 关闭：直接关闭socket即可，它会
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
