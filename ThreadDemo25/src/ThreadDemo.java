import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPool{
    //阻塞队列用来存放任务
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public void submit(Runnable runnable){
        queue.offer(runnable);
    }

    //此处实现一个固定线程数的线程池
    public MyThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(()->{
                try {
                    while (true){
                        Runnable runnable = queue.take();
                        runnable.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            thread.start();
        }

    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int sub = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(sub);
                }
            });
        }
    }

}
