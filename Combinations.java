public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(n, k, list, lists);
        return lists;
    }
    
    private void helper(int n, int k, List<Integer>list, List<List<Integer>>lists){
        if(list.size()==k) {
            lists.add(new ArrayList(list));
            return;
        }
        
        int low = list.size()==0?0:list.get(list.size()-1);
        for(int i = low+1; i<=n; i++){
            list.add(i);
            helper(n, k, list, lists);
            list.remove(list.size()-1);
        }
    }
}
