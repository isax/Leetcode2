public class Solution {
    // https://leetcode.com/discuss/62449/java-o-1-space-solution-of-rotate-array
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
    
    private void reverse(int[] nums, int a, int b){
        while(a<b && b<nums.length){
            int i = nums[a];
            nums[a++] = nums[b];
            nums[b--] = i;
        }
    }
}
