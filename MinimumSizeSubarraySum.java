public class Solution {
    // https://leetcode.com/discuss/45449/accepted-clean-java-o-n-solution-two-pointers
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        
        while(r<nums.length){
            if(sum<s) {
                sum += nums[r];
                r++;
            }
            
            while(sum>=s) { //&& l<=r-1){ <- no need
                minLen = Math.min(r-l, minLen);
                sum -= nums[l]; // if l->r, sum = 0
                l++; // l==r
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    // O(nlogn)
    // Reference: http://yucoding.blogspot.com/2015/06/leetcode-question-minimum-size-subarray.html,
    https://leetcode.com/discuss/35378/solutions-java-with-time-complexity-nlogn-with-explanation
    
    public int minSubArrayLen(int s, int[] nums) {
        int [] sums = new int[nums.length+1];
        for(int i = 0; i<nums.length; i++) sums[i+1] = nums[i] + sums[i]; 
        
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i<sums.length; i++){
            int curBestEnd = binarySearch(i, sums.length-1, i, s, sums);
            if(curBestEnd == sums.length) continue;
            minLen = Math.min(minLen, curBestEnd-i);
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
    
    // in this way, left will always get us the one that >= target
    private int binarySearch(int left, int right, int st, int target, int[]sums){
        if(left<=right){
            int mid = left + (right-left)/2;
            
            if(sums[mid]-sums[st]>=target) return binarySearch(left, mid-1, st, target, sums); // if only one == target, left will go right and surpass right, and return to where it == target
            else return binarySearch(mid+1, right, st, target, sums); // left will go right right and surpass right
        }
        return left;
    }
}
