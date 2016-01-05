public class Solution {
    
    public int numWays(int n, int k) {
        if(n==0 || k==0) return 0; 
        if(n==1) return k;
        if(n==2) return k*k;
        
        int a = k;
        int b = k*k;
        
        for(int i = 3; i<=n; i++){
            int c = a*(k-1) + b*(k-1);
            a = b;
            b = c;
        }
        return b;
    }
    
    public int numWaysMine(int n, int k) {
        if(n==0 || k==0) return 0; 
        int [][] dp = new int[n][k];
        
        Arrays.fill(dp[0], 1);
        
        int lastLastTotal = 0;
        int lastTotal = k;
        
        for(int i = 1; i<n; i++){
            int curTotal = 0;
            for(int j = 0; j<k; j++){
                dp[i][j] += (lastTotal-dp[i-1][j]) + (i==1?1:(lastLastTotal-dp[i-2][j]));
                curTotal += dp[i][j];
            }
            
            lastLastTotal = lastTotal;
            lastTotal = curTotal;
        }
        return lastTotal;
    }
}
