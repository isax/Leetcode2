public class Solution {
    public int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);
        for(int i = 0; i<=haystack.length()-needle.length(); i++){
            String sub = haystack.substring(i, i+needle.length()); // linear time for substring
            if(sub.equals(needle)) return i;
        }
        return -1;
    }
}
