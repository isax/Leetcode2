public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        boolean []used = new boolean[nums.length];
        helper(nums, used, new ArrayList<Integer>(), lists);
        return lists;
    }
    
     private void helper(int[]nums, boolean []used, List<Integer>list, List<List<Integer>>lists){
        if(list.size()==nums.length){
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(!used[i]){
                // check duplicate
                if(i!=0 && nums[i]==nums[i-1] && !used[i-1]){
                    continue;
                }
                list.add(nums[i]);
                used[i] = true;
                helper(nums, used, list, lists);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}
