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
		setTitle(new String("��ѯ��"));
		setResizable(false);
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt = new JTextField(20);
		Label lb = new Label("��Ʒ�ţ�");
		btn = new Button("ȷ��");
		btn.addActionListener(new Enter());
		btn2 = new Button("ȡ��");
		btn2.addActionListener(new Quit());
		/*
		 * MyPanel p1=new MyPanel("��Ʒ�ţ�",jt); MyPanel p2=new MyPanel("��Ʒ���ƣ�",jt2);
		 * MyPanel p3=new MyPanel("��Ʒ�۸�",jt3);
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
			if (e.getActionCommand().equals("ȷ��")) {
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
					int count = 0;//��ѯ������Ϊ0,��ѯ�õ���Ϊ1
					while (rs.next()) {
						String msg = rs.getString("sno") + "\t"
								+ rs.getString("sname") + "\t"
								+ rs.getString("sprice") + "\n";
						JOptionPane.showMessageDialog(null, msg, "��ѯ�����",
								JOptionPane.NO_OPTION);
						dispose();
						count = 1;//��ѯ�õ��ͼ�countΪ1,
					}
					if (count == 0)//��ѯ��������ʾ�޸���Ʒ��
						JOptionPane.showMessageDialog(null, "�޸���Ʒ��", "��ѯ�����",
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
			JOptionPane.showMessageDialog(null, "ȡ���ɹ�!", "������ʾ",
					JOptionPane.NO_OPTION);
			dispose();
		}
	}
}