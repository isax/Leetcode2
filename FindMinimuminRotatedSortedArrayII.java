public class Solution {
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
