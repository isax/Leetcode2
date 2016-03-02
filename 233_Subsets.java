public class Solution {
    // 233
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), lists);
        return lists;
    }
    
    private void helper(int [] nums, int i, List<Integer>list, List<List<Integer>> lists){
        lists.add(new ArrayList<Integer>(list));
        if(i==nums.length){
            return;
        }
        for(int j = i; j<nums.length; j++){
            list.add(nums[j]);
            helper(nums, j+1, list, lists);
            list.remove(list.size()-1);
        }
    }
    
    // https://leetcode.com/discuss/54541/very-simple-and-fast-java-solution-with-explanation
    public List<List<Integer>> subsets(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> lists = new ArrayList<List<Integer>>();
       helper2(nums, 0, new ArrayList<Integer>(), lists);
       return lists;
    }
    
    private void helper2(int[]nums, int i, List<Integer>list, List<List<Integer>> lists){
        if(i<=nums.length){
            lists.add(new ArrayList<Integer>(list));
        }
        for(int j = i; j<nums.length; j++){
            list.add(nums[j]);
            helper2(nums, j+1, list, lists);
            list.remove(list.size()-1);
        }
    }
    
    
    // https://leetcode.com/discuss/80790/java-dfs-%26-backtracking-solution
    public List<List<Integer>> subsets2(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> lists = new ArrayList<List<Integer>>();
       for(int i = 1; i<=nums.length; i++){
           helper(nums, i, 0, new ArrayList<Integer>(), lists);
       }
       lists.add(new ArrayList<Integer>());
       return lists;
    }
    
    private void helper(int[]nums, int size, int i, List<Integer>list, List<List<Integer>> lists){
        if(list.size()==size){
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for(int j = i; j<nums.length; j++){
            list.add(nums[j]);
            helper(nums, size, j+1, list, lists);
            list.remove(list.size()-1);
        }
    }
}
