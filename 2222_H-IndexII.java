public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int l = 0; int r = len-1;
        
        while(l<=r){
            int mid = l + (r-l)/2;
            if(citations[mid]<len-mid) l = mid+1;
            else if(citations[mid]>=len-mid) r = mid-1;
        }
        
        return len-l;
    }
}
