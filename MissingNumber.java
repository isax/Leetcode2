public class Solution {
    
    // might overflow
    public int missingNumber2(int[] nums) {
       int n = nums.length;
       int sum = (n+1)*n/2;
       
       int sum_array = 0;
       for(int i : nums){
           sum_array += i;
       }
       return sum-sum_array;
    }
    
    // reference: https://leetcode.com/discuss/54694/java-bit-manipulation-solution-o-n-time-o-1-space
    public int missingNumber(int[] nums) {
       int sum = 0;
       for(int i = 0; i<=nums.length; i++) sum ^= i;
       for(int i = 0; i<nums.length; i++) sum ^= nums[i];
       
       return sum;
    }
}
