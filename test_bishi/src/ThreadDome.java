public class ThreadDome {

    public static void main(String[] args) throws InterruptedException {

        Object object = new Object();
        System.out.println("之前");
        synchronized (object){
            object.wait();
        }

        System.out.println("之后");
    }
}
