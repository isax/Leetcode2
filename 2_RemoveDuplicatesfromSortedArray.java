public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        
        int p = 1;
        for(int q = 1; q<nums.length; q++){
            if(nums[q]!=nums[p-1]){ // q-1 or p-1
                nums[p] = nums[q];
                p++;
            }
        }
        return p;
    }
}
