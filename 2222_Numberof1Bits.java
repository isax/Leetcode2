public class Solution {
    // https://leetcode.com/discuss/69543/why-works-perfectly-while-would-cause-time-exceeded-in-java
    
    
    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int count = 0;
        while(n!=0){
            if((n&1)==1) count++;
            n = n>>>1;
        }
        return count;
    }
    
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
