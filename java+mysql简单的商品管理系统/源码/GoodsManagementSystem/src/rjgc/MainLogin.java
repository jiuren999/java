package rjgc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

//����������г���  �����Ҽ����������
//
public class MainLogin extends JFrame {
	JTextField f1; // �����û��ı���
	JTextField f2;// ���������ı���
	JButton b1;// ��¼��ť
	JButton b2;// ���ð�ť
	String power;// ��ʾȨ��
	String imgePath = "backGround.jpg";
	JPanel p5;// ���������
	Image img = Toolkit.getDefaultToolkit().createImage(imgePath);// ��ȡĬ�Ϲ��߰�.
																	// ��ȡͼƬ��������

	MainLogin() {
		Container cp = getContentPane();// ���ش˴���� contentPane ����
		Label l1 = new Label("�û���");
		Label l2 = new Label("���룺");

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p5 = new JPanel() {
			protected void paintChildren(Graphics g) {
				g.drawImage(img, 0, 0, this);// ���ñ���ͼ������
				super.paintChildren(g);// ��ʾͼƬ
			}
		};

		f1 = new JTextField(15);
		f2 = new JPasswordField(15);
		b1 = new JButton("��¼");
		b2 = new JButton("����");
		p1.setBackground(Color.orange);
		p2.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
		p2.add(l1);// ����������������Ӳ��ɱ༭�ı�
		p2.add(f1);// ��ӿ������ı���
		p2.setBackground(Color.ORANGE);// ���ñ�����ɫ
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
		p5.setLayout(null);// ����һ���µ�
							// FlowLayout�������о��еĶ��뷽ʽ,ˮƽ.��ֱ���40
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		cp.add(p5, BorderLayout.CENTER);
		b1.addActionListener(new Enter());// ���� ��¼��ť�¼�
		b2.addActionListener(new ReWrite());// ���� ���ð�ť�¼�
		addWindowListener(new winClose());// �������ڴ����¼�
	}

	public static void main(String[] args) {
		MainLogin log = new MainLogin();
		log.setIconImage(Toolkit.getDefaultToolkit().createImage("icon.jpg"));// ��¼�������logoͼƬ
		String loginPageTitle = "�Ƶ����ϵͳ";
		if(Dbcon._prop.containsKey("frameTitle")) {
			loginPageTitle=(String) Dbcon._prop.get("loginPageTitle");
		}
		log.setTitle(loginPageTitle);
		log.setLocation(600, 300); // �����������Ļ��λ��
		log.setSize(750, 548); // ������¼���С
		log.setResizable(false);// ����Ϊ���ɵ������ڴ�С
		log.setVisible(true); // �Ƿ���ӻ� 

	}

	class Enter implements ActionListener {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)// ��д�¼���ӳ����
		{
			MainLogin log = new MainLogin();// ���ж�������
			if ((f1.getText()).equals("bai") && (f2.getText()).equals("123")) {
//				JOptionPane.showMessageDialog(null, "��¼�ɹ����û�Ȩ����adimistrator");// ����Ҫ���û��ṩֵ�����䷢��֪ͨ�ı�׼�Ի���
				power = "adminstrator";// �������ԱȨ��
				Qframe frame = new Qframe();// ��֤�ɹ���ͽ�������ù��췽���������ݿ�
				frame.setIconImage(Toolkit.getDefaultToolkit().createImage(
						"icon.jpg"));// �������ϵͳ��logoͼƬ
				frame.setLocation(400, 200);
				frame.setSize(500, 285);
				frame.setResizable(false);
				frame.setVisible(true);
				dispose();// �ͷŴ�ͼ�ε������Լ���ʹ�õ�����ϵͳ��Դ,��ʵ�ֹرյ����´��ں�ر��ϸ�����
			} else if ((f1.getText()).equals("xues")
					&& (f2.getText()).equals("123")) {
				JOptionPane.showMessageDialog(null, "��¼�ɹ����û�Ȩ����user");// ����Ҫ���û��ṩֵ�����䷢��֪ͨ�ı�׼�Ի���
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
				JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ������µ�¼��");
		}
	}

	class ReWrite implements ActionListener {// ������ʵ�ֽӿ�
		public void actionPerformed(ActionEvent e)// �����¼���Ϣ����
		{
			f1.setText("");// ���ı��е��������������Ч��
			f2.setText("");
			f1.requestFocus();// �����ȡ���뽹��,����������� ����Զ����������û���
		}
	}

	class winClose extends WindowAdapter// ���������ڹرչ�����ʱ���á� //����exit �˳�����
	{
		public void windowClosing(WindowEvent e) { // getwindow �����¼��ķ���
			(e.getWindow()).dispose();// �ͷ��ɴ� Window�������������ӵ�е������������ʹ�õ����б�����Ļ��Դ��
			System.exit(0);// ����exit �˳�����
		}
	}
}