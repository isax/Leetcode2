public class Solution {
    // my leetcode memory
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(sum>max){
                max = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }
    
    // Good explanation here for local and global: http://blog.csdn.net/linhuanmars/article/details/21314059
    public int maxSubArray(int[] nums) {
        int local = nums[0];
        int global = nums[0];
        
        for(int i = 1; i<nums.length; i++){
               local = Math.max(nums[i], local+nums[i]);
               global = Math.max(global, local);
        }
        return global;
    }
}
