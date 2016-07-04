package demo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * 番茄时间
 */
public class TomatoTime extends JFrame {
	private static final long serialVersionUID = 6627698653356375972L;

	static {
		try {
			// 采用本地窗口样式
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TomatoTime() {
		initFrame();
	}

	/**
	 * 初始化界面
	 */
	private void initFrame() {
		setTitle("番茄时钟 v1.0");
		setSize(420, 160);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setUndecorated(true); // 去掉窗口的装饰
		getContentPane().setBackground(Color.BLACK);

		JButton workBtn = new JButton("25:00");
		JButton restBtn = new JButton("5:00");
		JButton closeBtn = new JButton("关闭");
		workBtn.setFont(new Font("", 1, 45));
		restBtn.setFont(new Font("", 1, 45));
		workBtn.setPreferredSize(new Dimension(200, 123));
		restBtn.setPreferredSize(new Dimension(200, 123));
		add(workBtn);
		add(restBtn);
		add(closeBtn);

		// 绑定业务事件
		workBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimeDialog panel = new TimeDialog(TomatoTime.this, 25 * 60 * 1000);
				panel.setVisible(true);
			}
		});
		restBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimeDialog panel = new TimeDialog(TomatoTime.this, 5 * 60 * 1000);
				panel.setVisible(true);
			}
		});
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// 绑定关闭事件
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}

	class TimeDialog extends JDialog {
		private static final long serialVersionUID = 5973886701746181537L;
		private long time = 0;
		private JLabel timeLabel = null;
		private Thread currThread = null;
		private boolean threadKeep = true;

		public TimeDialog(Component c, long countDownTime) {
			// 接收并初始化倒计时
			this.time = countDownTime;

			initDialog();
			// 绑定关闭事件
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					threadKeep = false;
					currThread.interrupt();
					dispose();
				}
			});

			// 开始计时
			currThread = new CountDown();
			currThread.start();
		}

		public void initDialog() {
			// 启用模型化显示
			setModal(true);
			setTitle("计时器");
			setSize(420, 160);
			setResizable(false);
			setLocationRelativeTo(null);
			getContentPane().setBackground(Color.black);

			timeLabel = new JLabel("25:00", JLabel.CENTER);
			// “dialog”代表字体，1代表样式(1是粗体，0是平常的）15是字号
			timeLabel.setFont(new Font("微软雅黑", 1, 100));
			// 设置颜色
			timeLabel.setForeground(Color.red);
			add(timeLabel);
		}

		class CountDown extends Thread {
			@Override
			public void run() {
				SimpleDateFormat fmt = new SimpleDateFormat("mm:ss");
				String tempMsg = fmt.format(new Date((time)));
				while (threadKeep) {
					timeLabel.setText(fmt.format(new Date((time))));
					// 1000ms
					time -= 1000;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("强行中断了线程");
					}
					if (time < 0) {
						threadKeep = false;
					}
				}

				JOptionPane.showMessageDialog(TomatoTime.this, "计时完成:" + tempMsg);
				dispose();
			}
		}

	}

	public static void main(String[] args) {
		new TomatoTime();
	}
}
