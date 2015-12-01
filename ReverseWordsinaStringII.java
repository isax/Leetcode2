public class Solution {
    
    // https://leetcode.com/discuss/24227/my-java-solution-with-explanation
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        
        int start = 0;
        for(int i = 0; i<=s.length; i++){
            if(i==s.length||s[i]==' '){
                reverse(s, start, i-1);
                start = i+1;
            }
        }
    }
    
    private void reverse(char[]s, int a, int b){
        while(a<b){
            char c = s[a];
            s[a++] = s[b];
            s[b--] = c;
        }
    }
}
