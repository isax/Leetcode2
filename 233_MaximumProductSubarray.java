public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return Integer.MIN_VALUE;
        
        int max = nums[0];
        int localMin = nums[0];
        int localMax = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            int localMin_copy = localMin;
            localMin = Math.min(nums[i], Math.min(localMax*nums[i], localMin*nums[i]));
            localMax = Math.max(nums[i], Math.max(localMax*nums[i], localMin_copy*nums[i]));
            
            max = Math.max(max, localMax);
        }
        return max;
    }
}
