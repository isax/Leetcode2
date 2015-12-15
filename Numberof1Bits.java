public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int sum = 0;
        for(int i = 0; i<32; i++){
            if((n&1)==1) sum++;
            n = n>>1;
        }
        return sum;
    }
    
    // https://leetcode.com/discuss/27703/concise-java-solution-x-%26-x-1
     public int hammingWeight(int n) {
        int sum = 0;
        while(n!=0){
            n = n & (n-1);
            sum++;
        }
        return sum;
    }
}
