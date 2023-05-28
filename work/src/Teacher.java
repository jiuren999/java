package sun19bao;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Teacher {

    public void Mether1() throws Exception {
        boolean t=true;
        ResultSet rs0=null;
        Connection connection=null;
        PreparedStatement p1=null;
        PreparedStatement p2=null;
        Scanner s = new Scanner(System.in);
        System.out.println("请输入教师号:");
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
                System.out.println("----------欢迎使用教师教务系统-------------");
                System.out.println("------------1.查询教师表-------------");
                System.out.println("------------2.查询个人信息-------------");
                System.out.println("------------3.查询班级信息-------------");
                System.out.println("------------4.选授课程-------------");
                System.out.println("------------5.退出系统-------------");
                System.out.println("请输入你的选择:");
                int a = s.nextInt();
                switch (a) {
                    case 1:
                        String sql1 = "select * from Teacher";
                        p1 = connection.prepareStatement(sql1);
                        rs0 = p1.executeQuery(sql1);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Tno") + "\t" + rs0.getString("Tame") +
                                    "\t" + rs0.getString("Ttitle") + "\t");

                        }
                        break;

                    case 2:
                        sql1 = "select * from Teacher where Tame=?";
                        p1 = connection.prepareStatement(sql1);
                        System.out.println("请输入要查询的教师名");
                        String name=s.next();
                        p1.setObject(1,name);
                        rs0 = p1.executeQuery();
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
                        sql2="select * from Tc1";
                        p1 = connection.prepareStatement(sql2);
                        rs0 = p1.executeQuery(sql2);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Tno") + "\t"+ rs0.getInt("Cno") +
                                    "\t" + rs0.getString("Tame") + "\t"+ rs0.getString("Ttitle") + "\t"
                                    + rs0.getString("Tyear") + "\t"+ rs0.getString("Tterm") + "\t"
                            );

                        }
                        String sql="insert into Tc1 (Tno,Cno)values(?,?);";
                        p2= connection.prepareStatement(sql);
                        System.out.println("请输入你的教师号：");
                        String Sno=s.next();
                        p2.setObject(1,Sno);
                        System.out.println("请输入你要选择的课程号：");
                        String Cno=s.next();
                        p2.setObject(2,Cno);
                        p2.executeUpdate();
                        System.out.println("选课成功！");
                        break;
                    case 5:
                        System.out.println("谢谢使用，正在退出教师教务管理系统");
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