public class Solution {
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if(!set.add(i)) return true;
        }
        return false;
    }
    
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]) return true;
        }
        return false;
    }
}
