public class Solution {
    // double factorial n!!
    // https://leetcode.com/discuss/64291/share-my-java-backtracking-solution
    public boolean canWin(String s) {
        for(int i = 0; i<s.length()-1; i++){
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
                //flip this and dfs
                if(!canWin(s.substring(0, i)+"--"+s.substring(i+2))){
                    return true;
                }
            }
        }
        return false;
    }
}
