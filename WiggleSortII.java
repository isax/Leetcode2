public class Solution {
    // https://leetcode.com/discuss/77133/o-n-o-1-after-median-virtual-indexing?
    // Partition?
    
    // https://leetcode.com/discuss/76965/3-lines-python-with-explanation-proof
    public void wiggleSortOnlogn(int[] nums) {
        Arrays.sort(nums);
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        int smaller = (nums.length+1)/2-1;
        int larger = nums.length-1;
        
        for(int i = 0; i<nums.length; i++){
            nums[i] = (i%2==0)?copy[smaller--]:copy[larger--];
        }
    }

}
