public class Solution {
    public int singleNumber2(int[] nums) {
        int [] a = new int[32];
        
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<32; j++){
                int bit = nums[i]>>j;
                if((bit&1)==1){
                    a[j] = (a[j]+1)%3;
                }
            }
        }
        int num = 0;
        for(int i = 0; i<32; i++){
            num += a[i]*Math.pow(2,i); // not working for negative
        }
        return num;
    }
    
    public int singleNumber(int[] nums) {
        int num = 0;
        
        for(int i = 0; i<32; i++){
            int cur = 0;
            for(int j = 0; j<nums.length; j++){
                int bit = nums[j]>>i;
                if((bit&1)==1){
                    cur = (cur+1)%3;
                }
            }
            
            num += cur<<i;
        }
        return num;
    }
}
