public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> hs = new HashSet<Character>();
        
        for(char ch : s.toCharArray()){
            if(hs.contains(ch)) hs.remove(ch);
            else hs.add(ch);
        }
        return hs.size()<=1;
    }
}
