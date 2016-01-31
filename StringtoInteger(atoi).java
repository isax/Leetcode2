public class Solution {
    // https://leetcode.com/discuss/77628/java-easy-version-to-understand
    /* 1) Whitespace 2) Sign: '+', '-'  3) Numerical digits  4) Integer boundary: MAX, MIN */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        
        char firstChar = str.charAt(0);
        int sign = 1, start = 0;
        if(firstChar=='+'){
            sign = 1;
            start = 1;
        }else if(firstChar=='-'){
            sign = -1;
            start = 1;
        }
        
        long sum = 0;
        for(int i = start; i<str.length(); i++){
            if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                break;
            }
            sum = sum * 10 + str.charAt(i) - '0';
            
            if (sign == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && (-1)*sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)sum * sign;
    }
}
