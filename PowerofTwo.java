public class Solution {
    public boolean isPowerOfTwo2(int n) {
        if(n==1) return true;
        if(n<=0 || n%2!=0) return false;
        else return isPowerOfTwo(n/2);
    }
    
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n&(n-1))==0;
    }
}
