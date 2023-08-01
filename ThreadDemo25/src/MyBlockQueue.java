public class MyBlockQueue {

    public int[] elem = new int[1000];
    public int head = 0;
    public int tail = 0;
    public int size = 0;


     synchronized public void put(int value) throws InterruptedException {

        while (size == elem.length){
            wait();
        }
        elem[tail] = value;
        tail++;
        if (tail==elem.length){
            tail = 0;
        }
        size++;
        notify();
    }

    synchronized public Integer take() throws InterruptedException {
        while (size==0){
            wait();
        }
        int tmp = elem[head];
        head++;
        if (head == elem.length){
            head = 0;
        }
        size--;
        notify();
        return tmp;
    }

}
