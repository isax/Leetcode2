public class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int l = 0, r = len-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            
            boolean left = mid==0?true:(nums[mid-1]<nums[mid]);
            boolean right = mid==len-1?true:(nums[mid]>nums[mid+1]);
            
            if(left&&right){
                return mid;
            }else if(!left){
                r = mid-1;
            }else if(!right){
                l = mid+1;
            }
        }
        return -1;
    }
}
