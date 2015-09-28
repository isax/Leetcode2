public class Solution {
    // Code Ganker: first sort http://codeganker.blogspot.com/2014/03/permutations-ii-leetcode.html
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        boolean [] used = new boolean[nums.length];
        Arrays.sort(nums);  // sort
        permuteCG(nums, list, lists, used);
        return lists;
    }
    private void permuteCG(int[]nums, List<Integer>list, List<List<Integer>> lists, boolean [] used){
        if(list.size()==nums.length) {
            lists.add(new ArrayList(list));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(i>0 && !used[i-1] && nums[i]==nums[i-1]) continue; // avoid doing recursion for duplicate ele
            // !used[i-1] means i-1 has been included in previous recursion, if (used[i-1]) it means i-1 has already been in current list
            // doing check in the next recursion..
            
            if(!used[i]){
                list.add(nums[i]);
                used[i] = true;
                permuteCG(nums, list, lists, used);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    
    // Mine
    public List<List<Integer>> permuteUniqueMine(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        boolean [] used = new boolean[nums.length];
        permute(nums, list, lists, used);
        return lists;
    }
    
    private void permute(int[]nums, List<Integer>list, List<List<Integer>> lists, boolean [] used){
        if(list.size()==nums.length) {
            lists.add(new ArrayList(list));
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i<nums.length; i++){
            if(!used[i] && !set.contains(nums[i])){ // doing check before recursion
                list.add(nums[i]);
                used[i] = true;
                permute(nums, list, lists, used);
                used[i] = false;
                list.remove(list.size()-1);
                
                set.add(nums[i]);
            }
        }
    }
}
