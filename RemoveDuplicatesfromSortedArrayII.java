public class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 2;
        
        for(int i = 2; i<nums.length; i++){
            if(nums[i]!=nums[p-1] || nums[i] != nums[p-2]){
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}
