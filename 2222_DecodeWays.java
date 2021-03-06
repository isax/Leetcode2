public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len==0) return 0;
        int [] dp = new int[len+1];
        dp[0] = 1;
        
        for(int i = 1; i<=len; i++){
            int num = s.charAt(i-1) - '0';
            
            if(num!=0){
                dp[i] += dp[i-1];
            }
            if(i>1 && (s.charAt(i-2)=='1' || s.charAt(i-2)=='2' && num<=6)){
                dp[i] += dp[i-2];
            }
            //if(dp[i]==0) return 0;
        }
        return dp[len];
    }
    
    // https://leetcode.com/discuss/83547/java-clean-dp-solution-with-explanation
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for(int i = 2; i<=n; i++){
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            
            if(first>=1 && first<=9){
                dp[i] += dp[i-1];
            }
            if(second>=10 && second<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
