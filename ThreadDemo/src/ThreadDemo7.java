

public class ThreadDemo7 {
    public static Object object1 = new Object();
    public static Object object2 = new Object();
    public static Object object3 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() ->{
            int p =1;
            try {
                while (p<=10){
                    synchronized (object1){
                        object1.wait();
                    }
                    System.out.print("A");
                    p++;
                    synchronized (object2){
                        object2.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread t2 = new Thread(() ->{
            int p =1;
            while (p<=10){
                synchronized (object2){
                    try {
                        object2.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                p++;
                synchronized (object3){
                    object3.notify();
                }
            }
        });
        t2.start();
        Thread t3 = new Thread(() ->{
            int p =1;
            while (p<=10){
                synchronized (object3){
                    try {
                        object3.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                p++;
                synchronized (object1){
                    object1.notify();
                }
            }
        });
        t3.start();
        Thread.sleep(1000);
        synchronized (object1){
            object1.notify();
        }
    }
}
