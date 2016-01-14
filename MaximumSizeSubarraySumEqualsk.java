public class Solution {
    // https://leetcode.com/discuss/77901/java-easy-to-understand-solution-with-hashmap-31ms
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        
        int max = 0, sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            
            if(map.containsKaey(sum-k)){
                max = Math.max(max, i-map.get(sum-k));
            }
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
    
    public int maxSubArrayLenBruteForce(int[] nums, int k) {
        int max = 0;
        for(int i = 0; i<nums.length; i++){
            int sum = 0;
            for(int j = i; j<nums.length; j++){
                sum += nums[j];
                if(sum==k) max = Math.max(max, j-i+1);
            }
        }
        return max;
    }
}
