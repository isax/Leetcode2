public class Solution {
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
    
    // bit manipulation
    public int majorityElement(int[] nums) {
        int [] bits = new int[32];
        for(int n : nums){
            for(int i = 0; i<32; i++){
                if(((n>>i)&1)==1) bits[i]++;
            }
        }
        
        int res = 0;
        for(int i = 0; i<32; i++){
            if(bits[i]>nums.length/2){
                res += (1<<i);
            }
        }
        return res;
    }
    
    // DivideNConquer
    public int majorityElementDivideNConquer(int[] nums) {
        return helper(nums, 0, nums.length-1); 
    }
    
    private int helper(int []nums, int start, int end){
        if(start==end){
            return nums[start];
        }
        
        int mid = (start+end)/2;
        
        int left = helper(nums, start, mid);
        int right = helper(nums, mid+1, end);
        
        if(left==right){
            return left;
        }else{
            int leftCount = 0, rightCount = 0;
            for(int i = start; i<=end; i++){
                leftCount = nums[i]==left?leftCount+1:leftCount;
                rightCount = nums[i]==right?rightCount+1:rightCount;
            }
            return leftCount>=rightCount?left:right;
        }
    }
}
