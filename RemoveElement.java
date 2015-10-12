public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        
        if(len==0) return 0;
        
        int left = 0;
        int right = len-1;
        
        while(left<=right){ // have to be left <= right
            while(left<len && nums[left]!=val){
                left++;
            }
            while(right>=0 && nums[right]==val){
                right--;
            }
            if(left<len && right>=0 && left<right){
                nums[left] = nums[right];
                nums[right] = val;
                //left++;
                //right--;
            }
        }
        return left;
    }
}
