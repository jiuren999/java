import java.util.PriorityQueue;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        TestHeap testHeap =new TestHeap();
        int[] array = { 27,15,19,18,28,34,65,49,25,37 };
        testHeap.initElem(array);
        testHeap.createHeap();
        testHeap.pop();



    }

    public int[] smallestK(int[] arr, int k) {
        int[] tmp = new int[k];

        if(arr== null || k==0){
            return tmp;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(arr.length);
        for (int x:arr) {
            minHeap.offer(x);
        }

        for (int i = 0; i < k ; i++) {
            tmp[i] = minHeap.poll();
        }
        return tmp;
    }



    //前k个最大的元素
    public int[] maxK2(int[] arr, int k) {
        int[] tmp = new int[k];

        if(arr== null || k==0){
            return tmp;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(k);

        //遍历数组的前k个  放到堆当中
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }
        //遍历剩下的k-1个   每次和堆顶元素进行比较

        for (int i = k; i < arr.length; i++) {
            if (minHeap.peek() < arr[i]){
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k ; i++) {
            tmp[i] = minHeap.poll();
        }
        return tmp;
    }


}
