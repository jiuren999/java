package threading;
//线程不安全
class Counter{
    public int counter;

    public void add(){
        synchronized (this){
            counter++;
        }

    }

    public int getCounter() {
        return counter;
    }
}
public class ThreadDome9 {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

            Thread t1 = new Thread(() ->{
                for (int i = 0; i <2500 ; i++) {
                c.add();
            }
        });
        Thread t2 = new Thread(() ->{
            for (int i = 0; i <2500 ; i++) {
                c.add();
            }
        });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        System.out.println(c.getCounter());
    }
}
