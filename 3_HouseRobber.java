public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int max = 0;
        
        for(int i = 0; i<nums.length; i++){
            c = Math.max(a+nums[i], b);
            //max = Math.max(c, max);
            a = b;
            b = c;
        }
        return c;
    }
}
