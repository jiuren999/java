package sun19bao;
import java.util.Scanner;


public class Text {
    public static void main(String[] args) throws Exception {
        boolean m=true;
        Scanner sc = new Scanner(System.in);
        Student s0 = new Student();
        Teacher s1=new Teacher();
        Manager s2=new Manager();
        while (m) {
            System.out.println("------------欢迎使用教务管理系统---------------");
            System.out.println("------------1.学生登录-------------");
            System.out.println("------------2.教师登录-------------");
            System.out.println("------------3.管理员登录-------------");
            System.out.println("------------4.退出系统-------------");
            System.out.println("请输入你的选择:");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    s0.Mether0();
                    break;
                case 2:
                    s1.Mether1();
                    break;
                case 3:
                    s2.Mether2();
                    break;
                case 4:
                    System.out.println("谢谢使用，正在退出教务管理系统");
                    m=false;
                    break;
            }

        }

    }
}