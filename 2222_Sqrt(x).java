public class Solution {
    public int mySqrt(int x) {
        if(x<0) return Integer.MIN_VALUE;
        if(x==0) return 0; // otherwise x/0
        return bs(x, 1, x/2+1);
    }
    private int bs(int x, int l, int r){
        while(l<=r){
            int mid = (l+r)/2;
            
            //////////////int cur = mid*mid;
            //if(mid==x/mid && x%mid==0){
                //return mid;
            //}
            if(mid<=x/mid && mid+1>x/(mid+1)){
                return mid;
            }else if(mid>x/mid){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }
}
