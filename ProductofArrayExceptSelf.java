public class Solution {
    public int[] productExceptSelfMy(int[] nums) {
        int [] res = new int[nums.length];
        
        int before = 1;
        for(int i = 0; i<nums.length; i++){
            if(i==0){
                res[i] = 1;
            }else{
                before *= nums[i-1];
                res[i] = before;
            }
        }
        int after = 1;
        for(int i = nums.length-1; i>=0; i--){
            if(i!=nums.length-1){
                after *= nums[i+1];
                res[i] *= after;
            }
        }
        
        return res;
    }
    // https://leetcode.com/discuss/53781/my-solution-beats-100%25-java-solutions
    public int[] productExceptSelf(int[] nums) {
        int [] res = new int[nums.length];
        
        int before = 1;
        for(int i = 0; i<nums.length; i++){
            res[i] = before;
            before *= nums[i];
        }
        int after = 1;
        for(int i = nums.length-1; i>=0; i--){
            res[i] *= after;
            after *= nums[i];
        }
        
        return res;
    }
}
