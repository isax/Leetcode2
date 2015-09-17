public class Solution {
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[left]<=nums[mid] && nums[mid]<=nums[right]){
                return nums[left];
            }else if(nums[left]>nums[mid] && nums[right]>nums[mid]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    //https://leetcode.com/discuss/37307/4ms-simple-c-code-with-explanation
    public int findMinThink(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            if(nums[left]<=nums[right]){
                return nums[left];
            }
            
            int mid = (left+right)/2;
            
            if(nums[mid]<nums[right]){
                right = mid;;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
