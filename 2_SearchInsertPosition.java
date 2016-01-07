public class Solution {
    public int searchInsert(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }
    
    private int helper(int[] nums, int target, int l, int r){
        while(l<=r){
            int mid = l + (r-l)/2;
            
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r = mid-1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
