public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        
        int last = 0;
        for(int i = 0; i<=s.length; i++){
            if(i==s.length || s[i]==' '){
                reverse(s, last, i-1);
                last = i+1;
            }
        }
    }
    
    private void reverse(char[]s, int l, int r){
        while(l<r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++; r--;
        } 
    }
}
