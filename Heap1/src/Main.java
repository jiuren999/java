import java.lang.invoke.CallSite;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main<lock, locker> {


//    public static void main(String[] args) {
//        int[] array = {2,2,1};
//        TestHeap testHeap = new TestHeap();
//        System.out.println(testHeap.singleNumber(array));
//
//    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum+=i;
                }
                return sum;0
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        int ret = futureTask.get();
        System.out.println(ret);
    }


}

