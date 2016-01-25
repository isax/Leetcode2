public class Solution {
    // https://leetcode.com/discuss/74041/my-simple-c-solution
    public String convertToTitle(int n) {
        
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int diff = (n-1)%26;
            sb.append((char)('A'+ diff) + "");
            n = (n-1)/26;
        }
        return sb.reverse().toString();
    }
}
