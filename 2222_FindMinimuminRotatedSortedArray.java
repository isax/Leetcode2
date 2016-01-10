public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        
        while(l<=r){
            if(nums[l]<=nums[r]){
                return nums[l];
            }
            
            int mid = (l+r)/2;
            
            // [1,2] [2,1]
            if(nums[mid]<nums[r]){ // nums[mid]==nums[r] impossible
                r = mid;
            }else if(nums[mid]>nums[r]){
                l = mid+1;
            }
        }
        return Integer.MIN_VALUE;
    }
}
