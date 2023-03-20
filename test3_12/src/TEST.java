import java.lang.reflect.Array;
import java.util.Arrays;

/*class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        for (int i = 0; i < k; i++) {
             for (int j =0;j<nums.length-1;j++) {
                 int tmp = nums[j + 1];
                 nums[j+1]=nums[0];
                 nums[0]=tmp;
            }
        System.out.println(String.valueOf(Arrays.toString(nums)));

    }
}

public class TEST {
   public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution solution = new Solution();
        solution.rotate(arr, k);
    }
}*/
