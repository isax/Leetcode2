public class Solution {
    // https://github.com/isax/Leetcode2/blob/master/SearchinRotatedSortedArrayII.java
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            
            if(nums[mid]==target){
                return true;
            }
            
            if(nums[mid]>nums[l]){
                if(target<nums[mid] && target>=nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else if(nums[mid]<nums[l]){ // if(nums[mid]<nums[r]) --- [3, 1, 1] find 3
                if(target>nums[mid] && target<=nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
               l++; 
            }
        }
        return false;
    }
}
