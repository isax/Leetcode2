public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(1, 0, n, k, new ArrayList<Integer>(), lists);
        return lists;
    }
    
    private void helper(int cur, int curSum, int target, int k, List<Integer> list, List<List<Integer>> lists){
        if(list.size()==k){
            if(curSum==target) {
                lists.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        for(int i = cur; i<=9; i++){
            if(i+curSum>target) {
                break; // trim
            }
            list.add(i);
            helper(i+1, curSum+i, target, k, list, lists);
            list.remove(list.size()-1);
        }
    }
}
