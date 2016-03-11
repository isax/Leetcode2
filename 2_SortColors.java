public class Solution {
    // https://leetcode.com/discuss/17000/share-my-one-pass-constant-space-10-line-solution
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length-1;
        
        for(int i = 0; i<nums.length; i++){
            while(nums[i]==2 && i<two){
                swap(nums, i, two--);
            }
            
            while(nums[i]==0 && i>zero){
                swap(nums, i, zero++);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors2(int[] nums) {
        int[] count = new int[3];
        
        for(int i = 0; i<nums.length; i++){
            count[nums[i]]++;
        }
        for(int i = 1; i<3; i++){
            count[i] += count[i-1];
        }
        
        int [] res = new int[nums.length];
        
        for(int i = 0; i<nums.length; i++){
            res[count[nums[i]]-1] = nums[i];
            count[nums[i]]--;
        }
        
        for(int i = 0; i<nums.length; i++){
            nums[i] = res[i];
        }
    }
}
