public class Solution {
    // timecomplexity: https://leetcode.com/discuss/69427/concise-java-solution-based-on-quick-select
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length-1, k);
    }
    
    private int helper(int[] nums, int left, int right, int k){
        int pivot = nums[left];
        
        int l = left, r = right;
        while(l<=r){
            while(l<=r && nums[l] >= pivot){
                l++;
            }
            while(l<=r && nums[r] <= pivot){
                r--;
            }
            if(l<=r){
                swap(nums, l++, r--);
            }
        }
        swap(nums, left, r);
        
        if(l-left==k){
            return pivot;
        }else if (l-left < k){
            return helper(nums, l, right, k-(l-left));
        }else{
            //return helper(nums, left, l-2, k);
            return helper(nums, left, r-1, k);
        }
    }
    
    private void swap(int[]nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
