public class Solution {
    
    public int maxCoins(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        int[] coins = new int[len + 2];
        coins[0] = 1; coins[len + 1] = 1;
        System.arraycopy(nums, 0, coins, 1, len);
        
        int[][] dp = new int[len+1][len+1];
        
        for(int l = 1; l<=len; l++){
            for(int i = 1; i <= len - l + 1; i++){
                int max = Integer.MIN_VALUE;
                int j = i + l - 1;
                for(int last = i; last <= j; last++){
                    int reward = coins[last]*coins[i-1]*coins[i+l];
                    if(last != i){
                        reward += dp[i][last-1];
                    }
                    if(last != i + l -1){
                        reward += dp[last+1][j];
                    }
                    max = Math.max(max, reward);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][len];
    }
    
    
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
