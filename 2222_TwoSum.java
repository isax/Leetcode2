public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int [] res = new int[2];
        
        for(int i = 0; i<nums.length; i++){
            int remaining = target - nums[i];
            if(map.containsKey(remaining)){
                res[0] = i;
                res[1] = map.get(remaining);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
    
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        int [] res = new int[2];
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                if(target-nums[i]!=nums[i] || map.get(nums[i])!=i){
                    res[0] = i;
                    res[1] = map.get(target-nums[i]);
                    break;
                }
            }
        }
        return res;
    }
    
    public int[] twoSumMine(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
        int [] res = new int[2];
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                if(target-nums[i]!=nums[i]){
                    res[0] = i;
                    res[1] = map.get(target-nums[i]).get(0);
                    break;
                }else if(map.get(nums[i]).size()>1){
                    res[0] = i;
                    res[1] = map.get(nums[i]).get(1);
                    break;
                }
            }
        }
        return res;
    }
}
