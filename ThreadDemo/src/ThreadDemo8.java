public class ThreadDemo8 {

    public static void main(String[] args) {

        Thread t3 = new Thread(() ->{
            System.out.print(Thread.currentThread().getName());
        },"c");

        Thread t2 = new Thread(() ->{
            try {
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(Thread.currentThread().getName());
        },"b");

        Thread t1 = new Thread(() ->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(Thread.currentThread().getName());
        },"a");

        t1.start();
        t2.start();
        t3.start();
    }

}
