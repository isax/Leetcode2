public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1) return;
        
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        
        if(i>=0){ // rule out 3,2,1 case
            int j = i+1;
            
            while(j<nums.length && nums[i]<nums[j]){
                j++;
            }
            //j-1
            swap(nums, i, j-1);
        }
        reverse(nums, i+1);
    }
    
    private void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[]nums, int left){
        int right = nums.length-1;
        while(left<right){
            swap(nums, left++, right--);
        }
    }
}
