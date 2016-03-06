public class Solution {
    // https://leetcode.com/discuss/88054/java-oms-with-explanation
    public boolean isSelfCrossing(int[] x) {
        int len = x.length;
        if(x.length<=3) return false;
        
        for(int i = 3; i<len; i++){
            // case 1: i cross i-3 (4th cross first)
            if(x[i]>=x[i-2] && x[i-1]<=x[i-3]) return true;
            // case 2: i overlaps i-4 (5th meets first)
            if(i>=4 && x[i-1]==x[i-3] && x[i] + x[i-4] >= x[i-2]) return true;
            // case 6: i cross i-5 (6th cross first)
            if(i>=5 && x[i-1]<=x[i-3] && x[i-2]>x[i-4] && x[i-1] + x[i-5]>=x[i-3] && x[i] + x[i-4]>=x[i-2]) return true;
        }
        return false;
    }

}
