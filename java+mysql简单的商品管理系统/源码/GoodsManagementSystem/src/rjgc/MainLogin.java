package rjgc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

//这个是主运行程序  可以右键运行这个类
//
public class MainLogin extends JFrame {
	JTextField f1; // 输入用户文本框
	JTextField f2;// 输入密码文本框
	JButton b1;// 登录按钮
	JButton b2;// 重置按钮
	String power;// 表示权限
	String imgePath = "backGround.jpg";
	JPanel p5;// 最外层容器
	Image img = Toolkit.getDefaultToolkit().createImage(imgePath);// 获取默认工具包.
																	// 获取图片像素数据

	MainLogin() {
		Container cp = getContentPane();// 返回此窗体的 contentPane 对象
		Label l1 = new Label("用户：");
		Label l2 = new Label("密码：");

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p5 = new JPanel() {
			protected void paintChildren(Graphics g) {
				g.drawImage(img, 0, 0, this);// 设置背景图和坐标
				super.paintChildren(g);// 显示图片
			}
		};

		f1 = new JTextField(15);
		f2 = new JPasswordField(15);
		b1 = new JButton("登录");
		b2 = new JButton("重置");
		p1.setBackground(Color.orange);
		p2.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
		p2.add(l1);// 往轻量级容器里添加不可编辑文本
		p2.add(f1);// 添加可输入文本框
		p2.setBackground(Color.ORANGE);// 设置背景颜色
		p2.setBounds(200, 240, 224, 30);
		p3.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
		p3.add(l2);
		p3.add(f2);
		p3.setBackground(Color.ORANGE);
		p3.setBounds(200, 340, 224, 30);
		p4.add(b1);
		p4.add(b2);
		p4.setLayout(new FlowLayout(FlowLayout.LEFT,2,2));
		p4.setBackground(Color.ORANGE);
		p4.setBounds(240, 410, 125, 30);
		p5.setLayout(null);// 构造一个新的
							// FlowLayout，它具有居中的对齐方式,水平.垂直间距40
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		cp.add(p5, BorderLayout.CENTER);
		b1.addActionListener(new Enter());// 监听 登录按钮事件
		b2.addActionListener(new ReWrite());// 监听 重置按钮事件
		addWindowListener(new winClose());// 监听窗口处理事件
	}

	public static void main(String[] args) {
		MainLogin log = new MainLogin();
		log.setIconImage(Toolkit.getDefaultToolkit().createImage("icon.jpg"));// 登录界面标题logo图片
		String loginPageTitle = "酒店管理系统";
		if(Dbcon._prop.containsKey("frameTitle")) {
			loginPageTitle=(String) Dbcon._prop.get("loginPageTitle");
		}
		log.setTitle(loginPageTitle);
		log.setLocation(600, 300); // 方框出现在屏幕的位置
		log.setSize(750, 548); // 调整登录框大小
		log.setResizable(false);// 设置为不可调整窗口大小
		log.setVisible(true); // 是否可视化 

	}

	class Enter implements ActionListener {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)// 重写事件反映方法
		{
			MainLogin log = new MainLogin();// 持有对象引用
			if ((f1.getText()).equals("bai") && (f2.getText()).equals("123")) {
//				JOptionPane.showMessageDialog(null, "登录成功！用户权限是adimistrator");// 弹出要求用户提供值或向其发出通知的标准对话框
				power = "adminstrator";// 赋予管理员权限
				Qframe frame = new Qframe();// 验证成功后就建对象调用构造方法连接数据库
				frame.setIconImage(Toolkit.getDefaultToolkit().createImage(
						"icon.jpg"));// 进入管理系统的logo图片
				frame.setLocation(400, 200);
				frame.setSize(500, 285);
				frame.setResizable(false);
				frame.setVisible(true);
				dispose();// 释放此图形的上文以及它使用的所有系统资源,即实现关闭弹出新窗口后关闭上个窗口
			} else if ((f1.getText()).equals("xues")
					&& (f2.getText()).equals("123")) {
				JOptionPane.showMessageDialog(null, "登录成功！用户权限是user");// 弹出要求用户提供值或向其发出通知的标准对话框
				power = "adminstrator";
				Qframe frame = new Qframe();
				frame.setIconImage(Toolkit.getDefaultToolkit().createImage(
						"img1.jpg"));
				frame.setLocation(400, 200);
				frame.setSize(750, 543);// 500/285
				frame.setResizable(false);
				frame.setVisible(true);
				dispose();
			} else
				JOptionPane.showMessageDialog(null, "登录失败，请重新登录！");
		}
	}

	class ReWrite implements ActionListener {// 监听器实现接口
		public void actionPerformed(ActionEvent e)// 传入事件信息对象
		{
			f1.setText("");// 把文本中的内容清空起到重置效果
			f2.setText("");
			f1.requestFocus();// 请求获取输入焦点,即点击完重置 光标自动跳回输入用户框
		}
	}

	class winClose extends WindowAdapter// 窗口正处在关闭过程中时调用。 //最终exit 退出程序
	{
		public void windowClosing(WindowEvent e) { // getwindow 返回事件的发起方
			(e.getWindow()).dispose();// 释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源。
			System.exit(0);// 最终exit 退出程序
		}
	}
}