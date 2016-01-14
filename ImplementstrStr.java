public class Solution {
    // https://leetcode.com/discuss/27524/share-my-accepted-java-solution
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        
        //if(h<n) return -1;
        if(n==0) return 0;
        
        for(int i = 0; i<h-n+1; i++){
            if(haystack.substring(i, i+n).equals(needle)) return i;
        }
        return -1;
    }
}
