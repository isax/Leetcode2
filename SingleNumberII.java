public class Solution {
    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        int [] bits = new int[32];
        
        for(int i = 0; i<32; i++){
            int bit = 0;
            for(int j = 0; j<nums.length; j++){
                bit = (bit + ((nums[j]>>i)&1))%3;
            }
            singleNumber += (bit<<i);
        }
        return singleNumber;
    }
}
