public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> hs = new HashSet<Character>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!hs.add(ch)) hs.remove(ch);
        }
        
        //int count = 0;
        //for(char ch : hs){ // iterate a hashset without iterator
            //count++;
            //if(count>1) return false;
        //}
        return hs.size()<=1;
    }
}
