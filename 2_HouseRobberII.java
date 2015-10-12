public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    
    private int helper(int [] nums, int start, int end){
        int [] dp = new int [end-start+1];
        
        for(int i = start; i<=end; i++){
            int o1 = i-start-1>=0?dp[i-start-1]:0;
            int o2 = nums[i] + (i-start-2>=0?dp[i-start-2]:0);
            dp[i-start] = Math.max(o1, o2);
        }
        return dp[end-start];
    }
}
