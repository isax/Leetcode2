public class Solution {
    
    // 1) easy to understand but time consuming..
    // https://leetcode.com/discuss/37314/my-easily-understandable-but-time-consuming-c-solution
    
    // 2) based on longest palindrome
    // https://leetcode.com/discuss/55696/using-longest-palindrome
    // there is a clean one here - https://leetcode.com/discuss/61416/my-9-lines-three-pointers-java-solution-with-explanation
    public String shortestPalindromeOOM(String s) {
        int len = s.length();
        boolean [][] dp = new boolean[len][len];
        
        int maxPrefixPal = 0;
        for(int i = 0; i<len; i++){
            for(int j = 0; j<=i; j++){
                if(s.charAt(j)==s.charAt(i) && (i-j<=1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }else{
                    dp[j][i] = false;
                }
            }
            if(dp[0][i]) maxPrefixPal = i+1;
        }
        
        String suffix = s.substring(maxPrefixPal);
        return new StringBuilder(suffix).reverse().toString() + s;
    }
    
    public String shortestPalindrome(String s) {
        char [] chs = s.toCharArray();
        int len = s.length();
        int l = 0, r = len-1, temp = r;
        
        while(l<r){
            if(chs[l]==chs[r]){
                l++; r--;
            }else if(l<r){
                l = 0;
                r = temp-1;
                temp = r;
            }
        }
        
        String suffix = s.substring(temp+1);
        return new StringBuilder(suffix).reverse().toString() + s;
    }
}
