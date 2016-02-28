public class Solution {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(2, n, new ArrayList<Integer>(), lists);
        return lists;
    }
    
    private void helper(int low, int remaining, List<Integer> list, List<List<Integer>> lists){
        if(remaining==1){
            if(list.size() > 1){
                lists.add(new ArrayList<Integer>(list));
            }
            return;
        }
        list.add(remaining);
        helper(remaining, 1, list, lists);
        list.remove(list.size() - 1);
        
        for(int i = low; i*i <= remaining; i++){
            if(remaining % i == 0){
                list.add(i);
                helper(i, remaining / i, list, lists);
                list.remove(list.size()-1);
            }
        }
    }
    
    public List<List<Integer>> getFactorsMine(int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(1, n, new ArrayList<Integer>(), lists);
        return lists;
    }
    
    private void helper(int prev, int remaining, List<Integer> list, List<List<Integer>> lists){
        if(remaining==1){
            if(!list.isEmpty()){
                lists.add(new ArrayList<Integer>(list));
            }
            return;
        }
        if(!list.isEmpty()){
            list.add(remaining);
            helper(remaining, 1, list, lists);
            list.remove(list.size() - 1);
        }
        
        for(int i = 2; i*i <= remaining; i++){
            if(remaining % i == 0 && remaining / i != 1 && i >= prev){
                list.add(i);
                helper(i, remaining / i, list, lists);
                list.remove(list.size()-1);
            }
        }
    }
}
