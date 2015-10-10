public class Solution {
    public int rob(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        
        for(int i = 0; i<nums.length; i++){
            int o1 = nums[i] + (i-2<0?0:dp[i-2]); // dont forget the brackets..
            int o2 = i-1<0?0: dp[i-1];
            dp[i] = Math.max(o1, o2);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
