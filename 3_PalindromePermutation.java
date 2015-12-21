public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        
        for(char c : s.toCharArray()){
            if(!set.add(c)) set.remove(c);
        }
        return set.size()<=1;
    }
}
