package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import component.CheckInput;
import component.dateDeal;
import database.administratorDatabase;
import database.bookDatabase;
import database.readerDatabase;

public class borrowBooks extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reader_number, reader_name, reader_state, borrow_maxNum, borrow_num, borrow_bookNumbers;
	private JLabel bookNameJLabel, writerJLabel, bookPublishingHouseJLabel, bookPublishingDateJLabel, bookCategoryJLabel;
	private JLabel searchBookNumberJLabel_f, searchBookNameJLabel_f, searchBookWriter_f, searchBookPublishingHouse_f, 
		searchBookPublishingDate_f, searchBookCategory_f, searchBookFloorRack_f, searchBookState_f;
	private JLabel pageJLabel, previousPageJLabel, nextPageJLabel;
	private JTextField bookNameJTextField, writerJTextField, calendarJTextField, pageInputJTextField;
	private JComboBox<Object> bookCategoryJComboBox, bookPublishingHouseJComboBox;
	private JButton fuzzySearchJButton, exactSearchJButton, borrowedJButton, logoutJButton;
	private boolean borrowedJButtonPressed = false;
	private ButtonGroup timeButtonGroup;
	private JRadioButton timeBeforeJRadioButton, timeAfterJRadioButton;
	private String[] bookCategory = {"--请选择--", "马列、毛、邓", "哲学、宗教", "社会科学总论", "政治、法律", 
			"军事", "经济", "文化科学教育体育", "语言", "文学", "自然科学总论", "数理科学和化学", "天文学、地球科学", 
			"生物科学", "医学", "农业科学", "工业技术", "交通运输", "航空、航天", "环境科学、安全科学", "综合性图书"};
	private String[] bookPublishingHouse = {"--请选择--", "北京大学出版社", "北京科学技术出版社", "北京师范大学出版社", "电子工业出版社", 
			"法律出版社", "复旦大学出版社", "高等教育出版社", "国家图书馆出版社", "化学工业出版社", "机械工业出版社", "建筑工业出版社", 
			"江苏教育出版社", "科学出版社", "清华大学出版社", "人民出版社", "人民法院出版社", "人民教育出版社", "人民卫生出版社", 
			"人民文学出版社", "人民邮电出版社", "商务印书馆", "社科文献出版社", "生活·读书·新知三联书店", "外语教学与研究出版社", 
			"武汉大学出版社", "译林出版社", "中国财经出版社", "中国电力出版社", "中国法制出版社", "中国建筑工业出版社", 
			"中国金融出版社", "中国经济出版社", "中国人民大学出版社", "中国少年儿童新闻出版总社", "中国水利水电出版社", 
			"中国政法大学出版社", "中华书局", "中信出版社", "中央编译出版社", "作家出版社"};
	private String bookNameString, writerString, bookCategoryString, timeBeforeOrAfterString, bookPublishingHouseString, bookPublishingDateString; 
	private String[][] searchBookInformationString;
	private JLabel[][] searchBookInformationJLabel;
	private int pagenumber;
	public borrowBooks(String s) {
		String[] str = s.split(" ");
		reader_number = str[0];
		reader_name = str[1];
		reader_state = str[2];
		borrow_maxNum = str[3];
		borrow_num = str[4];
		if(str.length == 6) {
			borrow_bookNumbers = str[5];
		}else {
			borrow_bookNumbers = "";
		}
		interfaceMethod();//加载界面
		function();//加载功能
	}
	
	void interfaceMethod() {
		setLayout(null);
		setTitle("欢迎您，" + reader_name + "（" + reader_number + "，最大借阅数量" + borrow_maxNum + "本，已借" + borrow_num + "本）");
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    	int windowsWedth = 1200, windowsHeight = 740;
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
		
		int x = 112, y = 40;
		
		bookNameJLabel = new JLabel(" 名 称  ：");
		bookNameJLabel.setFont(new Font("",Font.PLAIN,20));
		getContentPane().add(bookNameJLabel);
		bookNameJLabel.setBounds(x,y,100,30);
		
		writerJLabel = new JLabel(" 作 者  ：");
		writerJLabel.setFont(new Font("",Font.PLAIN,20));
		getContentPane().add(writerJLabel);
		writerJLabel.setBounds(x+300,y,100,30);
		
		bookCategoryJLabel = new JLabel(" 类 别  ：");
		bookCategoryJLabel.setFont(new Font("",Font.PLAIN,20));
		getContentPane().add(bookCategoryJLabel);
		bookCategoryJLabel.setBounds(x+595,y,100,30);
		
		bookPublishingHouseJLabel = new JLabel("出版社 ：");
		bookPublishingHouseJLabel.setFont(new Font("",Font.PLAIN,20));
		getContentPane().add(bookPublishingHouseJLabel);
		bookPublishingHouseJLabel.setBounds(x,y+50,100,30);
		
		bookPublishingDateJLabel = new JLabel("出版时间：");
		bookPublishingDateJLabel.setFont(new Font("",Font.PLAIN,20));
		getContentPane().add(bookPublishingDateJLabel);
		bookPublishingDateJLabel.setBounds(x+295,y+50,100,30);
		
		bookNameJTextField = new JTextField();
		getContentPane().add(bookNameJTextField);
		bookNameJTextField.setBounds(x+90,y+2,150,30);

		writerJTextField = new JTextField();
		getContentPane().add(writerJTextField);
		writerJTextField.setBounds(x+390,y+2,150,30);

		bookCategoryJComboBox =  new JComboBox<Object>(bookCategory);
		bookCategoryJComboBox.setMaximumRowCount(10); 
		getContentPane().add(bookCategoryJComboBox);
		bookCategoryJComboBox.setBounds(x+685,y,150,30);

		bookPublishingHouseJComboBox =  new JComboBox<Object>(bookPublishingHouse);
		bookPublishingHouseJComboBox.setMaximumRowCount(10); 
		getContentPane().add(bookPublishingHouseJComboBox);
		bookPublishingHouseJComboBox.setBounds(x+90,y+52,150,30);
		
		calendarJTextField = new JTextField();
		CalendarPanel calendarPanel = new CalendarPanel(calendarJTextField, "yyyy-MM-dd");
		calendarPanel.initCalendarPanel();
		getContentPane().add(calendarJTextField);
		calendarJTextField.setBounds(x+390,y+52,95,30);
		getContentPane().add(calendarPanel);
		calendarPanel.setBounds(x+290,y+85,250,250);
		
		timeButtonGroup = new ButtonGroup();
		timeBeforeJRadioButton = new JRadioButton("以前");
		timeAfterJRadioButton = new JRadioButton("以后");
		timeButtonGroup.add(timeBeforeJRadioButton);
		timeButtonGroup.add(timeAfterJRadioButton);
		timeBeforeJRadioButton.setBackground(Color.white);
		timeAfterJRadioButton.setBackground(Color.white);
		timeAfterJRadioButton.setSelected(true);
		timeBeforeOrAfterString = "after";
		getContentPane().add(timeBeforeJRadioButton);
		timeBeforeJRadioButton.setBounds(x+495,y+51,50,14);
		getContentPane().add(timeAfterJRadioButton);
		timeAfterJRadioButton.setBounds(x+495,y+68,50,14);
		
		fuzzySearchJButton = new JButton("模糊查找");
		fuzzySearchJButton.setBackground(Color.white);
		fuzzySearchJButton.setFont(new Font("微软雅黑",Font.PLAIN,14));
		fuzzySearchJButton.setForeground(Color.black);
		getContentPane().add(fuzzySearchJButton);
		fuzzySearchJButton.setBounds(x+603,y+52,95,30);
		
		exactSearchJButton = new JButton("精确查找");
		exactSearchJButton.setBackground(Color.white);
		exactSearchJButton.setFont(new Font("微软雅黑",Font.PLAIN,14));
		exactSearchJButton.setForeground(Color.black);
		getContentPane().add(exactSearchJButton);
		exactSearchJButton.setBounds(x+740,y+52,95,30);
		
		borrowedJButton = new JButton("已  借");
		borrowedJButton.setBackground(Color.white);
		borrowedJButton.setFont(new Font("微软雅黑",Font.PLAIN,14));
		borrowedJButton.setForeground(Color.black);
		getContentPane().add(borrowedJButton);
		borrowedJButton.setBounds(x+885,y,90,30);
		
		logoutJButton = new JButton("注  销");
		logoutJButton.setBackground(Color.white);
		logoutJButton.setFont(new Font("微软雅黑",Font.PLAIN,14));
		logoutJButton.setForeground(Color.black);
		getContentPane().add(logoutJButton);
		logoutJButton.setBounds(x+885,y+52,90,30);
		
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
		
		setComponentVisible(false, new JComponent[] {searchBookNumberJLabel_f, searchBookNameJLabel_f, searchBookWriter_f, searchBookPublishingHouse_f, 
			searchBookPublishingDate_f, searchBookCategory_f, searchBookFloorRack_f, searchBookState_f});
		
		ImageIcon blackBorderPicture = new ImageIcon("src/picture/blackBorder.jpg");
		blackBorderPicture.setImage(blackBorderPicture.getImage().getScaledInstance(windowsWedth, 1, Image.SCALE_DEFAULT));
		JLabel blackBorderPictureJLabel = new JLabel(blackBorderPicture);
		getContentPane().add(blackBorderPictureJLabel);
		blackBorderPictureJLabel.setBounds(0, 0, windowsWedth, 1);
		
		setVisible(true);
	}
	
	void function() {
		bookDatabase.Instantiate();
		readerDatabase.Instantiate();
		administratorDatabase.Instantiate();
		bookCategoryString = "--请选择--";
		bookPublishingHouseString = "--请选择--";
		bookCategoryJComboBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent event){
				switch (event.getStateChange()){
					case ItemEvent.SELECTED: 
						bookCategoryString = event.getItem().toString();
						break;
				}
			}
		});
		bookPublishingHouseJComboBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent event){
				switch (event.getStateChange()){
					case ItemEvent.SELECTED: 
						bookPublishingHouseString = event.getItem().toString();
						break;
				}
			}
		});
		calendarJTextField.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				int keyChar = e.getKeyChar();
				if(keyChar == KeyEvent.VK_BACK_SPACE){
					calendarJTextField.setText("");
				}else {
					e.consume();
				}
			}
		});
		timeBeforeJRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				timeBeforeOrAfterString = "before";
			}
		});
		timeAfterJRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				timeBeforeOrAfterString = "after";
			}
		});
		
		fuzzySearchJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		fuzzySearchJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				showSearchBookInformation(searchBook("模糊查找"));
			}
		});
		exactSearchJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exactSearchJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				showSearchBookInformation(searchBook("精确查找"));
			}
		});
		borrowedJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		borrowedJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(borrowedJButtonPressed) {
					borrowedJButtonPressed = false;
					borrowedJButton.setText("已借");
					setComponentVisible(true, new JComponent[] {bookNameJTextField, writerJTextField, calendarJTextField, 
							pageInputJTextField, bookNameJLabel, writerJLabel, bookPublishingHouseJLabel, bookPublishingDateJLabel, 
							bookCategoryJLabel, timeBeforeJRadioButton, timeAfterJRadioButton, fuzzySearchJButton, exactSearchJButton,
							bookCategoryJComboBox, bookPublishingHouseJComboBox});
					setComponentVisible(false, new JComponent[] {searchBookNumberJLabel_f, searchBookNameJLabel_f, searchBookWriter_f, 
							searchBookPublishingHouse_f, searchBookPublishingDate_f, searchBookCategory_f, searchBookFloorRack_f, 
							searchBookState_f, pageJLabel, previousPageJLabel, nextPageJLabel, pageInputJTextField});
					setComponentVisible(false, searchBookInformationJLabel);
				}else {
					borrowedJButtonPressed = true;
					borrowedJButton.setText("返回");
					setComponentVisible(false, new JComponent[] {bookNameJTextField, writerJTextField, calendarJTextField, 
							pageInputJTextField, bookNameJLabel, writerJLabel, bookPublishingHouseJLabel, bookPublishingDateJLabel, 
							bookCategoryJLabel, timeBeforeJRadioButton, timeAfterJRadioButton, fuzzySearchJButton, exactSearchJButton,
							bookCategoryJComboBox, bookPublishingHouseJComboBox});
					if(!borrow_bookNumbers.equals("")) {
						int sum = borrow_bookNumbers.length() / 13;
						String SQL = "select * from book_table where ";
						for(int i = 0; i < sum; i++) {
							SQL += "book_number = '" + borrow_bookNumbers.substring(i * 13, i * 13 + 13) + "' or ";
						}
						SQL = SQL.substring(0,SQL.length()-4);
						showSearchBookInformation(bookDatabase.searchBookString(SQL));
					}else {
						setComponentVisible(false, new JComponent[] {searchBookNumberJLabel_f, searchBookNameJLabel_f, searchBookWriter_f, 
								searchBookPublishingHouse_f, searchBookPublishingDate_f, searchBookCategory_f, searchBookFloorRack_f, 
								searchBookState_f, pageJLabel, previousPageJLabel, nextPageJLabel, pageInputJTextField});
						setComponentVisible(false, searchBookInformationJLabel);
					}
				}
			}
		});
		logoutJButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logoutJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Object[] options ={ "确定", "取消" };
				int response = JOptionPane.showOptionDialog(borrowBooks.this, "您确定要注销账户吗？", 
						"提示",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(response == 0 ) {
					dispose();
					new Login();
				}
			}
		});
	}
	
	String [][] searchBook(String searchWay){
		String SQL = "select * from book_table where ";
		int SQLLength = SQL.length();
		bookNameString = bookNameJTextField.getText();
		writerString = writerJTextField.getText();
		bookPublishingDateString = calendarJTextField.getText();
		if(!CheckInput.clearBlankString(bookNameString).equals("")) {
			if(searchWay.equals("模糊查找")) {
				SQL += "book_name like '" + bookNameString.replace("", "%") + "' and ";
			}else {
				SQL += "book_name like '" + bookNameString + "' and ";
			}
		}
		if(!CheckInput.clearBlankString(writerString).equals("")) {
			if(searchWay.equals("模糊查找")) {
				SQL += "book_writer like '" + writerString.replace("", "%") + "' and ";
			}else {
				SQL += "book_writer like '" + writerString + "' and ";
			}
		}
		if(!bookCategoryString.equals("--请选择--")) {
			SQL += "book_category = '" + bookCategoryString + "' and ";
		}
		if(!bookPublishingHouseString.equals("--请选择--")) {
			SQL += "book_publishingHouse = '" + bookPublishingHouseString + "' and ";
		}
		if(!bookPublishingDateString.equals("")) {
			if(timeBeforeOrAfterString.equals("before")) {
				SQL += "book_publishingDate < '" + bookPublishingDateString + "' and ";
			}else {
				SQL += "book_publishingDate >= '" + bookPublishingDateString + "' and ";
			}
		}
		if(SQLLength != SQL.length()) {
			SQL = SQL.substring(0,SQL.length()-5);
			return bookDatabase.searchBookString(SQL);
		}else {
			return null;
		}
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
				case "可借":
					searchBookInformationJLabel[i][7].setText("<HTML><U>可借</U></HTML>");
					searchBookInformationJLabel[i][7].setForeground(Color.GREEN);
					searchBookInformationJLabel[i][7].setBounds(componentStart+1060,componentTop+47+i%10*45,50,20);
					searchBookInformationJLabel[i][7].setCursor(new Cursor(Cursor.HAND_CURSOR));
					int index = i;
					searchBookInformationJLabel[i][7].addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if(searchBookInformationString[index][7].equals("可借")) {
								Object[] options ={ "借阅", "取消" };
								int response = JOptionPane.showOptionDialog(borrowBooks.this, "您确定要借阅《" + searchBookInformationString[index][1] + "》吗？", 
										"提示",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
								if(response == 0 ) {
									if(reader_state.equals("正常")) {
										if(Integer.parseInt(borrow_num) < Integer.parseInt(borrow_maxNum)) {
											searchBookInformationString[index][7] = "已借";
											searchBookInformationJLabel[index][7].setText("已借");
											searchBookInformationJLabel[index][7].setForeground(Color.BLUE);
											searchBookInformationString[index][11] = dateDeal.dateAdd(new SimpleDateFormat("yyyy-MM-dd").format(new Date()), 30);
											searchBookInformationJLabel[index][7].setToolTipText("<HTML><font color=\"#0000FF\">" + searchBookInformationString[index][11] + "</font></HTML>");
											searchBookInformationJLabel[index][7].setBounds(componentStart+1060,componentTop+50+index%10*45,50,20);
											borrow_num = String.valueOf(Integer.parseInt(borrow_num) + 1);
											setTitle("欢迎您，" + reader_name + "（" + reader_number + "，最大借阅数量" + borrow_maxNum + "本，已借" + borrow_num + "本）");
											bookDatabase.borrowBookVoid(reader_number, searchBookInformationString[index][0]);
											borrow_bookNumbers += searchBookInformationString[index][0];
											readerDatabase.borrowBookVoid(reader_number, borrow_num, borrow_bookNumbers);
										}else {
											JOptionPane.showMessageDialog(borrowBooks.this, "错误", "已达最大借阅数目！", JOptionPane.ERROR_MESSAGE);
										}
									}else if(reader_state.equals("超期")) {
										JOptionPane.showMessageDialog(borrowBooks.this, "错误", "存在超期未还！", JOptionPane.ERROR_MESSAGE);
									}else if(reader_state.equals("封禁")) {
										JOptionPane.showMessageDialog(borrowBooks.this, "错误", "该账号已被封禁！", JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						}
					});
					break;
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
