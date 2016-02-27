public class Solution {
    public boolean increasingTriplet(int[] nums) {
        //if(nums.length==0) return false;
        int no1 = Integer.MAX_VALUE, no2 = Integer.MAX_VALUE;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>no2){
                return true;
            }else if(nums[i]<no1){
                no1 = nums[i];
            }else if(nums[i]>no1 && nums[i]<no2){
                no2 = nums[i];
            }
        }
        return false;
    }
}
