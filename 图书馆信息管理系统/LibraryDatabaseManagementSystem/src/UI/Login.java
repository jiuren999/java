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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import component.CheckInput;
import database.administratorDatabase;
import database.bookDatabase;
import database.readerDatabase;

public class Login extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel searchJLabel, manageJLabel, accountJLabel, passwordJLabel, loginPictureJLabel;
	private JTextField accountJTextField;
	private JPasswordField passwordJPasswordField;
	private JButton returnJButton, loginJButton;
	private String StudentOrAdministrator;

	public Login() {
		interfaceMethod();//加载界面
		connectDatabaseMethod();//连接数据库
	}

	void connectDatabaseMethod() {
		bookDatabase.Instantiate();
		readerDatabase.Instantiate();
		administratorDatabase.Instantiate();
		if(bookDatabase.connectResult && readerDatabase.connectResult && administratorDatabase.connectResult) {
			functionMethod();//启动功能
		}else {
			Object[] options ={ "重连", "退出" };
			int response = JOptionPane.showOptionDialog(this, "数据库连接失败！", "错误",JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
			if(response == 0) {
				connectDatabaseMethod();
			}else {
				Runtime.getRuntime().exit(0);
			}
		}
	}
	
	void interfaceMethod() {
		setLayout(null);
		setTitle("图书馆借阅系统");
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    	int windowsWedth = 532, windowsHeight = 409;
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
		
		searchJLabel = new JLabel("查阅");
		searchJLabel.setFont(new Font("楷体",Font.PLAIN,38));
		searchJLabel.setForeground(Color.red);
		getContentPane().add(searchJLabel);
		searchJLabel.setBounds(380,226,80,40);
		
		manageJLabel = new JLabel("管理");
		manageJLabel.setFont(new Font("楷体",Font.PLAIN,38));
		manageJLabel.setForeground(Color.red);
		getContentPane().add(manageJLabel);
		manageJLabel.setBounds(380,278,80,40);
		
		int x = 163, y = 110;
		accountJLabel = new JLabel("账号：");
		accountJLabel.setFont(new Font("宋体",Font.PLAIN,20));
		getContentPane().add(accountJLabel);
		accountJLabel.setBounds(x,y,60,30);
		accountJLabel.setVisible(false);
		
		passwordJLabel = new JLabel("密码：");
		passwordJLabel.setFont(new Font("宋体",Font.PLAIN,20));
		getContentPane().add(passwordJLabel);
		passwordJLabel.setBounds(x,y+40,60,30);
		passwordJLabel.setVisible(false);
		
		accountJTextField = new JTextField();
		getContentPane().add(accountJTextField);
		accountJTextField.setBounds(x+60,y+2,130,22);
		accountJTextField.setVisible(false);
		
		passwordJPasswordField = new JPasswordField();
		getContentPane().add(passwordJPasswordField);
		passwordJPasswordField.setBounds(x+60,y+42,130,22);
		passwordJPasswordField.setVisible(false);
		
		returnJButton=new JButton("返回");
		returnJButton.setBackground(new Color(120,170,240));
		returnJButton.setFont(new Font("宋体",Font.BOLD,14));
		returnJButton.setForeground(new Color(250,250,250));
		getContentPane().add(returnJButton);
		returnJButton.setBounds(166,y+90,70,38);
		returnJButton.setVisible(false);
		
		loginJButton=new JButton("登录");
		loginJButton.setBackground(new Color(120,170,240));
		loginJButton.setFont(new Font("宋体",Font.BOLD,14));
		loginJButton.setForeground(new Color(250,250,250));
		getContentPane().add(loginJButton);
		loginJButton.setBounds(282,y+90,70,38);
		loginJButton.setVisible(false);
		
		ImageIcon blackBorderPicture = new ImageIcon("src/picture/blackBorder.jpg");
		blackBorderPicture.setImage(blackBorderPicture.getImage().getScaledInstance(windowsWedth, 1, Image.SCALE_DEFAULT));
		JLabel blackBorderPictureJLabel = new JLabel(blackBorderPicture);
		getContentPane().add(blackBorderPictureJLabel);
		blackBorderPictureJLabel.setBounds(0, 0, windowsWedth, 1);
		
		ImageIcon loginPicture = new ImageIcon("src/picture/001.jpg");
		loginPicture.setImage(loginPicture.getImage().getScaledInstance(windowsWedth,windowsHeight,Image.SCALE_DEFAULT));
		loginPictureJLabel = new JLabel(loginPicture);
		getContentPane().add(loginPictureJLabel);
		loginPictureJLabel.setBounds(0,0,windowsWedth,windowsHeight);
		
		setVisible(true);
	}
	
	void functionMethod() {
		searchJLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchJLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				accountJTextField.setText("");
				passwordJPasswordField.setText("");
				StudentOrAdministrator = "Student";
				showLoginInterface(true);
			}
			public void mouseEntered(MouseEvent e) {
				searchJLabel.setForeground(Color.green);
			}
			public void mouseExited(MouseEvent e) {
				searchJLabel.setForeground(Color.red);
			}
		});
		manageJLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		manageJLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				accountJTextField.setText("");
				passwordJPasswordField.setText("");
				StudentOrAdministrator = "Administrator";
				showLoginInterface(true);
			}
			public void mouseEntered(MouseEvent e) {
				manageJLabel.setForeground(Color.green);
			}
			public void mouseExited(MouseEvent e) {
				manageJLabel.setForeground(Color.red);
			}
		});
		returnJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		returnJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				showLoginInterface(false);
			}
		});
		loginJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String accountString = accountJTextField.getText().toString();
				String passwordString = String.valueOf(passwordJPasswordField.getPassword());
				if(accountString.equals("") || passwordString.equals("")) {
					JOptionPane.showOptionDialog(null, "输入内容为空！", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, "确定");
				}else if(CheckInput.isBlank(accountString)) {
					JOptionPane.showOptionDialog(null, "账号含有空白符号！", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, "确定");
				}else if(CheckInput.isBlank(passwordString)) {
					JOptionPane.showOptionDialog(null, "密码含有空白符号！", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, "确定");
				}else {
					returnJButton.setEnabled(false);
					loginJButton.setEnabled(false);
					if(StudentOrAdministrator != null) {
						String returnResult = "";
						if(StudentOrAdministrator.equals("Administrator")) {
							returnResult = administratorDatabase.searchAdministratorDatabaseString(accountString, passwordString);
						}else {
							returnResult = readerDatabase.searchReaderDatabaseString(accountString, passwordString);
						}
						switch(returnResult) {
							case "":
								returnJButton.setEnabled(true);
								loginJButton.setEnabled(true);
								break;
							case "-1":
								JOptionPane.showOptionDialog(null, "数据库错误！", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, "确定");
								returnJButton.setEnabled(true);
								loginJButton.setEnabled(true);
								break;
							case "0":
								JOptionPane.showOptionDialog(null, "该账户不存在！", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, "确定");
								returnJButton.setEnabled(true);
								loginJButton.setEnabled(true);
								break;
							case "2":
								JOptionPane.showOptionDialog(null, "密码错误！", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, "确定");
								returnJButton.setEnabled(true);
								loginJButton.setEnabled(true);
								break;
							default:
								returnJButton.setEnabled(true);
								loginJButton.setEnabled(true);
								if(StudentOrAdministrator.equals("Administrator")) {
									new administrator(accountString);
									dispose();
								}else {
									new borrowBooks(accountString + " " + returnResult);
									dispose();
								}
								break;
						}
					}
				}
			}
	    });
	}
	
	void showLoginInterface(boolean b) {
		loginPictureJLabel.setVisible(!b);
		searchJLabel.setVisible(!b);
		manageJLabel.setVisible(!b);
		accountJLabel.setVisible(b);
		passwordJLabel.setVisible(b);
		accountJTextField.setVisible(b);
		passwordJPasswordField.setVisible(b);
		returnJButton.setVisible(b);
		loginJButton.setVisible(b);
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
