public class Solution {
    // good explanation here: http://blog.csdn.net/linhuanmars/article/details/39537283
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        int local = nums[0];
        int local_min = nums[0]; // local negative max
        int global = nums[0];
    
        for(int i = 1; i<nums.length; i++){
            int temp = local*nums[i];
            int temp_min = local_min*nums[i];
            
            //decide local 
            local = Math.max(Math.max(temp, temp_min), nums[i]);
            
            // decide local min: negative with max absolute value
            local_min = Math.min(Math.min(temp, temp_min), nums[i]);
            
            // decide global
            global = Math.max(global, local);
        }
        max = Math.max(max, global);
        return max;
    }
}
