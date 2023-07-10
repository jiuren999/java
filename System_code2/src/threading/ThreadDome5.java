package threading;

public class ThreadDome5 {
    public static void main(String[] args) {
        Thread t = new Thread( () ->{
            while (true){
                System.out.println("hello t");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } );
        t.start();
        System.out.println(t.getName());
        while (true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
