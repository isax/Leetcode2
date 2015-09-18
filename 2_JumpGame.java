public class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(i>farthest) break;
            
            int canReach = i + nums[i];
            farthest = Math.max(farthest, canReach);
            
            if(farthest>=nums.length-1){
                return true;
            }
        }
        return false;
    }
    
    public boolean canJumpShort(int[] nums) {
        int farthest = 0;
        
        for(int i = 0; i<=farthest&&i<nums.length; i++){
            farthest = Math.max(farthest, i + nums[i]);
        }
        return farthest>=nums.length-1;
    }
}
