public class Solution {
    public int maxSubArrayLenBF(int[] nums, int k) {
        int max = 0;
        int len = nums.length;
        for(int i = 0; i<len; i++){
            int sum = 0;
            for(int j = i; j<len; j++){
                sum += nums[j];
                if(sum==k) max = Math.max(max, j-i+1);
            }
        }
        return max;
    }
    
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, -1);
        
        int max = 0;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            
            if(hm.containsKey(sum-k)){
                max = Math.max(max, i-hm.get(sum-k));
            }
            if(!hm.containsKey(sum)) hm.put(sum, i);
        }
        return max;
    }
}
