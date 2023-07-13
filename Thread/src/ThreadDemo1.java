public class ThreadDemo1 {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        Thread t1 = new Thread(() ->{
            try {
                System.out.println("wait开始");
                synchronized (object){
                    object.wait();
                    System.out.println("wait结束");
                }
            }catch (InterruptedException e){
                e.getStackTrace();
            }

        });
        t1.start();

        Thread.sleep(1000);

        Thread t2 = new Thread(() ->{
            synchronized (object){
                System.out.println("notify开始");
                object.notify();
                System.out.println("notify结束");

            }
        });

        t2.start();
    }
}
