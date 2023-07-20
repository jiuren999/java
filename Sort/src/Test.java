import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        int[] arr = {9,7,5,3,4,1};
//        Sort.insertSort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        Sort.shellSort(arr);
//        System.out.println(Arrays.toString(arr));
//        Sort.selectSort2(arr);
        Sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
