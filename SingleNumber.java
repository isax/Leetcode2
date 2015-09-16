public class Solution {
    public int singleNumber(int[] nums) {
        int v = 0;
        for(int n : nums){
            v ^= n;
        }
        return v;
    }
}
