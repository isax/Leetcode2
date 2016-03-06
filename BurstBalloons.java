public class Solution {
    // https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int [] copy = new int[len+2];
        System.arraycopy(nums, 0, copy, 1, len);
        copy[0] = 1; copy[len+1] = 1;
        // can burst 0 at first to optimize it
        
        int[][] dp = new int[len+2][len+2];
        for(int length = 2; length < len+2; length++){
            // left + (len-1) = right
            for(int left = 0; left<len+2-length; left++){
                int right = left + length;
                for(int last = left + 1; last < right; last++){
                    dp[left][right] = Math.max(dp[left][right],
                    copy[left]*copy[last]*copy[right] + dp[left][last] + dp[last][right]);
                }
            }
        }
        return dp[0][len+1];
    }
}
