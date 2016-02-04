public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean [][] pal = new boolean[len][len];
        
        int max = 0;
        int [] res = new int[2];
        for(int i = 0; i<len; i++){
            for(int j = 0; j<=i; j++){
                if( (i==j || s.charAt(j)==s.charAt(i)) && (i-j<=1 || pal[j+1][i-1])){
                    pal[j][i] = true;
                    if(i-j+1>max) {
                        max = i-j+1;
                        res[0] = j;
                        res[1] = i;
                    }
                }else{
                    pal[j][i] = false;
                }
            }
        }
        return s.substring(res[0], res[1]+1);
    }
}
