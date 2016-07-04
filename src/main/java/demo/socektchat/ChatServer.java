package demo.socektchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *服务端 
 *
 */
public class ChatServer {
	// 运行状态
	private boolean started = false;
	// 服务器socket
	private ServerSocket serverSocket = null;
	// 客户集合
	private List<Client> clients = new ArrayList<Client>();

	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		chatServer.startServer();
	}

	// 启动服务
	private void startServer() {
		try {
			// 创建指定端口的服务器socket对象
			serverSocket = new ServerSocket(8888);
			started = true;
			System.out.println("服务器启动成功，等待客户连接！");
		} catch (BindException e) {
			System.out.println("端口使用中！");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			while (started) {
				// 在没有收到
				Socket socket = serverSocket.accept();
				System.out.println("A Clinet Connected!");
				Client client = new Client(socket);
				clients.add(client);
				client.start();
			}
		} catch (IOException e) {
			System.out.println("与客户端连接断开，服务器退出！");
		} finally {
			closeServer();
		}
	}

	/**
	 * 关闭服务器
	 */
	private void closeServer() {
		try {
			if (serverSocket != null) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 服务器端Client内部类
	 *
	 */
	private class Client extends Thread {
		Socket socket = null;
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;

		public Client(Socket socket) throws IOException {
			this.socket = socket;
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
		}

		@Override
		public void run() {
			try {
				while (true) {
					String msg = dataInputStream.readUTF();
					// 打印收到消息
					System.out.println("服务器收到消息" + msg);
					// 转发给除自己外的每个用户
					for (Client client : clients) {
						if (client == this) {
							continue;
						}
						client.sendToClient(msg);
					}
				}
			} catch (IOException e) {
				System.out.println("客户端异常");
			} finally {
				close();
				clients.remove(this);
				System.out.println("当前在线客户数量：" + clients.size());
			}
		}

		private void close() {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void sendToClient(String data) throws IOException {
			dataOutputStream.writeUTF(data);
			dataOutputStream.flush();
		}
	}
}
