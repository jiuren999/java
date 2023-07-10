package threading;

public class ThreadDome7 {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        t.start();
        t.join();
        System.out.println("2");
    }
}
