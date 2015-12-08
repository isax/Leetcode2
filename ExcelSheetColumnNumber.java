public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        int digit = 1;
        for(int i = s.length()-1; i>=0; i--){
            sum += digit*(s.charAt(i)-'A'+1);
            digit *= 26;
        }
        return sum;
    }
}
