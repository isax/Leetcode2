public class Solution {
    // https://leetcode.com/discuss/82822/solution-explanation
    // Greedy
    public int minPatches(int[] nums, int n) {
        long miss = 1; // otherwise overflow when == Integer.MAX_VALUE
        int count = 0;
        int i = 0;
        while(miss<=n){
            if(i < nums.length && nums[i]<=miss){
                miss += nums[i++];
            }else{
                count++;
                miss += miss;
            }
        }
        return count;
    }
}
