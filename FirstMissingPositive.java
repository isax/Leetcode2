public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/20884585
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            int cur = nums[i];
            while(cur>0 && cur<=nums.length && nums[cur-1]!=cur){
                int temp = nums[cur-1];
                nums[cur-1] = cur;
                cur = temp;
            }
        }
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
}
