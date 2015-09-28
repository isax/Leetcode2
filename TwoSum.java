public class Solution {
    
    // guaranteed with one and only one solution, so no need to care about indices overriding
    // reference: https://leetcode.com/discuss/58175/clean-16ms-c-solution
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int [] res = new int[2];
        for(int i = 0; i<nums.length; i++){
            int rest = target - nums[i];
            if(map.containsKey(rest)){
                res[0] = map.get(rest);
                res[1] = i+1;
                return res;
            }
            map.put(nums[i], i+1);
        }
        return null;
    }
    
    public int[] twoSumFirst(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for(int i = 0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i+1);
        }
        int [] res= new int[2];
        
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int rest = target - nums[i];
                if(rest==nums[i]) {
                    List<Integer> index = map.get(nums[i]);
                    if(index.size()> 1){
                        res[0] = map.get(nums[i]).get(0);
                        res[1] = map.get(nums[i]).get(1);
                        return res;
                    }
                }else{
                    if(map.containsKey(rest)){
                        res[0] = Math.min(i+1, map.get(rest).get(0));
                        res[1] = Math.max(i+1, map.get(rest).get(0));
                        return res;
                    }
                }
            }
        }
        return null;
    }
}
