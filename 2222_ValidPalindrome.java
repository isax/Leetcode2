public class Solution {
    // TRY WRITE IT AGAIN AND BUGFREE = =|||
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0) return true;
        String str = s.toLowerCase();
        int l = 0, r = s.length()-1;
        
        while(l<r){
            if(!isAlphanumeric(s.charAt(l))){
                l++;
                continue;
            }
            if(!isAlphanumeric(s.charAt(r))){
                r--;
                continue;
            }
            if(!isSame(s.charAt(l), s.charAt(r))) return false;
            l++; r--;
        }
        return true;
    }
    
    private boolean isSame(char c, char h){
        if(c>='A' && c<='Z') c = (char)(c-'A'+'a');
        if(h>='A' && h<='Z') h = (char)(h-'A'+'a');
        return c==h;
    }
    
    public boolean isPalindromeMine(String s) {
        if(s==null || s.length()==0) return true;
        String str = s.toLowerCase();
        int l = 0, r = s.length()-1;
        
        while(l<r){
            while(l<r && !isAlphanumeric(s.charAt(l))){
                l++;
            }
            while(l<r &&  !isAlphanumeric(s.charAt(r))){
                r--;
            }
            if(str.charAt(l++)!=str.charAt(r--)) return false;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char ch){
        return ch>='0'&&ch<='9' || ch>='a'&&ch<='z' || ch>='A' && ch<='Z';
    }
}
