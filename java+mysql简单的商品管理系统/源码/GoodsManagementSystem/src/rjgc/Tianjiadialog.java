package rjgc;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class Tianjiadialog extends JFrame {
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
	public Tianjiadialog() {
		setSize(Width, Heigth);
		setLocation(820, 200);
		setTitle(new String("�������µ���Ϣ��"));
		setLayout(new FlowLayout());
		setResizable(false);
		Container con = getContentPane();
		jt = new JTextField(20);
		Label lb = new Label("��Ʒ�ţ�");
		jt2 = new JTextField(20);
		Label lb2 = new Label("��Ʒ���ƣ�");
		jt3 = new JTextField(20);
		Label lb3 = new Label("��Ʒ�۸�");
		btn = new Button("�޸�");
		btn.addActionListener(new Enter());
		btn2 = new Button("ȡ��");
		btn2.addActionListener(new Quit());
		/*
		 * MyPanel p1=new MyPanel("��Ʒ�ţ�",jt); MyPanel p2=new MyPanel("��Ʒ���ƣ�",jt2);
		 * MyPanel p3=new MyPanel("��Ʒ�۸�",jt3);
		 */
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
			Adddialog ad = new Adddialog();
			if (e.getActionCommand().equals("�޸�")) {
				con.setBackground(Color.blue);
				String sno = jt.getText();
				String sname = jt2.getText();
				String sprice = jt3.getText();
				if (sno.length()==0)
					JOptionPane.showMessageDialog(null, "�޸�ʧ��,��Ʒ�Ų���Ϊ��!", "������ʾ",
							JOptionPane.NO_OPTION);
				else if (sname.length()==0)
					JOptionPane.showMessageDialog(null, "�޸�ʧ��,��Ʒ���Ʋ���Ϊ��!", "������ʾ",
							JOptionPane.NO_OPTION);
				else if (sprice.length()==0)
					JOptionPane.showMessageDialog(null, "�޸�ʧ��,��Ʒ�۸���Ϊ��!", "������ʾ",
							JOptionPane.NO_OPTION);
				else {
					Object str[] = { sno, sname, sprice };
					Connection sin = Dbcon.getconnectin();
					Dbcon.insert(sin, str);
					System.out.println(sno+"111"+sname+"111"+sprice);
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�!", "������ʾ",
							JOptionPane.NO_OPTION);
					dispose();
				}
			}
		}
	}

	class Quit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "ȡ���ɹ�!", "������ʾ",
					JOptionPane.NO_OPTION);
			dispose();
		}
	}
}
