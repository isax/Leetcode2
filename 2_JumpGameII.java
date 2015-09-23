public class Solution {
    public int jumpNew(int[] nums) {
        int steps = 0;
        int currentRange = nums[0];
        int nextRange = 0;
        
        if(nums.length==1) return 0;
        
        for(int i = 0; i<nums.length; i++){
            if(currentRange>=nums.length-1) return steps+1;
            
            nextRange = Math.max(i + nums[i], nextRange);
            
            if(i>=currentRange){
                steps++;
                if(nextRange<=currentRange) return -1;
                currentRange = nextRange;
            }
        }
        return -1;
    }
    
    public int jump(int[] nums) {
        int steps = 0;
        int currentRange = 0;
        int nextRange = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(i>currentRange){
                if(nextRange<=currentRange) return -1;
                currentRange = nextRange;
                steps++;
                
            }
            nextRange = Math.max(nextRange, nums[i]+i);
        }
        return steps;
    }
}
