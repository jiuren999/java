package rjgc;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

/*
 * ���ӶԻ�����
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
		setTitle(new String("����:"));
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt = new JTextField(20);
		Label lb = new Label("��Ʒ�ţ�");
		jt2 = new JTextField(20);
		Label lb2 = new Label("��Ʒ���ƣ�");
		jt3 = new JTextField(20);
		Label lb3 = new Label("��Ʒ�۸�");
		btn = new Button("���");
		btn.addActionListener(new Enter());// �����Ӽ�
		btn2 = new Button("ȡ��");
		btn2.addActionListener(new Quit());// ���ȡ����

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
			if (e.getActionCommand().equals("���")) {
				con.setBackground(Color.green);
				String sno = jt.getText();
				String sname = jt2.getText();
				String sprice = jt3.getText();
				if (sno.length() == 0)
					JOptionPane.showMessageDialog(null, "���ʧ��,��Ʒ�Ų���Ϊ��!", "������ʾ",
							JOptionPane.NO_OPTION);
				else if (sname.length() == 0)
					JOptionPane.showMessageDialog(null, "���ʧ��,��Ʒ���Ʋ���Ϊ��!", "������ʾ",
							JOptionPane.NO_OPTION);
				else if (sprice.length() == 0)
					JOptionPane.showMessageDialog(null, "���ʧ��,��Ʒ�۸���Ϊ��!", "������ʾ",
							JOptionPane.NO_OPTION);
				else {
					Object str[] = { sno, sname, sprice };
					Connection sin = Dbcon.getconnectin();
					Dbcon.insert(sin, str);
					JOptionPane.showMessageDialog(null, "��ӳɹ�!", "������ʾ",
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
 * MyPanel p1=new MyPanel("��Ʒ�ţ�",jt); MyPanel p2=new MyPanel("��Ʒ���ƣ�",jt2); MyPanel
 * p3=new MyPanel("��Ʒ�۸�",jt3);
 */