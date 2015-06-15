public class Solution {
    public int jump(int[] nums) {
        int next_ability = 0;
        int cur_max_ability = 0;
        int steps = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(i>cur_max_ability){
                if(next_ability == cur_max_ability) return -1;
                cur_max_ability = next_ability;
                steps++;
            } 
            
            if(i+nums[i]>next_ability){
                next_ability = i+nums[i];
            }
        }
        return steps;
    }
}
