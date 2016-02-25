public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverse = 0;
        // while(n!=0){
        for(int i = 0; i<32; i++)
        {
            // ">>" maintains the sign bit (result is a signed integer), while ">>>" does not (result is an unsigned integer).
            reverse <<= 1;
            reverse |= n&1; //reverse ^= n&1;
            n >>= 1;
        }
        return reverse;
    }
}
