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
		setTitle(new String("�޸ģ�"));
		setResizable(false);
		setLayout(new FlowLayout());
		jt = new JTextField(20);
		Label lb = new Label("��Ʒ�ţ�");
		btn = new Button("ȷ��");
		btn.addActionListener(new Enter());
		btn2 = new Button("ȡ��");
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

	class Enter implements ActionListener {//�޸ļ���ɾ���
		public void actionPerformed(ActionEvent e) {
			Container con = getContentPane();
			if (e.getActionCommand().equals("ȷ��")) {
				con.setBackground(Color.red);
				Connection sin = Dbcon.getconnectin();
				String sno = jt.getText();//��ȡҪ�޸ĵ���Ʒ��sno
				int num=Dbcon.delete(sin, sno);//����ɾ���� ִ��ɾ������
				if(num==0)		
					JOptionPane.showMessageDialog(null, "��Ϣ�޸�ʧ��!,�޸���Ʒ��", "��Ϣ",
							JOptionPane.INFORMATION_MESSAGE);
				else{
					Tianjiadialog tg = new Tianjiadialog();//���
				tg.setVisible(true);
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
 * 1 class MyPanel extends JPanel{ Label lb ;
 * 
 * MyPanel(String s,JTextField jt){ setLayout(new FlowLayout());
 * 
 * lb=new Label(s); add(lb);add(jt); }
 * 
 * }
 */

/*
 * 2 MyPanel p1=new MyPanel("��Ʒ�ţ�",jt); MyPanel p2=new MyPanel("��Ʒ���ƣ�",jt2);
 * MyPanel p3=new MyPanel("��Ʒ�۸�",jt3);
 */

// 3add(lb2);add(jt2);add(lb3);add(jt3);
