public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/21145231
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        
        int div = 1;
        while(div<=x/10){
            div *= 10;
        }
        
        while(x>0){
            if(x/div != x%10) return false;
            x = (x%div)/10;
            div /= 100;
        }
        return true;
    }
}
