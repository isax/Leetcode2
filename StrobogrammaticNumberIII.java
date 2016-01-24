public class Solution {
    // https://leetcode.com/discuss/73721/easiest-20ms-94%25-java-solution
    char[][] pairs = {{'0','0'}, {'1','1'}, {'6','9'}, {'8','8'}, {'9','6'}};
    
    public int strobogrammaticInRange(String low, String high) {
        //int [] count = new int[1];
        int count = 0;
        for(int i = low.length(); i<=high.length(); i++){
            count += dfs(low, high, new char[i], 0, i-1);
        }
        return count;
    }
    
    private int dfs(String low, String high, char[] c, int l, int r){
        if(l>r){
            String str = new String(c);
            if(low.length()==str.length() && str.compareTo(low)<0 ||  high.length()==str.length() && high.compareTo(str)<0){
                return 0;
            }
            //count[0]++;
            return 1;
        }
        int count = 0;
        for(char[]p : pairs){
            c[l] = p[0];
            c[r] = p[1];
            if(c.length != 1 && c[0] == '0') continue; // otherwise, [50, 100] will contain 000, 080, 010 as they are <100.
            if(l<r || l==r && p[0]==p[1]) count += dfs(low, high, c, l+1, r-1);
        }
        return count;
    }
}
