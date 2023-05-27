package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class administrator extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String administratorNameString; 
	private JLabel logoutJLabel;
	private JButton readerManagementJButton, bookManagementJButton;
	
	public administrator(String s) {
		administratorNameString = s;
		interfaceMethod();//加载界面
		function();//加载功能
	}

	void interfaceMethod() {
		setLayout(null);
		setTitle("欢迎您，管理员" + administratorNameString);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    	int windowsWedth = 500, windowsHeight = 300;
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
		
		int x = 98, y = 90;


		ImageIcon logoutPicture = new ImageIcon("src/picture/logout.jpg");
		logoutPicture.setImage(logoutPicture.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
		logoutJLabel = new JLabel(logoutPicture);
		getContentPane().add(logoutJLabel);
		logoutJLabel.setBounds(windowsWedth-60,windowsHeight-83,30,30);

		
		readerManagementJButton = new JButton("读者管理");
		readerManagementJButton.setBackground(Color.white);
		readerManagementJButton.setFont(new Font("微软雅黑",Font.PLAIN,16));
		readerManagementJButton.setForeground(Color.black);
		getContentPane().add(readerManagementJButton);
		readerManagementJButton.setBounds(x,y,110,40);
		
		bookManagementJButton = new JButton("书籍管理");
		bookManagementJButton.setBackground(Color.white);
		bookManagementJButton.setFont(new Font("微软雅黑",Font.PLAIN,16));
		bookManagementJButton.setForeground(Color.black);
		getContentPane().add(bookManagementJButton);
		bookManagementJButton.setBounds(x+180,y,110,40);
		
		ImageIcon blackBorderPicture = new ImageIcon("src/picture/blackBorder.jpg");
		blackBorderPicture.setImage(blackBorderPicture.getImage().getScaledInstance(windowsWedth, 1, Image.SCALE_DEFAULT));
		JLabel blackBorderPictureJLabel = new JLabel(blackBorderPicture);
		getContentPane().add(blackBorderPictureJLabel);
		blackBorderPictureJLabel.setBounds(0, 0, windowsWedth, 1);
		
		setVisible(true);
	}
	
	void function() {
		readerManagementJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		readerManagementJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
				new readerManagement(administratorNameString);
			}
		});
		bookManagementJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bookManagementJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		logoutJLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logoutJLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Object[] options ={ "确定", "取消" };
				int response = JOptionPane.showOptionDialog(administrator.this, "您确定要注销账户吗？", 
						"提示",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(response == 0 ) {
					dispose();
					new Login();
				}
			}
		});
	}
	
}
