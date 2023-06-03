package rjgc;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class Cxdialog extends JFrame {
	public static final int Width = 320;
	public static final int Heigth = 230;

	Button btn, btn2;
	JTextField jt, jt2, jt3;

	/*
	 * class MyPanel extends JPanel{ Label lb ;
	 * 
	 * MyPanel(String s,JTextField jt){ setLayout(new FlowLayout());
	 * 
	 * lb=new Label(s); add(lb);add(jt); }
	 * 
	 * }
	 */
	public Cxdialog() {
		setSize(Width, Heigth);
		setLocation(820, 200);
		setTitle(new String("查询："));
		setResizable(false);
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt = new JTextField(20);
		Label lb = new Label("商品号：");
		btn = new Button("确定");
		btn.addActionListener(new Enter());
		btn2 = new Button("取消");
		btn2.addActionListener(new Quit());
		/*
		 * MyPanel p1=new MyPanel("商品号：",jt); MyPanel p2=new MyPanel("商品名称：",jt2);
		 * MyPanel p3=new MyPanel("商品价格：",jt3);
		 */
		add(lb);
		add(jt);
		// add(lb2);add(jt2);add(lb3);add(jt3);
		add(btn);
		add(btn2);
	}

	class Enter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Container con = getContentPane();
			if (e.getActionCommand().equals("确定")) {
				con.setBackground(Color.red);
				Connection sin = Dbcon.getconnectin();
				String sno = jt.getText();
				ResultSet rs = null;
				PreparedStatement stmt = null;
				try {
					stmt = sin
							.prepareStatement("select * from info where sno=?");
					stmt.setObject(1, sno);
					rs = stmt.executeQuery();
					int count = 0;//查询不到记为0,查询得到记为1
					while (rs.next()) {
						String msg = rs.getString("sno") + "\t"
								+ rs.getString("sname") + "\t"
								+ rs.getString("sprice") + "\n";
						JOptionPane.showMessageDialog(null, msg, "查询结果：",
								JOptionPane.NO_OPTION);
						dispose();
						count = 1;//查询得到就记count为1,
					}
					if (count == 0)//查询不到就显示无该商品号
						JOptionPane.showMessageDialog(null, "无该商品号", "查询结果：",
								JOptionPane.NO_OPTION);
					// stmt.close();
					// con.close();
				} catch (SQLException h) {
					// TODO Auto-generated catch block
					h.printStackTrace();
				}
			}
		}
	}

	class Quit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "取消成功!", "操作提示",
					JOptionPane.NO_OPTION);
			dispose();
		}
	}
}