import java.util.Deque;
import java.util.LinkedList;

public class Sort {

//    直接插入排序
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {

            int tmp = array[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if (array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }

    }
//希尔排序
    public static void shellSort(int[] array){
        int ghp = array.length;
        while (ghp>1){
            shell(array,ghp);
            ghp/=2;
        }
        shell(array,ghp);
    }


    public static void shell(int[] array, int ghp){
        for (int i = ghp; i < array.length; i++) {
            int tmp = array[i];
            int j = i-ghp;
            for (; j >= 0 ; j-=ghp) {
                if (array[j] > tmp){
                    array[j+ghp] = array[j];
                }else {
                    break;
                }
            }
            array[j+ghp] = tmp;
        }
    }

    //选择排序
    public static void selectSort(int[] array){

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j <array.length ; j++) {
                if (array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            Sort.swap(array ,i ,minIndex);
        }
    }


    public static void swap(int[] array , int i ,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

//选择排序二
    public static void selectSort2(int[] array){
        int left = 0;
        int right = array.length-1;

        while (left<right) {
            int minIndex = left;
            int maxIndex = left;

            for (int i = left+1; i <= right; i++) {
                if (array[i] < array[minIndex]){
                    minIndex = i;
                }
                if (array[i]>array[maxIndex]){
                    maxIndex = i;
                }
            }
            swap(array , left ,minIndex);
            if (left == maxIndex){
                maxIndex = minIndex;
            }
            swap(array , right ,maxIndex);
            left++;
            right--;
        }
    }

    //堆排序

    public static void heapSort(int[] array){
        creatBigHeap(array);
        int end = array.length-1;
        while (end>0){
            swap(array, 0 ,end);
            shiftDown(array,0,end);
            end--;
        }
    }

    public static void creatBigHeap(int[] array){
        for (int parent = (array.length-1-1)/2; parent >= 0 ; parent--) {
            shiftDown(array ,parent,array.length);
        }
    }

    public static void shiftDown(int[] array , int parent , int len){

        int child = 2*parent+1;
        while (child<len){
            if (child+1 < len && array[child]<array[child+1]){
                child++;
            }
            if (array[child]>array[parent]){
                swap(array,child,parent);
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }

    }

    //冒泡排序
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            boolean flog = false;
            for (int j = 0 ; j < array.length-1-i; j++) {
                if (array[j]>array[j+1]){
                    swap(array,j,j+1);
                    flog = true;
                }
            }
            if (flog == false){
                return;
            }
        }
    }



        /**
         * 时间复杂度：N*logN
         *         最好情况 ：N*logN
         *         最坏情况：N^2  有序、逆序  优化！！！
         * 空间复杂度：
         *         最好情况：logN
         *         最坏情况：N
         * 稳定性：不稳定
         * @param array
         */
    public static void quickSort1(int[] array) {
        quick(array,0,array.length-1);
    }
    private static void quick(int[] array,int start,int end) {
        //为什么取大于号  ： 1 2 3 4 5 6
        if(start >= end) {
            return;
        }

        //使用这个优化 主要解决 减少递归的次数
        if(end - start + 1 <= 14) {
            //插入排序
            insertSort2(array,start,end);
            return;
        }
        //System.out.println("start:"+start+"  end: "+end);
        //三数取中法
        int index = midThree(array, start,end);
        swap(array,index,start);

        int pivot = partition(array,start,end);//划分
        quick(array,start,pivot-1);
        quick(array,pivot+1,end);
    }

    private static void insertSort2(int[] array,int left,int right) {
        for (int i = left+1; i <= right; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= left ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    private static int midThree(int[] array,int left,int right) {
        int mid = (left+right) / 2;
        //6  8
        if(array[left] < array[right]) {
            if(array[mid] < array[left]) {
                return left;
            }else if(array[mid] > array[right]) {
                return right;
            }else {
                return mid;
            }
        }else {
            //array[left] > array[right]
            if(array[mid] < array[right]) {
                return right;
            }else if(array[mid] > array[left]) {
                return left;
            }else {
                return mid;
            }
        }

    }
    //挖坑法
    private static int partition(int[] array,int left,int right) {
        int tmp = array[left];
        while (left < right) {
            while (left< right && array[right] >= tmp) {
                right--;
            }
            array[left] = array[right];
            while (left< right && array[left] <= tmp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = tmp;
        return left;
    }
    //Hoare法
    private static int partition2(int[] array,int left,int right) {
        int tmp = array[left];
        int i = left;
        while (left < right) {
            while (left< right && array[right] >= tmp) {
                right--;
            }
            while (left< right && array[left] <= tmp) {
                left++;
            }
            swap(array,left,right);
        }
        swap(array,left,i);
        return  left;
    }

    //前后指针法 【了解即可】
    private static int partition3(int[] array,int left,int right) {
        int prev = left ;
        int cur = left+1;
        while (cur <= right) {
            if(array[cur] < array[left] && array[++prev] != array[cur]) {
                swap(array,cur,prev);
            }
            cur++;
        }
        swap(array,prev,left);
        return prev;
    }

    //快排非递归实现
    public static void quickSort3(int[] array) {
        Deque<Integer> stack = new LinkedList<>();

        int left = 0;
        int right = array.length-1;

        stack.push(left);
        stack.push(right);

        while (!stack.isEmpty()){
            right = stack.pop();
            left = stack.pop();
            int pivot = partition(array,left,right);
            if (pivot > left+1){
                stack.push(left);
                stack.push(pivot-1);
            }
            if (pivot < right-1){
                stack.push(pivot+1);
                stack.push(right);
            }
        }
    }
//归并排序  时间复杂度 N*logN   空间复杂度N
    public static void mergeSort(int[] array){
        mergeFunc(array,0,array.length-1);
    }

    public static void mergeFunc(int[] array,int left,int right){
        if (left >= right){
            return;
        }

        int mid = (left+right)/2;
        mergeFunc(array,left,mid);
        mergeFunc(array,mid+1,right);
        merge(array,left,right,mid);
    }
                                          ///   0       1       0
    public static void merge(int[] array,int start,int end,int mid){
        int s1 = start;//0
        int s2 = mid+1;//1

        int[] tmp = new int[end-start+1]; //2
        int k = 0; //表示tmp数组的下标
        while (s1 <= mid && s2 <= end){
            if (array[s1] <= array[s2]){
                tmp[k++] = array[s1++];
            }else{
                tmp[k++] = array[s2++];
            }
        }
        while (s1 <= mid){
            tmp[k++] = array[s1++];
        }
        while (s2 <= end){
            tmp[k++] = array[s2++];
        }
        for (int i = 0; i <tmp.length ; i++) {
            array[i+start] = tmp[i];
        }
    }


    public static void mergeSort2(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            // i += gap * 2 当前gap组的时候，去排序下一组
            for (int i = 0; i < array.length; i += gap * 2) {
                int left = i;
                int mid = left+gap-1;//有可能会越界
                if(mid >= array.length) {
                    mid = array.length-1;
                }
                int right = mid+gap;//有可能会越界
                if(right>= array.length) {
                    right = array.length-1;
                }
                merge(array,left,right,mid);
            }
            //当前为2组有序  下次变成4组有序
            gap *= 2;
        }
    }

    /**
     * 计数排序
     * 时间复杂度： O(N+范围)
     * 空间复杂度：O(范围)
     * 稳定性：
     * @param array
     */
    public static void countSort(int[] array) {
        //1. 遍历数组 找到最大值 和 最小值
        int max = array[0];
        int min = array[0];
        //O(N)
        for (int i = 1; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
            if(array[i] > max) {
                max = array[i];
            }
        }
        //2. 根据范围 定义计数数组的长度
        int len = max - min + 1;
        int[] count = new int[len];
        //3.遍历数组，在计数数组当中 记录每个数字出现的次数 O(N)
        for (int i = 0; i < array.length; i++) {
            count[array[i]-min]++;
        }
        //4.遍历计数数组
        int index = 0;// array数组的新的下标 O(范围)
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                //这里要加最小值  反应真实的数据
                array[index] = i+min;
                index++;
                count[i]--;
            }
        }
    }

}

