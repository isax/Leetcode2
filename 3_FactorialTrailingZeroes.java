public class Solution {
    // http://www.danielbit.com/blog/puzzle/leetcode/leetcode-factorial-trailing-zeroes
    public int trailingZeroes(int n) {
        int count = 0;
        while(n!=0){
            count += n/5;
            n = n/5;
        }
        return count;
    }
}
