public class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        for(int i = 1; i<=n; i++){
            int sqrt = (int)Math.sqrt(i);
            if(sqrt*sqrt==i) dp[i] = 1;
            //while((sqrt+1)*(sqrt+1)<=i){
                //sqrt++;
            //}
            else{
                dp[i] = i;
                for(int j = sqrt; j>=1; j--){
                    dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                }
            }
        }
        return dp[n];
    }
}
