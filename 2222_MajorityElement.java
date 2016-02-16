public class Solution {
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    // bit map
    public int majorityElementBitMap(int[] nums) {
        int [] bit = new int[32];
        
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<32; j++){
                if(((nums[i]>>j) & 1)==1) bit[j]++;
            }
        }
        int num = 0;
        for(int i = 0; i<32; i++){
            if(bit[i]>nums.length/2){
                num += (1<<i);
            }
        }
        return num;
    }
    
    public int majorityElementMooreVotingAlg(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        for(int i = 1; i<nums.length; i++){
            if(candidate==nums[i]){
                count++;
            }else{
                count--;
                if(count==0){
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }
    
    // divide and conquer
    // https://leetcode.com/discuss/42929/6-suggested-solutions-in-c-with-explanations?show=50714#a50714
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private int helper(int[]nums, int i, int j){
        if(i==j) return nums[i];
        
        int mid = (i+j)/2;
        int left = helper(nums, i, mid);
        int right = helper(nums, mid+1, j);
        
        if(left==right) return left;
        else{
            int countL = 0, countR = 0;
            for(; i<=j; i++){
                if(nums[i]==left) countL++;
                else if(nums[i]==right) countR++;
            }
            return countL>countR?left:right;
        }
    }
}
