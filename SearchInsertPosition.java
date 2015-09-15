public class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int left = 0; int right = nums.length-1;
        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        // even if we dont check its fine. we can just return left
        // 2 cases: 1) left and right -> same one, > or < target 2) left->x, right -> x+1, mid -> x, > target
        /*
        if(nums[mid]>target){
            return mid;
        }else{
            return mid+1;
        }*/
        return left;
    }
}
