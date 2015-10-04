public class Solution {
    // https://leetcode.com/discuss/43675/228ms-java-solution
    public int lengthOfLastWord2(String s) {
        String [] array = s.split(" ");
        if(array.length==0) return 0;
        return array[array.length-1].length();
    }
    
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
