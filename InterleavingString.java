public class Solution {
    // https://leetcode.com/discuss/11694/my-dp-solution-in-c
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i = 1; i<=s1.length();i++){
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
        }
        for(int i = 1; i<=s2.length();i++){
            dp[0][i] = dp[0][i-1] && s2.charAt(i-1)==s3.charAt(i-1);
        }
        
        for(int i = 1; i<=s1.length(); i++){
            for(int j = 1; j<=s2.length();j++){
                dp[i][j] = (s1.charAt(i-1)==s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1)==s3.charAt(i+j-1) && dp[i][j-1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
    
    
    // complicated: recursion + cache
    public boolean isInterleaveMy(String s1, String s2, String s3) {
        int[][][] cache = new int[s1.length()][s2.length()][s3.length()];
        
        for(int i = 0; i<s1.length(); i++){
            for(int j = 0; j<s2.length(); j++){
                for(int k = 0; k<s3.length(); k++){
                    cache[i][j][k] = -1;
                }
            }
        }
        return helper(s1, s2, s3, 0, 0, 0, cache);
    }
    
    private boolean helper(String s1, String s2, String s3, int i1, int i2, int i, int [][][] cache){
        int l1 = i1>s1.length()-1?0:s1.length()-i1;
        int l2 = i2>s2.length()-1?0:s2.length()-i2;
        int l3 = i>s3.length()-1?0:s3.length()-i;
        if(l1+l2!=l3) {
            return false;
        }
        
        //if(i1 == s1.length() && i2==s2.length() && i==s3.length()) return true;
        
        if(i1>s1.length()-1)  return s2.substring(i2).equals(s3.substring(i));
        if(i2>s2.length()-1)  return s1.substring(i1).equals(s3.substring(i));
        
        if(cache[i1][i2][i]!=-1) return cache[i1][i2][i]==1?true:false;
        
        boolean res;
        char ch = s3.charAt(i);
        char ch1 = s1.charAt(i1);
        char ch2 = s2.charAt(i2);
            
        if(ch!=ch1 && ch!=ch2) {
            res = false;
        }else{
            if(ch==ch1 && ch!=ch2){
                res = helper(s1, s2, s3, i1+1, i2, i+1, cache);
            }else if(ch==ch2 && ch!=ch1){
                res = helper(s1, s2, s3, i1, i2+1, i+1, cache);
            }else{ // ch == ch1 && ch == ch2
                res = helper(s1, s2, s3, i1+1, i2, i+1, cache) || helper(s1, s2,s3, i1, i2+1, i+1, cache);
            }
        }
        
        cache[i1][i2][i] = res?1:0;
        return res;
    }
}
