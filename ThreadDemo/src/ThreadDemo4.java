import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


//生产者消费者模型
public class ThreadDemo4 {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        //生产者
        Thread t1 = new Thread(() ->{
            int val = 0;
            while (true){
                try {
                    System.out.println("生产一个元素"+val);
                    blockingQueue.put(val);
                    val++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        //消费者
        Thread t2 = new Thread(() ->{

            while (true){
                try {
                    int val = blockingQueue.take();
                    System.out.println("消耗一个元素"+val);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t2.start();
    }
}
