public class Solution {
    // https://leetcode.com/discuss/63863/simple-15-line-code-with-o-n-time-and-o-1-memory-solution-java
    // https://leetcode.com/discuss/51721/simple-java-dp-solution
    public int minCostMoreSpace(int[][] costs) {
        int count = costs.length;
        if(count==0) return 0;
        int [][] dp = new int[count][3];
        
        for(int i = 0;i<count; i++){
            /*
            dp[i][0] = i==0?costs[i][0]:Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = i==0?costs[i][1]:Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = i==0?costs[i][2]:Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
            */
            for(int j = 0; j<3; j++){
                dp[i][j] = i==0?costs[i][j]:Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + costs[i][j];
            }
        }
        return Math.min(dp[count-1][0],Math.min(dp[count-1][1], dp[count-1][2]));
    }
    
     public int minCost(int[][] costs) {
        int count = costs.length;
        if(count==0) return 0;
        int [] prev = costs[0]; // i==0
        
        for(int i = 1;i<count; i++){
            int [] cur = new int[3];
            for(int j = 0; j<3; j++){
                cur[j] = Math.min(prev[(j+1)%3], prev[(j+2)%3]) + costs[i][j];
            }
            prev = cur;
        }
        return Math.min(prev[0],Math.min(prev[1], prev[2]));
    }
}
