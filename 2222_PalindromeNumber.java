public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int base = 1;
        while(base<=x/10){ // note: base*10<=x could overflow
            base *= 10;
        }
        
        while(x>0){ // cannot be x>=10, e.g. 100021
            if(x/base!=x%10) return false;
            
            x = x%base/10;
            base /= 100;
        }
        return true;
    }
}
