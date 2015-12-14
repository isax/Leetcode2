public class Solution {
    // http://fisherlei.blogspot.com/2015/10/leetcode-single-number-iii-solution.html
    public int[] singleNumber2(int[] nums) {
        int xor = 0;
        // get b^c
        for(int n : nums){
            xor ^= n;
        }
        
        // get right most bit 1 in xor
        int first_1_index = 0;
        for(int i = 0; i<32; i++){
            if(((xor>>i)&1)==1) first_1_index = i;
        }
        
        // separate 
        int xor_2 = 0;
        for(int n : nums){
            if(((n>>first_1_index)&1)==1) xor_2 ^= n;
        }
        
        int[]res = new int[2];
        res[0] = xor_2;
        res[1] = xor ^ xor_2;
        return res;
        
    }
    
    // http://www.cnblogs.com/EdwardLiu/p/4391455.html
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        // get b^c
        for(int n : nums){
            xor ^= n;
        }
        
        // get right most bit 1 in xor
        // 11100 -> ~(11100-1) = ~(11011) -> 00100
        int first_1_index = xor & (~(xor-1));
        
        // separate 
        int xor_2 = 0;
        for(int n : nums){
            if((n&first_1_index)==first_1_index) xor_2 ^= n;
        }
        
        int[]res = new int[2];
        res[0] = xor_2;
        res[1] = xor ^ xor_2;
        return res;
        
    }
}
