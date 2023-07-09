package threading;

public class ThreadDome11 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <20 ; i++) {
            int j = i;

            Thread thread = new Thread(() ->{
                System.out.println(j );
            });
            thread.start();
            thread.join();
        }
        System.out.println("ok");
    }
}
