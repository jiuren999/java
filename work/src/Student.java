package sun19bao;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Student {

    public void Mether0() throws Exception {
        boolean t=true;
        ResultSet rs0=null;
        Connection connection=null;
        PreparedStatement p1=null;
        PreparedStatement p2=null;
        Scanner s = new Scanner(System.in);
        System.out.println("请输入学号:");
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
                System.out.println("----------欢迎使用学生教务系统-------------");
                System.out.println("------------1.查询学生表-------------");
                System.out.println("------------2.查询个人信息-------------");//加成绩
                System.out.println("------------3.查询班级信息-------------");
                System.out.println("------------4.选修课程-------------");
                System.out.println("------------5.查询课程表-------------");
                System.out.println("------------6.退出系统-------------");
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
                        String sql1 = "select * from student where Sname=?";
                        p1 = connection.prepareStatement(sql1);
                        System.out.println("请输入要查询的学生名");
                        String name=s.next();
                        p1.setObject(1,name);
                        rs0 = p1.executeQuery();
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Sno") + "\t" + rs0.getString("Sname") +
                                    "\t" + rs0.getInt("Sage") + "\t" + rs0.getString("Smajor") + "\t");

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
                        sql2="select * from Sc1";
                        p1 = connection.prepareStatement(sql2);
                        rs0 = p1.executeQuery(sql2);
                        while (rs0.next()) {
                            System.out.println(rs0.getInt("Sno") + "\t"
                                    + rs0.getInt("Cno") + "\t" + rs0.getString("Came") + "\t");

                        }
                        String sql="insert into Sc1 (Sno,Cno)values(?,?);";
                        p2= connection.prepareStatement(sql);
                        System.out.println("请输入你的学号：");
                        String Sno=s.next();
                        p2.setObject(1,Sno);
                        System.out.println("请输入你要选择的课程号：");
                        String Cno=s.next();
                        p2.setObject(2,Cno);
                        p2.executeUpdate();
                        System.out.println("选课成功！");
                        break;
                    case 5:
                        sql2="select Course.Cno,Came,Ccredit,Tc.Tno,Tame from Tc,Teacher,Course where\n" +
                                "   Course.Cno=Tc.Cno and Tc.Tno=Teacher.Tno ;";
                        p1 = connection.prepareStatement(sql2);
                        rs0 = p1.executeQuery(sql2);
                        while (rs0.next()){
                            System.out.println(rs0.getInt("Cno") + "\t" + rs0.getString("Came") +
                                    "\t" + rs0.getFloat("Ccredit") + "\t" + rs0.getInt("Tno") +
                                    "\t" + rs0.getString("Tame") + "\t" );
                        }
                        break;
                    case 6:
                        System.out.println("谢谢使用，正在退出学生教务管理系统");
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