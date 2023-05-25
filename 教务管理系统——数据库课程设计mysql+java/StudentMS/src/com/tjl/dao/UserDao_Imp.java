package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;





public class UserDao_Imp implements UserDao {

	int whether=0;
	private static final String SQL_USER_LOGIN = "select type from user where uname = ? and upass = ?";
	private static final String SQL_USER_INSET = "insert into user values (id,?,?,2)";
	private static final String SQL_USER_DELETE = "delete from user where uname = ?";
	private static final String SQL_USER_UPDATE = "update user set upass = ? where uname = ?";
	private static final String SQL_USER_SELECT = "select * from user where uname = ?";
	private static final String SQL_STU_information_SELECT = "SELECT * FROM student_information WHERE userID= ?";
	private static final String SQL_STU_sc_grade_SELECT = "SELECT * FROM student_sc_grade WHERE userID= ?";
	private static final String SQL_TEACHER_information_SELECT = "SELECT * FROM teacher_information WHERE teachID= ?";
	private static final String SQL_TEACHER_sc_SELECT = "SELECT * FROM teacher_sc WHERE teachID= ?";

	@Override
	public int login(User user) {
		Connection conn = JDBCUtils.getConnection();
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        
        try {
        	prepareStatement = conn.prepareStatement(SQL_USER_LOGIN);
        	prepareStatement.setString(1,user.getUname());//譜崔及匯倖諒催議峙
        	prepareStatement.setString(2,user.getUpass());//譜崔及屈倖諒催議峙
        	result = prepareStatement.executeQuery();

            while(result.next()){
                int type = result.getInt("type");
                return type;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,prepareStatement,result);
        }
        return -1;//鞠村払移
	}

	@Override
	public boolean insert(User user) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
        try {
            //方象垂嶄厮将繍type議潮範峙譜崔葎2��侭參宸戦音俶勣譜崔type議峙
        	prepareStatement = conn.prepareStatement(SQL_USER_INSET);
        	prepareStatement.setString(1,user.getUname());//譜崔及匯倖諒催議峙
        	prepareStatement.setString(2,user.getUpass());//譜崔及屈倖諒催議峙
        	int line = prepareStatement.executeUpdate();
            
        	return line>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,prepareStatement,null);
        }
        return false;
	}

	@Override
	public boolean delete(String uname) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
        try {
        	prepareStatement = conn.prepareStatement(SQL_USER_DELETE);
        	prepareStatement.setString(1,uname);//譜崔及匯倖諒催議峙
        	int line = prepareStatement.executeUpdate();
            
        	return line>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	JDBCUtils.close(conn,prepareStatement,null);
        }
        return false;
	}

	@Override
	public boolean update(User user) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
        try {
        	prepareStatement = conn.prepareStatement(SQL_USER_UPDATE);
        	prepareStatement.setString(1,user.getUpass());//譜崔及匯倖諒催議峙
        	prepareStatement.setString(2,user.getUname());//譜崔及屈倖諒催議峙

            int line = prepareStatement.executeUpdate();
            
        	return line>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	JDBCUtils.close(conn,prepareStatement,null);
        }
        return false;
	}

	@Override
	public User select(String uname) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
        	prepareStatement = conn.prepareStatement(SQL_USER_SELECT);
        	prepareStatement.setString(1,uname);//譜崔及匯倖諒催議峙
        	result = prepareStatement.executeQuery();
            while(result.next()){
            	int id = result.getInt("id");
            	uname = result.getString("uname");
                String upass = result.getString("upass");
                int type = result.getInt("type");
                
                return new User(id,uname,upass,type);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	JDBCUtils.close(conn,prepareStatement,result);
        }
        return null;//臥儂払移卦指null
	}

	@Override
	public User select_stu_information(String uname) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
        	prepareStatement = conn.prepareStatement(SQL_STU_information_SELECT);
        	prepareStatement.setString(1,uname);//譜崔及匯倖諒催議峙
        	result = prepareStatement.executeQuery();
            while(result.next()){
            	System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            	System.out.print("|僥丕		|");
            	System.out.print("僥催		|");
            	System.out.print("侖兆	|");
            	System.out.print("來艶	|");
            	System.out.print("定槍	|");
            	System.out.print("秘僥扮寂	|");
            	System.out.print("萎雫			|");
            	System.out.print("廨匍			|");
            	System.out.println("僥垪		|");
            	System.out.print("|"+result.getString("stuName")+"	|");
            	System.out.print(result.getInt("userID")+"	|");
				System.out.print(result.getString("userName")+"	|");
				System.out.print(result.getString("userSex")+"	|");
				System.out.print(result.getInt("userage")+"	|");
				System.out.print(result.getString("markYear")+"	|");
				System.out.print(result.getString("className")+"	|");
				System.out.print(result.getString("majorName")+"	|");
				System.out.println(result.getString("deptName")+"	|");
				System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            	System.out.println();
                return null;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	JDBCUtils.close(conn,prepareStatement,result);
        }
        return null;//臥儂払移卦指null
	}
	@Override
	public User select_stu_sc(String uname) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
        	prepareStatement = conn.prepareStatement(SQL_STU_sc_grade_SELECT);
        	prepareStatement.setString(1,uname);//譜崔及匯倖諒催議峙
        	result = prepareStatement.executeQuery();
        	System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
        	System.out.print("|僥催		|");
        	System.out.print("侖兆	|");
        	System.out.print("萎雫			|");
        	System.out.print("仁殻		|");
        	System.out.print("仁殻析弗	|");
        	System.out.print("扮寂		|");
        	System.out.print("仁殻撹示	|");
        	System.out.print("仁殻蝕兵扮寂	|");
        	System.out.println("仁殻潤崩扮寂	|");
        	System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
        	
        	while(result.next()){
            	System.out.print("|"+result.getInt("userID")+"	|");
				System.out.print(result.getString("userName")+"	|");
				System.out.print(result.getString("className")+"	|");
				System.out.print(result.getString("courseName")+"	|");
				System.out.print(result.getString("teachName")+"		|");
				System.out.print(result.getString("time")+"	|");
				System.out.print(result.getInt("grade")+"		|");
				System.out.print(result.getString("startTime")+"	|");
				System.out.println(result.getString("endTime")+"	|");
				System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            	System.out.println();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	JDBCUtils.close(conn,prepareStatement,result);
        }
        return null;//臥儂払移卦指null
	}
	
	@Override
	public User select_teacher_information(String uname) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
        	prepareStatement = conn.prepareStatement(SQL_TEACHER_information_SELECT);
        	prepareStatement.setString(1,uname);//譜崔及匯倖諒催議峙
        	result = prepareStatement.executeQuery();
            while(result.next()){
            	System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            	System.out.print("|僥丕		|");
            	System.out.print("岼垢催	|");
            	System.out.print("侖兆	|");
            	System.out.print("來艶	|");
            	System.out.print("定槍	|");
            	System.out.print("僥煽	|");
            	System.out.print("岼各	|");
            	System.out.print("秘縮扮寂	|");
            	System.out.print("縮冩片		|");
            	System.out.println("僥垪		|");
            	System.out.print("|"+result.getString("stuName")+"	|");
            	System.out.print(result.getInt("teachID")+"	|");
				System.out.print(result.getString("teachName")+"	|");
				System.out.print(result.getString("teachSex")+"	|");
				System.out.print(result.getInt("teachAge")+"	|");
				System.out.print(result.getString("degree")+"	|");
				System.out.print(result.getString("title")+"	|");
				System.out.print(result.getString("teachYear")+"	|");
				System.out.print(result.getString("roomName")+"	|");
				System.out.println(result.getString("deptName")+"	|");
				
				System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            	System.out.println();
                return null;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	JDBCUtils.close(conn,prepareStatement,result);
        }
        return null;//臥儂払移卦指null
	}
	
	@Override
	public User select_teacher_sc(String uname) {
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
        	prepareStatement = conn.prepareStatement(SQL_TEACHER_sc_SELECT);
        	prepareStatement.setString(1,uname);//譜崔及匯倖諒催議峙
        	result = prepareStatement.executeQuery();
        	System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
        	System.out.print("|岼垢催	|");
        	System.out.print("侖兆	|");
        	System.out.print("仁殻		|");
        	System.out.print("扮寂		|");
        	System.out.print("僥扮	|");
        	System.out.print("蝕兵縮僥	|");
        	System.out.println("潤崩縮僥	|");
            while(result.next()){
            	System.out.print("|"+result.getInt("teachID")+"	|");
				System.out.print(result.getString("teachName")+"	|");
				System.out.print(result.getString("courseName")+"	|");
				System.out.print(result.getString("time")+"	|");
				System.out.print(result.getString("hours")+"	|");
				System.out.print(result.getString("startTime")+"	|");
				System.out.println(result.getString("endTime")+"	|");
				System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            	System.out.println();
            	whether=1;
            }
            if(whether==0)            	
            	System.out.println("\n壙涙仁殻縮僥\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	JDBCUtils.close(conn,prepareStatement,result);
        }
        return null;//臥儂払移卦指null
	}
	
}
