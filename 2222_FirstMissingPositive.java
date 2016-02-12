public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/20884585
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 1;
        // first missing #:
        // min - 1
        // max - nums.length+1
        int i = 0;
        while(i<nums.length){
            while(nums[i]<=nums.length && nums[i]>0 && nums[nums[i]-1]!=nums[i] ){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            i++;
        }
        
        for(int j = 0; j<nums.length; j++){
            if(nums[j]!=j+1) return j+1;
        }
        return nums.length+1;
    }
}
