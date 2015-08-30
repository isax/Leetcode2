public class Solution {
    public boolean isUgly(int num) {
        if(num==1) return true;
        if(num<=0) return false;
        
        if(num%2==0 && isUgly(num/2)) return true;
        else if(num%3==0 && isUgly(num/3)) return true;
        else if(num%5==0 && isUgly(num/5)) return true;
        else return false;
    }
    // iteration: https://leetcode.com/discuss/54666/java-entry-ugly-number-i
}
