public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(0, 0, target, candidates, new ArrayList<Integer>(), lists);
        return lists;
    }
    
    private void helper(int cur, int curSum, int target, int []candidates, List<Integer> list, List<List<Integer>> lists){
        if(curSum==target){
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = cur; i<candidates.length; i++){
            if(candidates[i]+curSum>target) {
                break; // prune
            }
            list.add(candidates[i]);
            helper(i, curSum+candidates[i], target, candidates, list, lists);
            list.remove(list.size()-1);
        }
    }
}
