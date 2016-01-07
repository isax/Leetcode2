public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        
        int l = searchLeftRange(nums, target);
        int r = searchRightRange(nums, target);
        
        if(l+1<nums.length && nums[l+1]==target) {
            res[0] = l+1;
            res[1] = r-1;
        }else {
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }
    
    private int searchLeftRange(int[] nums, int target){
        int left = 0, right = nums.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(nums[mid]>=target) right = mid-1;
            else left = mid+1;
        }
        return right;
    }
    
    private int searchRightRange(int[] nums, int target){
        int left = 0, right = nums.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(nums[mid]<=target) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
}
