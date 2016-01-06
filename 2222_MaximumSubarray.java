public class Solution {
    public int maxSubArray2(int[] nums) {
        if(nums.length==0) return Integer.MIN_VALUE;
        
        int max = nums[0];
        int local = 0;
        for(int i = 0; i<nums.length; i++){
            local += nums[i];
            max = Math.max(local, max);
            
            if(local<0){
                local = 0;
            }
        }
        return max;
    }
    
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return Integer.MIN_VALUE;
        
        int max = nums[0];
        int local = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(local<0){
                local = nums[i];
            }else{
                local += nums[i];
            }
            max = Math.max(local, max);
        }
        return max;
    }
}
