public class Solution {
    //315
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    private int helper(int[] nums, int i, int j){
        int mid = (i+j)/2;
        
        if(nums[i]<=nums[j]){
            // increasing
            return nums[i];
        }else{
            if(nums[i]<=nums[mid]){
                return helper(nums, mid+1, j);
            }else{
                return helper(nums, i, mid);
            }
        }
    }
    
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
