public class Solution {
    // number of 5s in n!
    public int trailingZeroes(int n) {
        int numOf5 = 0;
        while(n!=0){
            numOf5 += n/5;
            n = n/5;
        }
        return numOf5;
    }
}
