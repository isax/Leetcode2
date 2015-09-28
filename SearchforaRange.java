public class Solution {
    // Another solution: https://leetcode.com/discuss/18242/clean-iterative-solution-binary-searches-with-explanation
    
    // Mine:
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        
        res[0] = searchStart(nums, target, 0, nums.length-1);
        res[1] = searchEnd(nums, target, 0, nums.length-1);
        
        return res;
    }
    
    private int searchStart(int[]nums, int target, int left, int right){
        boolean f = false;//int i = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>=target){
                right = mid-1;
            }
            if(nums[mid]==target) f = true;
        }
        return f?right+1:-1;
    }
    
    private int searchEnd(int[]nums, int target, int left, int right){
        boolean f = false;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<=target){
                left = mid+1;
            }else {
                right = mid-1;
            }
            if(nums[mid]==target) f = true;
        }
        return f?left-1:-1;
    }
}
