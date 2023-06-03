package rjgc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Dbcon {
	static String url="jdbc:mysql://localhost:3306/wtf?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";//���ݿ���Ϊwtf
	static String username="root";//���ݿ��û���
	static String password="";//���ݿ����� û�о��ǿ��ַ���
	static Properties _prop=null;
	
	
	static {
		  _prop = new Properties();
		try {
			String proFilePath = System.getProperty("user.dir") + "\\config.properties";  
			InputStream in = new BufferedInputStream(new FileInputStream(proFilePath));  
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			_prop.load(bf);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public final static Connection getconnectin() {
		Connection con = null;// �������ݿ�
		if(_prop.containsKey("database")) {				
			password=  _prop.getProperty("database");
		}
		if(_prop.containsKey("username")) {			
			username = _prop.getProperty("username");
		}
		if(_prop.containsKey("username")) {				
			password=  _prop.getProperty("password");
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// ע������
			con.setCatalog("wtf");// ѡ��Ҫ�����н��й����Ĵ� Connection�������ݿ���ӿռ�(wtf���ݿ�)��
		} catch (SQLException sqle) {
			System.out.println(sqle + "���Ӵ���");
		} catch (Exception e) {
			System.out.println(e + "��������");
		}
		return con;//����Connection����
	}

	// �������
	public final static void insert(Connection con, Object obj[]) {
		PreparedStatement stmt = null;
		try {
			stmt = con
					.prepareStatement("insert into info(sno,sname,sprice) values(?,?,?)");
			// SQL ��䱻Ԥ���벢�洢�� PreparedStatement ������,������� '?' IN ����ռλ���� SQL ���
			stmt.setString(1, obj[0].toString());// ��ָ����������Ϊ������ַ���
			stmt.setString(2, obj[1].toString());
			stmt.setString(3, obj[2].toString());
			stmt.execute(); // ִ��sql���
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ʧ��", "������ʾ!",
					JOptionPane.NO_OPTION);
		}
	}

	// ��ѯ����
	public final static ResultSet query(Connection con) {
		ResultSet rs = null;
		PreparedStatement stmt = null;// sql���ִ�ж���
		try {
			stmt = con.prepareStatement("select * from info");// ��sql��䷢�͵����ݿⷵ��statement����
			rs = stmt.executeQuery();// ִ�� SQL ��ѯ
			// stmt.close();// ���ɹ���
			// con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;// ���ؽ����
	}

	// ɾ������
	public final static int delete(Connection con, String s) {
		int num = 0;
		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("delete from info where sno=?");// ?����ͨ���
			stmt.setObject(1, s);// �ѵ�һ������ ��? ����Ϊ��������String s
			num = stmt.executeUpdate();// ִ��sql��� 'ɾ��'�����޷��ؽ��
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

}