public class Solution {
    // https://leetcode.com/discuss/78532/summary-all-solutions-new-method-included-at-15-30pm-jan-8th
    public boolean isPowerOfThree2(int n) {
        //if(n<=0) return false;
        
        while(n>1){
            if(n%3!=0) return false;
            n = n/3;
        }
        return n==1;
    }
    public boolean isPowerOfThree(int n) {
        return n>0 && Math.pow(3, (int)(Math.log(Integer.MAX_VALUE)/Math.log(3)))%n==0;
    }
}
