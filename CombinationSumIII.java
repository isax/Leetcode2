public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
        helper(k, n, list, lists);
        return lists;
    }
    
    private void helper(int k, int sum, List<Integer> list, List<List<Integer>> lists){
        if(list.size()==k) {
            if(sum==0){
                lists.add(new ArrayList<Integer>(list));
            }
            return;
        }
        int curStart = list.isEmpty()?1:list.get(list.size()-1)+1;
        for(int i = curStart; i<=9; i++){
            list.add(i);
            helper(k, sum-i, list, lists);
            list.remove(list.size()-1);
        }
    }
}
