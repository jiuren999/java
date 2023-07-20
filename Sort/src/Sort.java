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

}
