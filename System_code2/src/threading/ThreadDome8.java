package threading;

public class ThreadDome8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() ->{
            System.out.println("0");
        });

        System.out.println(t.getState());
        t.start();

        Thread.sleep(2000);
        System.out.println(t.getState());
    }
}
