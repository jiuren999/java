import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int p=0;
        int r=nums.length-1;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==val){
                if (nums[r]!=val){
                nums[i]=nums[r];
                p++;
                r--;
                }
            }
        }
        return nums.length-p;
    }
}
public class yichu {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr ={3,2,2,3};  int val = 3;
        System.out.println(solution.removeElement(arr, val));

    }
}
