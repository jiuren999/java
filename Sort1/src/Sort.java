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
        return left;
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
}
