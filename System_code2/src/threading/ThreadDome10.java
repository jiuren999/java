package threading;

import java.util.Scanner;

public class ThreadDome10 {
    volatile public static int flog = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
           while (flog == 0){

           }
            System.out.println("t1结束");
        });
        Thread t2 = new Thread(() ->{
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个数字:");
            flog = scanner.nextInt();
        });
        t1.start();
        t2.start();
    }
}
