public class Solution {
    public int numWaysMine(int n, int k) {
        if(n==0) return 0;
        if(n==1) return k;
        if(n==2) return k*k;
        
        int [] dp = new int[n+1];
        dp[1] = k;
        dp[2] = k*k;
        
        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1]*(k-1) + dp[i-2]*(k-1);
        }
        return dp[n];
    }
    
    public int numWays(int n, int k) {
        if(n==0) return 0;
        if(n==1) return k;
        if(n==2) return k*k;
        
        int prev = k;
        int prev2 = k*k;
        
        for(int i = 3; i<=n; i++){
            int cur = prev2*(k-1) + prev*(k-1);
            prev = prev2;
            prev2 = cur;
        }
        return prev2;
    }
    
    
}
