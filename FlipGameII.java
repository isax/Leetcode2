public class Solution {
    
    // https://leetcode.com/discuss/64291/share-my-java-backtracking-solution
    // (n-1) * (n-3) * (n-5)... = O(n!!)
    public boolean canWin(String s) {
        if(s.length()==0) return false;
        
        for(int i = 0; i<s.length()-1; i++){
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
                boolean next = canWin(s.substring(0, i) + "--"+s.substring(i+2));
                if(!next) return true;
            }
        }
        return false;
    }
}
