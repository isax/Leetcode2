/*public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(i>k){
                hs.remove(nums[i-k-1]);
            }
            
            if(hs.contains(nums[i])){
                return true;
            } else{
                hs.add(nums[i]);
            }
        }
        return false;
    }
}*/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(i>k){
                hs.remove(nums[i-k-1]);
            }
            
            if(!hs.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
