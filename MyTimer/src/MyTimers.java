

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

// 表示一个任务.
class MyTask implements Comparable<MyTask> {
    public Runnable runnable;
    // 为了方便后续判定, 使用绝对的时间戳.
    public long time;


    public MyTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        // 取当前时刻的时间戳 + delay, 作为该任务实际执行的时间戳
        this.time = System.currentTimeMillis() + delay;
    }

    @Override
    public int compareTo(MyTask o) {
        // 这样的写法意味着每次取出的是时间最小的元素.
        // 到底是谁减谁?? 俺也记不住!!! 随便写一个, 执行下, 看看效果~~
        return (int)(this.time - o.time);
    }
}

class MyTimer {
    // 这个结构, 带有优先级的阻塞队列. 核心数据结构
    private PriorityQueue<MyTask> queue = new PriorityQueue<>();

    // 创建一个锁对象
    private Object locker = new Object();

    // 此处的 delay 是一个形如 3000 这样的数字 (多长时间之后, 执行该任务)
    public void schedule(Runnable runnable, long delay) {
        // 根据参数, 构造 MyTask, 插入队列即可.
        synchronized (locker) {
            MyTask myTask = new MyTask(runnable, delay);
            queue.offer(myTask);
            locker.notify();
        }
    }


    // 在这里构造线程, 负责执行具体任务了.
    public MyTimer() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        // 阻塞队列, 只有阻塞的入队列和阻塞的出队列, 没有阻塞的查看队首元素.
                        while (queue.isEmpty()) {
                            locker.wait();
                        }
                        MyTask myTask = queue.peek();
                        long curTime = System.currentTimeMillis();
                        if (curTime >= myTask.time) {
                            // 时间到了, 可以执行任务了
                            queue.poll();
                            myTask.runnable.run();
                        } else {
                            // 时间还没到
                            locker.wait(myTask.time - curTime);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 少了个启动操作.
        t.start();
    }
}

public class MyTimers {
    public static void main(String[] args) {
        // System.out.println(System.currentTimeMillis());
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello4");
            }
        }, 4000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello3");
            }
        }, 3000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello2");
            }
        }, 2000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        }, 1000);

        System.out.println("hello0");
    }
}
