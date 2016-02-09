public class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        
        int ability = nums[0];
        int next = nums[0];
        int step = 0;
        
        for(int i = 1; i<nums.length; i++){
            if(ability<i){
                if(next<i) return -1;
                ability = next;
                step++;
            }
            next = Math.max(next, i+nums[i]);
        }
        return step;
    }
}
