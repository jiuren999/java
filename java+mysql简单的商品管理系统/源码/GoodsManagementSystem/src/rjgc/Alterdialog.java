package rjgc;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class Alterdialog extends JFrame {
	public static final int Width = 320;
	public static final int Heigth = 230;

	Button btn, btn2;
	JTextField jt, jt2, jt3;

	/*
	 * 1
	 */

	public Alterdialog() {
		setSize(Width, Heigth);
		setLocation(820, 200);
		setTitle(new String("修改："));
		setResizable(false);
		setLayout(new FlowLayout());
		jt = new JTextField(20);
		Label lb = new Label("商品号：");
		btn = new Button("确定");
		btn.addActionListener(new Enter());
		btn2 = new Button("取消");
		btn2.addActionListener(new Quit());
		/*
		 * 2
		 */
		add(lb);
		add(jt);
		// 3
		add(btn);
		add(btn2);

	}

	class Enter implements ActionListener {//修改即先删后加
		public void actionPerformed(ActionEvent e) {
			Container con = getContentPane();
			if (e.getActionCommand().equals("确定")) {
				con.setBackground(Color.red);
				Connection sin = Dbcon.getconnectin();
				String sno = jt.getText();//获取要修改的商品号sno
				int num=Dbcon.delete(sin, sno);//调用删除类 执行删除方法
				if(num==0)		
					JOptionPane.showMessageDialog(null, "信息修改失败!,无该商品号", "信息",
							JOptionPane.INFORMATION_MESSAGE);
				else{
					Tianjiadialog tg = new Tianjiadialog();//添加
				tg.setVisible(true);
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
 * 1 class MyPanel extends JPanel{ Label lb ;
 * 
 * MyPanel(String s,JTextField jt){ setLayout(new FlowLayout());
 * 
 * lb=new Label(s); add(lb);add(jt); }
 * 
 * }
 */

/*
 * 2 MyPanel p1=new MyPanel("商品号：",jt); MyPanel p2=new MyPanel("商品名称：",jt2);
 * MyPanel p3=new MyPanel("商品价格：",jt3);
 */

// 3add(lb2);add(jt2);add(lb3);add(jt3);
