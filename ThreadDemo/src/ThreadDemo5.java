
//阻塞队列的实现
class MyBlockQueue{
    int[] array = new int[1000];

    volatile private int size;
    volatile private int head;
    volatile private int tail;

   synchronized public void put(int elem) throws InterruptedException {
       while (size == array.length){
            this.wait();
        }
        array[tail] = elem;
        tail++;
        if (tail==array.length){
            tail = 0;
        }
        size++;
        this.notify();
    }

    synchronized public Integer take() throws InterruptedException {
        while (size==0){
            this.wait();
        }
        int tmp = array[head];
        head++;
        if (head == array.length){
            head=0;
        }
        size--;
        this.notify();
        return tmp;
    }
}

public class ThreadDemo5 {
    public static void main(String[] args) {
        MyBlockQueue queue = new MyBlockQueue();

        //消费者
        Thread t1 = new Thread(() ->{
            while (true) {
                try {
                    int value = queue.take();
                    System.out.println("消费:"+value);
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //生产者
        Thread t2 = new Thread(() ->{
            int value = 0;
            while (true) {
                try {
                    System.out.println("生产"+value);
                    queue.put(value);
                    value++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
