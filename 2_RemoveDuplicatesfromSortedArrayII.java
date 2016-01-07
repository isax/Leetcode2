public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        
        int p = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i]==nums[p] && p!=0 && nums[i]==nums[p-1]){
                continue;
            }else{
                nums[++p] = nums[i];
            }
        }
        return p+1;
    }
}
