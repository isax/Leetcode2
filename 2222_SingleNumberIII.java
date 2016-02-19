public class Solution {
    // https://github.com/isax/Leetcode2/blob/master/SingleNumberIII.java
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int n : nums){
            xor ^= n;
        }
        
        int first_diff = 0;
        for(int i = 0; i<32; i++){
            if(((xor>>i)&1)==1) {
                first_diff = i;
                break;
            }
        }
        
        int [] res = new int[2];
        for(int n : nums){
            if(((n>>first_diff)&1)==1){
                res[0] ^= n;
            }//else{
                //res[1] ^= n;
            //}
        }
        res[1] = res[0]^xor;
        return res;
    }
}
