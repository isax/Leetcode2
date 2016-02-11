public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    
    private int helper(int[]nums, int i, int j){
        if(i>j) return 0;
        
        int[]dp = new int[j-i+3];
        
        for(int n = 2; n<j-i+3; n++){
            dp[n] = Math.max(dp[n-1], dp[n-2]+nums[i+n-2]);
        }
        return dp[j-i+2];
    }
}
