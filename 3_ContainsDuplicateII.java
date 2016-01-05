public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> hs = new HashSet<Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(i>k) hs.remove(nums[i-k-1]);
            if(!hs.add(nums[i])) return true;
            //if(hs.size()==k+1) hs.remove(nums[i-k]);
        }
        return false;
    }
}
