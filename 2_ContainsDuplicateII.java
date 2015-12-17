public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(hm.containsKey(nums[i]) && i-hm.get(nums[i])<=k) return true;
            hm.put(nums[i], i);
        }
        return false;
    }
    // https://leetcode.com/discuss/37851/c-solution-with-unordered_set
    // https://leetcode.com/discuss/38445/simple-java-solution
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(i>k) set.remove(nums[i-k-1]);
            
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
