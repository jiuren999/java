import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


class Inim implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
public class test {

    public static void main(String[] args) {
//        TestHeap testHeap =new TestHeap();
        int[] array = { 1,3,5,7,2,4,6,8 };
//        testHeap.initElem(array);
//        testHeap.createHeap();
        test t = new test();
        t.smallestK(array ,4);
//        testHeap.heapSort();
//        testHeap.offer(1);
//        System.out.println("ee");


    }

    public int[] smallestK1(int[] arr, int k) {
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


    Inim inim = new Inim();
    //前k个最小的元素
    public int[] maxK2(int[] arr, int k) {
        int[] tmp = new int[k];

        if(arr== null || k==0){
            return tmp;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(inim);

        //遍历数组的前k个  放到堆当中
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }

        for (int x:arr) {
            minHeap.offer(arr[x]);
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


    public int[] smallestK(int[] arr, int k) {
        int[] tmp = new int[k];

        if(arr== null || k==0){
            return tmp;
        }
        Queue<Integer> maxheap = new PriorityQueue<>(inim);

        for (int i = 0; i < k; i++) {
            maxheap.offer(arr[i]);
        }
        for (int j = k; j < arr.length; j++) {
            int var = maxheap.peek();
            if (var > arr[j]){
                maxheap.poll();
                maxheap.offer(arr[j]);
            }
        }

        for (int p = 0; p < k; p++) {
            tmp[p] = maxheap.poll();
        }
        return tmp;
    }
}
