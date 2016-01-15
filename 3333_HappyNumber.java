public class Solution {
    public boolean isHappy(int n) {
        if(n<0) return false;
        
        while(n>=10){
            int cur = 0;
            while(n>0){
                cur += (n%10)*(n%10);
                n = n/10;
            }
            n = cur;
        }
        return n==1||n==7;
    }
}
