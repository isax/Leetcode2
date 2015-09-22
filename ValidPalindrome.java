public class Solution {
    // http://codeganker.blogspot.com/2014/04/valid-palindrome-leetcode.html
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0) return true;
        
        int left = 0;
        int right = s.length()-1;
        
        while(left<right){
            if(!isAlphaNumeric(s.charAt(left))){
                left++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(right))){
                right--;
                continue;
            }
            if(!isSame(s.charAt(left),s.charAt(right))) return false;

            left++;
            right--;
        }
        return true;
    }
    
    private boolean isSame(char c, char t){
        if(c>='A' && c<='Z') c = (char)(c-'A'+'a');
        if(t>='A' && t<='Z') t = (char)(t-'A'+'a');
        return c==t;
    }
    
    public boolean isPalindromeMy(String s) {
        if(s==null || s.length()==0) return true;
        
        int left = 0;
        int right = s.length()-1;
        
        while(left<right){
            if(!isAlphaNumeric(s.charAt(left))){
                left++;
            }
            if(!isAlphaNumeric(s.charAt(right))){
                right--;
            }
            if(isAlphaNumeric(s.charAt(left))&& isAlphaNumeric(s.charAt(right)) && left<=right){
                if((char)Character.toLowerCase(s.charAt(left))!=(char)Character.toLowerCase(s.charAt(right))) return false;
                left++;
                right--;
            }
        }
        return true;
    }
    
    private boolean isAlphaNumeric(char ch){
        if( ch>='0' && ch<='9' || ch>='a' && ch<='z' || ch>='A' && ch<='Z' ) return true;
        return false;
    }
}
