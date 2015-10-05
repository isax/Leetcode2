public class Solution {
    // Another neat solution: http://blog.csdn.net/likecool21/article/details/10858799
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/19949159
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, longest = 0;
        HashSet<Character> hs = new HashSet<Character>();
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            while(hs.contains(c)){
                hs.remove(s.charAt(left));
                left++;
            }
            
            hs.add(s.charAt(i));
            right = i;
            
            longest = Math.max(longest, right-left+1);
        }
        return longest;
    }
}
