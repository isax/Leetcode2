public class Solution {
    private int[] cache;
    
    public int rob(int[] nums) {
        cache = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            cache[i] = -1;
        }
        return robHelper(nums, nums.length-1);
    }
    
    public int robHelper(int[]nums, int index){
        if(index<0) return 0;
        if(index==0) return nums[0];
        if(cache[index]!=-1){
            return cache[index];
        }
        int amount = Math.max(robHelper(nums, index-2)+nums[index], robHelper(nums, index-1));
        cache[index] = amount;
        return amount;
    }
    
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        
        int [] dp = new int[nums.length+1];
        dp[0]  = 0;
        dp[1] = nums[0];
        
        for(int i = 2; i<nums.length+1; i++){
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[nums.length];
    }
    
    public int rob(int[] nums) {
        int even = 0;
        int odd = 0;
        
        for(int i=0; i<nums.length; i++){
            if(i%2==0){
                even += nums[i];
                even = even > odd? even : odd;
            }else{
                odd += nums[i];
                odd = odd > even ? odd : even;
            }
        }
        return even > odd? even : odd;
    }
}
