package rjgc;

import java.awt.*;
import java.awt.event.*;
//import java.security.cert.PKIXRevocationChecker.Option;

import javax.swing.*;
import java.sql.*;

class Qframe extends JFrame implements ActionListener {

	JPanel contentPane;
	BorderLayout borderLayout1 = new BorderLayout(5, 10);// 构造边框布局,水平间距5,垂直间距10

	public static final TextArea result = new TextArea();

	public Qframe() {
		contentPane = (JPanel) this.getContentPane();// 返回此窗体的 contentPane 对象
		contentPane.setLayout(borderLayout1);
		
		String frameTitle = "商品信息管理系统";
		if(Dbcon._prop.containsKey("frameTitle")) {
			frameTitle=(String) Dbcon._prop.get("frameTitle");
		}
		this.setTitle(frameTitle);// 设置主页操作窗口标题

		addWindowListener(new WindowAdapter() {// 监听窗口处理事件 按X就结束程序
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		result.setEditable(false);// 设置信息显示文本框区域为不可编辑
		result.setBackground(Color.WHITE);// 设置文本背景为白色
		JPanel option = new JPanel();// 选择功能按钮容器

		final Button zenjia = new Button("增加(add)");// 增加按钮
		option.add(zenjia, BorderLayout.NORTH);// 将组件置于其显示区域的顶部，并在水平方向上居中。
		zenjia.addActionListener(new ActionListener() {// 监听增加按钮事件
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == zenjia) {
					Adddialog add1 = new Adddialog();// 调用增加窗口类
					add1.setVisible(true);// 显示窗口
				}

			}
		});

		final Button shanchu = new Button("删除(delet)");// 删除按钮
		option.add(shanchu, BorderLayout.NORTH);
		shanchu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == shanchu) {
					Deletedialog dt1 = new Deletedialog();
					dt1.setVisible(true);
				}

			}
		});
		shanchu.addActionListener(this);

		final Button xiugai = new Button("修改(alter)");// 修改按钮
		option.add(xiugai, BorderLayout.NORTH);
		xiugai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == xiugai) {
					Alterdialog af = new Alterdialog();
					af.setVisible(true);

				}

			}
		});

		final Button cx = new Button("查询(query)");// 查询按钮
		option.add(cx, BorderLayout.NORTH);
		cx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == cx) {
					Cxdialog cj = new Cxdialog();
					cj.setVisible(true);
				}

			}
		});
		cx.addActionListener(this);
		xiugai.addActionListener(this);

		final Button chaxun = new Button("刷新(refresh)");// 刷新按钮
		option.add(chaxun, BorderLayout.NORTH);
		chaxun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == chaxun) {
					Connection sin = Dbcon.getconnectin();// 获取已连接好数据库的Connection
															// 对象
					ResultSet rs = Dbcon.query(sin);// 调用查找sql语句查询信息 并返回结果集

					try {
						result.setText("刷新成功\n\n\n"+"商品号\t"+"商品名称\t"+"商品价格\n");
						while (rs.next())// 遍历输出结果集
						{
							String msg = rs.getString("sno") + "\t"
									+ rs.getString("sname")+"\t"+"\t"
									+ rs.getString("sprice") + "\n";
							result.append(msg);// 往文本里追加从数据库取出的信息
						}
						sin.close();// 关流
						rs.close();
					} catch (Exception h) {
						h.printStackTrace();
					}
				}

			}
		});
		chaxun.addActionListener(this);

		final Button tuichu = new Button("退出(quit)"); // 退出按钮
		option.add(tuichu, BorderLayout.NORTH);
		tuichu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == tuichu) {
					System.exit(0); // 退出程序
				}
			}

		});

		// 界面布局

		contentPane.add(result, BorderLayout.SOUTH);// 往容器里添加文本框
		contentPane.add(option, BorderLayout.NORTH);// 添加操作按钮

	}

	public void actionPerformed(ActionEvent e) {

	}
	// @SuppressWarnings("deprecation")
	/*
	 * public static void main(String argc[]){
	 * 
	 * LoginIn dl=new LoginIn(); dl.show();
	 * 
	 * 
	 * Qframe frame= new Qframe(); frame.setLocation(400,200);
	 * frame.resize(400,285); frame.show();
	 * 
	 * }
	 */

}
