public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int global = 0;
        int [] local = new int[len];
        Arrays.fill(local, 1);
        
        for(int i = 0; i<len; i++){
            for(int j = i-1; j>=0; j--){
                if(nums[j]<nums[i]){
                    local[i] = Math.max(local[i], local[j]+1);
                }
            }
            global = Math.max(global, local[i]);
        }
        return global;
    }
}
