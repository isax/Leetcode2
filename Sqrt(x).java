public class Solution {
    public int mySqrt(int x) {
        if(x<0) return -1;
        if(x==0) return 0;
        
        int l = 1;
        int r = x/2+1;
        
        while(l<=r){
            int mid = l+(r-l)/2;
            
            if(mid<=x/mid && mid+1>x/(mid+1)){
                return mid;
            }
            
            if(mid>x/mid){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        return -1;
    }
}
