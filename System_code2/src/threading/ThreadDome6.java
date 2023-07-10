package threading;

public class ThreadDome6 {
    public static void main(String[] args) {
        Thread t = new Thread(() ->{
            while (!Thread.currentThread().isInterrupted() ){
                //currentThread是获取到当前线程实例
                //此处currentThread 得到的对象就是t
                //isInterrupted就是t对象里自带的一个标志位
                System.out.println("hello t");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //把t内部的标志位给设置成true
        t.interrupt();
    }
}
