public class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0){
                if(i!=l) swap(nums, l, i);
                l++;
            }
        }
    }
    
    // didn't maintain the relative order
    public void moveZeroesWRONG(int[] nums) {
        int l = 0, r = nums.length-1;
        
        while(l<r){
            while(nums[l]!=0 && l<r){
                l++;
            }
            while(nums[r]==0 && l<r){
                r--;
            }
            if(l<r) swap(nums, l++, r--);
        }
    }
    
    private void swap(int[]nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
