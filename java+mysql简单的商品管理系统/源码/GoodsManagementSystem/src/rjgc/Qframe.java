package rjgc;

import java.awt.*;
import java.awt.event.*;
//import java.security.cert.PKIXRevocationChecker.Option;

import javax.swing.*;
import java.sql.*;

class Qframe extends JFrame implements ActionListener {

	JPanel contentPane;
	BorderLayout borderLayout1 = new BorderLayout(5, 10);// ����߿򲼾�,ˮƽ���5,��ֱ���10

	public static final TextArea result = new TextArea();

	public Qframe() {
		contentPane = (JPanel) this.getContentPane();// ���ش˴���� contentPane ����
		contentPane.setLayout(borderLayout1);
		
		String frameTitle = "��Ʒ��Ϣ����ϵͳ";
		if(Dbcon._prop.containsKey("frameTitle")) {
			frameTitle=(String) Dbcon._prop.get("frameTitle");
		}
		this.setTitle(frameTitle);// ������ҳ�������ڱ���

		addWindowListener(new WindowAdapter() {// �������ڴ����¼� ��X�ͽ�������
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		result.setEditable(false);// ������Ϣ��ʾ�ı�������Ϊ���ɱ༭
		result.setBackground(Color.WHITE);// �����ı�����Ϊ��ɫ
		JPanel option = new JPanel();// ѡ���ܰ�ť����

		final Button zenjia = new Button("����(add)");// ���Ӱ�ť
		option.add(zenjia, BorderLayout.NORTH);// �������������ʾ����Ķ���������ˮƽ�����Ͼ��С�
		zenjia.addActionListener(new ActionListener() {// �������Ӱ�ť�¼�
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == zenjia) {
					Adddialog add1 = new Adddialog();// �������Ӵ�����
					add1.setVisible(true);// ��ʾ����
				}

			}
		});

		final Button shanchu = new Button("ɾ��(delet)");// ɾ����ť
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

		final Button xiugai = new Button("�޸�(alter)");// �޸İ�ť
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

		final Button cx = new Button("��ѯ(query)");// ��ѯ��ť
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

		final Button chaxun = new Button("ˢ��(refresh)");// ˢ�°�ť
		option.add(chaxun, BorderLayout.NORTH);
		chaxun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == chaxun) {
					Connection sin = Dbcon.getconnectin();// ��ȡ�����Ӻ����ݿ��Connection
															// ����
					ResultSet rs = Dbcon.query(sin);// ���ò���sql����ѯ��Ϣ �����ؽ����

					try {
						result.setText("ˢ�³ɹ�\n\n\n"+"��Ʒ��\t"+"��Ʒ����\t"+"��Ʒ�۸�\n");
						while (rs.next())// ������������
						{
							String msg = rs.getString("sno") + "\t"
									+ rs.getString("sname")+"\t"+"\t"
									+ rs.getString("sprice") + "\n";
							result.append(msg);// ���ı���׷�Ӵ����ݿ�ȡ������Ϣ
						}
						sin.close();// ����
						rs.close();
					} catch (Exception h) {
						h.printStackTrace();
					}
				}

			}
		});
		chaxun.addActionListener(this);

		final Button tuichu = new Button("�˳�(quit)"); // �˳���ť
		option.add(tuichu, BorderLayout.NORTH);
		tuichu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == tuichu) {
					System.exit(0); // �˳�����
				}
			}

		});

		// ���沼��

		contentPane.add(result, BorderLayout.SOUTH);// ������������ı���
		contentPane.add(option, BorderLayout.NORTH);// ��Ӳ�����ť

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
