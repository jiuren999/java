package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.bookDatabase;
import database.readerDatabase;

public class readerManagement extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String administratorNameString;
	private String reader_number, reader_name, borrow_maxNum, borrow_num, borrow_bookNumbers;
	private JLabel readerNumberInputJLabel;
	private JLabel pageJLabel, previousPageJLabel, nextPageJLabel;
	private JTextField readerNumberInputJTextField, pageInputJTextField;
	private JButton searchReaderNumberJButton, returnJButton;
	private JLabel readerNumberJLabel, readerNameJLabel, borrowMaxNumJLabel, borrowNumJLabel, searchBookNumberJLabel_f,
		searchBookNameJLabel_f, searchBookWriter_f, searchBookPublishingHouse_f, searchBookPublishingDate_f, 
		searchBookCategory_f, searchBookFloorRack_f, searchBookState_f;
	private String[][] searchBookInformationString;
	private JLabel[][] searchBookInformationJLabel;
	private int pagenumber;
	
	public readerManagement(String s) {
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
    	int windowsWedth = 1200, windowsHeight = 740;
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
		
		int x = 112, y = 40;
		
		readerNumberInputJLabel = new JLabel("输入学号：");
		readerNumberInputJLabel.setFont(new Font("",Font.PLAIN,20));
		getContentPane().add(readerNumberInputJLabel);
		readerNumberInputJLabel.setBounds(x+200,y,100,30);
		
		readerNumberInputJTextField = new JTextField();
		getContentPane().add(readerNumberInputJTextField);
		readerNumberInputJTextField.setBounds(x+310,y+2,150,30);
		
		searchReaderNumberJButton = new JButton("查  找");
		searchReaderNumberJButton.setBackground(Color.white);
		searchReaderNumberJButton.setFont(new Font("微软雅黑",Font.PLAIN,14));
		searchReaderNumberJButton.setForeground(Color.black);
		getContentPane().add(searchReaderNumberJButton);
		searchReaderNumberJButton.setBounds(x+530,y+2,85,30);
		
		returnJButton = new JButton("返  回");
		returnJButton.setBackground(Color.white);
		returnJButton.setFont(new Font("微软雅黑",Font.PLAIN,14));
		returnJButton.setForeground(Color.black);
		getContentPane().add(returnJButton);
		returnJButton.setBounds(x+640,y+2,85,30);
		
		readerNumberJLabel = new JLabel("学号：");
		readerNumberJLabel.setFont(new Font("黑体",Font.PLAIN,18));
		getContentPane().add(readerNumberJLabel);
		readerNumberJLabel.setBounds(x-32,y+70,200,30);

		readerNameJLabel = new JLabel("姓名：");
		readerNameJLabel.setFont(new Font("黑体",Font.PLAIN,18));
		getContentPane().add(readerNameJLabel);
		readerNameJLabel.setBounds(x+248,y+70,200,30);
		
		borrowMaxNumJLabel = new JLabel("最大借阅数目：");
		borrowMaxNumJLabel.setFont(new Font("黑体",Font.PLAIN,18));
		getContentPane().add(borrowMaxNumJLabel);
		borrowMaxNumJLabel.setBounds(x+528,y+70,200,30);
		
		borrowNumJLabel = new JLabel("当前已借数目：");
		borrowNumJLabel.setFont(new Font("黑体",Font.PLAIN,18));
		getContentPane().add(borrowNumJLabel);
		borrowNumJLabel.setBounds(x+808,y+70,200,30);
		
		int componentStart = 50, componentTop = 170;
		
		searchBookNumberJLabel_f = new JLabel("编  号", JLabel.CENTER);
		searchBookNumberJLabel_f.setFont(new Font("黑体",Font.PLAIN,18));
		searchBookNumberJLabel_f.setForeground(new Color(0,0,0));
		getContentPane().add(searchBookNumberJLabel_f);
		searchBookNumberJLabel_f.setBounds(componentStart+5,componentTop,60,20);
		
		searchBookNameJLabel_f = new JLabel("名  称", JLabel.CENTER);
		searchBookNameJLabel_f.setFont(new Font("黑体",Font.PLAIN,18));
		searchBookNameJLabel_f.setForeground(new Color(0,0,0));
		getContentPane().add(searchBookNameJLabel_f);
		searchBookNameJLabel_f.setBounds(componentStart+166,componentTop,60,20);

		searchBookWriter_f = new JLabel("作  者", JLabel.CENTER);
		searchBookWriter_f.setFont(new Font("黑体",Font.PLAIN,18));
		searchBookWriter_f.setForeground(new Color(0,0,0));
		getContentPane().add(searchBookWriter_f);
		searchBookWriter_f.setBounds(componentStart+382,componentTop,60,20);

		searchBookPublishingHouse_f = new JLabel("出版社", JLabel.CENTER);
		searchBookPublishingHouse_f.setFont(new Font("黑体",Font.PLAIN,18));
		searchBookPublishingHouse_f.setForeground(new Color(0,0,0));
		getContentPane().add(searchBookPublishingHouse_f);
		searchBookPublishingHouse_f.setBounds(componentStart+588,componentTop,60,20);

		searchBookPublishingDate_f = new JLabel("出版日期", JLabel.CENTER);
		searchBookPublishingDate_f.setFont(new Font("黑体",Font.PLAIN,18));
		searchBookPublishingDate_f.setForeground(new Color(0,0,0));
		getContentPane().add(searchBookPublishingDate_f);
		searchBookPublishingDate_f.setBounds(componentStart+714,componentTop,80,20);
		
		searchBookCategory_f = new JLabel("类别", JLabel.CENTER);
		searchBookCategory_f.setFont(new Font("黑体",Font.PLAIN,18));
		searchBookCategory_f.setForeground(new Color(0,0,0));
		getContentPane().add(searchBookCategory_f);
		searchBookCategory_f.setBounds(componentStart+863,componentTop,40,20);

		searchBookFloorRack_f = new JLabel("楼层书架", JLabel.CENTER);
		searchBookFloorRack_f.setFont(new Font("黑体",Font.PLAIN,18));
		searchBookFloorRack_f.setForeground(new Color(0,0,0));
		getContentPane().add(searchBookFloorRack_f);
		searchBookFloorRack_f.setBounds(componentStart+969,componentTop,80,20);

		searchBookState_f = new JLabel("状态", JLabel.CENTER);
		searchBookState_f.setFont(new Font("黑体",Font.PLAIN,18));
		searchBookState_f.setForeground(new Color(0,0,0));
		getContentPane().add(searchBookState_f);
		searchBookState_f.setBounds(componentStart+1064,componentTop,40,20);
		
		setComponentVisible(false, new JComponent[] {readerNumberJLabel, readerNameJLabel, borrowMaxNumJLabel, borrowNumJLabel, 
				searchBookNumberJLabel_f, searchBookNameJLabel_f, searchBookWriter_f, searchBookPublishingHouse_f, 
				searchBookPublishingDate_f, searchBookCategory_f, searchBookFloorRack_f, searchBookState_f});
		
		
		ImageIcon blackBorderPicture = new ImageIcon("src/picture/blackBorder.jpg");
		blackBorderPicture.setImage(blackBorderPicture.getImage().getScaledInstance(windowsWedth, 1, Image.SCALE_DEFAULT));
		JLabel blackBorderPictureJLabel = new JLabel(blackBorderPicture);
		getContentPane().add(blackBorderPictureJLabel);
		blackBorderPictureJLabel.setBounds(0, 0, windowsWedth, 1);
		
		setVisible(true);
	}
	
	void function() {
		readerNumberInputJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
				int keyChar = e.getKeyChar();
				if(keyChar < KeyEvent.VK_0 || keyChar > KeyEvent.VK_9){
					e.consume();
				}
			}
        });
		searchReaderNumberJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchReaderNumberJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String readerNumberString = readerNumberInputJTextField.getText();
				if(!readerNumberString.equals("")) {
					setComponentVisible(false, new JComponent[] {readerNumberJLabel, readerNameJLabel, borrowMaxNumJLabel, borrowNumJLabel, searchBookNumberJLabel_f,
							searchBookNameJLabel_f, searchBookWriter_f, searchBookPublishingHouse_f, searchBookPublishingDate_f, 
							searchBookCategory_f, searchBookFloorRack_f, searchBookState_f, pageJLabel, previousPageJLabel, nextPageJLabel, pageInputJTextField});
					setComponentVisible(false, searchBookInformationJLabel);
					String returnResultString = readerDatabase.searchReaderDatabaseString(readerNumberString);
					switch(returnResultString) {
					case "-1":
						JOptionPane.showOptionDialog(null, "数据库错误！", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, "确定");
						break;
					case "0":
						JOptionPane.showOptionDialog(null, "该账户不存在！", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, "确定");
						break;
					default:
						String[] str = returnResultString.split(" ");
						reader_number = readerNumberString;
						readerNumberJLabel.setText("学号：" + reader_number);
						reader_name = str[0];
						readerNameJLabel.setText("姓名：" + reader_name);
						borrow_maxNum = str[2];
						borrowMaxNumJLabel.setText("最大借阅数目：" + borrow_maxNum);
						borrow_num = str[3];
						borrowNumJLabel.setText("当前已借数目：" + borrow_num);
						setComponentVisible(true, new JComponent[] {readerNumberJLabel, readerNameJLabel, borrowMaxNumJLabel, borrowNumJLabel});
						if(str.length == 5) {
							borrow_bookNumbers = str[4];
							int sum = borrow_bookNumbers.length() / 13;
							String SQL = "select * from book_table where ";
							for(int i = 0; i < sum; i++) {
								SQL += "book_number = '" + borrow_bookNumbers.substring(i * 13, i * 13 + 13) + "' or ";
							}
							SQL = SQL.substring(0,SQL.length()-4);
							showSearchBookInformation(bookDatabase.searchBookString(SQL));
						}else {
							borrow_bookNumbers = "";
						}
						break;
					}
				}else {
					JOptionPane.showOptionDialog(null, "查找内容为空！", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, "确定");
				}
			}
		});
		returnJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		returnJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
				new administrator(administratorNameString);
			}
		});
	}
	
	void showSearchBookInformation(String[][] s) {
		setComponentVisible(false, new JComponent[] {searchBookNumberJLabel_f, searchBookNameJLabel_f, searchBookWriter_f, 
				searchBookPublishingHouse_f, searchBookPublishingDate_f, searchBookCategory_f, searchBookFloorRack_f, 
				searchBookState_f, pageJLabel, previousPageJLabel, nextPageJLabel, pageInputJTextField});
		setComponentVisible(false, searchBookInformationJLabel);
		if(s != null) {
			int componentStart = 50, componentTop = 160;
			int searchBookSum = s.length;
			int pagesum = (int)Math.ceil((float)searchBookSum/10);
			pagenumber = 0;
			searchBookInformationString = new String[pagesum*10][s[0].length-2];
			searchBookInformationJLabel = new JLabel[pagesum*10][8];
			for(int i = 0; i < pagesum * 10; i++) {
				for(int j = 0; j < 6; j++) {
					if(i < searchBookSum) {
						searchBookInformationString[i][j] = s[i][j];
					}else {
						searchBookInformationString[i][j] = "";
					}
				}
				for(int j = 7; j < searchBookInformationString[0].length; j++) {
					if(i < searchBookSum) {
						searchBookInformationString[i][j] = s[i][j+2];
					}else {
						searchBookInformationString[i][j] = "";
					}
				}
				if(i < searchBookSum) {
					searchBookInformationString[i][6] = s[i][7] + "层" + s[i][8] + "书架";
				}else {
					searchBookInformationString[i][6] = "";
				}
			}
			setComponentVisible(true, new JComponent[] {searchBookNumberJLabel_f, searchBookNameJLabel_f, searchBookWriter_f, searchBookPublishingHouse_f, 
					searchBookPublishingDate_f, searchBookCategory_f, searchBookFloorRack_f, searchBookState_f});
			createsearchBookInformationJLabel(componentStart, componentTop, pagenumber);		
			if(pagesum != 1) {
				int x = 450, y = 660;
				if(pagesum > 9) {
					pageJLabel = new JLabel("第     页，共 " + String.valueOf(pagesum) + " 页");
				}else {
					pageJLabel = new JLabel("第     页，共  " + String.valueOf(pagesum) + " 页");
				}
				pageJLabel.setFont(new Font("宋体",Font.BOLD,14));
				getContentPane().add(pageJLabel);
				pageJLabel.setBounds(x+65,y,150,16);
				pageInputJTextField = new JTextField();
				getContentPane().add(pageInputJTextField);
				pageInputJTextField.setBounds(x+85,y-1,28,17);
				pageInputJTextField.setFont(new Font("黑体",Font.PLAIN,14));
				pageInputJTextField.setText("1");
				pageInputJTextField.addKeyListener(new KeyAdapter() {
		            @Override
		            public void keyTyped(KeyEvent e){
						int keyChar = e.getKeyChar();
						if(keyChar < KeyEvent.VK_0 || keyChar > KeyEvent.VK_9){
							if(keyChar == KeyEvent.VK_ENTER) {
		                		String str = pageInputJTextField.getText().toString();
		                		if(str.equals("")) {
		                			pageInputJTextField.setText(String.valueOf(pagenumber+1));
		                		}else {
		                			int input = Integer.parseInt(str);
		                			if(input == pagenumber+1 || input > pagesum || input < 1) {
		                				pageInputJTextField.setText(String.valueOf(pagenumber+1));
		                			}else {
										for(int i = pagenumber*10; i < pagenumber*10+10; i++) {
											removeMethod(searchBookInformationJLabel[i]);
										}
										pagenumber = input - 1;
										createsearchBookInformationJLabel(componentStart, componentTop, pagenumber);
										pageInputJTextField.setText(String.valueOf(pagenumber+1));
		                			}
		                		}
							}
							e.consume();
						}
					}
		        });
				previousPageJLabel = new JLabel("上一页");
				previousPageJLabel.setFont(new Font("宋体",Font.BOLD,14));
				previousPageJLabel.setForeground(Color.BLUE);
				getContentPane().add(previousPageJLabel);
				previousPageJLabel.setBounds(x,y,50,16);
				previousPageJLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				previousPageJLabel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if(pagenumber != 0) {
							for(int i = pagenumber*10; i < pagenumber*10+10; i++) {
								removeMethod(searchBookInformationJLabel[i]);
							}
							pagenumber--;
							createsearchBookInformationJLabel(componentStart, componentTop, pagenumber);
							pageInputJTextField.setText(String.valueOf(pagenumber+1));
						}
					}
					public void mouseEntered(MouseEvent e) {
						previousPageJLabel.setForeground(Color.GREEN);
					}
					public void mouseExited(MouseEvent e) {
						previousPageJLabel.setForeground(Color.BLUE);
					}
				});
				nextPageJLabel = new JLabel("下一页");
				nextPageJLabel.setFont(new Font("宋体",Font.BOLD,14));
				nextPageJLabel.setForeground(Color.BLUE);
				getContentPane().add(nextPageJLabel);
				nextPageJLabel.setBounds(x+220,y,50,16);
				nextPageJLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				nextPageJLabel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if(pagenumber+1 != pagesum) {
							for(int i = pagenumber*10; i < pagenumber*10+10; i++) {
								removeMethod(searchBookInformationJLabel[i]);
							}
							pagenumber++;
							createsearchBookInformationJLabel(componentStart, componentTop, pagenumber);
							pageInputJTextField.setText(String.valueOf(pagenumber+1));
						}
					}
					public void mouseEntered(MouseEvent e) {
						nextPageJLabel.setForeground(Color.GREEN);
					}
					public void mouseExited(MouseEvent e) {
						nextPageJLabel.setForeground(Color.BLUE);
					}
				});
			}
		}
	}
	
	void createsearchBookInformationJLabel(int componentStart, int  componentTop, int pagenumber) {
 		for(int i = pagenumber*10; i<pagenumber*10+10; i++) {
 			searchBookInformationJLabel[i][0] = new JLabel(searchBookInformationString[i][0], JLabel.CENTER);
			searchBookInformationJLabel[i][0].setFont(new Font("宋体",Font.PLAIN,16));
			searchBookInformationJLabel[i][0].setForeground(new Color(0,0,0));
			getContentPane().add(searchBookInformationJLabel[i][0]);
			searchBookInformationJLabel[i][0].setBounds(componentStart-20,componentTop+50+i%10*45,110,20);
			
			searchBookInformationJLabel[i][1] = new JLabel(searchBookInformationString[i][1], JLabel.CENTER);
			searchBookInformationJLabel[i][1].setFont(new Font("宋体",Font.PLAIN,16));
			searchBookInformationJLabel[i][1].setForeground(new Color(0,0,0));
			getContentPane().add(searchBookInformationJLabel[i][1]);
			searchBookInformationJLabel[i][1].setBounds(componentStart+96,componentTop+50+i%10*45,200,20);
			
			searchBookInformationJLabel[i][2] = new JLabel(searchBookInformationString[i][2], JLabel.CENTER);
			searchBookInformationJLabel[i][2].setFont(new Font("宋体",Font.PLAIN,16));
			searchBookInformationJLabel[i][2].setForeground(new Color(0,0,0));
			getContentPane().add(searchBookInformationJLabel[i][2]);
			searchBookInformationJLabel[i][2].setBounds(componentStart+312,componentTop+50+i%10*45,200,20);
			
			searchBookInformationJLabel[i][3] = new JLabel(searchBookInformationString[i][3], JLabel.CENTER);
			searchBookInformationJLabel[i][3].setFont(new Font("宋体",Font.PLAIN,16));
			searchBookInformationJLabel[i][3].setForeground(new Color(0,0,0));
			getContentPane().add(searchBookInformationJLabel[i][3]);
			searchBookInformationJLabel[i][3].setBounds(componentStart+518,componentTop+50+i%10*45,200,20);
			
			searchBookInformationJLabel[i][4] = new JLabel(searchBookInformationString[i][4], JLabel.CENTER);
			searchBookInformationJLabel[i][4].setFont(new Font("宋体",Font.PLAIN,16));
			searchBookInformationJLabel[i][4].setForeground(new Color(0,0,0));
			getContentPane().add(searchBookInformationJLabel[i][4]);
			searchBookInformationJLabel[i][4].setBounds(componentStart+715,componentTop+50+i%10*45,80,20);
			searchBookInformationJLabel[i][4].setToolTipText(searchBookInformationString[i][4]);
			
			searchBookInformationJLabel[i][5] = new JLabel(searchBookInformationString[i][5], JLabel.CENTER);
			searchBookInformationJLabel[i][5].setFont(new Font("宋体",Font.PLAIN,16));
			searchBookInformationJLabel[i][5].setForeground(new Color(0,0,0));
			getContentPane().add(searchBookInformationJLabel[i][5]);
			searchBookInformationJLabel[i][5].setBounds(componentStart+808,componentTop+50+i%10*45,150,20);
			
			searchBookInformationJLabel[i][6] = new JLabel(searchBookInformationString[i][6], JLabel.CENTER);
			searchBookInformationJLabel[i][6].setFont(new Font("宋体",Font.PLAIN,16));
			searchBookInformationJLabel[i][6].setForeground(new Color(0,0,0));
			getContentPane().add(searchBookInformationJLabel[i][6]);
			searchBookInformationJLabel[i][6].setBounds(componentStart+970,componentTop+50+i%10*45,80,20);
			
			searchBookInformationJLabel[i][7] = new JLabel(searchBookInformationString[i][7], JLabel.CENTER);
			searchBookInformationJLabel[i][7].setFont(new Font("宋体",Font.PLAIN,16));
			searchBookInformationJLabel[i][7].setForeground(new Color(0,0,0));
			getContentPane().add(searchBookInformationJLabel[i][7]);
			searchBookInformationJLabel[i][7].setBounds(componentStart+1060,componentTop+50+i%10*45,50,20);
			switch(searchBookInformationString[i][7]) {
				case "已借":
				case "续借":
					searchBookInformationJLabel[i][7].setForeground(Color.BLUE);
					searchBookInformationJLabel[i][7].setToolTipText("<HTML><font color=\"#0000FF\">" + searchBookInformationString[i][11] + "</font></HTML>");
					break;
				case "超期":
					searchBookInformationJLabel[i][7].setForeground(Color.RED);
					searchBookInformationJLabel[i][7].setToolTipText("<HTML><font color=\"#FF0000\">" + searchBookInformationString[i][11] + "</font></HTML>");
					break;
			}
			int index = i;
			searchBookInformationJLabel[i][7].setCursor(new Cursor(Cursor.HAND_CURSOR));
			searchBookInformationJLabel[i][7].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(!searchBookInformationString[index][7].equals("已还")) {
						Object[] options ={ "还书", "取消" };
						int response = JOptionPane.showOptionDialog(readerManagement.this, "您确定要归还《" + searchBookInformationString[index][1] + "》吗？", 
								"提示",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
						if(response == 0 ) {
							searchBookInformationString[index][7] = "已还";
							searchBookInformationJLabel[index][7].setText("已还");
							searchBookInformationJLabel[index][7].setForeground(Color.GREEN);
							borrow_num = String.valueOf(Integer.parseInt(borrow_num) - 1);
							borrowNumJLabel.setText("当前已借数目：" + borrow_num);		
							bookDatabase.returnBookVoid(reader_number, searchBookInformationString[index][0]);
							borrow_bookNumbers = borrow_bookNumbers.replace(searchBookInformationString[index][0], "");
							readerDatabase.returnBookVoid(reader_number, borrow_num, borrow_bookNumbers);					
						}
					}
				}
			});
		}
 	}
	
	void setComponentVisible(boolean b, JComponent[] jcomponent) {
		if(jcomponent != null) {
			for(int i = 0; i < jcomponent.length; i++) {
				if(jcomponent[i] != null) {
					jcomponent[i].setVisible(b);
				}
			}
		}
	}
	
	void setComponentVisible(boolean b, JComponent[][] jcomponent) {
		if(jcomponent != null) {
			for(int i = 0; i < jcomponent.length; i++) {
				for(int j = 0; j < jcomponent[0].length; j++) {
					if(jcomponent[i][j] != null) {
						jcomponent[i][j].setVisible(b);
					}
				}
			}
		}
	}
	
	void removeMethod(JComponent[] jcomponent) {
		if(jcomponent != null) {
			for(int i = 0; i < jcomponent.length; i++) {
				if(jcomponent[i] != null) {
					remove(jcomponent[i]);
				}
			}
		}
	}
	
	void removeMethod(JComponent[][] jcomponent) {
		if(jcomponent != null) {
			for(int i = 0; i < jcomponent.length; i++) {
				for(int j = 0; j < jcomponent[0].length; j++) {
					if(jcomponent[i][j] != null) {
						remove(jcomponent[i][j]);
					}
				}
			}
		}
	}
	
	void show(String[][] s) {
		if(s != null) {
			for(int i = 0; i < s.length; i++) {
				for(int j = 0; j < s[0].length; j++) {
					System.out.print(s[i][j] + "  ");
				}
				System.out.println("");
			}
		}
	}
	
	void show(String[] s) {
		if(s != null) {
			for(int i = 0; i < s.length; i++) {
				System.out.print(s[i] + "  ");
			}
			System.out.println("");
		}
	}
	
}
