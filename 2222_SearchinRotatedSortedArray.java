public class Solution {
    // https://github.com/isax/Leetcode2/blob/master/SearchinRotatedSortedArray.java
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            
            if(nums[mid]==target){
                return mid;
            }
            
            if(nums[mid]>=nums[l]){
                if(target<nums[mid] && target>=nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target>nums[mid] && target<=nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public int searchMine(int[] nums, int target) {
        return helper(nums, 0, nums.length-1, target);
    }
    
    private int helper(int[] nums, int l, int r, int target){
        if(l>r) return -1;
        
        int mid = (l+r)/2;
        if(nums[l]<=nums[mid] && nums[mid]<=nums[r]){
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                return helper(nums, mid+1, r, target);
            }else{
                return helper(nums, l, mid-1, target);
            }
        }else if(nums[mid]>=nums[l]){
            if(target<=nums[mid] && target>=nums[l]){
                return helper(nums, l, mid, target);
            }else{
                return helper(nums, mid+1, r, target);
            }
        }else{
            if(target>=nums[mid] && target<=nums[r]){
                return helper(nums, mid, r, target);
            }else{
                return helper(nums, l, mid-1, target);
            }
        }
    }
}
