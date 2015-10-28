public class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(i==0 || nums[i]!=nums[p-1]){
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}
