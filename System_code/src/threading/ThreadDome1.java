package threading;

//继承Thread类
class MyThread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("hello t");
        }
    }
}

public class ThreadDome1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();

        while (true){
            System.out.println("hello main");
        }
    }
}
