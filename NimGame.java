public class Solution {
    
    //https://leetcode.com/discuss/63725/theorem-all-4s-shall-be-false
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
    
    public boolean canWinNimMine(int n) {
        if(n<=3) return true;
        if(n==4) return false;
        
        if((n-1)%4==0 || (n-2)%4==0 || (n-3)%4==0) return true;
        else return false;
    }
}
