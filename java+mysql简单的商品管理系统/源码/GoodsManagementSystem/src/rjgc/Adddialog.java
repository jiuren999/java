package rjgc;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

/*
 * 增加对话窗口
 */
public class Adddialog extends JFrame {
	public static final int Width = 320;
	public static final int Heigth = 230;

	Button btn, btn2;
	JTextField jt, jt2, jt3;

	public Adddialog() {
		setSize(Width, Heigth);
		setLocation(820, 200);
		setResizable(false);
		setTitle(new String("增加:"));
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt = new JTextField(20);
		Label lb = new Label("商品号：");
		jt2 = new JTextField(20);
		Label lb2 = new Label("商品名称：");
		jt3 = new JTextField(20);
		Label lb3 = new Label("商品价格：");
		btn = new Button("添加");
		btn.addActionListener(new Enter());// 监控添加键
		btn2 = new Button("取消");
		btn2.addActionListener(new Quit());// 监控取消键

		add(lb);
		add(jt);
		add(lb2);
		add(jt2);
		add(lb3);
		add(jt3);
		add(btn);
		add(btn2);

	}

	class Enter implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Container con = getContentPane();
			if (e.getActionCommand().equals("添加")) {
				con.setBackground(Color.green);
				String sno = jt.getText();
				String sname = jt2.getText();
				String sprice = jt3.getText();
				if (sno.length() == 0)
					JOptionPane.showMessageDialog(null, "添加失败,商品号不能为空!", "操作提示",
							JOptionPane.NO_OPTION);
				else if (sname.length() == 0)
					JOptionPane.showMessageDialog(null, "添加失败,商品名称不能为空!", "操作提示",
							JOptionPane.NO_OPTION);
				else if (sprice.length() == 0)
					JOptionPane.showMessageDialog(null, "添加失败,商品价格不能为空!", "操作提示",
							JOptionPane.NO_OPTION);
				else {
					Object str[] = { sno, sname, sprice };
					Connection sin = Dbcon.getconnectin();
					Dbcon.insert(sin, str);
					JOptionPane.showMessageDialog(null, "添加成功!", "操作提示",
							JOptionPane.NO_OPTION);
					dispose();
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

/*
 * class MyPanel extends JPanel{ Label lb ;
 * 
 * MyPanel(String s,JTextField jt){ setLayout(new FlowLayout());
 * 
 * lb=new Label(s); add(lb);add(jt); }
 * 
 * }
 */

/*
 * MyPanel p1=new MyPanel("商品号：",jt); MyPanel p2=new MyPanel("商品名称：",jt2); MyPanel
 * p3=new MyPanel("商品价格：",jt3);
 */