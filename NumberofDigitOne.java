public class Solution {
    // https://leetcode.com/discuss/64962/java-python-one-pass-solution-easy-to-understand
    // xyz a bcd
    // if a==0, (0 - xyz-1) * 1000
    // if a==1, (0 - xyz-1) * 1000 + xyz 1 000 - xyz 1 bcd, which is bcd + 1
    // if a>1, (0 - xyz-1) * 1000 + xyz 1 000 - xyz 1 999, which is 1000
    public int countDigitOne(int n) {
        int count = 0;
        int x = n, y = 1;
        while(x > 0) {
            int digit = x % 10;
            x /= 10;
            count += x * y; // digit  = 0
            if (digit == 1) count += n % y + 1;
            if (digit > 1) count += y;
            y *= 10;
        }
        return count;
    }
}
