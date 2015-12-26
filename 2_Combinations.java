public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>lists = new ArrayList<List<Integer>>();
        if (n<k) return lists;
        helper(1, n, k, new ArrayList<Integer>(), lists);
        return lists;
    }
    
    private void helper(int cur, int n, int k, List<Integer> list, List<List<Integer>>lists){
        if(list.size()==k){
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = cur; i<=n; i++){
            if(n-i+1<k-list.size()) {
                break; // pruning
            }
            list.add(i);
            helper(i+1, n, k, list, lists);
            list.remove(list.size()-1);
        }
    }
}
