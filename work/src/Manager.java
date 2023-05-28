package sun19bao;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Manager {

    public void Mether2() throws Exception {
        boolean t=true;
        ResultSet rs0=null;
        Connection connection=null;
        PreparedStatement p1=null;
        PreparedStatement p2=null;
        Scanner s = new Scanner(System.in);
        System.out.println("请输入管理员号:");
        String user = s.nextLine();
        System.out.println("请输入密码:");
        String password = s.nextLine();

        try {
            //1.加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.通过DriverManage获取连接
            String url = "jdbc:mysql://localhost:3306/jiaowu";
            connection = DriverManager.getConnection(url, user, password);

            while (t) {
                System.out.println("----------欢迎使用管理员教务系统-------------");
                System.out.println("------------1.查询学生表-------------");
                System.out.println("------------2.查询教师表-------------");
                System.out.println("------------3.查询班级表-------------");
                System.out.println("------------4.添加学生信息-------------");
                System.out.println("------------5.修改学生信息-------------");
                System.out.println("------------6.删除学生信息-------------");
                System.out.println("------------7.添加老师信息-------------");
                System.out.println("------------8.修改老师信息-------------");
                System.out.println("------------9.删除老师信息-------------");
                System.out.println("------------10.修改成绩表-------------");
                System.out.println("------------11.修改课程表-------------");
                System.out.println("------------12.退出系统-------------");
                System.out.println("请输入你的选择:");
                int a = s.nextInt();
                switch (a) {
                    case 1:
                        String sql0 = "select*from student";
                        p1 = connection.prepareStatement(sql0);
                        rs0 = p1.executeQuery(sql0);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Sno") + "\t" + rs0.getString("Sname") +
                                    "\t" + rs0.getInt("Sage") + "\t" + rs0.getString("Smajor") + "\t");

                        }
                        break;
                    case 2:
                        String sql1 = "select * from Teacher";
                        p1 = connection.prepareStatement(sql1);
                        rs0 = p1.executeQuery(sql1);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Tno") + "\t" + rs0.getString("Tame") +
                                    "\t" + rs0.getString("Ttitle") + "\t");

                        }

                        break;
                    case 3:
                        String sql2 = "select * from Class";
                        p1 = connection.prepareStatement(sql2);
                        rs0 = p1.executeQuery(sql2);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Rno") + "\t" + rs0.getString("Rname") +
                                    "\t" + rs0.getInt("Rnum") + "\t" + rs0.getString("Rteacher") + "\t");

                        }

                        break;
                    case 4:
                        sql2="select * from Student";
                        p1 = connection.prepareStatement(sql2);
                        rs0 = p1.executeQuery(sql2);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Sno") + "\t" + rs0.getString("Sname") +
                                    "\t" + rs0.getInt("Sage") + "\t" + rs0.getString("Smajor") + "\t");

                        }
                        String sql="insert into Student (Sno,Sname,Sage,Smajor)values(?,?,?,?);";
                        p2= connection.prepareStatement(sql);
                        System.out.println("请输入要添加学生的学号：");
                        String Sno=s.next();
                        p2.setObject(1,Sno);
                        System.out.println("请输入要添加学生的姓名：");
                        String Sname=s.next();
                        p2.setObject(2,Sname);
                        System.out.println("请输入要添加学生的年龄：");
                        String Sage=s.next();
                        p2.setObject(3,Sage);
                        System.out.println("请输入要添加学生的专业：");
                        String Smajor=s.next();
                        p2.setObject(4,Smajor);
                        p2.executeUpdate();
                        System.out.println("学生信息添加成功！");
                        break;
                    case 5:
                        sql2="select * from Student";
                        p1 = connection.prepareStatement(sql2);
                        rs0 = p1.executeQuery(sql2);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Sno") + "\t" + rs0.getString("Sname") +
                                    "\t" + rs0.getInt("Sage") + "\t" + rs0.getString("Smajor") + "\t");

                        }
                        String sql3="update Student set Smajor=? where Sname=?";
                        p2= connection.prepareStatement(sql3);
                        System.out.println("请输入要更改的专业的学生姓名：");
                        String Snam=s.next();
                        p2.setObject(2,Snam);
                        System.out.println("请输入要更改的专业：");
                        String Smajor1=s.next();
                        p2.setObject(1,Smajor1);
                        p2.executeUpdate();
                        System.out.println("学生信息修改成功！");
                        break;
                    case 6:
                        String sql4="delete from Student where Sno=?";
                        p2= connection.prepareStatement(sql4);
                        System.out.println("请输入要删除信息的学生学号：");
                        String Sno1=s.next();
                        p2.setObject(1,Sno1);
                        p2.executeUpdate();
                        System.out.println("学生信息删除成功！");
                        break;
                    case 7:
                        sql1 = "select * from Teacher";
                        p1 = connection.prepareStatement(sql1);
                        rs0 = p1.executeQuery(sql1);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Tno") + "\t" + rs0.getString("Tame") +
                                    "\t" + rs0.getString("Ttitle") + "\t");

                        }
                        sql="insert into Teacher (Tno,Tame,Ttitle)values(?,?,?);";
                        p2= connection.prepareStatement(sql);
                        System.out.println("请输入要添加教师号：");
                        String Tno=s.next();
                        p2.setObject(1,Tno);
                        System.out.println("请输入要添加教师姓名：");
                        String Tame=s.next();
                        p2.setObject(2,Tame);
                        System.out.println("请输入要添加教师所教授的课程名：");
                        String Ttitle=s.next();
                        p2.setObject(3,Ttitle);
                        p2.executeUpdate();
                        System.out.println("教师信息添加成功！");
                        break;
                    case 8:
                        sql1 = "select * from Teacher";
                        p1 = connection.prepareStatement(sql1);
                        rs0 = p1.executeQuery(sql1);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Tno") + "\t" + rs0.getString("Tame") +
                                    "\t" + rs0.getString("Ttitle") + "\t");

                        }
                        sql3="update Teacher set Ttitle=? where Tame=?";
                        p2= connection.prepareStatement(sql3);
                        System.out.println("请输入要更改的教授课程的老师姓名：");
                        String Tnam=s.next();
                        p2.setObject(2,Tnam);
                        System.out.println("请输入要更改的课程名：");
                        String Ttitle1=s.next();
                        p2.setObject(1,Ttitle1);
                        p2.executeUpdate();
                        System.out.println("教师信息修改成功！");
                        break;
                    case 9:
                        sql4="delete from Teacher where Tno=?";
                        p2= connection.prepareStatement(sql4);
                        System.out.println("请输入要删除信息的教师号：");
                        String Tno1=s.next();
                        p2.setObject(1,Tno1);
                        p2.executeUpdate();
                        System.out.println("教师信息删除成功！");
                        break;
                    case 10:
                        sql0 = "select*from Sc";
                        p1 = connection.prepareStatement(sql0);
                        rs0 = p1.executeQuery(sql0);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Sno") + "\t"+ rs0.getInt("Cno") +
                                    "\t" + rs0.getFloat("Grade") + "\t");

                        }
                        sql3="update Sc set Grade=? where Sno=?and Cno=?";
                        p2= connection.prepareStatement(sql3);
                        System.out.println("请输入要更改的学生学号：");
                        String Sno2=s.next();
                        p2.setObject(2,Sno2);
                        System.out.println("请输入要更改的课程号：");
                        String Cno1=s.next();
                        p2.setObject(3,Cno1);
                        System.out.println("请输入要更改的成绩：");
                        String grade=s.next();
                        p2.setObject(1,grade);
                        p2.executeUpdate();
                        System.out.println("成绩信息修改成功！");
                        break;
                    case 11:
                        sql0 = "select*from Tc1";
                        p1 = connection.prepareStatement(sql0);
                        rs0 = p1.executeQuery(sql0);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Tno") + "\t"+ rs0.getInt("Cno") +
                                    "\t" + rs0.getString("Tame") + "\t"+ rs0.getString("Ttitle") + "\t"
                                    + rs0.getString("Tyear") + "\t"+ rs0.getString("Tterm") + "\t"
                            );

                        }
                        sql3="update Tc1 set Cno=? where Tno=?;";
                        p2= connection.prepareStatement(sql3);
                        System.out.println("请输入要更改课程的教师号：");
                        String Cn=s.next();
                        p2.setObject(2,Cn);
                        System.out.println("请输入要更改的课程号：");
                        String Sn=s.next();
                        p2.setObject(1,Sn);
                        p2.executeUpdate();
                        System.out.println("课程信息修改成功！");
                        break;
                    case 12:
                        System.out.println("谢谢使用，正在退出管理员教务管理系统");
                        t = false;
                        break;
                }

                Enter();
            }
            if (p1!= null) {
                p1.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (rs0 != null) {
                rs0.close();
            }

        } catch (Exception e) {
            throw new Exception(e);
        }

    }
    public static void Enter() throws Exception  {
        System.out.println("请按回车继续");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

}