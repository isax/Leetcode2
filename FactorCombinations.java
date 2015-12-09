public class Solution {
    // https://leetcode.com/discuss/51250/my-recursive-dfs-java-solution
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(lists, new ArrayList<Integer>(), n, 2);
        return lists;
    }
    
    private void helper(List<List<Integer>> lists, List<Integer>list, int n, int low){
        if(n==1){
            if(list.size()>1) lists.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = low; i<=n; i++){
            if(n%i==0){
                list.add(i);
                helper(lists, list, n/i, i);
                list.remove(list.size()-1);
            }
        }
        
    }
}
