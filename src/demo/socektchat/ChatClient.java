package demo.socektchat;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * 客户端
 *
 */
public class ChatClient extends Frame {
	private static final long serialVersionUID = 4143685610626082080L;
	// 页面控件
	private TextField textField = new TextField();
	private TextArea textArea = new TextArea();
	// 客户端socket
	private Socket socket = null;
	private DataOutputStream dataOutputStream = null;
	private DataInputStream dataInputStream = null;
	// 连接状态
	private boolean bconnected = false;

	static {
		try {
			// 采用本地窗口样式
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void launchJFrame() {
		setLocation(400, 300);
		setSize(300, 300);
		add(textField, BorderLayout.SOUTH);
		add(textArea, BorderLayout.NORTH);
		pack();
		// 关闭事件
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
				System.exit(0);
			}
		});
		// 回车事件
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				try {
					sendToServer(str);
					addText(str);
					textField.setText("");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(ChatClient.this, "消息发送失败");
				}
			}
		});
		setVisible(true);
		connect();
	}

	public void connect() {
		try {
			socket = new Socket("127.0.0.1", 8888);
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			new Recv(socket).start();
			bconnected = true;
			System.out.println("Connected!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(ChatClient.this, "网络连接失败");
		}
	}

	/**
	 * 关闭连接
	 */
	public void close() {
		try {
			if (dataInputStream != null) {
				dataInputStream.close();
			}
			if (dataOutputStream != null) {
				dataOutputStream.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加到文本框
	 * @param str
	 */
	private void addText(String str) {
		String oldText = textArea.getText();
		textArea.setText(oldText + ("".equals(oldText) ? "" : "\n") + str);
	}

	/**
	 * 发送消息到服务器
	 * @param str
	 * @throws IOException 
	 */
	private void sendToServer(String str) throws IOException {
		dataOutputStream.writeUTF(str);
		dataOutputStream.flush();
	}

	/**
	 * 接收消息内部类
	 *
	 */
	class Recv extends Thread {
		Socket socket = null;

		public Recv(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				while (bconnected) {
					String str = dataInputStream.readUTF();
					addText(str);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(ChatClient.this, "网络连接被中断！");
			} finally {
				close();
			}
		}
	}

	public static void main(String[] args) {
		new ChatClient().launchJFrame();
	}
}
