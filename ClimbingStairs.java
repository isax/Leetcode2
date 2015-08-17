public class Solution {
    /*
    public int climbStairs(int n) {
        int [] dp = new int [n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }*/
    
    public int climbStairs(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        
        if(n==0) return f1;
        if(n==1) return f2;
        
        for(int i = 2; i<=n; i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
