
class MyBlockQueue{
    private int size;
    private int head;
    private int tail;

    int[] array = new int[1000];
    synchronized public void put(int val) throws InterruptedException {
        while (size == array.length){
            this.wait();
        }
        array[tail] = val;
        tail++;
        if (tail == array.length){
            tail=0;
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
            head = 0;
        }
        size--;
        this.notify();
        return tmp;
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        MyBlockQueue queue = new MyBlockQueue();
        //消费者
        Thread t1 =new Thread(() ->{
            while (true) {
                try {
                    int value = queue.take();
                    System.out.println("消费"+value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //生产者
        Thread t2 =new Thread(() ->{
            int value = 0;
            while (true) {
                try {
                    queue.put(value);
                    System.out.println("生产"+value);
                    Thread.sleep(1000);

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
