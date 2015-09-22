public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates, target, 0);
    }
    
    private List<List<Integer>> helper(int[] candidates, int target, int cur){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for(int i = cur; i<candidates.length; i++){
            if(i>cur && candidates[i]==candidates[i-1]) continue; // first time ok, next time not ok
            
            if(target<candidates[i]) break;
            else if(target == candidates[i]){
                List<Integer> list = new ArrayList<Integer>();
                list.add(target);
                res.add(list);
            }else{
                List<List<Integer>> candidateList = helper(candidates, target-candidates[i], i+1);
                for(List<Integer> list : candidateList){
                    list.add(0, candidates[i]);
                    res.add(list);
                }
            }
        }
        
        return res;
    }
}
