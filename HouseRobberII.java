public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        return Math.max(robHelper(nums, 0, nums.length-2), robHelper(nums, 1, nums.length-1));
    }
    
    private int robHelper(int[]nums, int left, int right){
        if(left==right) return nums[left];
        int [] cache = new int[right-left+3];
        cache[0] = 0;
        cache[1] = 0;
        
        for(int i = 2; i<=right-left+2; i++){
            cache[i] = Math.max(cache[i-2]+nums[i+left-2], cache[i-1]);
        }
        return cache[right-left+2];
    } 
}
