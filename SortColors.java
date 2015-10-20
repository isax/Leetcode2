public class Solution {
    // One Pass
    // https://leetcode.com/discuss/17000/share-my-one-pass-constant-space-10-line-solution
    public void sortColors(int[] nums) {
        int zero = 0, second = nums.length-1;
        
        // 2 first then 0, as there will be no 2 before i
        for(int i = 0; i<nums.length; i++){
           while(nums[i]==2 && second>i){
               swap(i, second--, nums);
           }
           while(nums[i]==0 && zero<i){
               swap(i, zero++, nums);
           }
        }
    }
    
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // not standard but still counting sort
    public void sortColorsNotStandard(int[] nums) {
        int [] count = new int[3];
        
        for(int i : nums){
            count[i]++;
        }
        
        int currentColor = 0;
        for(int i = 0; i<nums.length; i++){
            while(count[currentColor]==0) currentColor++;
            nums[i] = currentColor;
            count[currentColor]--;
        }
    }
    
    // Standard counting sort
    public void sortColorsStandard(int[] nums) {
        int [] count = new int[3];
        
        for(int i : nums){
            count[i]++;
        }
        
        int [] res = new int[nums.length];
        
        for(int i = 1; i<3; i++){
            count[i] = count[i-1] + count[i];
        }
        
        for(int i = 0; i<nums.length; i++){
            res[count[nums[i]]-1] = nums[i];
            count[nums[i]]--;
        }
        
        for(int i = 0; i<nums.length; i++){
            nums[i] = res[i];
        }
    }
}
