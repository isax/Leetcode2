public class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i!=cur && candidates[i-1]==candidates[i]){ 
                // in the current level, we only choose the first duplicate number
                // in the next level, the second number can be chosen
                continue;
            }
            if(candidates[i]+curSum>target) {
                break; // prune
            }
            list.add(candidates[i]);
            helper(i+1, curSum+candidates[i], target, candidates, list, lists);
            list.remove(list.size()-1);
        }
    }
    
    
    
    public List<List<Integer>> combinationSum2Mine(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        helperMine(0, 0, target, candidates, used, new ArrayList<Integer>(), lists);
        return lists;
    }
    
    private void helperMine(int cur, int curSum, int target, int []candidates, boolean[] used, List<Integer> list, List<List<Integer>> lists){
        if(curSum==target){
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = cur; i<candidates.length; i++){
            if(i!=0 && candidates[i-1]==candidates[i] && !used[i-1]){
                continue;
            }
            if(candidates[i]+curSum>target) {
                break; // prune
            }
            list.add(candidates[i]);
            used[i] = true;
            helperMine(i+1, curSum+candidates[i], target, candidates, used, list, lists);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
