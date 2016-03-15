public class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private int helper(int[] nums, int i, int j){
        int mid = (i+j)/2;
        
        if(nums[i]<nums[j] || i==j){
            // increasing
            return nums[i];
        }else{
            if(nums[i]<nums[mid]){
                return helper(nums, mid+1, j);
            }else if(nums[i]>nums[mid]){
                return helper(nums, i, mid);
            }else{
                if(nums[i]==nums[j]){
                    return helper(nums, i, j-1);
                }else{
                    return helper(nums, mid+1, j);
                }
            }
        }
    }
    
    public int findMinFirst(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            if(nums[left]<nums[right]){
                return nums[left];
            }
            int mid = (left+right)/2;
            
            if(nums[left]==nums[right]){
                if(nums[mid]==nums[left]){
                    break;
                }else if(nums[mid]<nums[left]){
                    right = mid;
                }else{
                    left = mid+1;
                }
                continue;
            }
            
            if(nums[mid]<=nums[right]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = left; i<=right; i++){
            min = Math.min(min, nums[i]);
        }
        return min;
    }
    
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<right){
            if(nums[left]<nums[right]){
                return nums[left];
            }
            int mid = (left+right)/2;
            
            if(nums[mid]<nums[right]){
                right = mid;
            }else if(nums[mid]>nums[right]){
                left = mid+1;
            }else{ // mid == right
                if(nums[left]==nums[right]){
                    left++;
                    right--;
                }else{
                    right = mid;
                }
            }
        }
        return nums[left]; // nums[right] also works :), 3 cases in the end 1) [1,2], 2) [2,2], 3)[2,2,2]
    }
}
