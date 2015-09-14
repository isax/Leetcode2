public class Solution {
    
    // linear
    public int findPeakElement(int[] nums) {
        
        for(int i = 0; i<nums.length; i++){
            boolean left = i==0 ? true:nums[i]>nums[i-1];
            boolean right = i==nums.length-1? true:nums[i]>nums[i+1];
            
            if(left&&right){
                return i;
            }
        }
        return -1;
    }
    
    // Binary search: recursive
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private int helper(int [] nums, int low, int high){
        if(low>high) return -1;
        
        int mid = (low+high)/2;
        
        boolean left = mid-1==-1? true:nums[mid]>nums[mid-1];
        boolean right = mid+1==nums.length ? true: nums[mid]>nums[mid+1];
        if(left && right) return mid;
        
        if(right){
            return helper(nums, low, mid-1); // mid is not correct; SHOULD BE MID-1
        }else{
            return helper(nums, mid+1, high);
        }
    }
    
    public class Solution {
    
    // Binary search: iterative
    public int findPeakElement(int[] nums) {
        
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            boolean leftComp = mid - 1 < 0?true: nums[mid]>nums[mid-1];
            boolean rightComp = mid + 1 > nums.length-1?true:nums[mid]>nums[mid+1];
            
            if(leftComp && rightComp){
                return mid;
            }else if(!leftComp) {
                right = mid - 1;
            }else if(!rightComp){
                left  = mid + 1;
            }
        }
        return -1;
    }
}
}
