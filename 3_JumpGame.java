public class Solution {
    public boolean canJump(int[] nums) {
        int ability = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(ability<i) return false;
            
            ability = Math.max(ability, nums[i]+i);
        }
        return true;
    }
}
