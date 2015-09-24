public class Solution {
    
     public void moveZeroes(int[] nums) {
        int j = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0) nums[j++] = nums[i];
        }
        for(;j<nums.length; j++){
            nums[j] = 0;
        }
    }
    
    public void moveZeroes2(int[] nums) {
        int l = 0;
        
        for(int r = 0; r<nums.length; r++)
        {
            if(nums[r]!=0) {
                if(nums[l]==0) swap(l, r, nums);
                l++; 
            }
        }
    }
    
    public void moveZeroesMy(int[] nums) {
        int l = 0, r = 0;
        
        while(r<nums.length){
           if(nums[r]==0) r++;
           else{
               if(nums[l]==0) swap(l, r, nums);
               l++; r++;
           }
        }
    }
    private void swap(int i, int j, int []nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
