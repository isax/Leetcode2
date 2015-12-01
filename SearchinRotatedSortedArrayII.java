public class Solution {

    // http://blog.csdn.net/linhuanmars/article/details/20588511
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            
            if(nums[mid]==target){
                return true;
            }
            
            if(nums[l]<nums[mid]){ // we are sure left is incremental
                if(nums[mid]>target && target>=nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else if(nums[mid]<nums[l]){ // we are sure left is un-incremental, so right is incremental
                if(nums[mid]<target && target<=nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{ // not sure
                l++;
            }
        }
        return false;
    }
}
