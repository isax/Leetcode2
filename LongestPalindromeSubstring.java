public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean [][] dp = new boolean[len][len];
        int global = 0;
        int index = 0;
        for(int i = 0; i<len; i++){
            for(int j = 0; j<=i; j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=1 || dp[j+1][i-1])) dp[j][i] = true;
                
                if(dp[j][i] && i-j+1>global){
                    global = i-j+1;
                    index = j;
                }
            }
        }
        return s.substring(index, index+global);
    }

    public String longestPalindrome2(String s) {
        String global = "";
        for(int i = 0; i<s.length();i++){
            String odd = expand(s, i, i);
            String even = expand(s, i, i+1);
            
            String better = odd.length()>=even.length()?odd:even;
            global = global.length()>=better.length()?global:better;
        }
        return global;
    }
    
    private String expand(String str, int s, int e){
        String res = "";
        while(s>=0 && e<str.length()){
            if(str.charAt(s)==str.charAt(e)){
                s--;
                e++;
            }else{
                break;
            }
        }
        return str.substring(s+1,e);
    }
}
