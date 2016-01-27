public class Solution {
    // https://leetcode.com/discuss/53646/simple-and-easy-to-understand-java-solution
    // https://leetcode.com/discuss/67187/java-python-easy-solution-with-explanation
    public int rangeBitwiseAnd(int m, int n) {
        int diffBits = 0;
        while(m!=n){
            m >>= 1;
            n >>= 1;
            diffBits++;
        }
        return n<<diffBits;
    }
}
