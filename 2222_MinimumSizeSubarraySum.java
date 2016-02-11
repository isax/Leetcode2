public class Solution {
    // https://leetcode.com/discuss/45449/accepted-clean-java-o-n-solution-two-pointers
    public int minSubArrayLen2(int s, int[] nums) {
        int l = 0, r = 0;
        
        int minLen = nums.length+1;
        int sum = 0;
        while(r<nums.length){
            sum += nums[r];
            while(sum>=s && l<=r){
                minLen = Math.min(minLen, r-l+1);
                sum -= nums[l++];
            }
            r++;
        }
        return minLen==nums.length+1?0:minLen;
    }
    
    // O(nlogn)
    // Reference: http://yucoding.blogspot.com/2015/06/leetcode-question-minimum-size-subarray.html,
    // https://leetcode.com/discuss/35378/solutions-java-with-time-complexity-nlogn-with-explanation
    public int minSubArrayLen(int s, int[] nums) {
        int [] sums = new int[nums.length+1];
        for(int i = 1; i<=nums.length; i++){
            sums[i] = sums[i-1]+nums[i-1];
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<sums.length; i++){
            int curRightEnd = helper(sums, i, sums.length-1, i, s);
            if(curRightEnd!=sums.length) min = Math.min(min, curRightEnd-i);
        }
        return min==Integer.MAX_VALUE?0:min;
    }
    
    private int helper(int [] sums, int left, int right, int i, int s){
        if(left>right) return left;
        
        int mid = (left+right)/2;
        
        if(sums[mid]-sums[i]>=s){
            return helper(sums, left, mid-1, i, s);
        }else{
            return helper(sums, mid+1, right, i, s);
        }
    }
}
