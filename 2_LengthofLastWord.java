public class Solution {
    // https://leetcode.com/discuss/43675/228ms-java-solution
    public int lengthOfLastWord(String s) {
        s = s.trim(); // s is immutable, return copy 
        int len = 0;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)!=' ') len++;
            else break;
        }
        return len;
    }
    public int lengthOfLastWord3(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
    
    public int lengthOfLastWord(String s){
        String[] a = s.split(" ");
        if(a.length==0) return 0;
        else return a[a.length-1].length();
    }
}
