public class Solution {
    public int maxSubArray(int[] nums) {
        int global = Integer.MIN_VALUE;
        int local = 0;
        
        for(int num : nums){
            if(local<0){
                local = num;
            }else{
                local += num;
            }
            global = Math.max(global, local);
        }
        
        return global;
    }
}
