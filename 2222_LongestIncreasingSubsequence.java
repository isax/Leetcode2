public class Solution {
    public int lengthOfLIS2(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int [] table = new int[nums.length];
        int cur = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(i==0 || nums[i]<table[0]) table[0] = nums[i];
            else if(nums[i]>table[cur]) table[++cur] = nums[i];
            else{
                int index = binarySearch(0, cur, table, nums[i]);
                table[index] = nums[i];
            }
        }
        return cur+1;
    }
    
    private int binarySearch(int left, int right, int[]nums, int target){
        while(left<=right){
            int mid = (left+right)/2;
            
            if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
}
