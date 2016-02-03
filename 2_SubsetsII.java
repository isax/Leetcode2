public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(nums, 0, new ArrayList<Integer>(), lists);
        return lists;
    }
    
    private void helper(int[]nums, int cur, List<Integer>list, List<List<Integer>> lists){
        if(cur<=nums.length){
            lists.add(new ArrayList<Integer>(list));
        }
        
        for(int i = cur; i<nums.length; i++){
            if(i!=cur && nums[i]==nums[i-1]) continue;
            
            list.add(nums[i]);
            helper(nums, i+1, list, lists);
            list.remove(list.size()-1);
        }
    }
}
