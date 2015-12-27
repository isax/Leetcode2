public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/19965351
    public int removeElement(int[] nums, int val) {
        if(nums==null)  
        return 0; 
        int lastIndex = nums.length-1;  
        
        for(int i=0;i<=lastIndex;i++) 
        {  
            if(nums[i]==val)  
            {  
                nums[i--] = nums[lastIndex--]; 
            } 
            
        }  
        return lastIndex+1;  
    }
    
    // 
    public int removeElement2(int[] nums, int val) {
        int l = 0, r = nums.length-1;
        
        while(l<=r){
            while(l<nums.length && nums[l]!=val){
                l++;
            }
            
            while(l<=r && nums[r]==val){
                r--;
            }
            
            if(l<r){
                swap(nums, l, r);
                //l++; r--;
            }
        }
        return l;
    }
    
    private void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
