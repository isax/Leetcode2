public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        
        int localMin = nums[0];
        int localMax = nums[0];
        int global = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            int c1 = localMin*nums[i];
            int c2 = localMax*nums[i];
            
            localMin = Math.min(nums[i], Math.min(c1, c2));
            localMax = Math.max(nums[i], Math.max(c1, c2));
            global = Math.max(global, localMax);
        }
        return global;
    }
}
